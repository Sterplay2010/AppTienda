package mx.edu.utez.tienda.model;

import mx.edu.utez.tienda.utility.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Queue;

public class ProductoDao extends Conexion {
    public boolean insertarProducto(ProductoBean bean) {
        try (PreparedStatement pst = crearConexion().prepareStatement("INSERT INTO producto(nombre,idCategoria,idMarca,existencia,precio,descripcion,codigoBarra) VALUES(?,(SELECT idCategoria FROM categoria WHERE nombre = ?),(SELECT idMarca FROM marca WHERE nombre = ?),?,?,?,?);")) {
            pst.setString(1, bean.getNombre());
            pst.setString(2, bean.getIdCategoria());
            pst.setString(3, bean.getIdMarca());
            pst.setInt(4, bean.getExistencia());
            pst.setDouble(5, bean.getPrecio());
            pst.setString(6, bean.getDescripcion());
            pst.setString(7, bean.getCodigoBarra());
            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public boolean eliminarProducto(String codigoBarra) {
        try (PreparedStatement pst = crearConexion().prepareStatement("DELETE FROM producto WHERE codigo = (SELECT codigo FROM producto WHERE codigoBarra = '" + codigoBarra + "');")) {
            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean modificarProducto(ProductoBean bean, String codigoBarra) {
        try (PreparedStatement pst = crearConexion().prepareStatement("UPDATE producto set codigoBarra=?, nombre=?, idCategoria = (SELECT idCategoria FROM categoria WHERE nombre = ?), idMarca = (SELECT idMarca FROM marca WHERE nombre = ?),existencia =?, precio=?, descripcion=? WHERE codigo = (SELECT codigo FROM producto WHERE codigoBarra = '" + codigoBarra + "');")) {
            pst.setString(1, bean.getCodigoBarra());
            pst.setString(2, bean.getNombre());
            pst.setString(3, bean.getIdCategoria());
            pst.setString(4, bean.getIdMarca());
            pst.setInt(5, bean.getExistencia());
            pst.setDouble(6, bean.getPrecio());
            pst.setString(7, bean.getDescripcion());
            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public Queue<ProductoBean> consultarProductos() {
        Queue<ProductoBean> colaProductos = new LinkedList<>();
        try (PreparedStatement pst = crearConexion().prepareStatement("SELECT * FROM producto ORDER BY nombre ASC")) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                colaProductos.add(new ProductoBean(rs.getString("codigoBarra"), rs.getString("nombre"), rs.getString("idCategoria"), rs.getString("idMarca"), rs.getInt("existencia"), rs.getDouble("precio"), rs.getString("descripcion")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return colaProductos;
    }
}

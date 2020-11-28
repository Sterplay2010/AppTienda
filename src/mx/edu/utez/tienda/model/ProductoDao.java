package mx.edu.utez.tienda.model;

import mx.edu.utez.tienda.utility.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Queue;

public class ProductoDao extends Conexion {
    public boolean insertarProducto(ProductoBean bean, String nombreCategoria, String nombreMarca) {
        try (PreparedStatement pst = crearConexion().prepareStatement("INSERT INTO producto(nombre,idCategoria,idMarca,existencia,precio,descripcion,codigoBarra) VALUES(?,(SELECT idCategoria FROM categoria WHERE nombre = ?),(SELECT idMarca FROM marca WHERE nombre = ?),?,?,?,?);")) {
            pst.setString(1, bean.getNombre());
            pst.setString(2, nombreCategoria);
            pst.setString(3, nombreMarca);
            pst.setInt(4, bean.getExitencia());
            pst.setDouble(5, bean.getPrecio());
            pst.setString(6, bean.getDescripcion());
            pst.setString(7, bean.getCodigoBarra());
            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminarProducto(int idProducto) {
        try (PreparedStatement pst = crearConexion().prepareStatement("DELETE FROM producto WHERE idProducto = '" + idProducto + "'")) {
            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean modificarProducto(ProductoBean bean, String nombreCategoria, String nombreMarca) {
        try (PreparedStatement pst = crearConexion().prepareStatement("UPDATE producto set codigoBarra=?, nombre=?, idCategoria = (SELECT idCategoria FROM categoria WHERE nombre = ?), idMarca = (SELECT idMarca FROM marca WHERE nombre = ?), precio=?, existencia =?, descripcion=? WHERE idProducto =?;")) {

            pst.setString(1, bean.getCodigoBarra());
            pst.setString(2,bean.getNombre());
            pst.setString(3,nombreCategoria);
            pst.setString(4,nombreMarca);
            pst.setDouble(5,bean.getPrecio());
            pst.setInt(6, bean.getExitencia());
            pst.setString(7, bean.getDescripcion());
            pst.setInt(8,bean.getCodigo());
            if(pst.executeUpdate()==1){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Queue<ProductoBean> consultarProductos(){
        Queue<ProductoBean> cola = new LinkedList<>();
        try(PreparedStatement pst = crearConexion().prepareStatement("SELECT * FROM producto")){
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                cola.add(new ProductoBean(rs.getInt("codigo"), rs.getString("nombre"), rs.getInt("idCategoria"), rs.getInt("idMarca"), rs.getInt("existencia"), rs.getDouble("precio"),rs.getString("descripcion"), rs.getString("codigoBarra")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  cola;
    }

    public static void main(String[] args) {

        Queue<ProductoBean> queue = new ProductoDao().consultarProductos();
        for(ProductoBean var: queue){
            System.out.println(var.getCodigo());
            System.out.println(var.getNombre());
            System.out.println(var.getIdCategoria());
            System.out.println(var.getIdMarca());
            System.out.println(var.getExitencia());
            System.out.println(var.getPrecio());
            System.out.println(var.getDescripcion());
            System.out.println(var.getCodigo());
            System.out.println("----------------------------");
        }
    }
}

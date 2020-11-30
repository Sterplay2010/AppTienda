package mx.edu.utez.tienda.model;

import mx.edu.utez.tienda.utility.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Queue;

public class MarcaDao extends Conexion {

    public boolean insertarMarca(MarcaBean bean) {
        try (PreparedStatement pst = crearConexion().prepareStatement("INSERT INTO marca (nombre,descripcion) VALUES(?,?);")) {
            pst.setString(1, bean.getNombre());
            pst.setString(2, bean.getDescripcion());
            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminarMarca(String nombre) {
        try (PreparedStatement pst = crearConexion().prepareStatement("DELETE FROM marca WHERE idMarca = (SELECT idMarca FROM marca WHERE nombre ='" + nombre + "');")) {
            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean modificarMarca(MarcaBean bean, String nombre) {
        try (PreparedStatement pst = crearConexion().prepareStatement("UPDATE marca SET nombre=?, descripcion=? WHERE idMarca = (SELECT idMarca FROM marca WHERE nombre='" + nombre + "');")) {
            pst.setString(1, bean.getNombre());
            pst.setString(2, bean.getDescripcion());
            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Queue<MarcaBean> consultarMarcas() {
        Queue<MarcaBean> colaMarca = new LinkedList<>();
        try (PreparedStatement pst = crearConexion().prepareStatement("SELECT * FROM marca;")) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                colaMarca.add(new MarcaBean(rs.getString("nombre"), rs.getString("descripcion")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return colaMarca;
    }
}

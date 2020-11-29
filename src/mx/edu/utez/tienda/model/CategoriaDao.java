package mx.edu.utez.tienda.model;

import com.mysql.cj.conf.PropertyDefinitions;
import mx.edu.utez.tienda.utility.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Queue;

public class CategoriaDao extends Conexion {
    public boolean insertarCategoria(CategoriaBean bean) {
        try (PreparedStatement pst = crearConexion().prepareStatement("INSERT INTO categoria (nombre,descripcion) VALUES(?,?);")) {
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

    public boolean eliminarCategoria(String nombre) {
        try (PreparedStatement pst = crearConexion().prepareStatement("DELETE FROM categoria WHERE nombre = '" + nombre + "';")) {
            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean modificarCategoria(CategoriaBean bean, String nombre) {
        try (PreparedStatement pst = crearConexion().prepareStatement("UPDATE categoria SET nombre =?, descripcion=? WHERE idCategoria = (select idCategoria from categoria where nombre ='"+nombre+"');")) {
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

    public Queue<CategoriaBean> consultarCategorias() {
        Queue<CategoriaBean> colaCategorias = new LinkedList<>();
        try (PreparedStatement pst = crearConexion().prepareStatement("SELECT * FROM categoria ORDER BY nombre, descripcion ASC")) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                colaCategorias.add(new CategoriaBean(rs.getString("nombre"), rs.getString("descripcion")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return colaCategorias;
    }
}

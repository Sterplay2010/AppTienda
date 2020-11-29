package mx.edu.utez.tienda.action;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;
import mx.edu.utez.tienda.model.LoginDao;
import mx.edu.utez.tienda.model.LoginBean;
import mx.edu.utez.tienda.model.CategoriaDao;
import mx.edu.utez.tienda.model.CategoriaBean;
import mx.edu.utez.tienda.model.MarcaDao;
import mx.edu.utez.tienda.model.MarcaBean;
import mx.edu.utez.tienda.model.ProductoDao;
import mx.edu.utez.tienda.model.ProductoBean;

import java.util.LinkedList;
import java.util.Queue;

public class MainAction {
    private Queue<CategoriaBean> colaCategorias = new LinkedList<>();
    private Queue<MarcaBean> colaMarca = new LinkedList<>();
    private Queue<ProductoBean> colaProducto = new LinkedList<>();

    public boolean iniciarSesion(String usuario, String contrasenia) {
        return new LoginDao().sesion(new LoginBean(usuario, contrasenia));//mandamos los datos de consulta
    }

    public boolean agregarCategoria(String nombre, String descripcion){
        return new CategoriaDao().insertarCategoria(new CategoriaBean(nombre,descripcion));
    }

    public boolean eliminarCategoria(String nombre){
        return new CategoriaDao().eliminarCategoria(nombre);
    }

    public boolean modificarCategoria(String aux, String descripcion, String nombre){
        return new CategoriaDao().modificarCategoria(new CategoriaBean(aux,descripcion), nombre);
    }

    public boolean validarNombreCategoria(String nombre) {
        colaCategorias = new CategoriaDao().consultarCategorias();
        for (CategoriaBean var : colaCategorias) {
            if (var.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public boolean validarNombreMarca(String nombre) {
        colaMarca = new MarcaDao().consultarMarcas();
        for (MarcaBean var : colaMarca) {
            if (var.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }
    public boolean validarNombreProducto(String nombre){
        colaProducto = new ProductoDao().consultarProductos();
        for (ProductoBean var : colaProducto) {
            if (var.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }
}

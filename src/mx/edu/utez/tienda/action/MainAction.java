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
import sun.awt.AWTAccessor;

import java.util.LinkedList;
import java.util.Queue;

public class MainAction {
    private Queue<CategoriaBean> colaCategorias = new LinkedList<>();
    private Queue<MarcaBean> colaMarca = new LinkedList<>();
    private Queue<ProductoBean> colaProducto = new LinkedList<>();

    public boolean iniciarSesion(String usuario, String contrasenia) {
        return new LoginDao().sesion(new LoginBean(usuario, contrasenia));//mandamos los datos de consulta
    }

    public boolean agregarCategoria(String nombre, String descripcion) {
        return new CategoriaDao().insertarCategoria(new CategoriaBean(nombre, descripcion));
    }

    public boolean eliminarCategoria(String nombre) {
        return new CategoriaDao().eliminarCategoria(nombre);
    }

    public boolean modificarCategoria(String aux, String descripcion, String nombre) {
        return new CategoriaDao().modificarCategoria(new CategoriaBean(aux, descripcion), nombre);
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

    public boolean agregarMarca(String nombre, String descripcion) {
        return new MarcaDao().insertarMarca(new MarcaBean(nombre, descripcion));
    }

    public boolean eliminarMarca(String nombre) {
        return new MarcaDao().eliminarMarca(nombre);
    }

    public boolean modificarMarca(String aux,String descripcion, String nombre) {
        return new MarcaDao().modificarMarca(new MarcaBean(aux, descripcion), nombre);
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

    public boolean agregarProducto(String codigoBarra, String nombre, String nombreCategoria, String nombreMarca,int existencia, double precio,String descripcion){
        return new ProductoDao().insertarProducto(new ProductoBean(codigoBarra,nombre,nombreCategoria,nombreMarca,existencia,precio,descripcion));
    }

    public boolean eliminarProducto(String codigoBarra){
        return new ProductoDao().eliminarProducto(codigoBarra);
    }

    public boolean modificarProducto(String aux,String nombre, String nombreCategoria, String nombreMarca, int existencia, double precio, String descripion, String codigoBarra){
        return new ProductoDao().modificarProducto(new ProductoBean(aux,nombre,nombreCategoria,nombreMarca,existencia,precio,descripion),codigoBarra);
    }

    public boolean validarCodigoBarraProducto(String codigoBarra) {
        colaProducto = new ProductoDao().consultarProductos();
        for (ProductoBean var : colaProducto) {
            if (var.getCodigoBarra().equals(codigoBarra)) {
                return true;
            }
        }
        return false;
    }
}

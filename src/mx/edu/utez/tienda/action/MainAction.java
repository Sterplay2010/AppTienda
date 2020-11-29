package mx.edu.utez.tienda.action;
import  mx.edu.utez.tienda.model.LoginDao;
import  mx.edu.utez.tienda.model.LoginBean;
import  mx.edu.utez.tienda.model.CategoriaDao;
import  mx.edu.utez.tienda.model.CategoriaBean;
import  mx.edu.utez.tienda.model.MarcaDao;
import  mx.edu.utez.tienda.model.MarcaBean;
import  mx.edu.utez.tienda.model.ProductoDao;
import  mx.edu.utez.tienda.model.ProductoBean;
public class MainAction {
    public boolean iniciarSesion(String usuario, String contrasenia){
        return new LoginDao().sesion(new LoginBean(usuario,contrasenia));//mandamos los datos de consulta
    }
}

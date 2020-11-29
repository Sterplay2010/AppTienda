package mx.edu.utez.tienda.model;

import mx.edu.utez.tienda.utility.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao extends Conexion {
    public boolean sesion(LoginBean bean){
        try(PreparedStatement pst = crearConexion().prepareStatement("Select * FROM usuario")){
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                LoginBean beanBD = new LoginBean(rs.getString("nick"),rs.getString("contrasenia"));
                if(bean.getUsuario().equals(beanBD.getUsuario())&&bean.getContrasenia().equals(beanBD.getContrasenia())){
                    return true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(new LoginDao().sesion(new LoginBean("jair","123")));
    }
}

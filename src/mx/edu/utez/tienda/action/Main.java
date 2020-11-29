package mx.edu.utez.tienda.action;

import mx.edu.utez.tienda.action.MainAction;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // MENU PRINCIPAL DE LA APLICACIÓN

        boolean salir1 = false, salir2 = false;
        int opcion;
        String usuario, contrasenia;
        while (!salir1) {
            System.out.println("\n" +
                    "__ __ __ __ __ __  |  _  _ o._   __ __ __ __ __ __ \n" +
                    "                   |_(_)(_||| |                    \n" +
                    "                         _|                        ");
            System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");

            System.out.print("Usuario: ");
            usuario = in.next();
            System.out.print("Contraseña: ");
            contrasenia = in.next();
            if (new MainAction().iniciarSesion(usuario, contrasenia)) { //validamos la sesión
                while (!salir2) {
                    new Operacion().salto();
                    System.out.println("                    _                                            \n" +
                            "__ __ __ __ __ __  |_)o _ ._     _ ._ o _| _   __ __ __ __ __ __ \n" +
                            "                   |_)|(/_| |\\/ (/_| ||(_|(_)");
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("1) Operaciones con Categorias.");
                    System.out.println("2) Operaciones con Marcas.");
                    System.out.println("3) Operaciones con Productos.");
                    System.out.println("4) Salir.");
                    System.out.print("opción: ");
                    opcion = in.nextInt();
                    new Operacion().salto();
                    switch (opcion) {
                        case 1:
                            new Operacion().menuCategorias();
                            break;
                        case 2:
                            new Operacion().menuMarcas();
                            break;
                        case 3:
                            new Operacion().menuProductos();
                            break;
                        case 4:
                            salir2=true;//salida interna de esté menú
                            salir1=true;//salida externa del login
                            break;
                        default:
                            System.out.println("Opción Inválida");
                    }
                }
            } else {
                System.out.println("Usuario o contraseña incorrectos.");
            }
        }
    }
}

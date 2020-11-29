package mx.edu.utez.tienda.action;

import java.util.Scanner;

import mx.edu.utez.tienda.action.Operacion;

public class Operacion {
    Scanner in = new Scanner(System.in);

    public void menuCategorias() {
        boolean salir = false;
        int opcion;
        while (!salir) {
            System.out.println("__ __ __ __ __ __   |\\/| _ ._      __ __ __ __ __ __ \n" +
                    "                    |  |(/_| ||_|                   ");
            System.out.println("----------------------------------------------------");
            System.out.println("1) Registrar Categoria Nueva.");
            System.out.println("2) Eliminar Una Categoria");
            System.out.println("3) Consultar Todas Las Categorias.");
            System.out.println("4) Modificar Categoria Existente.");
            System.out.println("5) Regresar.");
            System.out.print("opción: ");
            opcion = in.nextInt();
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public void menuMarcas() {
        boolean salir = false;
        int opcion;
        while (!salir) {
            System.out.println("__ __ __ __ __ __   |\\/| _ ._      __ __ __ __ __ __ \n" +
                    "                    |  |(/_| ||_|                   ");
            System.out.println("----------------------------------------------------");
            System.out.println("1) Registrar Marca Nueva.");
            System.out.println("2) Eliminar Una Marca");
            System.out.println("3) Consultar Todas Las Marcas.");
            System.out.println("4) Modificar Marca Existente.");
            System.out.println("5) Regresar.");
            System.out.print("opción: ");
            opcion = in.nextInt();
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public void menuProductos() {
        boolean salir = false;
        int opcion;
        while (!salir) {
            System.out.println("__ __ __ __ __ __   |\\/| _ ._      __ __ __ __ __ __ \n" +
                    "                    |  |(/_| ||_|                   ");
            System.out.println("----------------------------------------------------");
            System.out.println("1) Registrar Producto Nuevo.");
            System.out.println("2) Eliminar Un Producto");
            System.out.println("3) Consultar Todos Los Productos.");
            System.out.println("4) Modificar Producto Existente.");
            System.out.println("5) Regresar.");
            System.out.print("opción: ");
            opcion = in.nextInt();
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    public void salto() {
        System.out.println("\n\n");//saltos de linea
    }
}

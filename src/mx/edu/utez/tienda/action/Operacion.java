package mx.edu.utez.tienda.action;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import mx.edu.utez.tienda.action.Operacion;
import mx.edu.utez.tienda.model.CategoriaBean;
import mx.edu.utez.tienda.model.CategoriaDao;

public class Operacion {
    Scanner in = new Scanner(System.in);
    Queue<CategoriaBean> categorias = new LinkedList<>();

    public void menuCategorias() {
        in.useDelimiter("\n");
        String nombre, descripcion = "", bandera,aux;
        boolean salir = false;
        while (!salir) {
            int opcion = 0;
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
                    try {
                        System.out.println("----------------------------------------------------");
                        System.out.println("                 Registrar Categoria                ");
                        System.out.println("----------------------------------------------------");
                        System.out.print("Ingresa el nombre de la categoria nueva: ");
                        nombre = in.next();
                        if (new MainAction().validarNombreCategoria(nombre)) {
                            System.out.println("Esta categoría ya está registrada, intente nuevamente con un nombre distinto.");
                        } else {
                            System.out.println("Desea agregar una descripción? S/N");
                            bandera = in.next();
                            if (bandera.equals("S") || bandera.equals("s")) {
                                System.out.print("Descripcion: ");
                                descripcion = in.next();
                                if (new MainAction().agregarCategoria(nombre, descripcion)) {
                                    System.out.println("Categoría registrada con éxito.");
                                }
                            } else {
                                System.out.println(nombre + " " + descripcion);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Hubo un error al guardar, intente nuevamente (verifique que los datos sean correctos)");
                    }
                    break;
                case 2:
                    categorias = new CategoriaDao().consultarCategorias();
                    try {
                        System.out.println("----------------------------------------------------");
                        System.out.println("                 Eliminar Categoria                 ");
                        System.out.println("----------------------------------------------------");
                        System.out.println("                Categorias Existentes               ");
                        for (CategoriaBean var: categorias){
                            System.out.println("Nombre: "+var.getNombre()+"  Descripcion: "+var.getDescripcion());
                        }
                        System.out.print("Ingresa el nombre de la Categoria: ");
                        nombre = in.next();
                        if(new MainAction().eliminarCategoria(nombre)){
                            System.out.println("Categoría eliminada con éxito.");
                        }else{
                            System.out.println("Hubo un error al eliminar, intente nuevamente.");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    categorias.clear();
                    break;
                case 3:
                    categorias = new CategoriaDao().consultarCategorias();
                    System.out.println("----------------------------------------------------");
                    System.out.println("                 Consultar Categorias               ");
                    System.out.println("----------------------------------------------------");
                    System.out.println("                Categorias Existentes               ");
                    for (CategoriaBean var: categorias){
                        System.out.println("Nombre: "+var.getNombre()+"  Descripcion: "+var.getDescripcion());
                    }
                    categorias.clear();
                    break;
                case 4:
                    categorias = new CategoriaDao().consultarCategorias();
                    System.out.println("----------------------------------------------------");
                    System.out.println("                 Modificar Categoria                ");
                    System.out.println("----------------------------------------------------");
                    for (CategoriaBean var: categorias){
                        System.out.println("Nombre: "+var.getNombre()+"  Descripcion: "+var.getDescripcion());
                    }
                    System.out.print("Ingresa el nombre de la categoria existente: ");
                    nombre = in.next();
                    System.out.println("Ingresa el nuevo nombre de la categoria: ");
                    aux=in.next();
                    if (new MainAction().validarNombreCategoria(aux)) {
                        System.out.println("Esta categoría ya está registrada, intente nuevamente con un nombre distinto.");
                    } else {
                        System.out.println("Desea agregar una descripción? S/N");
                        bandera = in.next();
                        if (bandera.equals("S") || bandera.equals("s")) {
                            System.out.print("Descripcion: ");
                            descripcion = in.next();
                            if (new MainAction().modificarCategoria(aux, descripcion, nombre)) {
                                System.out.println("Categoría Actualizada con éxito.");
                            }
                        } else {
                            System.out.println(nombre + " " + descripcion);
                        }
                    }
                    categorias.clear();
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
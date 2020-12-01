package mx.edu.utez.tienda.action;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import mx.edu.utez.tienda.action.Operacion;
import mx.edu.utez.tienda.model.*;

public class Operacion {
    Scanner in = new Scanner(System.in);
    Queue<CategoriaBean> categorias = new LinkedList<>();
    Queue<MarcaBean> marcas = new LinkedList<>();
    Queue<ProductoBean> productos = new LinkedList<>();

    public void menuCategorias() {
        in.useDelimiter("\n");
        String nombre, descripcion = " ", bandera, aux;
        boolean salir = false;
        while (!salir) {
            int opcion = 0;
            System.out.println("__ __ __ __ __ __   |\\/| _ ._      __ __ __ __ __ __ \n" +
                    "                    |  |(/_| ||_|                   ");
            System.out.println("----------------------------------------------------");
            System.out.println("1) Registrar Categoria Nueva.");
            System.out.println("");
            System.out.println("2) Eliminar Una Categoria");
            System.out.println("");
            System.out.println("3) Consultar Todas Las Categorias.");
            System.out.println("");
            System.out.println("4) Modificar Categoria Existente.");
            System.out.println("");
            System.out.println("5) Regresar.");
            System.out.println("");
            System.out.print("opción: ");
            opcion = in.nextInt();
            switch (opcion) {
                case 1:
                    try {
                        System.out.println("----------------------------------------------------");
                        System.out.println("                 Registrar Categoria                ");
                        System.out.println("----------------------------------------------------");
                        System.out.print("Ingresa el nombre de la categoria nueva: ");
                        nombre = in.next().toLowerCase();
                        if (new MainAction().validarNombreCategoria(nombre)) {
                            System.out.println("Esta categoría ya está registrada, intente nuevamente con un nombre distinto.");
                        } else {
                            System.out.println("Desea agregar una descripción? S/N");
                            bandera = in.next();
                            if (bandera.equals("S") || bandera.equals("s")) {
                                System.out.print("Descripcion: ");
                                descripcion = in.next().toLowerCase();
                                if (new MainAction().agregarCategoria(nombre, descripcion)) {
                                    System.out.println("Categoría registrada con éxito.");
                                } else {
                                    System.out.println("Hubo un error al guardar, intente nuevamente (verifique que los datos sean correctos)");
                                }
                            } else {
                                if (new MainAction().agregarCategoria(nombre, descripcion)) {
                                    System.out.println("Categoría registrada con éxito.");
                                } else {
                                    System.out.println("Hubo un error al guardar, intente nuevamente (verifique que los datos sean correctos)");
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    categorias = new CategoriaDao().consultarCategorias();
                    try {
                        System.out.println("----------------------------------------------------");
                        System.out.println("                 Eliminar Categoria                 ");
                        System.out.println("----------------------------------------------------");
                        System.out.println("                Categorias Existentes               ");
                        System.out.println("");
                        for (CategoriaBean var : categorias) {
                            System.out.println("Nombre: " + var.getNombre() + "            Descripcion: " + var.getDescripcion());
                            System.out.println("");
                        }
                        System.out.println("");
                        System.out.print("Ingresa el nombre de la Categoria: ");
                        nombre = in.next().toLowerCase();
                        if (new MainAction().eliminarCategoria(nombre)) {
                            System.out.println("Categoría eliminada con éxito.");
                        } else {
                            System.out.println("Hubo un error al eliminar, intente nuevamente.");
                        }
                    } catch (Exception e) {
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
                    System.out.println("");
                    for (CategoriaBean var : categorias) {
                        System.out.println("Nombre: " + var.getNombre() + "  Descripcion: " + var.getDescripcion());
                        System.out.println("");
                    }
                    categorias.clear();
                    break;
                case 4:
                    categorias = new CategoriaDao().consultarCategorias();
                    try {
                        System.out.println("----------------------------------------------------");
                        System.out.println("                 Modificar Categoria                ");
                        System.out.println("----------------------------------------------------");
                        System.out.println("");
                        for (CategoriaBean var : categorias) {
                            System.out.println("Nombre: " + var.getNombre() + "            Descripcion: " + var.getDescripcion());
                            System.out.println("");
                        }
                        System.out.println("");
                        System.out.print("Ingresa el nombre de la categoria existente: ");
                        nombre = in.next().toLowerCase();
                        System.out.println("Ingresa el nuevo nombre de la categoria: ");
                        aux = in.next().toLowerCase();
                        if (new MainAction().validarNombreCategoria(aux)) {
                            System.out.println("Esta categoría ya está registrada, intente nuevamente con un nombre distinto.");
                        } else {
                            System.out.println("Desea agregar una descripción? S/N");
                            bandera = in.next().toLowerCase();
                            if (bandera.equals("S") || bandera.equals("s")) {
                                System.out.print("Descripcion: ");
                                descripcion = in.next().toLowerCase();
                                if (new MainAction().modificarCategoria(aux, descripcion, nombre)) {
                                    System.out.println("Categoría Actualizada con éxito.");
                                } else {
                                    System.out.println("Hubo un error al actualizar, intente nuevamente (verifique que los datos sean correctos).");
                                }
                            } else {
                                if (new MainAction().modificarCategoria(aux, descripcion, nombre)) {
                                    System.out.println("Categoría Actualizada con éxito.");
                                } else {
                                    System.out.println("Hubo un error al actualizar, intente nuevamente (verifique que los datos sean correctos).");
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
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
        in.useDelimiter("\n");
        String nombre, descripcion = "", bandera, aux;
        boolean salir = false;
        int opcion = 0;
        while (!salir) {
            System.out.println("__ __ __ __ __ __   |\\/| _ ._      __ __ __ __ __ __ \n" +
                    "                    |  |(/_| ||_|                   ");
            System.out.println("----------------------------------------------------");
            System.out.println("1) Registrar Marca Nueva.");
            System.out.println("");
            System.out.println("2) Eliminar Una Marca");
            System.out.println("");
            System.out.println("3) Consultar Todas Las Marcas.");
            System.out.println("");
            System.out.println("4) Modificar Marca Existente.");
            System.out.println("");
            System.out.println("5) Regresar.");
            System.out.println("");
            System.out.print("opción: ");
            opcion = in.nextInt();
            switch (opcion) {
                case 1:
                    try {
                        System.out.println("----------------------------------------------------");
                        System.out.println("                   Registrar Marca                  ");
                        System.out.println("----------------------------------------------------");
                        System.out.print("Ingresa el nombre de la Marca nueva: ");
                        nombre = in.next().toLowerCase();
                        if (new MainAction().validarNombreMarca(nombre)) {
                            System.out.println("Esta Marca ya está registrada, intente nuevamente con un nombre distinto.");
                        } else {
                            System.out.println("Desea agregar una descripción? S/N");
                            bandera = in.next();
                            if (bandera.equals("S") || bandera.equals("s")) {
                                System.out.print("Descripcion: ");
                                descripcion = in.next().toLowerCase();
                                if (new MainAction().agregarMarca(nombre, descripcion)) {
                                    System.out.println("Marca registrada con éxito.");
                                } else {
                                    System.out.println("Hubo un error al guardar, intente nuevamente (verifique que los datos sean correctos)");
                                }
                            } else {
                                if (new MainAction().agregarMarca(nombre, descripcion)) {
                                    System.out.println("Categoría registrada con éxito.");
                                } else {
                                    System.out.println("Hubo un error al guardar, intente nuevamente (verifique que los datos sean correctos)");
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    marcas = new MarcaDao().consultarMarcas();
                    try {
                        System.out.println("----------------------------------------------------");
                        System.out.println("                    Eliminar Marca                  ");
                        System.out.println("----------------------------------------------------");
                        System.out.println("                   Marcas Existentes                ");
                        System.out.println("");
                        for (MarcaBean var : marcas) {
                            System.out.println("Nombre:  " + var.getNombre() + "          Descripcion: " + var.getDescripcion());
                            System.out.println("");
                        }
                        System.out.println("");
                        System.out.print("Ingresa el nombre de la Categoria: ");
                        nombre = in.next().toLowerCase();
                        if (new MainAction().eliminarMarca(nombre)) {
                            System.out.println("Categoría eliminada con éxito.");
                        } else {
                            System.out.println("Hubo un error al eliminar, intente nuevamente.");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    marcas.clear();
                    break;
                case 3:
                    marcas = new MarcaDao().consultarMarcas();
                    System.out.println("----------------------------------------------------");
                    System.out.println("                   Consultar Marcas                 ");
                    System.out.println("----------------------------------------------------");
                    System.out.println("                   Marcas Existentes                ");
                    System.out.println("");
                    for (MarcaBean var : marcas) {
                        System.out.println("Nombre: " + var.getNombre() + "  Descripcion: " + var.getDescripcion());
                        System.out.println("");
                    }
                    marcas.clear();
                    break;
                case 4:
                    marcas = new MarcaDao().consultarMarcas();
                    try {
                        System.out.println("----------------------------------------------------");
                        System.out.println("                    Modificar Marca                 ");
                        System.out.println("----------------------------------------------------");
                        System.out.println("");
                        for (MarcaBean var : marcas) {
                            System.out.println("Nombre: " + var.getNombre() + "            Descripcion: " + var.getDescripcion());
                            System.out.println("");
                        }
                        System.out.println("");
                        System.out.print("Ingresa el nombre de la marca existente: ");
                        nombre = in.next().toLowerCase();
                        System.out.println("Ingresa el nuevo nombre de la marca: ");
                        aux = in.next().toLowerCase();
                        if (new MainAction().validarNombreMarca(aux)) {
                            System.out.println("Esta Marca ya está registrada, intente nuevamente con un nombre distinto.");
                        } else {
                            System.out.println("Desea agregar una descripción? S/N");
                            bandera = in.next().toLowerCase();
                            if (bandera.equals("S") || bandera.equals("s")) {
                                System.out.print("Descripcion: ");
                                descripcion = in.next().toLowerCase();
                                if (new MainAction().modificarMarca(aux, descripcion, nombre)) {
                                    System.out.println("Marca Actualizada con éxito.");
                                } else {
                                    System.out.println("Hubo un error al actualizar, intente nuevamente (verifique que los datos sean correctos).");
                                }
                            } else {
                                if (new MainAction().modificarMarca(aux, descripcion, nombre)) {
                                    System.out.println("Marca Actualizada con éxito.");
                                } else {
                                    System.out.println("Hubo un error al actualizar, intente nuevamente (verifique que los datos sean correctos).");

                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
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

    public void menuProductos() {
        in.useDelimiter("\n");
        boolean salir = false;
        String nombre, nombreCategoria, nombreMarca, descripcion = " ", codigoBarra = "", bandera, aux;
        int existencia;
        double precio;
        int opcion = 0;
        while (!salir) {
            System.out.println("__ __ __ __ __ __   |\\/| _ ._      __ __ __ __ __ __ \n" +
                    "                    |  |(/_| ||_|                   ");
            System.out.println("----------------------------------------------------");
            System.out.println("1) Registrar Producto Nuevo.");
            System.out.println("");
            System.out.println("2) Eliminar Un Producto");
            System.out.println("");
            System.out.println("3) Consultar Todos Los Productos.");
            System.out.println("");
            System.out.println("4) Modificar Producto Existente.");
            System.out.println("");
            System.out.println("5) Regresar.");
            System.out.println("");
            System.out.print("opción: ");
            opcion = in.nextInt();
            switch (opcion) {
                case 1:
                    marcas = new MarcaDao().consultarMarcas();
                    categorias = new CategoriaDao().consultarCategorias();
                    try {
                        System.out.println("----------------------------------------------------");
                        System.out.println("                   Registrar Producto               ");
                        System.out.println("----------------------------------------------------");
                        System.out.println("                  Categorias Existente              ");
                        System.out.println("");
                        for (CategoriaBean var : categorias) {
                            System.out.println("Nombre: " + var.getNombre() + "            Descripcion: " + var.getDescripcion());
                            System.out.println("");
                        }
                        System.out.println("----------------------------------------------------");
                        System.out.println("                    Marcas Existentes               ");
                        System.out.println("");
                        for (MarcaBean var : marcas) {
                            System.out.println("Nombre: " + var.getNombre() + "            Descripcion: " + var.getDescripcion());
                            System.out.println("");
                        }
                        System.out.println("----------------------------------------------------");
                        System.out.print("Código del producto: ");
                        codigoBarra = in.next();
                        if (!new MainAction().validarCodigoBarraProducto(codigoBarra)) {
                            System.out.print("Nombre del producto: ");
                            nombre = in.next();
                            System.out.print("Categoria del producto: ");
                            nombreCategoria = in.next();
                            System.out.print("Marca del producto: ");
                            nombreMarca = in.next();
                            System.out.print("Existencia: ");
                            existencia = in.nextInt();
                            if (existencia <= 0) {
                                System.out.println("La existencia debe ser mayor a 0.");
                            } else {
                                System.out.print("Precio $: ");
                                precio = in.nextDouble();
                                if (precio <= 0) {
                                    System.out.println("El precio debe ser mayor a 0");
                                } else {
                                    System.out.print("Desea agregar una descripción? S/N: ");
                                    bandera = in.next();
                                    if (bandera.equals("S") || bandera.equals("s")) {
                                        System.out.print("Descripción: ");
                                        descripcion = in.next();
                                        if (new MainAction().agregarProducto(codigoBarra, nombre, nombreCategoria, nombreMarca, existencia, precio, descripcion)) {
                                            System.out.println("“Producto registrado con éxito”.");
                                        } else {
                                            System.out.println("Hubo un error al guardar, intente nuevamente (verifique que los datos sean correctos).");
                                        }
                                    } else {
                                        if (new MainAction().agregarProducto(codigoBarra, nombre, nombreCategoria, nombreMarca, existencia, precio, descripcion)) {
                                            System.out.println("“Producto registrado con éxito”.");
                                        } else {
                                            System.out.println("Hubo un error al guardar, intente nuevamente (verifique que los datos sean correctos).");
                                        }
                                    }
                                }
                            }
                        } else {
                            System.out.println("Este producto ya está registrado, intente nuevamente con un código distinto");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    marcas.clear();
                    categorias.clear();
                    break;
                case 2:
                    productos = new ProductoDao().consultarProductos();
                    try {
                        System.out.println("----------------------------------------------------");
                        System.out.println("                    Eliminar Producto               ");
                        System.out.println("----------------------------------------------------");
                        System.out.println("                   Productos Existentes             ");
                        System.out.println("");
                        for (ProductoBean var : productos) {
                            System.out.println("Código: " + var.getCodigoBarra() + "    Nombre: " + var.getNombre() + "     Descripcion:  " + var.getDescripcion());
                            System.out.println("");
                        }
                        System.out.println("");
                        System.out.print("Ingresa el nombre de la código del producto: ");
                        codigoBarra = in.next().toLowerCase();
                        if (new MainAction().eliminarProducto(codigoBarra)) {
                            System.out.println("Categoría eliminada con éxito.");
                        } else {
                            System.out.println("Hubo un error al eliminar, intente nuevamente.");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    productos.clear();
                    break;
                case 3:
                    marcas = new MarcaDao().consultarMarcas();
                    categorias = new CategoriaDao().consultarCategorias();
                    productos = new ProductoDao().consultarProductos();
                    try {
                        System.out.println("----------------------------------------------------");
                        System.out.println("                   Modificar Producto               ");
                        System.out.println("----------------------------------------------------");
                        System.out.println("                  Categorias Existente              ");
                        System.out.println("");
                        for (CategoriaBean var : categorias) {
                            System.out.println("Nombre: " + var.getNombre() + "            Descripcion: " + var.getDescripcion());
                            System.out.println("");
                        }
                        System.out.println("----------------------------------------------------");
                        System.out.println("                    Marcas Existentes               ");
                        System.out.println("");
                        for (MarcaBean var : marcas) {
                            System.out.println("Nombre: " + var.getNombre() + "            Descripcion: " + var.getDescripcion());
                            System.out.println("");
                        }
                        System.out.println("----------------------------------------------------");
                        System.out.println("                 Productos Existentes               ");
                        System.out.println("");
                        for (ProductoBean var : productos) {
                            System.out.println("Código: " + var.getCodigoBarra());
                            System.out.println("Nombre: " + var.getNombre());
                            System.out.println("Existencia: " + var.getExistencia());
                            System.out.println("Precio: $" + var.getPrecio());
                            System.out.println("----------------------------------------------------");
                        }
                        System.out.println("----------------------------------------------------");
                        System.out.print("Código del producto a modificar: ");
                        codigoBarra = in.next();
                        System.out.println("Código Nuevo del producto");//VERIFICAR SI ES QUE SE PUEDE MODIFICAR EL CÓDIGO
                        aux = in.next();
                        if (!new MainAction().validarCodigoBarraProducto(aux)) {
                            System.out.print("Nombre del producto: ");
                            nombre = in.next();
                            System.out.print("Categoria del producto: ");
                            nombreCategoria = in.next();
                            System.out.print("Marca del producto: ");
                            nombreMarca = in.next();
                            System.out.print("Existencia: ");
                            existencia = in.nextInt();
                            if (existencia <= 0) {
                                System.out.println("La existencia debe ser mayor a 0.");
                            } else {
                                System.out.print("Precio $: ");
                                precio = in.nextDouble();
                                if (precio <= 0) {
                                    System.out.println("El precio debe ser mayor a 0");
                                } else {
                                    System.out.print("Desea agregar una descripción? S/N: ");
                                    bandera = in.next();
                                    if (bandera.equals("S") || bandera.equals("s")) {
                                        System.out.print("Descripción: ");
                                        descripcion = in.next();
                                        if (new MainAction().modificarProducto(aux, nombre, nombreCategoria, nombreMarca, existencia, precio, descripcion, codigoBarra)) {
                                            System.out.println("“Producto registrado con éxito”.");
                                        } else {
                                            System.out.println("Hubo un error al guardar, intente nuevamente (verifique que los datos sean correctos).");
                                        }
                                    } else {
                                        if (new MainAction().modificarProducto(aux, nombre, nombreCategoria, nombreMarca, existencia, precio, descripcion,codigoBarra)) {
                                            System.out.println("“Producto registrado con éxito”.");
                                        } else {
                                            System.out.println("Hubo un error al guardar, intente nuevamente (verifique que los datos sean correctos).");
                                        }
                                    }
                                }
                            }
                        } else {
                            System.out.println("Este producto ya está registrado, intente nuevamente con un código distinto");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    marcas.clear();
                    categorias.clear();
                    productos.clear();
                    break;
                case 4:
                    productos = new ProductoDao().consultarProductos();
                    System.out.println("----------------------------------------------------");
                    System.out.println("                 Consultar Productos                ");
                    System.out.println("----------------------------------------------------");
                    System.out.println("                 Productos Existentes               ");
                    System.out.println("");
                    for (ProductoBean var : productos) {
                        System.out.println("Código: " + var.getCodigoBarra());
                        System.out.println("Nombre: " + var.getNombre());
                        System.out.println("Existencia: " + var.getExistencia());
                        System.out.println("Precio: $" + var.getPrecio());
                        System.out.println("----------------------------------------------------");
                    }
                    productos.clear();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

}

package mx.edu.utez.tienda.model;

public class ProductoBean {
    private int codigo;
    private String nombre;
    private int idCategoria;
    private int idMarca;
    private int exitencia;
    private double precio;
    private String descripcion;
    private String codigoBarra;

    public ProductoBean() {
    }

    public ProductoBean(int codigo, String nombre, int idCategoria, int idMarca, int exitencia, double precio, String descripcion, String codigoBarra) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.idCategoria = idCategoria;
        this.idMarca = idMarca;
        this.exitencia = exitencia;
        this.precio = precio;
        this.descripcion = descripcion;
        this.codigoBarra = codigoBarra;
    }

    public ProductoBean(String nombre, int idCategoria, int idMarca, int exitencia, double precio, String descripcion, String codigoBarra) {
        this.nombre = nombre;
        this.idCategoria = idCategoria;
        this.idMarca = idMarca;
        this.exitencia = exitencia;
        this.precio = precio;
        this.descripcion = descripcion;
        this.codigoBarra=codigoBarra;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public int getExitencia() {
        return exitencia;
    }

    public void setExitencia(int exitencia) {
        this.exitencia = exitencia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
}

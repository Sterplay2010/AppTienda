package mx.edu.utez.tienda.model;

public class ProductoBean {
    private int codigo;
    private String nombre;
    private String idCategoria;
    private String idMarca;
    private int existencia;
    private double precio;
    private String descripcion;
    private String codigoBarra;

    public ProductoBean() {
    }

    public ProductoBean(String codigoBarra, String nombre, String idCategoria, String idMarca, int existencia, double precio, String descripcion) {
        this.nombre = nombre;
        this.idCategoria = idCategoria;
        this.idMarca = idMarca;
        this.existencia = existencia;
        this.precio = precio;
        this.descripcion = descripcion;
        this.codigoBarra = codigoBarra;
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

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(String idMarca) {
        this.idMarca = idMarca;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExsitencia(int existencia) {
        this.existencia = existencia;
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

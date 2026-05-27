package models;

public class Libro {

    private int idLibro;
    private String nombre;
    private String anoPublicacion;
    private Categoria categoria;

    public Libro(){
    }

    public Libro(int idLibro, String nombre, String anoPublicacion, Categoria categoria) {
        this.idLibro = idLibro;
        this.nombre = nombre;
        this.anoPublicacion = anoPublicacion;
        this.categoria = categoria;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(String anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}

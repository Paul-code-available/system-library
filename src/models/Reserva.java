package models;

public class Reserva {

    private int idReserva;
    private String fechaReserva;
    private String fechaExpiracion;
    private String estado;
    private User user;
    private Book libro;

    public Reserva() {}

    public Reserva(int idReserva, String fechaReserva, String fechaExpiracion, String estado, User user, Book libro) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.fechaExpiracion = fechaExpiracion;
        this.estado = estado;
        this.user = user;
        this.libro = libro;
    }

    public int getIdReserva() { return idReserva; }
    public void setIdReserva(int idReserva) { this.idReserva = idReserva; }

    public String getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(String fechaReserva) { this.fechaReserva = fechaReserva; }

    public String getFechaExpiracion() { return fechaExpiracion; }
    public void setFechaExpiracion(String fechaExpiracion) { this.fechaExpiracion = fechaExpiracion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Book getLibro() { return libro; }
    public void setLibro(Book libro) { this.libro = libro; }
}
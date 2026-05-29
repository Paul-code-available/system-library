package models;

import java.time.LocalDate;

public class Prestamo {

    private int idPrestamo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private String estado;
    private User user;
    private Book libro;

    public Prestamo() {}
    
    public Prestamo(int idPrestamo,
            User user,
            Book libro,
            LocalDate fechaPrestamo,
            LocalDate fechaDevolucion,
            String estado) {

    	this.idPrestamo = idPrestamo;
    	this.user = user;
    	this.libro = libro;
    	this.fechaPrestamo = fechaPrestamo;
    	this.fechaDevolucion = fechaDevolucion;
    	this.estado = estado;
    ;
    }

    public Prestamo(User user,Book libro,LocalDate fechaPrestamo,LocalDate fechaDevolucion,String estado) {

    	this.user = user;
    	this.libro = libro;
    	this.fechaPrestamo = fechaPrestamo;
    	this.fechaDevolucion = fechaDevolucion;
    	this.estado = estado;
    }

    public int getIdPrestamo() { return idPrestamo; }
    public void setIdPrestamo(int idPrestamo) { this.idPrestamo = idPrestamo; }

    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(LocalDate fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDate fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Book getLibro() { return libro; }
    public void setLibro(Book libro) { this.libro = libro; }
}

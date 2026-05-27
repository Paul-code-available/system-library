package models;

public class Multa {

    private int idMulta;
    private double monto;
    private String fechaCreacion;
    private String fechaLimitePago;
    private String estado;
    private Prestamo prestamo;

    public Multa() {}

    public Multa(int idMulta, double monto, String fechaCreacion, String fechaLimitePago, String estado, Prestamo prestamo) {
        this.idMulta = idMulta;
        this.monto = monto;
        this.fechaCreacion = fechaCreacion;
        this.fechaLimitePago = fechaLimitePago;
        this.estado = estado;
        this.prestamo = prestamo;
    }

    public int getIdMulta() { return idMulta; }
    public void setIdMulta(int idMulta) { this.idMulta = idMulta; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public String getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(String fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public String getFechaLimitePago() { return fechaLimitePago; }
    public void setFechaLimitePago(String fechaLimitePago) { this.fechaLimitePago = fechaLimitePago; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Prestamo getPrestamo() { return prestamo; }
    public void setPrestamo(Prestamo prestamo) { this.prestamo = prestamo; }
}
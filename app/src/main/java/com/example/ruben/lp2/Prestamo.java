package com.example.ruben.lp2;



import java.util.Date;


public class Prestamo {
    int idPrestamo;
    Alumno alumno;
    Date fecha;
    DetallePrestamo detalle;

    public Prestamo(int idPrestamo, Alumno alumno, Date fecha, DetallePrestamo detalle) {
        this.idPrestamo = idPrestamo;
        this.alumno = alumno;
        this.fecha = fecha;
        this.detalle = detalle;
    }

    public Integer getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public DetallePrestamo getDetalle() {
        return detalle;
    }

    public void setDetalle(DetallePrestamo detalle) {
        this.detalle = detalle;
    }
}

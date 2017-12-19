package com.example.ruben.lp2;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by ruben on 05/12/17.
 */
@Entity
public class Prestamo {
    @PrimaryKey(autoGenerate = true)
    int idPrestamo;
    @Embedded
    Alumno alumno;
    @ColumnInfo(name = "fecha")
    Date fecha;
    @Embedded
    DetallePrestamo detalle;

    public Prestamo(int idPrestamo, Alumno alumno, Date fecha, DetallePrestamo detalle) {
        this.idPrestamo = idPrestamo;
        this.alumno = alumno;
        this.fecha = fecha;
        this.detalle = detalle;
    }

    public int getIdPrestamo() {
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

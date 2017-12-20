package com.example.ruben.lp2;

import java.util.Date;



public class DetallePrestamo {

    int codPrestamo;
    Libro producto;
    Date fechaEntrega;
    int cantDias;



    public DetallePrestamo(int codPrestamo, Libro producto, Date fechaEntrega, int cantDias) {
        this.codPrestamo = codPrestamo;
        this.producto = producto;
        this.fechaEntrega = fechaEntrega;
        this.cantDias = cantDias;
    }

    public int getCodPrestamo() {
        return codPrestamo;
    }

    public void setCodPrestamo(int codPrestamo) {
        this.codPrestamo = codPrestamo;
    }

    public Libro getProducto() {
        return producto;
    }

    public void setProducto(Libro producto) {
        this.producto = producto;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }
}

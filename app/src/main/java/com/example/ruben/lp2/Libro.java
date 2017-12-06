package com.example.ruben.lp2;

/**
 * Created by ruben on 05/12/17.
 */

public class Libro {
    int isbnLibro;
    String descripcion;
    int disponibilidad;

    public Libro(int isbnLibro, String descripcion, int disponibilidad) {
        this.isbnLibro = isbnLibro;
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
    }

    public int getIsbnLibro() {
        return isbnLibro;
    }

    public void setIsbnLibro(int isbnLibro) {
        this.isbnLibro = isbnLibro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}

package com.example.ruben.lp2;

import java.util.ArrayList;

/**
 * Created by ruben on 05/12/17.
 */

public class LibroDao {
    private ArrayList<Libro> libros;

    public LibroDao() {
        libros = new ArrayList<>();
        libros.add(new Libro(1,"Libro 1", 5));
        libros.add(new Libro(2,"Libro 2", 5));
        libros.add(new Libro(3,"Libro 3", 5));
        libros.add(new Libro(4,"Libro 4", 5));
        libros.add(new Libro(5,"Libro 5", 5));
        libros.add(new Libro(6,"Libro 6", 5));
        libros.add(new Libro(7,"Libro 7", 5));
        libros.add(new Libro(8,"Libro 8", 5));
        libros.add(new Libro(9,"Libro 9", 5));
        libros.add(new Libro(1110,"Libro 10", 5));
        libros.add(new Libro(11122,"Libro 112", 5));
        libros.add(new Libro(113,"Libro 113", 5));

    }

    public ArrayList<Libro> findAll(){
        return this.libros;
    }


    public ArrayList<Libro> getByFilter(String query) {
        ArrayList<Libro> libros2 = new ArrayList<>();
        for (int i=0;i< this.libros.size();i++){
            if (this.libros.get(i).descripcion.contains(query)){
                libros2.add(this.libros.get(i));
            }
        }
        return libros2;
    }
}

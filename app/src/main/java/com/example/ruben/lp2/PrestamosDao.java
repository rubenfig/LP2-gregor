package com.example.ruben.lp2;

import java.util.ArrayList;


public class PrestamosDao {
    private ArrayList<Prestamo> prestamos;

    public PrestamosDao() {
        cargarPrestamos();

    }
    public void agregar(Prestamo p){
        this.prestamos.add(p);
    }

    private void cargarPrestamos(){
        prestamos = new ArrayList<>();

    }

    public ArrayList<Prestamo> findAll(){
        return this.prestamos;
    }


    public ArrayList<Prestamo> getByFilter(String query) {
        ArrayList<Prestamo> prestamos2 = new ArrayList<>();
        cargarPrestamos();
        for (int i=0;i< this.prestamos.size();i++){
            if (this.prestamos.get(i).getIdPrestamo().toString().contains(query)){
                prestamos2.add(this.prestamos.get(i));
            }
        }
        return prestamos2;
    }
}

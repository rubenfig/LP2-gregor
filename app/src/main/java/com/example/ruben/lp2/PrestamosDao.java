package com.example.ruben.lp2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by ruben on 05/12/17.
 */
@Dao
public interface PrestamosDao {

    @Query("SELECT * FROM prestamo")
    public List<Prestamo> findAll();

    @Query("SELECT * FROM prestamo WHERE id = (:query)")
    public List<Prestamo> getByFilter(String query);


    @Insert
    void insert(Prestamo users);

    @Delete
    void delete(Prestamo user);
}

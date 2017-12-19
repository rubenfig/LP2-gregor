package com.example.ruben.lp2;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by ruben on 18/12/17.
 */

@Database(entities = {Prestamo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PrestamosDao prestamosDao();
}

package com.example.mathias.timebook.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mathias.timebook.BookingModel.Booking;

/**
 * Created by Niklas on 2015-11-09.
 * This class is responsible for communication with a database for
 * Booking objects.
 */
public class DatabaseBookingHandler extends DatabaseHandler<Booking> {



    public DatabaseBookingHandler(){}

    @Override
    public boolean Add(Booking obj) {
        return false;
    }

    @Override
    public boolean Update(Booking obj){
        return false;
    }

    @Override
    public Booking Get(Booking obj) {
        return null;
    }

    @Override
    public boolean Delete(Booking obj) {
        return false;
    }
}

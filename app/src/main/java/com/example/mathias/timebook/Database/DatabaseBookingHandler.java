package com.example.mathias.timebook.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mathias.timebook.BookingModel.Booking;
import com.example.mathias.timebook.BookingModel.Customer;

import java.text.DateFormat;


/**
 * Created by Niklas on 2015-11-09.
 * This class is responsible for communication with a database for
 * Booking objects.
 */
public class DatabaseBookingHandler extends DatabaseHandler<Booking> {

    DatabaseHelper dbHelper;
    Context ctx;
    SQLiteDatabase db;

    //Customer Table information
    private static final String TABLE_CUSTOMER = "Customer";
    private static final String CUSTOMER_NAME = "Name";
    private static final String CUSTOMER_PHONE_NUMBER = "Phone_number";

    //Booking Table information
    private static final String TABLE_BOOKING = "Booking";
    private static final String BOOKING_DESCRIPTION = "Description";
    private static final String BOOKING_START_TIME = "Start_time";
    private static final String BOOKING_END_TIME = "End_time";
    private static final String BOOKING_ACTIVITY_OWNER = "Activity_Owner";

    //Creating Tables in DB
    private static final String BOOKING_TABLE_CREATE = "CREATE TABLE Booking(BookingID int primary key, Description varchar(200), "+
            "DATETIME Start_time, DATETIME End_time, Activity_Owner varchar(30), CustomerID int);";
    private static final String CUSTOMER_TABLE_CREATE = "CREATE TABLE Customer(CustomerID int primary key, Name varchar(50), "+
    "Phone_number varchar(50));";

    //Database name
    public static final String DATABASENAME = "Timebooking_DB100";
    //Version of DB
    public static final int DATABASE_VERSION = 1;

    public DatabaseBookingHandler(Context ctx){
        this.ctx = ctx;
        dbHelper = new DatabaseHelper(ctx);
    }

    public DatabaseBookingHandler open(){
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    /*
    * Add a Booking object to Booking in SQLLite db
    * */
    @Override
    public boolean Add(Booking obj) {

        ContentValues cont = new ContentValues();

        Customer tempCust = obj.getCustomer();

        cont.put(CUSTOMER_NAME, tempCust.getName());
        cont.put(CUSTOMER_PHONE_NUMBER, tempCust.getPhone_number());
        db.insertOrThrow(TABLE_CUSTOMER, null, cont);

        cont = new ContentValues();

        cont.put(BOOKING_DESCRIPTION, obj.getDescription());
        cont.put(BOOKING_START_TIME, obj.getStarttime().toString());
        cont.put(BOOKING_END_TIME, obj.getEndtime().toString());
        cont.put(BOOKING_ACTIVITY_OWNER, obj.getActivity_owner());
        db.insertOrThrow(TABLE_BOOKING, null, cont);
        return true;
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




    /*
    * DatabaseHelper class
    * */
    private static class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context ctx) {
            super(ctx, DATABASENAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CUSTOMER_TABLE_CREATE);
                db.execSQL(BOOKING_TABLE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXIST Customer");
            db.execSQL("DROP TABLE IF EXIST Booking");
            onCreate(db);
        }
    }


}

package com.example.mathias.timebook.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.mathias.timebook.BookingModel.Booking;
import com.example.mathias.timebook.BookingModel.Customer;
import java.util.ArrayList;


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
            "Start_time varchar(50), End_time varchar(50), Activity_Owner varchar(30), CustomerID int);";
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

        db = dbHelper.getWritableDatabase();
        ContentValues cont = new ContentValues();
        Customer tempCust = obj.getCustomer();

        cont.put(CUSTOMER_NAME, tempCust.getName());
        cont.put(CUSTOMER_PHONE_NUMBER, tempCust.getPhone_number());
        db.insertOrThrow(TABLE_CUSTOMER, null, cont);

        cont = new ContentValues();

        cont.put(BOOKING_DESCRIPTION, obj.getDescription());
        cont.put(BOOKING_START_TIME, obj.getStarttime());
        cont.put(BOOKING_END_TIME, obj.getEndtime());
        cont.put(BOOKING_ACTIVITY_OWNER, obj.getActivity_owner());
        db.insertOrThrow(TABLE_BOOKING, null, cont);
        return true;
        }

    @Override
    public boolean Update(Booking obj){
        return false;
    }

    @Override
    public Booking Get(String indata) {
        return null;
    }

    @Override
    public boolean Delete(Booking obj) {
        return false;
    }

    public ArrayList<Booking> GetBookingList(){

        ArrayList<Booking> tempList = new ArrayList<Booking>();
        db = dbHelper.getWritableDatabase();

        String select_query = "SELECT BookingID, Description, Start_time, End_time, Activity_Owner, +" +
                "Name AS Customer_name, Phone_number FROM " +TABLE_BOOKING+ " JOIN "+
                TABLE_CUSTOMER + " ON "+TABLE_BOOKING+".BookingID = "+TABLE_CUSTOMER+".CustomerID";

        Cursor cursor = db.rawQuery(select_query, null);

        if(cursor.moveToFirst()){
            do{
                Booking tempBooking = new Booking();
                Customer tempCustomer = new Customer();
                //Adding data to Booking object
                tempBooking.setId(Integer.parseInt(cursor.getString(0)));
                tempBooking.setDescription(cursor.getString(1));
                tempBooking.setStarttime(cursor.getString(2));
                tempBooking.setEndtime(cursor.getString(3));
                tempBooking.setActivity_owner(cursor.getString(4));

                //Adding data to Customer object
                tempCustomer.setName(cursor.getString(5));
                tempCustomer.setPhone_number(cursor.getString(6));

                //Add Customer object to Booking object
                tempBooking.setCustomer(tempCustomer);

                //Add Booking to list.
                tempList.add(tempBooking);
            } while (cursor.moveToNext());
        }
        return tempList;
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

package com.example.mathias.timebook.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mathias.timebook.BookingModel.Booking;
import com.example.mathias.timebook.BookingModel.Customer;
import com.example.mathias.timebook.Database.DatabaseBookingHandler;
import com.example.mathias.timebook.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView bookings_listview;
    DatabaseBookingHandler db_handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initiate();

    }

    private void Initiate(){
        bookings_listview = (ListView) findViewById(R.id.bookingsListview);
        db_handler = new DatabaseBookingHandler(this);

        //TESTING
        Booking tempBook = new Booking("Description", "Start 08:00", "End 08:30", new Customer("Mathias", "070Customnumber"), "Niklas");
        db_handler.Add(tempBook);
        ArrayList<Booking> tempList = new ArrayList<Booking>();
        tempList = db_handler.GetBookingList();
        Toast.makeText(this, "Hje", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

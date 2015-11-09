package com.example.mathias.timebook;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button calc_button;
    EditText first_textview;
    EditText second_textview;
    TextView result_label;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testlayout);


        Initiate();
    }

    private void Initiate(){

        calc_button = (Button) findViewById(R.id.calc_btn);
        first_textview = (EditText) findViewById(R.id.indatatext1);
        second_textview = (EditText) findViewById(R.id.indatatext2);
        result_label = (TextView) findViewById(R.id.resultLabel);

    }

    private void Calculate(){

        int firstvalue = Integer.parseInt(first_textview.getText().toString());
        int secondvalue = Integer.parseInt(second_textview.getText().toString());
        int sum = firstvalue + secondvalue;
        result_label.setText(Integer.toString(sum));


    }


    public void OnCalculateClick(View v) {

        Calculate();

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

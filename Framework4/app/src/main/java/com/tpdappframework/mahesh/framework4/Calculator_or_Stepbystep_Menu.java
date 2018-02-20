package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;

public class Calculator_or_Stepbystep_Menu extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_or_sbs);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home_button) {

            Intent goHome = new Intent(this,
                    Calculator_or_Stepbystep_Menu.class);

            final int result = 1;

            startActivity(goHome);

        }
        return super.onOptionsItemSelected(item);

    }

    //Click Events for Opening Screens

    public void calculator_click(View view) {

        //Creates the intent to open a screen

        Intent getCalculatorMenuIntent = new Intent(this,
                Calculator_Menu_Page.class);

        //Ignore not important but you need it

        final int result = 1;

        //Opens the activity without passing information

        startActivity(getCalculatorMenuIntent);

    }

    public void SBS_click(View view) {

        Intent getSBSMenuPageIntent = new Intent(this,
                SBS_Menu_Page.class);

        final int result = 1;

        startActivity(getSBSMenuPageIntent);

    }

}

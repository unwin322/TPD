package com.loughbroughproject.needleguidesettingsassistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class GuideSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_select);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);}

    // Start Fixed Scale Activity
    public void FixedScale(View view) {
        Intent openFixedScale = new Intent(this, FixedScaleAssistant.class);
        startActivity(openFixedScale);
    }

    // Start Moving Scale Activity
    public void MovingScale(View view) {
        Intent openMovingScale = new Intent(this, MovingScaleAssistant.class);
        startActivity(openMovingScale);
    }

    // Start Epidural Activity
    public void Epidural(View view) {
        Intent openEpidural = new Intent(this, EpiduralAssistant.class);
        startActivity(openEpidural);
    }

    // Start Key System Activity
    public void KeySystem(View view) {
        Intent openKeySystem = new Intent(this, KeySystemAssistant.class);
        startActivity(openKeySystem);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_guide_select, menu);
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


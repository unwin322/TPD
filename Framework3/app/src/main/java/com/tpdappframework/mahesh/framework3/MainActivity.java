package com.tpdappframework.mahesh.framework3;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

            DialogFragment myFragment = new MyExitDialogFragment();

            myFragment.show(getFragmentManager(), "theDialog");

            return true;
        } else if (id == R.id.exit_the_app) {
            finish();
            return true;
        }
            return super.onOptionsItemSelected(item);

    }


    public void onGetNameClick(View view) {

        Intent getNameScreenIntent = new Intent(this,
                SecondScreen.class);
        final int result = 1;

        //Placing data to send to second screen
        //Just add put extra to add additional information
        getNameScreenIntent.putExtra("CallingActivity","MainActivity");

        //If you don't need the new screen to send data back
        //Just calls the screen to open
        startActivity(getNameScreenIntent);

        //To retrieve information back from the other screen
        startActivityForResult(getNameScreenIntent,result);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView usersNameMessage = (TextView)
                findViewById(R.id.users_name_message);

        String nameSentBack = data.getStringExtra("UsersName");
        usersNameMessage.append(" " + nameSentBack);


    }

}

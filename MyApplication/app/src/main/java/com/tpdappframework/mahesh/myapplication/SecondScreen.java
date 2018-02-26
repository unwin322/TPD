package com.tpdappframework.mahesh.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class SecondScreen extends MainActivity{


    Double MoreSend;
    String ExtraSend;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Set the layout for the layout we created

        setContentView(R.layout.second_layout);

        //Define Rounding
        DecimalFormat dfl = new DecimalFormat("#.#");
        DecimalFormat dfa = new DecimalFormat("##");
        dfl.setRoundingMode(RoundingMode.HALF_UP);
        dfa.setRoundingMode(RoundingMode.HALF_UP);

        MoreSend = 1.232;
        ExtraSend = Double.toString(MoreSend);

        // Get the Intent that called for this Activity to open

        Intent activityThatCalled = getIntent();

        // Get the data that was sent

        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");

        TextView callingActivityMessage = (TextView)

        findViewById(R.id.calling_activity_info_text_view);


        callingActivityMessage.append(" " + previousActivity);

    }


    public void onSendUsersName(View view) {


        // Get the users name from the EditText

        EditText usersNameET = (EditText) findViewById(R.id.users_name_edit_text);

        // Get the name typed into the EditText

        String usersName = String.valueOf(usersNameET.getText());


        // Define our intention to go back to ActivityMain

        Intent goingBack = new Intent(this, blah.class);

        // Define the String name and the value to assign to it

        goingBack.putExtra("UsersName", usersName);
        goingBack.putExtra("UsersName2", ExtraSend);

        // Sends data back to the parent and can use RESULT_CANCELED, RESULT_OK, or any

        // custom values starting at RESULT_FIRST_USER. RESULT_CANCELED is sent if

        // this Activity crashes

        setResult(RESULT_OK, goingBack);

        // Close this Activity

        startActivity(goingBack);


    }

}

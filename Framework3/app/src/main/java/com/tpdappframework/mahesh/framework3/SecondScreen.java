package com.tpdappframework.mahesh.framework3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Mahesh on 08/02/2018.
 */

public class SecondScreen extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setting up layout for the new activity

        setContentView(R.layout.second_layout);

        //getting the data that was passed over from main activity

        Intent activityThatCalled = getIntent();

        String previousActivity = activityThatCalled.getExtras().getString("CallingActivity");

        TextView CallingActivityMessage = (TextView)
                findViewById(R.id.calling_activity_info_text_view);

        CallingActivityMessage.append(" " + previousActivity);

    }

    public void onSendUsersName(View view) {

        EditText userNameET = (EditText) findViewById(R.id.users_name_edit_text);

        String userName = String.valueOf(userNameET.getText());

        Intent goingBack = new Intent();

        goingBack.putExtra("UsersName", userName);

        setResult(RESULT_OK, goingBack);

        finish();

    }
}

package com.tpdappframework.mahesh.framework4;

import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Mahesh on 21/02/2018.
 */

public class RealTimeSetAngleOutCentre extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_set_angle_step_10_out_oncentre);

        //Retrieve Angle Data

        String RTAngleOutPlane = getIntent().getStringExtra("SendRTAngleOutPlane");

        TextView showRTAngleOutPlane = (TextView) findViewById(R.id.RTAngleOutPlaneShow);

        showRTAngleOutPlane.append(" " + RTAngleOutPlane);

    }
}

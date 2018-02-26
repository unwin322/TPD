package com.tpdappframework.mahesh.framework4;

import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Mahesh on 21/02/2018.
 */

public class RealTimeSetAngleInCentre extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_set_angle_step_10_in_oncentre);

        String RTAngleCentre = getIntent().getStringExtra("SendRTAngleInPlaneCentre");

        TextView showRTAngleCentre = (TextView) findViewById(R.id.RT_Angle_Centre_Show);

        showRTAngleCentre.append(" " + RTAngleCentre);

    }
}

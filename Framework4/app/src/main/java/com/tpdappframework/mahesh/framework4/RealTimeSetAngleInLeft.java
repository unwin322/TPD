package com.tpdappframework.mahesh.framework4;

import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Mahesh on 21/02/2018.
 */

public class RealTimeSetAngleInLeft extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_set_angle_step_10_in_leftcentre);

        String RTAngleLeft = getIntent().getStringExtra("SendRTAngleInPlaneLeft");

        TextView showRTAngleLeft = (TextView) findViewById(R.id.RT_Angle_Left_Show);

        showRTAngleLeft.append(" " + RTAngleLeft);

    }
}

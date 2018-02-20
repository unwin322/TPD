package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.net.Inet4Address;

/**
 * Created by Mahesh on 20/02/2018.
 */

public class RealTimeWhereTargetOutPlaneStep6 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_relative_position_step_6_out);

    }

    public void gorealtimeoutleftdepth(View view) {

        Intent getrealtimeoutleftdepth = new Intent(this,
                RealTimeDepthOutLeft.class);

        final int result = 1;

        startActivity(getrealtimeoutleftdepth);

    }

    public void gorealtimeoutrightdepth(View view) {

        Intent getrealtimeoutrightdepth = new Intent (this,
                RealTimeDepthOutRight.class);
        final int result = 1;

        startActivity(getrealtimeoutrightdepth);

    }

    public void gorealtimecentredepth(View view) {

        Intent getrealtimecentredepth = new Intent(this,
                RealTimeDepthOutCentre.class);

        final int result = 1;

        startActivity(getrealtimecentredepth);

    }
}

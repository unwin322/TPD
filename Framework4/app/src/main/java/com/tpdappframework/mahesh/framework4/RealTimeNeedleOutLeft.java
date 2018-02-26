package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.net.Inet4Address;

/**
 * Created by Mahesh on 21/02/2018.
 */

public class RealTimeNeedleOutLeft extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set the content for the screen

        setContentView(R.layout.real_time_needle_length_out_leftcentre);

        //Retrieve the data sent across

        String s = getIntent().getStringExtra("SendTargetDepth");

        TextView showDepth = (TextView) findViewById(R.id.depth_out);

        showDepth.append(" " + s);

    }

    //Go to the next screen

    public void gorealtimesetangleoutleft(View view) {

        Intent getrealtimesetangleoutleft = new Intent(this,
                RealTimeSetAngleOutLeft.class);

        final int result = 1;

        startActivity(getrealtimesetangleoutleft);
    }

}




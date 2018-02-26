package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Mahesh on 20/02/2018.
 */

public class RealTimeDepthInRight extends Calculator_or_Stepbystep_Menu {

    String TransferRTOffSetRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_depth_step_7_in_rightcentre);

        String RTOffsetRight = getIntent().getStringExtra("SendRTOffsetRight");

        TransferRTOffSetRight = RTOffsetRight;

    }

    public void gorealtimeneedleinright(View view) {

        EditText sendUserOffsetRightDepth = (EditText) findViewById(R.id.RT_Depth_InPlane_Right_Input);

        String RealTimeOffsetRightDepth = String.valueOf(sendUserOffsetRightDepth.getText());

        Intent getrealtimeneedleinright = new Intent(this,
                RealTimeNeedleInRight.class);

        getrealtimeneedleinright.putExtra("SendRTRightDepth", RealTimeOffsetRightDepth);

        getrealtimeneedleinright.putExtra("SendRTRightOffsetNext", TransferRTOffSetRight);

        startActivity(getrealtimeneedleinright);


    }
}

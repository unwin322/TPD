package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class RealTimeOffsetRight extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_offset_right);

    }

    public void gorealtimerightdepth(View view) {

        EditText sendUserOffsetLeft = (EditText) findViewById(R.id.Real_Time_Right_Offset_Input);

        String RealTimeTargetDepthOutPlane = String.valueOf(sendUserOffsetLeft.getText());

        Intent getRealTimeRightDepth = new Intent(this, RealTimeDepthInRight.class);

        getRealTimeRightDepth.putExtra("SendRTOffsetRight", RealTimeTargetDepthOutPlane);

        setResult(RESULT_OK, getRealTimeRightDepth);

        startActivity(getRealTimeRightDepth);

    }
}

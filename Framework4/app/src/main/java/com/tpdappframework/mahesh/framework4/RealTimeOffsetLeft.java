package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class RealTimeOffsetLeft extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_offset_left);

    }

    public void gorealtimeleftdepth(View view) {

        EditText sendUserOffsetLeft = (EditText) findViewById(R.id.Real_Time_Left_Offset_Input);

        String RealTimeTargetDepthOutPlane = String.valueOf(sendUserOffsetLeft.getText());

        Intent getRealTimeLeftDepth = new Intent(this, RealTimeDepthInLeft.class);

        getRealTimeLeftDepth.putExtra("SendRTOffsetLeft", RealTimeTargetDepthOutPlane);

        setResult(RESULT_OK, getRealTimeLeftDepth);

        startActivity(getRealTimeLeftDepth);

    }
}

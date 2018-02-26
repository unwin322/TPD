package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Mahesh on 20/02/2018.
 */

public class RealTimeDepthInLeft extends Calculator_or_Stepbystep_Menu {

    String TransferRTOffSetLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_depth_step_7_in_leftcentre);

        String RTOffsetLeft = getIntent().getStringExtra("SendRTOffsetLeft");

        TransferRTOffSetLeft = RTOffsetLeft;

    }

    public void gorealtimeneedleinleft(View view) {

        EditText sendUserOffsetLeftDepth = (EditText) findViewById(R.id.RT_Depth_InPlane_Left_Input);

        String RealTimeOffsetLeftDepth = String.valueOf(sendUserOffsetLeftDepth.getText());

        Intent getrealtimeneedleinleft = new Intent(this,
                RealTimeNeedleInLeft.class);

        getrealtimeneedleinleft.putExtra("SendRTLeftDepth", RealTimeOffsetLeftDepth);

        getrealtimeneedleinleft.putExtra("SendRTLeftOffsetNext", TransferRTOffSetLeft);

        setResult(RESULT_OK, getrealtimeneedleinleft);

        startActivity(getrealtimeneedleinleft);
    }
}

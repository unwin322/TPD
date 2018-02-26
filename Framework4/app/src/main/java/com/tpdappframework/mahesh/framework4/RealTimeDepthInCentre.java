package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Mahesh on 20/02/2018.
 */

public class RealTimeDepthInCentre extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_depth_step_7_in_oncentre);

    }

    public void goneedleinsertionlengthrtincentre(View view) {

        EditText sendUserOffsetCentreDepth = (EditText) findViewById(R.id.RT_Depth_InPlane_Centre_Input);

        String RealTimeOffsetCentreDepth = String.valueOf(sendUserOffsetCentreDepth.getText());

        Intent getneedleinsertionlengthrtincentre = new Intent(this,
                RealTimeNeedleInCentre.class);

        getneedleinsertionlengthrtincentre.putExtra("SendRTCentreDepth", RealTimeOffsetCentreDepth);

        startActivity(getneedleinsertionlengthrtincentre);

    }
}

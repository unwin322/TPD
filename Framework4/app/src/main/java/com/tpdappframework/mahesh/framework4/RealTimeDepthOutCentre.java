package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Mahesh on 20/02/2018.
 */

public class RealTimeDepthOutCentre extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_depth_step_7_out_oncentre);

    }

    public void gorealtimeneedleoutcentre(View view) {

        EditText sendUserTargetDepthOutPlane = (EditText) findViewById(R.id.target_depth_input_out_centre);

        String RealTimeTargetDepthOutPlane = String.valueOf(sendUserTargetDepthOutPlane.getText());

        Intent getrealtimeneedleoutcentre = new Intent(this,
                RealTimeNeedleOutCentre.class);

        getrealtimeneedleoutcentre.putExtra("SendRTTargetDepthOutPlane", RealTimeTargetDepthOutPlane);

        setResult(RESULT_OK, getrealtimeneedleoutcentre);

        startActivity(getrealtimeneedleoutcentre);

    }
}

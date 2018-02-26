package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


/**
 * Created by Mahesh on 20/02/2018.
 */

public class RealTimeDepthOutLeft extends Calculator_or_Stepbystep_Menu {

    EditText userDepthRealTimeOutLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_depth_step_7_out_leftcentre);

    }

    public void gorealtimeneedleoutleft(View view) {

        EditText sendUserTargetDepth = (EditText) findViewById(R.id.target_depth_input_out_left);

        String TargetDepth = String.valueOf(sendUserTargetDepth.getText());

        Intent getrealtimeneedleoutleft = new Intent(this, RealTimeNeedleOutLeft.class);

        getrealtimeneedleoutleft.putExtra("SendTargetDepth", TargetDepth);

        setResult(RESULT_OK, getrealtimeneedleoutleft);

        startActivity(getrealtimeneedleoutleft);

    }

}

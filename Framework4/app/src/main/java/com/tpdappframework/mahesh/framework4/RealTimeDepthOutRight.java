package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 20/02/2018.
 */

public class RealTimeDepthOutRight extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_depth_step_7_out_rightcentre);

    }

    public void gorealtimeneedleoutright(View view) {

        Intent getrealtimeneedleoutright = new Intent(this,
                RealTimeNeedleOutRight.class);

        final int result = 1;

        startActivity(getrealtimeneedleoutright);

    }
}

package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 21/02/2018.
 */

public class RealTimeNeedleOutRight extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_needle_length_out_rightcentre);

    }

    public void gorealtimesetangleoutright(View view) {

        Intent getrealtimesetangleoutright = new Intent(this,
                RealTimeSetAngleOutRight.class);

        final int result = 1;

        startActivity(getrealtimesetangleoutright);

    }
}

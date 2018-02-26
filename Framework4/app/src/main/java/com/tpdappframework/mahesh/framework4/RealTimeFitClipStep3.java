package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 20/02/2018.
 */

public class RealTimeFitClipStep3 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_needle_clip_onto_guide_step_3);
    }

    public void gorealtimestep4(View view) {

        Intent getrealtimestep4 = new Intent(this,
                RealTimeInPlaneOutPlaneStep4.class);

        final int result = 1;

        startActivity(getrealtimestep4);

    }
}

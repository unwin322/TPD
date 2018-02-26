package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 20/02/2018.
 */

public class RealTimeOutPlaneAttachGuideStep5 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_attach_guide_step_5_out);

    }

    public void gorealtimewhereistargetoutstep6(View view) {

        Intent getrealtimewhereistargetoutstep6 = new Intent(this,
                RealTimeDepthOutCentre.class);

        final int result = 1;

        startActivity(getrealtimewhereistargetoutstep6);


    }
}

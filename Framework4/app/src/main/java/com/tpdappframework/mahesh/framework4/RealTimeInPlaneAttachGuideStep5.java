package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 20/02/2018.
 */

public class RealTimeInPlaneAttachGuideStep5 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_attach_guide_step_5_in);

    }


    public void gorealtimewhereistargetstep6(View view) {

        Intent getrealtimewhereistargetstep6 = new Intent(this,
                RealTimeInPlaneAttachGuideStep5.class);

        final int result = 1;

        startActivity(getrealtimewhereistargetstep6);

    }
}


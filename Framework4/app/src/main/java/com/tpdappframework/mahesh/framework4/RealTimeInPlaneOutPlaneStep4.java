package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 20/02/2018.
 */

public class RealTimeInPlaneOutPlaneStep4 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_in_out_plane_step_4);

    }

    public void gorealtimeinplanestep5(View view) {

        Intent getrealtimeinplanestep5 = new Intent(this,
                RealTimeInPlaneAttachGuideStep5.class);

        final int result = 1;

        startActivity(getrealtimeinplanestep5);


    }

    public void gorealtimeoutplanestep5(View view) {

        Intent getrealtimeoutplanestep5 = new Intent(this,
                RealTimeOutPlaneAttachGuideStep5.class);

        final int result = 1;

        startActivity(getrealtimeoutplanestep5);



    }
}

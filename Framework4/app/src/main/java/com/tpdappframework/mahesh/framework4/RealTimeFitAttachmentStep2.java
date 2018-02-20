package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 20/02/2018.
 */

public class RealTimeFitAttachmentStep2 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_attachment_onto_probe_step_2);
    }


    public void gorealtimestep3(View view) {

        Intent getrealtimestep3 = new Intent(this,
                RealTimeFitClipStep3.class);

        final int result = 1;

        startActivity(getrealtimestep3);

    }
}

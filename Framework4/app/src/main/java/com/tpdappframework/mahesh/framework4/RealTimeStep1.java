package com.tpdappframework.mahesh.framework4;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


/**
 * Created by Mahesh on 09/02/2018.
 */

public class RealTimeStep1 extends Calculator_or_Stepbystep_Menu {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_step_1);

    }


    public void gorealtimestep2(View view) {

        Intent getrealtimestep2 = new Intent (this,
                RealTimeFitAttachmentStep2.class);

        final int result = 1;

        startActivity(getrealtimestep2);
    }
}

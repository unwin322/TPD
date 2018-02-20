package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 13/02/2018.
 */

public class PrePuncture60Step2 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_inout_60);

    }


    public void Pre_In_Plane_60_Start(View view) {

        Intent getPreInPlane60Start = new Intent(this,
                PrePuncture60InPlaneStep4.class);

        final int result = 1;

        startActivity(getPreInPlane60Start);

    }


    public void Pre_Out_Plane_60_Start(View view) {

        Intent getPreOutPlane60Start = new Intent(this,
                PrePuncture60OutPlaneStep4.class);

        final int result = 1;

        startActivity(getPreOutPlane60Start);

    }
}

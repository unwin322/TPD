package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 13/02/2018.
 */

public class PrePuncture45Step2 extends Calculator_or_Stepbystep_Menu {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_inout_45);

    }

    public void goPPInPlane45Step4(View view) {

        Intent getPreInPlane45Start = new Intent(this,
                PrePuncture45InPlaneStep4.class);

        final int result = 1;

        startActivity(getPreInPlane45Start);

    }

    public void goPPOutPlane45Step4(View view) {

        Intent getPreOutPlane60Start = new Intent(this,
                PrePuncture45OutPlaneStep4.class);

        final int result = 1;

        startActivity(getPreOutPlane60Start);

    }
}

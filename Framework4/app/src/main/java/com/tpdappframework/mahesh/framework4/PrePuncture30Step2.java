package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 13/02/2018.
 */

public class PrePuncture30Step2 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_inout_30);

    }

    public void goPPInPlane30Step4(View view) {

        Intent getPreInPlane30Start = new Intent(this,
                PrePuncture30InPlaneStep4.class);

        final int result = 1;

        startActivity(getPreInPlane30Start);

    }



    public void goPPOutPlane30Step4(View view) {

        Intent getPreOutPlane30Start = new Intent(this,
                PrePuncture30OutPlaneStep4.class);

        final int result = 1;

        startActivity(getPreOutPlane30Start);


    }
}

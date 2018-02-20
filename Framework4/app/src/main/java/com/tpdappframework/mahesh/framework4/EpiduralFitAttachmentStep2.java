package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 14/02/2018.
 */

public class EpiduralFitAttachmentStep2 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.epidural_fit_pens_step_2);

    }

    public void gofitgauageintobody(View view) {

        Intent getfitgaugeintobody = new Intent(this,
                 EpiduralFitClipOntoBodyStep3.class);

        final int result = 1;

        startActivity(getfitgaugeintobody);


    }
}

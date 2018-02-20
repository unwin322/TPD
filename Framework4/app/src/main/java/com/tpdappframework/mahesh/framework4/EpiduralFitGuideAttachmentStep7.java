package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 16/02/2018.
 */

public class EpiduralFitGuideAttachmentStep7 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.epidural_fit_guide_attachment_step_7);
    }


    public void gorelocateguideonpatient(View view) {

        Intent getrelocateguideonpatient = new Intent(this,
                EpiduralRelocateGuideStep8.class);

        final int result = 1;

        startActivity(getrelocateguideonpatient);

    }
}

package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 16/02/2018.
 */

public class EpiduralFitGuideAttachmentStep7 extends Calculator_or_Stepbystep_Menu {

    String EpiDepthJump2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.epidural_fit_guide_attachment_step_7);

        String EpiDepth = getIntent().getStringExtra("EpiDepthJump2");

        EpiDepthJump2 = EpiDepth;
    }


    public void gorelocateguideonpatient(View view) {

        Intent getrelocateguideonpatient = new Intent(this,
                EpiduralRelocateGuideStep8.class);

        getrelocateguideonpatient.putExtra("EpiDepthJump3", EpiDepthJump2);

        setResult(RESULT_OK, getrelocateguideonpatient);

        startActivity(getrelocateguideonpatient);

    }
}

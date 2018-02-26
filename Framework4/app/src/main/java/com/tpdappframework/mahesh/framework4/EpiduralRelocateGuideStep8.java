package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 16/02/2018.
 */

public class EpiduralRelocateGuideStep8 extends Calculator_or_Stepbystep_Menu {

    String EpiDepthJump3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.epidural_relocate_guide_onto_patient_step_8);

        String EpiDepth = getIntent().getStringExtra("EpiDepthJump3");

        EpiDepthJump3 = EpiDepth;

    }

    public void goneedleinsertionlength(View view) {

        Intent getneedleinsertionlength= new Intent(this,
                EpiduralNeedleInsertionLengthStep9.class);

        getneedleinsertionlength.putExtra("EpiDepthJump4", EpiDepthJump3);

        setResult(RESULT_OK, getneedleinsertionlength);

        startActivity(getneedleinsertionlength);

    }
}

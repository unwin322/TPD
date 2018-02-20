package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 16/02/2018.
 */

public class EpiduralRelocateGuideStep8 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.epidural_relocate_guide_onto_patient_step_8);

    }

    public void goneedleinsertionlength(View view) {

        Intent getneedleinsertionlength= new Intent(this,
                EpiduralNeedleInsertionLengthStep9.class);

        final int result = 1;

        startActivity(getneedleinsertionlength);

    }
}

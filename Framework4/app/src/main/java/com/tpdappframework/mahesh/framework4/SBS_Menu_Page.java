package com.tpdappframework.mahesh.framework4;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


/**
 * Created by Mahesh on 09/02/2018.
 */

public class SBS_Menu_Page extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.step_by_step_menu);

    }


    public void Real_Time_Guide(View view) {

        Intent getRealTimeGuide = new Intent(this,
                RealTimeStep1.class);

        final int result = 1;

        startActivity(getRealTimeGuide);

    }

    public void Epidural_Guide(View view) {

        Intent getEpiduralGuide = new Intent(this,
                EpiduralGuideStep1.class);

        final int result = 1;

        startActivity(getEpiduralGuide);

    }

    public void Pre_Puncture_Guide(View view) {

        Intent getPrePunctureGuide = new Intent(this,
                PrePunctureStep1.class);

        final int result = 1;

        startActivity(getPrePunctureGuide);

    }
}

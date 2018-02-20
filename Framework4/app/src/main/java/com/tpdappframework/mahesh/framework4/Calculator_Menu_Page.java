package com.tpdappframework.mahesh.framework4;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;



/**
 * Created by Mahesh on 09/02/2018.
 */

public class Calculator_Menu_Page extends Calculator_or_Stepbystep_Menu {


    //Set content for this page

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //sets what the content on this page should look like

        setContentView(R.layout.calculator_menu_page);

    }


    //Button commands to open the different calculators

    public void real_time_calculator(View view) {

        Intent getRealTimeCalculator = new Intent(this,
                RealTimeCalculator.class);

        final int result = 1;

        startActivity(getRealTimeCalculator);

    }

    public void epidural_guide_calculator(View view) {

        Intent getEpiduralCalculator = new Intent(this,
                EpiduralCalculator.class);

        final int result = 1;

        startActivity(getEpiduralCalculator);
    }

    public void pre_puncture_calculator(View view) {

        Intent getPrePunctureCalculator = new Intent(this,
                PrePunctureCalculator.class);
        final int result = 1;

        startActivity(getPrePunctureCalculator);

    }
}

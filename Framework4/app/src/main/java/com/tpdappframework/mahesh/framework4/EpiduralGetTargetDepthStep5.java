package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.GregorianCalendar;

/**
 * Created by Mahesh on 14/02/2018.
 */

public class EpiduralGetTargetDepthStep5 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.epidural_target_depth_step_5);
    }


    public void golocatepens(View view) {

        Intent getlocatepens = new Intent(this,
                EpiduralLocatePensStep6.class);

        final int result = 1;

        startActivity(getlocatepens);

    }
}

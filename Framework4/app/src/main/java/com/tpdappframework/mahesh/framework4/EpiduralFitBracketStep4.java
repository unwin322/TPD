package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 14/02/2018.
 */

public class EpiduralFitBracketStep4 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.epidural_fit_bracket_step_4);

    }

    public void goepiduraltargetdepth(View view) {

        Intent getepiduraltargetdepth = new Intent(this,
                EpiduralGetTargetDepthStep5.class);

        final int result = 1;

        startActivity(getepiduraltargetdepth);

    }
}

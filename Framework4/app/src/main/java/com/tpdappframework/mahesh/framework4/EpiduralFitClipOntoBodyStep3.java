package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 14/02/2018.
 */

public class EpiduralFitClipOntoBodyStep3 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.epidural_fit_clip_onto_guide_step_3);

    }

    public void goepiduralfitbracket(View view) {

        Intent getepiduralfitbracket = new Intent(this,
                EpiduralFitBracketStep4.class);

        final int result = 1;

        startActivity(getepiduralfitbracket);

    }
}

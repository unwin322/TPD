package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 13/02/2018.
 */

public class PrePuncture60InPlaneStep4 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_target_depth_60_in);

    }

    public void goPPInMark60(View view) {

        Intent goPPInMark60 = new Intent(this, PrePunctureMarkSkin60In.class);

        startActivity(goPPInMark60);

    }
}

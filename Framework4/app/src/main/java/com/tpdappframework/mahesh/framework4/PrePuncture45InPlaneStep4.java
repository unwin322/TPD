package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 13/02/2018.
 */

public class PrePuncture45InPlaneStep4 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_target_depth_45_in);

    }

    public void goPPInMark45(View view) {

        Intent getPPInMark45 = new Intent(this, PrePunctureMarkSkin45In.class);

        startActivity(getPPInMark45);


    }
}

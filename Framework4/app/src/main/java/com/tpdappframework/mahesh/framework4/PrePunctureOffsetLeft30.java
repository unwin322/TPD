package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureOffsetLeft30 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_offset_dist_in_left_30);

    }

    public void goPPInLeftAlign30(View view) {

        Intent getPPInLeftAlign30 = new Intent(this, PrePunctureAlignKeyInLeft30.class);

        startActivity(getPPInLeftAlign30);

    }
}

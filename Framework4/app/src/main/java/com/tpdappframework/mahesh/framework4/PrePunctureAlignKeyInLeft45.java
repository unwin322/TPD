package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureAlignKeyInLeft45 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_align_key_in_left_45);

    }

    public void goPPAlignKeyInLeft45(View view) {

        Intent etPPAlignKeyInLeft45 = new Intent(this, PrePunctureNeedleLengthInLeft45.class);

        startActivity(getIntent());

    }
}

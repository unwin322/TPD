package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureAlignKeyInLeft60 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_align_key_in_left_60);

    }

    public void goPPAlignKeyInLeft60(View view) {

        Intent getPPAlignKeyInLeft60 = new Intent(this, PrePunctureNeedleLengthInLeft60.class);

        startActivity(getPPAlignKeyInLeft60);

    }
}

package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureAlignKeyInLeft30 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_align_key_in_left_30);

    }

    public void goPPAlignKeyInLeft30(View view) {

        Intent getPPAlignKeyInLeft30 = new Intent(this, PrePunctureNeedleLengthInLeft30.class);

        startActivity(getPPAlignKeyInLeft30);

    }
}

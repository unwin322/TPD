package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureAlignKeyOut60 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_align_key_out_on_60);

    }

    public void goPPAlignKeyOut60(View view) {

        Intent getPPAlignKeyOut60 = new Intent(this, PrePunctureNeedleLengthOut60.class);

        startActivity(getPPAlignKeyOut60);

    }
}

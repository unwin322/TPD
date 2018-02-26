package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureAlignKeyOut45 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_align_key_out_on_45);

    }

    public void goPPAlignKeyOut45(View view) {

        Intent getPPAlignKeyOut45 = new Intent(this, PrePunctureNeedleLengthOut45.class);

        startActivity(getPPAlignKeyOut45);

    }
}

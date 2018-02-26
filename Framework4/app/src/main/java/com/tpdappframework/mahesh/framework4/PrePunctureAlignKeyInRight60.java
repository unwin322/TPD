package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureAlignKeyInRight60 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_align_key_in_right_60);

    }

    public void goPPAlignKeyInRight60(View view) {


        Intent getPPAlignKeyInRight60 = new Intent(this, PrePunctureNeedleLengthInRight60.class);

        startActivity(getPPAlignKeyInRight60);

    }
}

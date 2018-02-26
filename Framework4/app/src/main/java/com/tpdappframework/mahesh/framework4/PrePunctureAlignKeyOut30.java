package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureAlignKeyOut30 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_align_key_out_on_30);

    }

    public void goPPAlignKeyOut30(View view) {

        Intent getPPAlignKeyOut30 = new Intent(this, PrePunctureNeedleLengthOut30.class);

        startActivity(getPPAlignKeyOut30);

    }
}

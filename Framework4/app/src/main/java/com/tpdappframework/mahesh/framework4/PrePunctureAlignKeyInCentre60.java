package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureAlignKeyInCentre60 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_align_key_in_on_60);


    }

    public void goPPAlignKeyInCentre60(View view) {

        Intent getPPAlignKeyInCentre60 = new Intent(this, PrePunctureNeedleLengthInCentre60.class);

        startActivity(getPPAlignKeyInCentre60);

    }
}

package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureAlignKeyInCentre45 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_align_key_in_on_45);

    }

    public void goPPAlignKeyInCentre45(View view) {

        Intent getPPAlignKeyInCentre45 = new Intent(this, PrePunctureNeedleLengthInCentre45.class);

        startActivity(getPPAlignKeyInCentre45);

    }
}

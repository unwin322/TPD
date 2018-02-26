package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureAlignKeyInCentre30 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_align_key_in_on_30);

    }

    public void goPPAlignKeyInCentre30(View view) {

        Intent getPPAlignKeyInCentre30 = new Intent(this, PrePunctureNeedleLengthInCentre30.class);

        startActivity(getPPAlignKeyInCentre30);

    }
}

package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureRelativePos30 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_rel_pos_in_30);

    }

    public void goPPInAlignCentre30(View view) {

        Intent getPPInAlignCentre30 = new Intent(this, PrePunctureAlignKeyInCentre30.class);

        startActivity(getPPInAlignCentre30);

    }

    public void goPPLeftOffset30(View view) {

        Intent getPPLeftOffset30 = new Intent(this, PrePunctureOffsetLeft30.class);

        startActivity(getPPLeftOffset30);

    }

    public void goPPRightOffset30(View view) {

        Intent getPPRightOffset30 = new Intent(this, PrePunctureOffsetRight30.class);

        startActivity(getPPRightOffset30);

    }
}

package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureRelativePos45 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_rel_pos_in_45);

    }

    public void goPPInAlignCentre45(View view) {

        Intent getPPInAlignCentre45 = new Intent(this, PrePunctureAlignKeyInCentre45.class);

        startActivity(getPPInAlignCentre45);

    }

    public void goPPLeftOffset45(View view) {

        Intent getPPLeftOffset45 = new Intent(this, PrePunctureOffsetLeft45.class);

        startActivity(getPPLeftOffset45);

    }

    public void goPPRightOffset45(View view) {

        Intent getPPRightOffset45 = new Intent (this, PrePunctureOffsetRight45.class);

        startActivity(getPPRightOffset45);
    }
}

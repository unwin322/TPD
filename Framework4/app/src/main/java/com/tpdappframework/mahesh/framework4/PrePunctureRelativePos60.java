package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureRelativePos60 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_rel_pos_in_60);

    }

    public void goPPInAlignCentre60(View view) {

        Intent getPPInAlignCentre60 = new Intent(this, PrePunctureAlignKeyInCentre60.class);

        startActivity(getPPInAlignCentre60);

    }

    public void goPPLeftOffset60(View view) {

        Intent getPPLeftOffset60 = new Intent(this, PrePunctureOffsetLeft60.class);

        startActivity(getPPLeftOffset60);

    }

    public void goPPRightOffset60(View view) {

        Intent getPPRightOffset60 = new Intent(this, PrePunctureOffsetRight45.class);

        startActivity(getPPRightOffset60);
    }
}

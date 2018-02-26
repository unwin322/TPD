package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureOffsetRight60 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_offset_dist_in_right_60);

    }

    public void goPPAlignInRight60(View view) {

        Intent getPPAlignInRight60 = new Intent(this, PrePunctureAlignKeyInRight60.class);

        startActivity(getPPAlignInRight60);

    }
}

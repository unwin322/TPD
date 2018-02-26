package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureOffsetRight30 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_offset_dist_in_right_30);

    }

    public void goPPAlignInRight30(View view) {

        Intent getPPAlignInRight30 = new Intent(this, PrePunctureAlignKeyInRight30.class);

        startActivity(getPPAlignInRight30);

    }
}

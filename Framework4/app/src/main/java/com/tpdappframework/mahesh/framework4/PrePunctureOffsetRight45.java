package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureOffsetRight45 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_offset_dist_in_right_45);

    }

    public void goPPAlignInRight45(View view) {

        Intent getPPAlignInRight30 = new Intent(this, PrePunctureAlignKeyInRight45.class);

        startActivity(getPPAlignInRight30);

    }
}

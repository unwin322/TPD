package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 13/02/2018.
 */

public class PrePuncture60OutPlaneStep4 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_target_depth_60_out);

    }

    public void goPPOutMark60(View view) {

        Intent getPPOutMark60 = new Intent(this, PrePunctureMarkSkin60Out.class);

        startActivity(getPPOutMark60);

    }
}

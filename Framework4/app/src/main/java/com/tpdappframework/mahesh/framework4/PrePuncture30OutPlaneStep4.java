package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 13/02/2018.
 */

public class PrePuncture30OutPlaneStep4 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_target_depth_30_out);


    }

    public void goPPOutMark30(View view) {

        Intent getPPOutMark30 = new Intent(this, PrePunctureMarkSkin30Out.class);

        startActivity(getPPOutMark30);

    }
}

package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 13/02/2018.
 */

public class PrePuncture30InPlaneStep4 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_target_depth_30_in);

    }


    public void goPPInMark30(View view) {

        Intent getPPInMark30 = new Intent(this, PrePunctureMarkSkin30In.class);

        startActivity(getPPInMark30);

    }
}

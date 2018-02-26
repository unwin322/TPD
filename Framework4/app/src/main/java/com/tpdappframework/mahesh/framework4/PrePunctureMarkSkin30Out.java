package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureMarkSkin30Out extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_mark_out_30);
    }

    public void goPPOutAlign30(View view) {

        Intent getPPOutAlign30 = new Intent(this, PrePunctureAlignKeyOut30.class);

        startActivity(getPPOutAlign30);

    }
}

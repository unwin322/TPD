package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureMarkSkin45In extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_mark_in_45);

    }

    public void goPPInOffset45(View view) {

        Intent getPPInOffset45 = new Intent(this, PrePunctureRelativePos45.class);

        startActivity(getPPInOffset45);

    }
}

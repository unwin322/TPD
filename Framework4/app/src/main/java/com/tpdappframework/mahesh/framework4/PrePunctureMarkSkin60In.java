package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureMarkSkin60In extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_mark_in_60);
    }

    public void goPPInOffset60(View view) {

        Intent getPPInOffset60 = new Intent(this, PrePunctureRelativePos60.class);

        startActivity(getPPInOffset60);

    }
}

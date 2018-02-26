package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 26/02/2018.
 */

public class PrePunctureMarkSkin30In extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_mark_in_30);

    }

    public void goPPInOffset30(View view) {

        Intent getPPInOffset30 = new Intent(this, PrePunctureRelativePos30.class);

        startActivity(getPPInOffset30);

    }
}

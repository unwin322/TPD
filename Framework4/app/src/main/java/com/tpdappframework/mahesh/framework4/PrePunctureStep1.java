package com.tpdappframework.mahesh.framework4;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


/**
 * Created by Mahesh on 09/02/2018.
 */

public class PrePunctureStep1 extends Calculator_or_Stepbystep_Menu {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_step_1);

    }

    public void key60degree(View view) {

        Intent getkey60degrees = new Intent(this,
                PrePuncture60FitAttachment.class);

        final int result = 1;

        startActivity(getkey60degrees);

    }

    public void key45degree(View view) {

        Intent getkey45degrees = new Intent(this,
                PrePuncture45FitAttachment.class);

        final int result = 1;

        startActivity(getkey45degrees);

    }

    public void key30degree(View view) {

        Intent getkey30degrees = new Intent(this,
                PrePuncture30FitAttachment.class);

        final int result = 1;

        startActivity(getkey30degrees);

    }
}

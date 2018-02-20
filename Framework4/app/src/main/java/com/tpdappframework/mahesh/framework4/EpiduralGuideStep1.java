package com.tpdappframework.mahesh.framework4;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


/**
 * Created by Mahesh on 09/02/2018.
 */

public class EpiduralGuideStep1 extends Calculator_or_Stepbystep_Menu {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.epidural_step_1);

    }

    public void goepiduralfixattachment(View view) {

        Intent getepiduralfixattachment = new Intent(this,
                EpiduralFitAttachmentStep2.class);

        final int result = 1;

        startActivity(getepiduralfixattachment);

    }
}

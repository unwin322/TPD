package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 16/02/2018.
 */

public class EpiduralLocatePensStep6 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.epidural_locate_lock_pens_step_6);

    }

    public void gofitguideattachment(View view) {

        Intent getfitguideattachment = new Intent(this,
                EpiduralFitGuideAttachmentStep7.class);

        final int result = 1;

        startActivity(getfitguideattachment);

    }
}

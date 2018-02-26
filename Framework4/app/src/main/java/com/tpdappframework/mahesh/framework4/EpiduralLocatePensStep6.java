package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 16/02/2018.
 */

public class EpiduralLocatePensStep6 extends Calculator_or_Stepbystep_Menu {

    String EpiDepthJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.epidural_locate_lock_pens_step_6);

        String EpiDepth = getIntent().getStringExtra("EpiDepthJump1");

        EpiDepthJump = EpiDepth;

    }

    public void gofitguideattachment(View view) {

        Intent getfitguideattachment = new Intent(this,
                EpiduralFitGuideAttachmentStep7.class);

        getfitguideattachment.putExtra("EpiDepthJump2", EpiDepthJump);

        setResult(RESULT_OK, getfitguideattachment);

        startActivity(getfitguideattachment);

    }
}

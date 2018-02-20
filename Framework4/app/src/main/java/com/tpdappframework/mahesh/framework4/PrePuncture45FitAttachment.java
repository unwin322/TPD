package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 13/02/2018.
 */

public class PrePuncture45FitAttachment extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_puncture_45_fit_attachment);

    }

    public void GoPrePunctureInOut45(View view) {

        Intent getPrePunctureInOut45 = new Intent(this,
                PrePuncture45Step2.class);

        final int result = 1;

        startActivity(getPrePunctureInOut45);

    }
}

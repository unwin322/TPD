package com.tpdappframework.mahesh.framework4;

import android.os.Bundle;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Mahesh on 16/02/2018.
 */

public class EpiduralNeedleInsertionLengthStep9 extends Calculator_or_Stepbystep_Menu {

    double NeedleLength;
    String ShowNeedleLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.epidural_needle_insertion_length_step_9);

        String EpiDepth = getIntent().getStringExtra("EpiDepthJump4");

        double FixedNeedleLengthOffset = 3.4;
        double Depth = Double.parseDouble(EpiDepth);

        DecimalFormat dfl = new DecimalFormat("#.#");
        dfl.setRoundingMode(RoundingMode.HALF_UP);

        NeedleLength = Double.valueOf(dfl.format(FixedNeedleLengthOffset+Depth));
        ShowNeedleLength = Double.toString(NeedleLength);

        TextView showEpiFinal = (TextView) findViewById(R.id.show_epi_depth);

        showEpiFinal.append(" " + ShowNeedleLength);

    }
}

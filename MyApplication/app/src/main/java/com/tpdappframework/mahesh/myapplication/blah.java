package com.tpdappframework.mahesh.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;


/**
 * Created by Mahesh on 26/02/2018.
 */

public class blah extends MainActivity {

    double NeedleLength;
    double GuideAngle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.new_page);

        String depth_string = getIntent().getStringExtra("UsersName");
        String depth_string2 = getIntent().getStringExtra("UsersName2");

        double depth = Double.parseDouble(depth_string);

        //Define Rounding
        DecimalFormat dfl = new DecimalFormat("#.#");
        DecimalFormat dfa = new DecimalFormat("##");
        dfl.setRoundingMode(RoundingMode.HALF_UP);
        dfa.setRoundingMode(RoundingMode.HALF_UP);

        //Fixed Offset Data
        double FixedHorizontalOffset = 2.975;
        double FixedVerticalOffset = 1.277;
        double FixedNeedleLengthOffset = 2.95;
        double offset = 0;

        double TotalHorizontal = FixedHorizontalOffset + offset;
        double TotalVertical = FixedVerticalOffset + depth;


        NeedleLength = Double.valueOf(dfl.format((FixedNeedleLengthOffset + Math.sqrt((TotalHorizontal*TotalHorizontal)+(TotalVertical*TotalVertical)))));
        GuideAngle = Double.valueOf(dfa.format((Math.toDegrees(Math.atan(TotalHorizontal/TotalVertical)))));

        String ShowNeedleLength = Double.toString(NeedleLength);

        TextView newPage = (TextView) findViewById(R.id.yo_send_it_here);
        newPage.append(" " + ShowNeedleLength + depth_string2);

    }
}

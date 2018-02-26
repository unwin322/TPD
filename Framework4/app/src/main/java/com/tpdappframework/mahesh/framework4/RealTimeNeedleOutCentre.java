package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Mahesh on 21/02/2018.
 */

public class RealTimeNeedleOutCentre extends Calculator_or_Stepbystep_Menu {

    double NeedleLength;
    double GuideAngle;
    String ShowGuideAngle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_needle_length_out_oncentre);


        //Retrieve the data sent across

        String RTNeedleLengthOutPlane = getIntent().getStringExtra("SendRTTargetDepthOutPlane");

        double depth = Double.parseDouble(RTNeedleLengthOutPlane);

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
        ShowGuideAngle = Double.toString(GuideAngle);

        TextView showRTDepthOutPlane = (TextView) findViewById(R.id.RT_Needle_Length_Out_Show);

        showRTDepthOutPlane.append(" " + ShowNeedleLength);

    }

    public void gorealtimesetangleoutcentre( View view) {


        Intent getrealtimesetangleoutcentre = new Intent(this,
                RealTimeSetAngleOutCentre.class);

        getrealtimesetangleoutcentre.putExtra("SendRTAngleOutPlane", ShowGuideAngle);

        setResult(RESULT_OK, getrealtimesetangleoutcentre);

        startActivity(getrealtimesetangleoutcentre);

    }
}

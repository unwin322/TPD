package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Mahesh on 21/02/2018.
 */

public class RealTimeNeedleInRight extends Calculator_or_Stepbystep_Menu {

    double NeedleLength;
    double GuideAngle;
    String ShowGuideAngle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_needle_length_in_rightcentre);

        String RTOffsetRight = getIntent().getStringExtra("SendRTRightOffsetNext");

        String RTDepthRight = getIntent().getStringExtra("SendRTRightDepth");

        double RTdepthRight = Double.parseDouble(RTDepthRight);
        double RTDOffsetRight = Double.parseDouble(RTOffsetRight);

        //Target Offset Data
        double offsetAbs = RTDOffsetRight;
        double offset = offsetAbs*1;

        //Define Rounding
        DecimalFormat dfl = new DecimalFormat("#.#");
        DecimalFormat dfa = new DecimalFormat("##");
        dfl.setRoundingMode(RoundingMode.HALF_UP);
        dfa.setRoundingMode(RoundingMode.HALF_UP);

        //Fixed Offset Data
        double FixedHorizontalOffset = 4.5438;
        double FixedVerticalOffset = 1.294;
        double FixedNeedleLengthOffset = 2.95;

        double TotalHorizontal = FixedHorizontalOffset + offset;
        double TotalVertical = FixedVerticalOffset + RTdepthRight;


        NeedleLength = Double.valueOf(dfl.format((FixedNeedleLengthOffset + Math.sqrt((TotalHorizontal*TotalHorizontal)+(TotalVertical*TotalVertical)))));
        GuideAngle = Double.valueOf(dfa.format((Math.toDegrees(Math.atan(TotalHorizontal/TotalVertical)))));

        String ShowNeedleLength = Double.toString(NeedleLength);
        ShowGuideAngle = Double.toString(GuideAngle);

        //NEED TO SORT THIS OUT!!
        TextView showRTDepthLeft = (TextView) findViewById(R.id.RT_Needle_Length_Right_Show);

        showRTDepthLeft.append(" " + ShowNeedleLength);

    }

    public void gorealtimesetangleinright(View view) {

        Intent getrealtimesetangleinright = new Intent(this,
                RealTimeSetAngleInRight.class);

        getrealtimesetangleinright.putExtra("SendRTAngleInPlaneRight", ShowGuideAngle);

        setResult(RESULT_OK, getrealtimesetangleinright);

        startActivity(getrealtimesetangleinright);
    }
}

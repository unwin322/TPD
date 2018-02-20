package com.tpdappframework.mahesh.framework4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mahesh on 20/02/2018.
 */

public class RealTimeWhereTargetInPlaneStep6 extends Calculator_or_Stepbystep_Menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.real_time_relative_position_step_6_in);
    }

    public void gorealtimedepthinleft(View view) {

        Intent getrealtimedepthinleft = new Intent(this,
                RealTimeDepthInLeft.class);

        final int result = 1;

        startActivity(getrealtimedepthinleft);
    }

    public void gorealtimedepthinright(View view) {

        Intent getrealtimedepthinright = new Intent(this,
                RealTimeDepthInRight.class);

        final int result = 1;

        startActivity(getrealtimedepthinright);

    }

    public void gorealtimedepthincentre(View view) {

        Intent getrealtimedepthincentre = new Intent (this,
                RealTimeDepthInCentre.class);

        final int result = 1;

        startActivity(getrealtimedepthincentre);

    }
}

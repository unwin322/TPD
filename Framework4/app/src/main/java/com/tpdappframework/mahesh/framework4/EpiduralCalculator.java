package com.tpdappframework.mahesh.framework4;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Mahesh on 09/02/2018.
 */

public class EpiduralCalculator extends Calculator_or_Stepbystep_Menu implements View.OnClickListener {

        EditText EpTargetDepth;
        TextView outputEpNeedleLength;
        Button inputEpCalculateBtn;
        double NeedleLength;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_epidural_assistant);

            // Find Elements
            EpTargetDepth = (EditText) findViewById(R.id.inputEpTargetDepth);
            outputEpNeedleLength = (TextView) findViewById(R.id.outputEpNeedleLength);
            inputEpCalculateBtn = (Button) findViewById(R.id.inputEpCalculateBtn);

            // Set Listener
            inputEpCalculateBtn.setOnClickListener(this);

        }

        // ************************************
        // FUNCTION TO CALCULATE GUIDE SETTINGS
        // ************************************
        @Override
        public void onClick(View v) {

            //Handle Offset
            errorEvaluator();

            //Depth Data
            double Depth = Double.parseDouble(EpTargetDepth.getText().toString());

            //Fixed Offset Data
            double FixedNeedleLengthOffset = 3.4;

            //Define Rounding
            DecimalFormat dfl = new DecimalFormat("#.#");
            dfl.setRoundingMode(RoundingMode.HALF_UP);

            //Calculate Final Values
            NeedleLength = Double.valueOf(dfl.format(FixedNeedleLengthOffset+Depth));

            //Write Final Values to User Interface
            outputEpNeedleLength.setText(Double.toString(NeedleLength));

        }

        // ************************************************
        // FUNCTION TO EVALUATE ERRORS AND PROVIDE WARNINGS
        // ************************************************
        // Evaluates the selected settings and flags errors
        public void errorEvaluator(){
            //Grab Data
            String stringTargetDepth = EpTargetDepth.getText().toString();

            //Adjustments
            if (stringTargetDepth.matches("Enter Depth (cm)")||stringTargetDepth.matches("")){
                EpTargetDepth.setText("0");
            }

            //Error Messages
            if (stringTargetDepth.matches("0")||stringTargetDepth.matches("")) {
                new AlertDialog.Builder(this, R.style.AlertDialogCustom)
                        .setTitle("Missing Input")
                        .setMessage("Please enter the target depth as measured from the ultrasound picture")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int which){
                                //Do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        }

}



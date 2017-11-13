package com.loughbroughproject.needleguidesettingsassistant;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class EpiduralAssistant extends AppCompatActivity implements View.OnClickListener {

    EditText EpTargetDepth;
    TextView outputEpNeedleLength;
    Button inputEpCalculateBtn;
    double NeedleLength;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epidural_assistant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
            new AlertDialog.Builder(this)
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

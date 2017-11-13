package com.loughbroughproject.needleguidesettingsassistant;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MovingScaleAssistant extends AppCompatActivity implements View.OnClickListener {

    EditText MSTargetDepth;
    EditText MSTargetOffset;
    TextView outputMSNeedleLength;
    TextView outputMSGuideAngle;
    Button inputMSCalculateBtn;
    double NeedleLength;
    double GuideAngle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving_scale_assistant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Populate Plane Insertion Spinner
        List<String> InsertionPlaneOptions = new ArrayList<String>();
        InsertionPlaneOptions.add("Select from Drop Down Menu");
        InsertionPlaneOptions.add("In Plane");
        InsertionPlaneOptions.add("Out of Plane");

        ArrayAdapter<String> adapterPlane = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, InsertionPlaneOptions);

        adapterPlane.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner PlaneItems = (Spinner) findViewById(R.id.spinnerMSInsertionPlane);
        PlaneItems.setAdapter(adapterPlane);

        // Initial Population of Relative Position Spinner
        List<String> RelativePositionOptions = new ArrayList<String>();
        RelativePositionOptions.add("Select from Drop Down Menu");
        RelativePositionOptions.add("On Centreline");

        ArrayAdapter<String> adapterRelPos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, RelativePositionOptions);

        adapterRelPos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner RelPosItems = (Spinner) findViewById(R.id.spinnerMSRelativePsn);
        RelPosItems.setAdapter(adapterRelPos);

        //Conditional Population of Relative Position Spinner
        PlaneItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                String plane = (String)parent.getItemAtPosition(position);

                if (plane.matches("In Plane")) {
                    populateRelPos(1);
                } else if (plane.matches("Out of Plane")) {
                    populateRelPos(2);
                } else {
                    populateRelPos(0);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //DO NOTHING
            }
        });

        // Set Edit Text Box Based on Centreline Positioning
        RelPosItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                String plane = (String)parent.getItemAtPosition(position);

                if (plane.matches("On Centreline")) {
                    edittextcontrol(1);
                } else if (plane.matches("Left of Centreline")) {
                    edittextcontrol(2);
                } else if (plane.matches("Right of Centreline")) {
                    edittextcontrol(2);
                } else {
                    edittextcontrol(0);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //DO NOTHING
            }
        });

        // Find Elements
        MSTargetDepth = (EditText) findViewById(R.id.inputMSTargetDepth);
        MSTargetOffset = (EditText) findViewById(R.id.inputMSTargetOffset);
        outputMSNeedleLength = (TextView) findViewById(R.id.outputMSNeedleLength);
        outputMSGuideAngle = (TextView) findViewById(R.id.outputMSGuideAngle);
        inputMSCalculateBtn = (Button) findViewById(R.id.inputMSCalculateBtn);

        // Set Listener
        inputMSCalculateBtn.setOnClickListener(this);
    }

    // **********************************************
    // FUNCTION TO POPULATE RELATIVE POSITION SPINNER
    // **********************************************
    public void populateRelPos(int ListSelect) {
        if(ListSelect == 1) {
            // User has selected In Plane
            List<String> IPRelativePositionOptions = new ArrayList<String>();
            IPRelativePositionOptions.add("Select from Drop Down Menu");
            IPRelativePositionOptions.add("On Centreline");
            IPRelativePositionOptions.add("Left of Centreline");
            IPRelativePositionOptions.add("Right of Centreline");

            ArrayAdapter<String> adapterIPRelPos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, IPRelativePositionOptions);

            adapterIPRelPos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Spinner RelPosItems = (Spinner) findViewById(R.id.spinnerMSRelativePsn);
            RelPosItems.setAdapter(adapterIPRelPos);
        } else if(ListSelect==2) {
            // User has selected Out of Plane
            List<String> OoPRelativePositionOptions = new ArrayList<String>();
            OoPRelativePositionOptions.add("On Centreline");

            ArrayAdapter<String> adapterOoPRelPos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, OoPRelativePositionOptions);

            adapterOoPRelPos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Spinner RelPosItems = (Spinner) findViewById(R.id.spinnerMSRelativePsn);
            RelPosItems.setAdapter(adapterOoPRelPos);
        } else {
            // User has made no valid selection
            List<String> ResetRelativePositionOptions = new ArrayList<String>();
            ResetRelativePositionOptions.add("Select from Drop Down Menu");
            ResetRelativePositionOptions.add("On Centreline");

            ArrayAdapter<String> adapterResetRelPos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ResetRelativePositionOptions);

            adapterResetRelPos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Spinner RelPosItems = (Spinner) findViewById(R.id.spinnerMSRelativePsn);
            RelPosItems.setAdapter(adapterResetRelPos);
        }
    }

    // **************************************
    // FUNCTION TO SET EDIT TEXT AVAILABILITY
    // **************************************
    public void edittextcontrol(int ListSelect) {
        switch(ListSelect){
            // Case 1 = On Centreline
            // Case 2 = Left or Right of Centreline
            // Default = No Selection
            case 1: MSTargetOffset.setEnabled(false);
                MSTargetOffset.setBackgroundResource(R.drawable.text_input_2);
                MSTargetOffset.setText("0");
                break;
            case 2: MSTargetOffset.setEnabled(true);
                MSTargetOffset.setBackgroundResource(R.drawable.text_input_1);
                MSTargetOffset.setText("");
                break;
            default: MSTargetOffset.setEnabled(false);
                MSTargetOffset.setBackgroundResource(R.drawable.text_input_2);
                MSTargetOffset.setText("0");
        }
    }

    // ************************************
    // FUNCTION TO CALCULATE GUIDE SETTINGS
    // ************************************
    @Override
    public void onClick(View v) {

        //Handle Offset
        errorEvaluator();

        //Depth Data
        double depth = Double.parseDouble(MSTargetDepth.getText().toString());

        //Target Offset Data
        double offsetAbs = Double.parseDouble(MSTargetOffset.getText().toString());
        double offset = offsetAbs*getOffsetDirection();

        //Fixed Offset Data
        double FixedHorizontalOffset = getFixedHorizontalOffsetData();
        double FixedVerticalOffset = getFixedVerticalOffsetData();
        double FixedNeedleLengthOffset = 4.2;
        double rotaryOffset = 0.655;

        //Total Offsets
        double TotalHorizontal = FixedHorizontalOffset + offset;
        double TotalVertical = FixedVerticalOffset + depth;

        //Interim Length
        double interimLength = Math.sqrt((TotalHorizontal*TotalHorizontal)+(TotalVertical*TotalVertical));
        double totalLength = Math.sqrt((interimLength*interimLength)-(rotaryOffset*rotaryOffset));

        //Interim Angles
        double phiOne = Math.toDegrees(Math.atan(TotalHorizontal/TotalVertical));
        double phiTwo = Math.toDegrees(Math.atan(rotaryOffset/totalLength));

        //Define Rounding
        DecimalFormat dfl = new DecimalFormat("#.#");
        DecimalFormat dfa = new DecimalFormat("##");
        dfl.setRoundingMode(RoundingMode.HALF_UP);
        dfa.setRoundingMode(RoundingMode.HALF_UP);

        //Calculate Final Values
        NeedleLength = Double.valueOf(dfl.format((FixedNeedleLengthOffset + totalLength)));
        GuideAngle = Double.valueOf(dfa.format(90-(phiOne+phiTwo)));

        //Write Final Values to User Interface
        outputMSNeedleLength.setText(Double.toString(NeedleLength));
        outputMSGuideAngle.setText(Double.toString(GuideAngle));

        //Check Values are Achievable
        valueCheck(GuideAngle);
    }

    // ************************************************
    // FUNCTION TO EVALUATE ERRORS AND PROVIDE WARNINGS
    // ************************************************
    // Evaluates the selected settings and flags errors
    public void errorEvaluator(){
        //Grab Data
        Spinner spinnerInsertPlane = (Spinner)findViewById(R.id.spinnerMSInsertionPlane);
        String stringInsertPlane = spinnerInsertPlane.getSelectedItem().toString();
        Spinner spinnerRelPos = (Spinner)findViewById(R.id.spinnerMSRelativePsn);
        String stringRelPos = spinnerRelPos.getSelectedItem().toString();
        String stringTargetDepth = MSTargetDepth.getText().toString();
        String stringOffset = MSTargetOffset.getText().toString();

        //Adjustments
        if (stringTargetDepth.matches("Enter Depth (cm)")||stringTargetDepth.matches("")){
            MSTargetDepth.setText("0");
        }
        if (stringOffset.matches("Enter Depth (cm)")||stringOffset.matches("")){
            MSTargetOffset.setText("0");
        }

        //Error Messages
        if (stringInsertPlane.matches("Select from Drop Down Menu")) {
            new AlertDialog.Builder(this)
                    .setTitle("Missing Selection")
                    .setMessage("Please select the Plane of Insertion from the drop down menu")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which){
                            //Do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        } else if (stringRelPos.matches("Select from Drop Down Menu")) {
            new AlertDialog.Builder(this)
                    .setTitle("Missing Selection")
                    .setMessage("Please select the Relative Position from the drop down menu")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which){
                            //Do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        } else if (stringTargetDepth.matches("0")||stringTargetDepth.matches("")) {
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
        } else if ((stringRelPos.matches("Left of Centreline")||stringRelPos.matches("Right of Centreline"))
                && ((stringOffset.matches("0"))||(stringOffset.matches("")))){
            new AlertDialog.Builder(this)
                    .setTitle("Invalid Input")
                    .setMessage("Please enter the target offset as measured from the ultrasound picture. If the target is on the scan centreline please change the Relative Position from the drop down menu")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which){
                            //Do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }

    // ********************************************
    // FUNCTION TO GET FIXED HORIZONTAL OFFSET DATA
    // ********************************************
    // Returns fixed horizontal offset data for the chosen plane
    public double getFixedHorizontalOffsetData(){
        Spinner spinnerInsertionPlane = (Spinner)findViewById(R.id.spinnerMSInsertionPlane);
        String stringInsertionPlane = spinnerInsertionPlane.getSelectedItem().toString();
        double FixedHorizontalOffset;
        switch(stringInsertionPlane){
            case "In Plane": FixedHorizontalOffset = 4.7438;
                break;
            case "Out of Plane": FixedHorizontalOffset = 2.97;
                break;
            default: FixedHorizontalOffset = 0;
        }
        return FixedHorizontalOffset;
    }

    // ******************************************
    // FUNCTION TO GET FIXED VERTICAL OFFSET DATA
    // ******************************************
    // Returns fixed vertical offset data for the chosen plane
    public double getFixedVerticalOffsetData(){
        Spinner spinnerInsertionPlane = (Spinner)findViewById(R.id.spinnerMSInsertionPlane);
        String stringInsertionPlane = spinnerInsertionPlane.getSelectedItem().toString();
        double FixedVerticalOffset;
        switch(stringInsertionPlane){
            case "In Plane": FixedVerticalOffset = 1.09984;
                break;
            case "Out of Plane": FixedVerticalOffset = 1.09984;
                break;
            default: FixedVerticalOffset = 0;
        }
        return FixedVerticalOffset;
    }

    // ***********************************
    // FUNCTION TO GET AN OFFSET DIRECTOR
    // ***********************************
    // Returns a multiplier based on the selected direction of offset from centreline
    public int getOffsetDirection(){
        Spinner spinnerOffsetDirection = (Spinner)findViewById(R.id.spinnerMSRelativePsn);
        String stringOffsetDirection = spinnerOffsetDirection.getSelectedItem().toString();
        int OffsetDirector;
        switch(stringOffsetDirection){
            case "Left of Centreline": OffsetDirector = -1;
                break;
            case "Right of Centreline": OffsetDirector = 1;
                break;
            default: OffsetDirector = 0;
        }
        return OffsetDirector;
    }

    // ***********************
    // VALUE CHECKING FUNCTION
    // ***********************
    // Check validity of output and clear if invalid
    public void valueCheck(double GuideAngle) {
        if (GuideAngle < 21){
            new AlertDialog.Builder(this)
                    .setTitle("Angle Too Shallow")
                    .setMessage("The target cannot be reached using the Moving Scale Guide. \r\n\r\n" +
                            "Possible Solutions:\r\n" +
                            "(1) If 'In Plane' consider shifting the target left of centreline \r\n" +
                            "(2) If 'In Plane' consider using the guide 'Out Of Plane'\r\n" +
                            "(3) Use an alternative guide product \r\n")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which){
                            outputMSGuideAngle.setText("Out of Range");
                            outputMSNeedleLength.setText("Out of Range");
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }else if (GuideAngle >70) {
            new AlertDialog.Builder(this)
                    .setTitle("Angle Too Steep")
                    .setMessage("The target cannot be reached using the Moving Scale Guide. \r\n\r\n" +
                            "Possible Solutions:\r\n" +
                            "(1) If 'In Plane' consider shifting the target right of centreline \r\n" +
                            "(2) If 'In Plane' consider using the guide 'Out Of Plane'\r\n" +
                            "(3) Use an alternative guide product")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which){
                            outputMSGuideAngle.setText("Out of Range");
                            outputMSNeedleLength.setText("Out of Range");
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }

}

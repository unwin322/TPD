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
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FixedScaleAssistant extends AppCompatActivity implements View.OnClickListener {

    EditText FSTargetDepth;
    EditText FSTargetOffset;
    TextView outputFSNeedleLength;
    TextView outputFSGuideAngle;
    Button inputFSCalculateBtn;
    double NeedleLength;
    double GuideAngle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixed_scale_assistant);
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
        final Spinner PlaneItems = (Spinner) findViewById(R.id.spinnerFSInsertionPlane);
        PlaneItems.setAdapter(adapterPlane);

        // Initial Population of Relative Position Spinner
        List<String> RelativePositionOptions = new ArrayList<String>();
        RelativePositionOptions.add("Select from Drop Down Menu");
        RelativePositionOptions.add("On Centreline");

        ArrayAdapter<String> adapterRelPos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, RelativePositionOptions);

        adapterRelPos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner RelPosItems = (Spinner) findViewById(R.id.spinnerFSRelativePsn);
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
        FSTargetDepth = (EditText) findViewById(R.id.inputFSTargetDepth);
        FSTargetOffset = (EditText) findViewById(R.id.inputFSTargetOffset);
        outputFSNeedleLength = (TextView) findViewById(R.id.outputFSNeedleLength);
        outputFSGuideAngle = (TextView) findViewById(R.id.outputFSGuideAngle);
        inputFSCalculateBtn = (Button) findViewById(R.id.inputFSCalculateBtn);

        // Set Listener
        inputFSCalculateBtn.setOnClickListener(this);
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
            Spinner RelPosItems = (Spinner) findViewById(R.id.spinnerFSRelativePsn);
            RelPosItems.setAdapter(adapterIPRelPos);
        } else if(ListSelect==2) {
            // User has selected Out of Plane
            List<String> OoPRelativePositionOptions = new ArrayList<String>();
            OoPRelativePositionOptions.add("On Centreline");

            ArrayAdapter<String> adapterOoPRelPos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, OoPRelativePositionOptions);

            adapterOoPRelPos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Spinner RelPosItems = (Spinner) findViewById(R.id.spinnerFSRelativePsn);
            RelPosItems.setAdapter(adapterOoPRelPos);
        } else {
            // User has made no valid selection
            List<String> ResetRelativePositionOptions = new ArrayList<String>();
            ResetRelativePositionOptions.add("Select from Drop Down Menu");
            ResetRelativePositionOptions.add("On Centreline");

            ArrayAdapter<String> adapterResetRelPos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ResetRelativePositionOptions);

            adapterResetRelPos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Spinner RelPosItems = (Spinner) findViewById(R.id.spinnerFSRelativePsn);
            RelPosItems.setAdapter(adapterResetRelPos);
        }
    }

    // **************************************
    // FUNCTION TO SET EDIT TEXT AVAILABILITY
    // **************************************
    public void edittextcontrol(int ListSelect) {
        switch(ListSelect){
            // Case 1 = On Centreline
            // Case 2 = Left of Centreline
            // Case 3 = Right of Centreline
            // Default = No Selection
            case 1: FSTargetOffset.setEnabled(false);
                FSTargetOffset.setBackgroundResource(R.drawable.text_input_2);
                FSTargetOffset.setText("0");
                break;
            case 2: FSTargetOffset.setEnabled(true);
                FSTargetOffset.setBackgroundResource(R.drawable.text_input_1);
                FSTargetOffset.setText("");
                break;
            default: FSTargetOffset.setEnabled(false);
                FSTargetOffset.setBackgroundResource(R.drawable.text_input_2);
                FSTargetOffset.setText("0");
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
        double depth = Double.parseDouble(FSTargetDepth.getText().toString());

        //Target Offset Data
        double offsetAbs = Double.parseDouble(FSTargetOffset.getText().toString());
        double offset = offsetAbs*getOffsetDirection();

        //Fixed Offset Data
        double FixedHorizontalOffset = getFixedHorizontalOffsetData();
        double FixedVerticalOffset = getFixedVerticalOffsetData();
        double FixedNeedleLengthOffset = 2.95;

        //Total Offsets
        double TotalHorizontal = FixedHorizontalOffset + offset;
        double TotalVertical = FixedVerticalOffset + depth;

        //Define Rounding
        DecimalFormat dfl = new DecimalFormat("#.#");
        DecimalFormat dfa = new DecimalFormat("##");
        dfl.setRoundingMode(RoundingMode.HALF_UP);
        dfa.setRoundingMode(RoundingMode.HALF_UP);

        //Calculate Final Values
        NeedleLength = Double.valueOf(dfl.format((FixedNeedleLengthOffset + Math.sqrt((TotalHorizontal*TotalHorizontal)+(TotalVertical*TotalVertical)))));
        GuideAngle = Double.valueOf(dfa.format((Math.toDegrees(Math.atan(TotalHorizontal/TotalVertical)))));

        //Write Final Values to User Interface
        outputFSNeedleLength.setText(Double.toString(NeedleLength));
        outputFSGuideAngle.setText(Double.toString(GuideAngle));

        //Check Values are Achievable
        valueCheck(GuideAngle);
    }

    // ************************************************
    // FUNCTION TO EVALUATE ERRORS AND PROVIDE WARNINGS
    // ************************************************
    // Evaluates the selected settings and flags errors
    public void errorEvaluator(){
        //Grab Data
        Spinner spinnerInsertPlane = (Spinner)findViewById(R.id.spinnerFSInsertionPlane);
        String stringInsertPlane = spinnerInsertPlane.getSelectedItem().toString();
        Spinner spinnerRelPos = (Spinner)findViewById(R.id.spinnerFSRelativePsn);
        String stringRelPos = spinnerRelPos.getSelectedItem().toString();
        String stringTargetDepth = FSTargetDepth.getText().toString();
        String stringOffset = FSTargetOffset.getText().toString();

        //Adjustments
        if (stringTargetDepth.matches("Enter Depth (cm)")||stringTargetDepth.matches("")){
            FSTargetDepth.setText("0");
        }
        if (stringOffset.matches("Enter Depth (cm)")||stringOffset.matches("")){
            FSTargetOffset.setText("0");
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
        Spinner spinnerInsertionPlane = (Spinner)findViewById(R.id.spinnerFSInsertionPlane);
        String stringInsertionPlane = spinnerInsertionPlane.getSelectedItem().toString();
        double FixedHorizontalOffset;
        switch(stringInsertionPlane){
            case "In Plane": FixedHorizontalOffset = 4.5438;
                break;
            case "Out of Plane": FixedHorizontalOffset = 2.975;
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
        Spinner spinnerInsertionPlane = (Spinner)findViewById(R.id.spinnerFSInsertionPlane);
        String stringInsertionPlane = spinnerInsertionPlane.getSelectedItem().toString();
        double FixedVerticalOffset;
        switch(stringInsertionPlane){
            case "In Plane": FixedVerticalOffset = 1.294;
                break;
            case "Out of Plane": FixedVerticalOffset = 1.277;
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
        Spinner spinnerOffsetDirection = (Spinner)findViewById(R.id.spinnerFSRelativePsn);
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
        if (GuideAngle > 60){
            new AlertDialog.Builder(this)
                    .setTitle("Angle Too Shallow")
                    .setMessage("The target cannot be reached using the Fixed Scale Guide. \r\n\r\n" +
                            "Possible Solutions:\r\n" +
                            "(1) If 'In Plane' consider shifting the target left of centreline \r\n" +
                            "(2) If 'In Plane' consider using the guide 'Out Of Plane'\r\n" +
                            "(3) Use an alternative guide product \r\n")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which){
                            outputFSGuideAngle.setText("Out of Range");
                            outputFSNeedleLength.setText("Out of Range");
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }else if (GuideAngle < 25) {
            new AlertDialog.Builder(this)
                    .setTitle("Angle Too Steep")
                    .setMessage("The target cannot be reached using the Fixed Scale Guide. \r\n\r\n" +
                            "Possible Solutions:\r\n" +
                            "(1) If 'In Plane' consider shifting the target right of centreline \r\n" +
                            "(2) If 'In Plane' consider using the guide 'Out Of Plane'\r\n" +
                            "(3) Use an alternative guide product")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which){
                            outputFSGuideAngle.setText("Out of Range");
                            outputFSNeedleLength.setText("Out of Range");
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }
}


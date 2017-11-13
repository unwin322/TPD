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

public class KeySystemAssistant extends AppCompatActivity implements View.OnClickListener {

    EditText KSTargetDepth;
    EditText KSTargetOffset;
    TextView outputKSNeedleLength;
    TextView outputKSGuideOffset;
    Button inputKSCalculateBtn;
    double NeedleLength;
    double GuideOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_system_assistant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Populate Key Selection Spinner
        List<String> KeySelectOptions = new ArrayList<String>();
        KeySelectOptions.add("Select");
        KeySelectOptions.add("30 Degrees");
        KeySelectOptions.add("45 Degrees");
        KeySelectOptions.add("60 Degrees");

        ArrayAdapter<String> adapterKey = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, KeySelectOptions);

        adapterKey.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner KeyItems = (Spinner) findViewById(R.id.spinnerKSSelectedKey);
        KeyItems.setAdapter(adapterKey);

        // Populate Plane Insertion Spinner
        List<String> InsertionPlaneOptions = new ArrayList<String>();
        InsertionPlaneOptions.add("Select");
        InsertionPlaneOptions.add("In Plane");
        InsertionPlaneOptions.add("Out of Plane");

        ArrayAdapter<String> adapterPlane = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, InsertionPlaneOptions);

        adapterPlane.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner PlaneItems = (Spinner) findViewById(R.id.spinnerKSInsertionPlane);
        PlaneItems.setAdapter(adapterPlane);

        // Initial Population of Relative Position Spinner
        List<String> RelativePositionOptions = new ArrayList<String>();
        RelativePositionOptions.add("Select from Drop Down Menu");
        RelativePositionOptions.add("On Centreline");

        ArrayAdapter<String> adapterRelPos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, RelativePositionOptions);

        adapterRelPos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner RelPosItems = (Spinner) findViewById(R.id.spinnerKSRelativePsn);
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
        KSTargetDepth = (EditText) findViewById(R.id.inputKSTargetDepth);
        KSTargetOffset = (EditText) findViewById(R.id.inputKSTargetOffset);
        outputKSNeedleLength = (TextView) findViewById(R.id.outputKSNeedleLength);
        outputKSGuideOffset = (TextView) findViewById(R.id.outputKSGuideOffset);
        inputKSCalculateBtn = (Button) findViewById(R.id.inputKSCalculateBtn);

        // Set Listener
        inputKSCalculateBtn.setOnClickListener(this);
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
            Spinner RelPosItems = (Spinner) findViewById(R.id.spinnerKSRelativePsn);
            RelPosItems.setAdapter(adapterIPRelPos);
        } else if(ListSelect==2) {
            // User has selected Out of Plane
            List<String> OoPRelativePositionOptions = new ArrayList<String>();
            OoPRelativePositionOptions.add("On Centreline");

            ArrayAdapter<String> adapterOoPRelPos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, OoPRelativePositionOptions);

            adapterOoPRelPos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Spinner RelPosItems = (Spinner) findViewById(R.id.spinnerKSRelativePsn);
            RelPosItems.setAdapter(adapterOoPRelPos);
        } else {
            // User has made no valid selection
            List<String> ResetRelativePositionOptions = new ArrayList<String>();
            ResetRelativePositionOptions.add("Select from Drop Down Menu");
            ResetRelativePositionOptions.add("On Centreline");

            ArrayAdapter<String> adapterResetRelPos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ResetRelativePositionOptions);

            adapterResetRelPos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Spinner RelPosItems = (Spinner) findViewById(R.id.spinnerKSRelativePsn);
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
            case 1: KSTargetOffset.setEnabled(false);
                KSTargetOffset.setBackgroundResource(R.drawable.text_input_2);
                KSTargetOffset.setText("0");
                break;
            case 2: KSTargetOffset.setEnabled(true);
                KSTargetOffset.setBackgroundResource(R.drawable.text_input_1);
                KSTargetOffset.setText("");
                break;
            default: KSTargetOffset.setEnabled(false);
                KSTargetOffset.setBackgroundResource(R.drawable.text_input_2);
                KSTargetOffset.setText("0");
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
        double depth = Double.parseDouble(KSTargetDepth.getText().toString());

        //Angle Data
        double theta = getAngleFromSelectedGuide();

        //Target Offset Data
        double offsetAbs = Double.parseDouble(KSTargetOffset.getText().toString());
        double offset = offsetAbs*getOffsetDirection();

        //Fixed Offset Data
        double FixedHorizontalOffset = getFixedHorizontalOffsetData();
        double FixedVerticalOffset = 0;
        double FixedNeedleLengthOffset = getFixedNeedleLengthOffsetData();

        //Total Offsets
        double TotalHorizontal = FixedHorizontalOffset + offset;
        double TotalVertical = FixedVerticalOffset + depth;

        //Define Rounding
        DecimalFormat dfl = new DecimalFormat("#.#");
        DecimalFormat dfo = new DecimalFormat("#.#");
        dfl.setRoundingMode(RoundingMode.HALF_UP);
        dfo.setRoundingMode(RoundingMode.HALF_UP);

        //Calculate Final Values
        GuideOffset = Double.valueOf(dfo.format(((TotalVertical/(Math.tan(theta)))-TotalHorizontal)));
        NeedleLength = Double.valueOf(dfl.format((FixedNeedleLengthOffset + Math.sqrt(((TotalHorizontal+GuideOffset)*(TotalHorizontal+GuideOffset))+(TotalVertical*TotalVertical)))));

        //Write Final Values to User Interface
        outputKSNeedleLength.setText(Double.toString(NeedleLength));
        outputKSGuideOffset.setText(Double.toString(GuideOffset));

        //Check Values are Achievable
        valueCheck(GuideOffset);
    }

    // ************************************************
    // FUNCTION TO EVALUATE ERRORS AND PROVIDE WARNINGS
    // ************************************************
    // Evaluates the selected settings and flags errors
    public void errorEvaluator() {
        //Grab Data
        Spinner spinnerSelectedKey = (Spinner) findViewById(R.id.spinnerKSSelectedKey);
        String stringSelectedKey = spinnerSelectedKey.getSelectedItem().toString();
        Spinner spinnerInsertPlane = (Spinner) findViewById(R.id.spinnerKSInsertionPlane);
        String stringInsertPlane = spinnerInsertPlane.getSelectedItem().toString();
        Spinner spinnerRelPos = (Spinner) findViewById(R.id.spinnerKSRelativePsn);
        String stringRelPos = spinnerRelPos.getSelectedItem().toString();
        String stringTargetDepth = KSTargetDepth.getText().toString();
        String stringOffset = KSTargetOffset.getText().toString();

        //Adjustments
        if (stringTargetDepth.matches("Enter Depth (cm)") || stringTargetDepth.matches("")) {
            KSTargetDepth.setText("0");
        }
        if (stringOffset.matches("Enter Depth (cm)") || stringOffset.matches("")) {
            KSTargetOffset.setText("0");
        }

        //Error Messages
        if (stringSelectedKey.matches("Select")) {
            new AlertDialog.Builder(this)
                    .setTitle("Missing Selection")
                    .setMessage("Please select the chosen fixed angle needle guide key from the drop down menu")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which){
                            //Do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

        } else if(stringInsertPlane.matches("Select")) {
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

    // *******************************************
    // FUNCTION TO GET FIXED ANGLE FROM CHOSEN KEY
    // *******************************************
    // Returns the angle of the selected needle guide IN RADS
    public double getAngleFromSelectedGuide(){
        Spinner spinnerSelectedKey = (Spinner) findViewById(R.id.spinnerKSSelectedKey);
        String stringLengthOffset = spinnerSelectedKey.getSelectedItem().toString();
        double Theta;
        switch (stringLengthOffset) {
            case "30 Degrees":
                Theta = 0.5235987756;
                break;
            case "45 Degrees":
                Theta = 0.7853981634;
                break;
            case "60 Degrees":
                Theta = 1.047197551;
                break;
            default:
                Theta = 0.5235987756;
        }
        return Theta;
    }

    // ********************************************
    // FUNCTION TO GET FIXED HORIZONTAL OFFSET DATA
    // ********************************************
    // Returns fixed horizontal offset data for the chosen plane
    public double getFixedHorizontalOffsetData(){
        Spinner spinnerInsertionPlane = (Spinner)findViewById(R.id.spinnerKSInsertionPlane);
        String stringInsertionPlane = spinnerInsertionPlane.getSelectedItem().toString();
        double FixedHorizontalOffset;
        switch(stringInsertionPlane){
            case "In Plane": FixedHorizontalOffset = 1.18258;
                break;
            case "Out of Plane": FixedHorizontalOffset = 1.06325;
                break;
            default: FixedHorizontalOffset = 0;
        }
        return FixedHorizontalOffset;
    }

    // ***********************************
    // FUNCTION TO GET AN OFFSET DIRECTOR
    // ***********************************
    // Returns a multiplier based on the selected direction of offset from centreline
    public int getOffsetDirection(){
        Spinner spinnerOffsetDirection = (Spinner)findViewById(R.id.spinnerKSRelativePsn);
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

    // ***************************************
    // FUNCTION TO GET AN NEEDLE LENGTH OFFSET
    // ***************************************
    // Returns a needle length offset for the chosen key
    // Also handles error if no key selected
    public double getFixedNeedleLengthOffsetData() {
        Spinner spinnerSelectedKey = (Spinner) findViewById(R.id.spinnerKSSelectedKey);
        String stringLengthOffset = spinnerSelectedKey.getSelectedItem().toString();
        double LengthOffset;
        switch (stringLengthOffset) {
            case "30 Degrees":
                LengthOffset = 1.574;
                break;
            case "45 Degrees":
                LengthOffset = 1.594;
                break;
            case "60 Degrees":
                LengthOffset = 1.633;
                break;
            default:
                LengthOffset = 0;
        }
        return LengthOffset;
    }

    // ***********************
    // VALUE CHECKING FUNCTION
    // ***********************
    // Check validity of output and clear if invalid
    public void valueCheck(double GuideOffset) {
        if (GuideOffset < -1){
            new AlertDialog.Builder(this)
                    .setTitle("Target out of Range")
                    .setMessage("The target cannot be reached using the selected needle guide key. \r\n\r\n" +
                            "Possible Solutions:\r\n" +
                            "(1) Use a key with a shallower (lower) angle \r\n" +
                            "(2) Use the probe 'In Plane' and shift the probe so that the target is on the left of the probe centreline'\r\n" +
                            "(3) Use an alternative guide product \r\n")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which){
                            outputKSGuideOffset.setText("Out of Range");
                            outputKSNeedleLength.setText("Out of Range");
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }else if (GuideOffset > 1) {
            new AlertDialog.Builder(this)
                    .setTitle("Target out of Range")
                    .setMessage("The target cannot be reached using the selected needle guide key. \r\n\r\n" +
                            "Possible Solutions:\r\n" +
                            "(1) Use a key with a steeper (larger) angle \r\n" +
                            "(2) Use the probe 'In Plane' and shift the probe so that the target is on the right of the probe centreline \r\n" +
                            "(3) Use an alternative guide product")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which){
                            outputKSGuideOffset.setText("Out of Range");
                            outputKSNeedleLength.setText("Out of Range");
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }

}

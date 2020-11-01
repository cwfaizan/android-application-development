package com.pf.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    RadioButton radioButtonMainActivityMale, radioButtonMainActivityFemale;
    RadioButton radioButtonMainActivityOther;
    RadioGroup radioGroupMainActivityGender;
    Button buttonMainActivityGetGenderUsingRadioButton, buttonMainActivityGetGenderUsingRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupMainActivityGender = findViewById(R.id.radioGroupMainActivityGender);
        buttonMainActivityGetGenderUsingRadioGroup = findViewById(R.id.buttonMainActivityGetGenderUsingRadioGroup);

        // Get Current State of RadioButton(s) Using-Radio-Group on Button onClick (Method 1)
        buttonMainActivityGetGenderUsingRadioGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String gender = "";
                switch (radioGroupMainActivityGender.getCheckedRadioButtonId())
                {
                    case R.id.radioButtonMainActivityMale:
                        // do your coding
                        gender = "Male";
                        break;
                    case R.id.radioButtonMainActivityFemale:
                        // do your coding
                        gender = "Female";
                        break;
                    case R.id.radioButtonMainActivityOther:
                        // do your coding
                        gender = "Other";
                        break;
                }
                Toast.makeText(MainActivity.this, "Gender is "+gender+" (Method 1)", Toast.LENGTH_SHORT).show();
            }
        });
        
        // Get Current State of RadioButton using-Radio-Group self onClick (Method 2)
        radioGroupMainActivityGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedRadioButtonId) {
                switch (checkedRadioButtonId)
                {
                    case R.id.radioButtonMainActivityFemale:
                        // do your coding
                        Toast.makeText(MainActivity.this, "Female is checked (using RadioGroup)", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        buttonMainActivityGetGenderUsingRadioButton = findViewById(R.id.buttonMainActivityGetGenderUsingRadioButton);
        radioButtonMainActivityMale = findViewById(R.id.radioButtonMainActivityMale);
        radioButtonMainActivityFemale = findViewById(R.id.radioButtonMainActivityFemale);
        radioButtonMainActivityOther = findViewById(R.id.radioButtonMainActivityOther);

        // Get Current State of RadioButton(s) Using-Radio-Button on Button onClick (Method 3)
        buttonMainActivityGetGenderUsingRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String gender = "";
                if(radioButtonMainActivityMale.isChecked()){
                    // do your coding
                    gender = "Male";
                }
                else if(radioButtonMainActivityFemale.isChecked()){
                    // do your coding
                    gender = "Female";
                }
                else if(radioButtonMainActivityOther.isChecked()){
                    // do your coding
                    gender = "Other";
                }
                Toast.makeText(MainActivity.this, "Gender is "+gender+" (Method 3)", Toast.LENGTH_SHORT).show();
            }
        });

        // Get Current State of RadioButton using RadioButton self onClick (Method 4)
        radioButtonMainActivityMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Male is checked (using RadioButton)", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Call Function onClick and Get Current State of RadioButton on RadioButton XML onClick (Method 5)
    public void radioButtonOnClickListenerMainActivity(@NotNull View view){
        switch (view.getId()){
            case R.id.radioButtonMainActivityOther:
                // do your coding
                Toast.makeText(MainActivity.this, "Other is checked (using Function)", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

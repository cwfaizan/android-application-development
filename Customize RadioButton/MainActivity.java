package com.pf.tutorial;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroupMainActivityGender;
    Button buttonMainActivitySubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupMainActivityGender = findViewById(R.id.radioGroupMainActivityGender);
        buttonMainActivitySubmit = findViewById(R.id.buttonMainActivitySubmit);

        /*radioGroupMainActivityGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int radioButtonId) {
                String gender = "";
                switch (radioButtonId)
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
                Toast.makeText(MainActivity.this, "Selected Gender is "+gender, Toast.LENGTH_SHORT).show();
            }
        });*/

        /*buttonMainActivitySubmit.setOnClickListener(new View.OnClickListener() {
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
                Toast.makeText(MainActivity.this, "Submit Gender is "+gender, Toast.LENGTH_SHORT).show();
            }
        });*/

        buttonMainActivitySubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioButtonId = radioGroupMainActivityGender.getCheckedRadioButtonId();
                RadioButton radioButtonSelected = findViewById(radioButtonId);
                String gender = radioButtonSelected.getText().toString();
                Toast.makeText(MainActivity.this, "Submitted Gender is "+gender, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void radioButtonOnClickListener(View view){
        String gender = "";
        switch (view.getId())
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
        Toast.makeText(MainActivity.this, "Selected Gender is "+gender, Toast.LENGTH_SHORT).show();
    }
}

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
    Button buttonMainActivityGetGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButtonMainActivityMale = findViewById(R.id.radioButtonMainActivityMale);
        radioButtonMainActivityFemale = findViewById(R.id.radioButtonMainActivityFemale);
        radioButtonMainActivityOther = findViewById(R.id.radioButtonMainActivityOther);

        radioGroupMainActivityGender = findViewById(R.id.radioGroupMainActivityGender);
        buttonMainActivityGetGender = findViewById(R.id.buttonMainActivityGetGender);

        // Get State of RadioButton(s) on Button onClick
        buttonMainActivityGetGender.setOnClickListener(new View.OnClickListener() {
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
                Toast.makeText(MainActivity.this, "Gender is "+gender, Toast.LENGTH_SHORT).show();
            }
        });

        // Get State of RadioButton on RadioButton itself onClick (Method 1)
        radioButtonMainActivityMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Male is checked (using RadioButton)", Toast.LENGTH_SHORT).show();
            }
        });
        
        // Get State of RadioButton on RadioGroup onClick (Method 2)
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
        
    }

    // Call Function onClick and Get State of RadioButton on RadioButton XML onClick (Method 3)
    public void radioButtonOnClickListenerMainActivity(@NotNull View view){
        switch (view.getId())
        {
            case R.id.radioButtonMainActivityOther:
                // do your coding
                Toast.makeText(MainActivity.this, "Other is checked (using Function)", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

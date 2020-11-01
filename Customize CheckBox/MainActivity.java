package com.pf.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBoxMainActivityJava, checkBoxMainActivityPython;
    CheckBox checkBoxMainActivityPHP, checkBoxMainActivityCSharp;
    Button buttonMainActivityGetSkills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxMainActivityJava = findViewById(R.id.checkBoxMainActivityJava);
        checkBoxMainActivityPython = findViewById(R.id.checkBoxMainActivityPython);
        checkBoxMainActivityPHP = findViewById(R.id.checkBoxMainActivityPHP);
        checkBoxMainActivityCSharp = findViewById(R.id.checkBoxMainActivityCSharp);
        buttonMainActivityGetSkills = findViewById(R.id.buttonMainActivityGetSkills);

        // Get State(s) of CheckBox(es) on Button onClick
        buttonMainActivityGetSkills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String checked = "";
                if( checkBoxMainActivityJava.isChecked() ) {
                    // do your coding
                    checked += "Java";
                }
                if( checkBoxMainActivityPython.isChecked() ) {
                    // do your coding
                    checked += ", Python";
                }
                if( checkBoxMainActivityPHP.isChecked() ) {
                    // do your coding
                    checked += ", PHP";
                }
                if( checkBoxMainActivityCSharp.isChecked() ) {
                    // do your coding
                    checked += ", C#";
                }
                Toast.makeText(MainActivity.this, checked+" checked", Toast.LENGTH_SHORT).show();
            }
        });

        // Get State of CheckBox on CheckBox itself onClick (Method 1)
        checkBoxMainActivityJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean checked = ((CheckBox) view).isChecked();
                if (checked){
                    // Do your coding
                    Toast.makeText(MainActivity.this, "Java checked", Toast.LENGTH_SHORT).show();
                }
                else{
                    // Do your coding
                    Toast.makeText(MainActivity.this, "Java unchecked", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    // Call Function onClick and Get State of CheckBox on CheckBox itself onClick (Method 2)
    public void checkBoxOnClickListenerMainActivity(@NotNull View view)
    {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.checkBoxMainActivityJava:
                // Do your coding
                Toast.makeText(MainActivity.this, "Java checked "+checked, Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxMainActivityPython:
                // Do your coding
                Toast.makeText(MainActivity.this, "Python checked "+checked, Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxMainActivityPHP:
                // Do your coding
                Toast.makeText(MainActivity.this, "PHP checked "+checked, Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBoxMainActivityCSharp:
                // Do your coding
                Toast.makeText(MainActivity.this, "C# checked "+checked, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

package com.pf.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pf.tutorial.R;

public class TestActivity extends AppCompatActivity {

    Button buttonTestActivityClickMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        buttonTestActivityClickMe = findViewById(R.id.buttonTestActivityClickMe);

        buttonTestActivityClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // put your code here
                Toast.makeText(TestActivity.this, "Hello Programming with Faizan", Toast.LENGTH_LONG).show();
            }
        });
    }
}

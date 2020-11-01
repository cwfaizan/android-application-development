package com.pf.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.pf.tutorial.R;

public class TestActivity extends AppCompatActivity {

    TextView textViewTestActivityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        textViewTestActivityName = findViewById(R.id.textViewTestActivityName);
        textViewTestActivityName.setText("Welcome to Programming with Faizan");
    }
}

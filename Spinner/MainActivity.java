package com.pf.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerMainActivityCity;
    Button buttonMainActivityGetCity;
    ArrayList<String> arrayListCity = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerMainActivityCity = findViewById(R.id.spinnerMainActivityCity);
        buttonMainActivityGetCity = findViewById(R.id.buttonMainActivityGetCity);

        ArrayAdapter<String> adapterCity = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayListCity);
        adapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMainActivityCity.setAdapter(adapterCity);

        buttonMainActivityGetCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedCity = spinnerMainActivityCity.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, "Selected City is "+selectedCity, Toast.LENGTH_LONG).show();
            }
        });

        spinnerMainActivityCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedCity = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Selected City is "+selectedCity, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        arrayListCity.addAll( Arrays.asList("Islamabad", "Rawalpindi", "Lahore", "Karachi", "Multan", "DG Khan") );
        adapterCity.notifyDataSetChanged();
    }
}

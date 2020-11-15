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

    private Button buttonSubmit;
    private Spinner spinnerCity, spinnerCountry;
    private ArrayList<String> arrayListCity = new ArrayList<>();
    private ArrayList<Country> arrayListCountry = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCity = findViewById(R.id.spinnerMainActivityCity);
        spinnerCountry = findViewById(R.id.spinnerMainActivityCountry);
        buttonSubmit = findViewById(R.id.buttonMainActivitySubmit);

        citySpinnerHandling();
        /* Pass Country Object with Country Id or Country Code to Spinner */
        countrySpinnerHandling();
        formSubmissionHandling();
    }

    private void citySpinnerHandling(){
        ArrayAdapter<String> arrayAdapterCity = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, arrayListCity);
        arrayAdapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(arrayAdapterCity);

        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedCity = adapterView.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, selectedCity, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Fill data and notify Adapter
        arrayListCity.addAll( Arrays.asList("Islamabad", "Rawalpindi", "Lahore", "Karachi", "Multan", "DG Khan") );
        arrayAdapterCity.notifyDataSetChanged();
    }

    private void countrySpinnerHandling(){
        ArrayAdapter<Country> arrayAdapterCountry = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, arrayListCountry);
        arrayAdapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(arrayAdapterCountry);

        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Country country = (Country) adapterView.getSelectedItem();
                Toast.makeText(MainActivity.this, country.getName()+" "+country.getCode(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Fill data and notify Adapter
        Country countryPakistan = new Country(92, "Pakistan");
        arrayListCountry.add(countryPakistan);
        arrayListCountry.add(new Country(1, "USA"));
        arrayListCountry.add(new Country(91, "India"));
        arrayAdapterCountry.notifyDataSetChanged();
    }

    private void formSubmissionHandling(){
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedCity = spinnerCity.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, "Selected City is "+selectedCity, Toast.LENGTH_LONG).show();
                Country selectedCountry = (Country) spinnerCountry.getSelectedItem();
                Toast.makeText(MainActivity.this, "Selected Country is "+selectedCountry.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }
}

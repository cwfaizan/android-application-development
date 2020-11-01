package com.pf.tutorial;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.pf.tutorial.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextViewMainActivityCountry;
    Button buttonMainActivitySubmitACTV;

    ArrayList<String> arrayListCountrySuggestion = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextViewMainActivityCountry = findViewById(R.id.autoCompleteTextViewMainActivityCountry);
        buttonMainActivitySubmitACTV = findViewById(R.id.buttonMainActivitySubmitACTV);

        autoCompleteTextViewMainActivityCountry.setThreshold(1);
        ArrayAdapter<String> adapterACTV = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, arrayListCountrySuggestion);
        autoCompleteTextViewMainActivityCountry.setAdapter(adapterACTV);

        autoCompleteTextViewMainActivityCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Selected Country is : " + adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });

        buttonMainActivitySubmitACTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String country = autoCompleteTextViewMainActivityCountry.getText().toString();
                Toast.makeText(MainActivity.this, "Country: " + country, Toast.LENGTH_SHORT).show();
            }
        });

        // countries list have been changed and notify the adapterACTV
        arrayListCountrySuggestion.addAll( Arrays.asList("Pakistan", "USA", "Australia", "UK", "Italy", "Ireland", "Africa") );
        adapterACTV.notifyDataSetChanged();
    }
}

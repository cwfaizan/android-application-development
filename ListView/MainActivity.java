package com.pf.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView listViewMainActivityCountry;
    ArrayList<String> arrayListCountry = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewMainActivityCountry = findViewById(R.id.listViewMainActivityCountry);

        ArrayAdapter<String> adapterCountry = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, arrayListCountry);
        listViewMainActivityCountry.setAdapter(adapterCountry);

        listViewMainActivityCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedCountry = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Selected Country is "+selectedCountry, Toast.LENGTH_LONG).show();
            }
        });

        listViewMainActivityCountry.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedCountry = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Long Selected Country is "+selectedCountry, Toast.LENGTH_LONG).show();
                return true;
            }
        });

        arrayListCountry.addAll( Arrays.asList("Pakistan", "India", "China", "UK", "USA", "Russia") );
        adapterCountry.notifyDataSetChanged();
    }
}

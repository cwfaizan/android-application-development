package com.pf.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextMainActivityFirstNumber, editTextMainActivitySecondNumber;

    ImageView imageViewMainActivityOdd;
    TextView textViewMainActivityOdd;
    ListView listViewMainActivityOdd;
    ArrayList<Integer> arrayListOdd = new ArrayList();

    ImageButton imageButtonMainActivityEven;
    TextView textViewMainActivityEven;
    ListView listViewMainActivityEven;
    ArrayList<Integer> arrayListEven = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMainActivityFirstNumber = findViewById(R.id.editTextMainActivityFirstNumber);
        editTextMainActivitySecondNumber = findViewById(R.id.editTextMainActivitySecondNumber);

        textViewMainActivityOdd = findViewById(R.id.textViewMainActivityOdd);
        listViewMainActivityOdd = findViewById(R.id.listViewMainActivityOdd);
        imageViewMainActivityOdd = findViewById(R.id.imageViewMainActivityOdd);

        ArrayAdapter<Integer> adapterOdd = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, arrayListOdd);
        listViewMainActivityOdd.setAdapter(adapterOdd);

        imageViewMainActivityOdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int firstNumber = Integer.valueOf( editTextMainActivityFirstNumber.getText().toString() );
                int secondNumber = Integer.valueOf( editTextMainActivitySecondNumber.getText().toString() );

                arrayListOdd.clear();
                int countOdd = 0;
                for (int i=firstNumber; i<=secondNumber; i=i+1){
                    if(i%2!=0){
                        countOdd++;
                        arrayListOdd.add(i);
                    }
                }
                textViewMainActivityOdd.setText( String.valueOf(countOdd) );
                adapterOdd.notifyDataSetChanged();
            }
        });



        textViewMainActivityEven = findViewById(R.id.textViewMainActivityEven);
        listViewMainActivityEven = findViewById(R.id.listViewMainActivityEven);
        imageButtonMainActivityEven = findViewById(R.id.imageButtonMainActivityEven);

        ArrayAdapter<Integer> adapterEven = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, arrayListEven);
        listViewMainActivityEven.setAdapter(adapterEven);

        imageButtonMainActivityEven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int firstNumber = Integer.valueOf( editTextMainActivityFirstNumber.getText().toString() );
                int secondNumber = Integer.valueOf( editTextMainActivitySecondNumber.getText().toString() );

                arrayListEven.clear();
                int countEven = 0;
                for(int i=firstNumber; i<=secondNumber; i=i+1){
                    if(i%2==0){
                        countEven++;
                        arrayListEven.add(i);
                    }
                }
                textViewMainActivityEven.setText( String.valueOf(countEven) );
                adapterEven.notifyDataSetChanged();
            }
        });
    }
}

package com.pf.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.pf.tutorial.R;

public class TestActivity extends AppCompatActivity {

    EditText editTextTestActivityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        
        editTextTestActivityName = findViewById(R.id.editTextTestActivityName);
        
        // get Input as a Text from EditText Control
        /* String name = editTextTestActivityName.getText().toString(); */
        
        // Automatically call this method, when user type input in EditText
        editTextTestActivityName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                // You can do your logic after change
                if(charSequence.length() != 0)
                {
                    Toast.makeText(TestActivity.this, charSequence.toString(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                
            }
        });
        
    }
}

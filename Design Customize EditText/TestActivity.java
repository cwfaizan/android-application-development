import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.pf.firstproject.R;

public class TestActivity extends AppCompatActivity {

    EditText editTextTestActivityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
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

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // You can put your logic here after the change
            }
        });
        
    }
}

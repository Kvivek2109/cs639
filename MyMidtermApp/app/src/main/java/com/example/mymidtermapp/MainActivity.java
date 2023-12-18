package com.example.mymidtermapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText literEditText;
    TextView showTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        literEditText = findViewById(R.id.editTextNumber);
        showTextView = findViewById(R.id.textView_gallons);

        findViewById(R.id.convert_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                literToGallons(view);
            }
        });
    }

    private void literToGallons(View view) {
        String literString = literEditText.getText().toString();
        Integer ltr = Integer.parseInt(literString);
        Double gallons = 0.219*ltr;
        showTextView.setText(ltr+" liters equals "+gallons+" gallons.");
    }
}
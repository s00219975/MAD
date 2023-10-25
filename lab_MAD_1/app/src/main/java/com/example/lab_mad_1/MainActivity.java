package com.example.lab_mad_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button buttonClick;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        buttonClick = findViewById(R.id.buttonClick);
        textViewResult = findViewById(R.id.textViewResult);

        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get text from EditText
                String name = editText.getText().toString();

                // Display the text in the TextView
                String greeting = "Hi " + name;
                textViewResult.setText(greeting);
                textViewResult.setVisibility(View.VISIBLE); // Show the TextView
            }
        });
    }
}
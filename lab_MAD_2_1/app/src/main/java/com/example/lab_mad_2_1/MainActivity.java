package com.example.lab_mad_2_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText TextWeight;
    private EditText TextHeight;
    private Button buttonCalc;
    private Button buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextWeight = findViewById(R.id.editTextWeight);
        TextHeight = findViewById(R.id.editTextHeight);
        buttonCalc = findViewById(R.id.buttonCalc);
        buttonReset = findViewById(R.id.buttonReset);

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    // Reset the entered text
                    TextWeight.setText("");
                    TextHeight.setText("");
            }
        });

        buttonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int height = Integer.parseInt(TextHeight.getText().toString());
                int weight = Integer.parseInt(TextWeight.getText().toString());

                // Check if height and weight are within the valid range
                if (height < 80 || height > 300 || weight < 20 || weight > 200) {
                    // Handle invalid input values
                    Toast.makeText(MainActivity.this, "Height should be between 80-300cm, weight between 20-200kg.", Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    // Create an Intent to open the second activity
                    Intent intentSecond = new Intent(v.getContext(), lab_MAD_2_secondPage.class);

                    // Get text from editTextWeight and editTextHeight
                    height = Integer.parseInt(TextHeight.getText().toString());
                    weight = Integer.parseInt(TextWeight.getText().toString());

                    // Put the two integer variables into the Intent
                    intentSecond.putExtra("hght", height);
                    intentSecond.putExtra("wght", weight);

                    // Start the second activity
                    startActivity(intentSecond);
                }
            }
        });
    }
}
package com.example.lab_mad_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



public class MainActivity2 extends AppCompatActivity {

    private int seconds;
    private int stepCount;
    private TextView tvCurrentDate, tvRange, tvCalories, tvTimeTaken;
    private Button buttonReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Get today's date
        Date today = new Date();

        // Format the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String formattedDate = dateFormat.format(today);

        // Retrieve values from the Intent
        Intent intent1 = getIntent();
        seconds = intent1.getIntExtra("seconds", 0);
        stepCount = intent1.getIntExtra("stepCount", 0);

        // Initialize your UI elements
        tvCurrentDate = findViewById(R.id.tvCurrentDate);
        tvRange = findViewById(R.id.tvRange);
        tvCalories = findViewById(R.id.tvCalories);
        tvTimeTaken = findViewById(R.id.tvTimeTaken);
        buttonReturn = findViewById(R.id.buttonReturn);

        // Update UI with transferred value
        tvCurrentDate.setText("Date: " + formattedDate);
        tvRange.setText(String.valueOf("Metres: " + stepCount * 0.8));
        tvCalories.setText("Calories burned: " + stepCount * 0.04);
        tvTimeTaken.setText("Time: " + seconds + " seconds");

        // Start or resume your timers
        //timerHandler.post(timerRunnableTime);
        //timerHandler.post(timerRunnableSteps);

        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the new activity
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                // Start the new activity
                startActivity(intent);
                finish();

            }
        });
    }
}
package com.example.lab_mad_2_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class lab_MAD_2_secondPage extends AppCompatActivity {

    private Button buttonClose;
    private ProgressBar bmiProgressBar;
    private TextView bmiCategoryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_mad2_second_page);

        buttonClose = findViewById(R.id.buttonClose);

        // Get the Intent that started this activity
        Intent intent = getIntent();

        // Retrieve the integer variables from the Intent
        int height = intent.getIntExtra("hght", 0);
        int weight = intent.getIntExtra("wght", 0);

        // Display the values in TextViews or use them as needed
        TextView textViewHeight = findViewById(R.id.textViewHeight);
        TextView textViewWeight = findViewById(R.id.textViewWeight);
        textViewHeight.setText("Your height: " + height + " cm");
        textViewWeight.setText("Your weight: " + weight + " kg");

        TextView textViewResult = findViewById(R.id.textViewResult);
        float heightInMeters = (float) height / 100;
        float bmi = weight / (heightInMeters * heightInMeters);
        textViewResult.setText("Your BMI is: " + bmi);
        bmiProgressBar = findViewById(R.id.bmiProgressBar);
        bmiCategoryTextView = findViewById(R.id.bmiCategoryTextView);


        int bmiProgress = (int) bmi;

        // Determine the BMI category
        String category;
        if (bmiProgress < 18.5) {
            bmiProgressBar.setProgress(15); // Set ProgressBar to 0 for underweight
            bmiCategoryTextView.setText("Category: Underweight");
        } else if (bmiProgress >= 18.5 && bmiProgress <= 24.9) {
            bmiCategoryTextView.setText("Category: Healthy Weight");
            bmiProgressBar.setProgress(50); // Set ProgressBar to 50 for healthy weight
        } else if (bmiProgress >= 25) {
            bmiProgressBar.setProgress(85); // Set ProgressBar to 100 for overweight
            bmiCategoryTextView.setText("Category: Overweight");
        }



            buttonClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Create an Intent to start the new activity
                    Intent intent = new Intent(v.getContext(), MainActivity.class);

                    // Start the new activity
                    startActivity(intent);

                    // Finish the current activity if you want to prevent going back to it
                    finish();
                }
            });
        }
    }
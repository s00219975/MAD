package com.example.lab_mad_1_3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private Button buttonMultiply;
    private Button buttonAdd;
    private TextView textViewAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        textViewAnswer = findViewById(R.id.textViewAnswer);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    // Get text from EditText1 and EditText2
                    // Convert the String to an int
                    int number1 = Integer.parseInt(editText1.getText().toString());
                    int number2 = Integer.parseInt(editText2.getText().toString());

                    int answer = number1 + number2;

                    // Display the text in the TextView
                    textViewAnswer.setText(String.valueOf(answer)); // Display the answer in the TextView
                    textViewAnswer.setVisibility(View.VISIBLE); // Show the TextView
                } catch (NumberFormatException e) {}


            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Get text from EditText1 and EditText2
                    // Convert the String to an int
                    int number1 = Integer.parseInt(editText1.getText().toString());
                    int number2 = Integer.parseInt(editText2.getText().toString());

                    int answer = number1 * number2;

                    // Display the text in the TextView
                    textViewAnswer.setText(String.valueOf(answer)); // Display the answer in the TextView
                    textViewAnswer.setVisibility(View.VISIBLE); // Show the TextView
                } catch (NumberFormatException e) {}
            }
        });
    }
}
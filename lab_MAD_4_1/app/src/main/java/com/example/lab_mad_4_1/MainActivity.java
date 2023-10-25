package com.example.lab_mad_4_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerBand1, spinnerBand2, spinnerBand3;
    Button btnCalculate, btnReset;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerBand1 = findViewById(R.id.spinnerBand);
        spinnerBand2 = findViewById(R.id.spinnerBand2);
        spinnerBand3 = findViewById(R.id.spinnerBand3);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnReset = findViewById(R.id.btnReset);
        tvResult = findViewById(R.id.tvResult);

        String[] spinnerItems = {"Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Gray", "White", "Gold", "Silver"};

        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(this, R.layout.custom_spinner_item, spinnerItems);

        spinnerBand1.setAdapter(adapter);
        spinnerBand2.setAdapter(adapter);
        spinnerBand3.setAdapter(adapter);

        // Calculate button click event
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Calculate resistance and display the result
                calculateResistance();
            }
        });

        // Reset button click event
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reset the spinners and result
                spinnerBand1.setSelection(0);
                spinnerBand2.setSelection(0);
                spinnerBand3.setSelection(0);
                tvResult.setText("");
            }
        });
    }

    private void calculateResistance() {
        // Implement the resistance calculation logic based on the selected colors.
        // You would need to define the color-to-resistance mapping and tolerance here.

        // For this example, we'll just show a placeholder result.
        String resistance = "1000 Ω ±5%";
        tvResult.setText(resistance);
    }
}
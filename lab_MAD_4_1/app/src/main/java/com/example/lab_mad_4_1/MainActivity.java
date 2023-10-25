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

    Spinner spinnerBand1, spinnerBand2, spinnerBand3, spinnerBand4;
    Button btnCalculate, btnReset;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerBand1 = findViewById(R.id.spinnerBand);
        spinnerBand2 = findViewById(R.id.spinnerBand2);
        spinnerBand3 = findViewById(R.id.spinnerBand3);
        spinnerBand4 = findViewById(R.id.spinnerBand4);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnReset = findViewById(R.id.btnReset);
        tvResult = findViewById(R.id.tvResult);

        String[] spinnerItemsLong = {"None", "Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Gray", "White", "Gold", "Silver"};
        String[] spinnerItemsShort = {"None", "Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Gray", "White"};


        CustomSpinnerAdapter adapterLong = new CustomSpinnerAdapter(this, spinnerItemsLong);
        CustomSpinnerAdapter adapterShort = new CustomSpinnerAdapter(this, spinnerItemsShort);

        spinnerBand1.setAdapter(adapterShort);
        spinnerBand2.setAdapter(adapterShort);
        spinnerBand3.setAdapter(adapterLong);
        spinnerBand4.setAdapter(adapterLong);

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
                spinnerBand4.setSelection(0);
                tvResult.setText("");
            }
        });
    }

    private void calculateResistance() {

        float resistanceValue = 0;
        float multiplier = 0;
        String tolerance = "";

        

        switch (spinnerBand1.getSelectedItem().toString()) {
            case "Black":
                resistanceValue = 0;
                break;
            case "Brown":
                resistanceValue = 1;
                break;
            case "Red":
                resistanceValue = 2;
                break;
            case "Orange":
                resistanceValue = 3;
                break;
            case "Yellow":
                resistanceValue = 4;
                break;
            case "Green":
                resistanceValue = 5;
                break;
            case "Blue":
                resistanceValue = 6;
                break;
            case "Violet":
                resistanceValue = 7;
                break;
            case "Gray":
                resistanceValue = 8;
                break;
            case "White":
                resistanceValue = 9;
                break;
        }

        resistanceValue *= 10;

        switch (spinnerBand2.getSelectedItem().toString()) {
            case "Black":
                resistanceValue += 0;
                break;
            case "Brown":
                resistanceValue += 1;
                break;
            case "Red":
                resistanceValue += 2;
                break;
            case "Orange":
                resistanceValue += 3;
                break;
            case "Yellow":
                resistanceValue += 4;
                break;
            case "Green":
                resistanceValue += 5;
                break;
            case "Blue":
                resistanceValue += 6;
                break;
            case "Violet":
                resistanceValue += 7;
                break;
            case "Gray":
                resistanceValue += 8;
                break;
            case "White":
                resistanceValue += 9;
                break;
        }

        switch (spinnerBand3.getSelectedItem().toString()) {
            case "Black":
                multiplier = 1;
                break;
            case "Brown":
                multiplier = 10;
                break;
            case "Red":
                multiplier = 100;
                break;
            case "Orange":
                multiplier = 1000;
                break;
            case "Yellow":
                multiplier = 10000;
                break;
            case "Green":
                multiplier = 100000;
                break;
            case "Blue":
                multiplier = 1000000;
                break;
            case "Violet":
                multiplier = 10000000;
                break;
            case "Gray":
                multiplier = 100000000;
                break;
            case "White":
                multiplier = 1000000000;
                break;
            case "Gold":
                multiplier = 0.1f;
                break;
            case "Silver":
                multiplier = 0.01f;
                break;
        }

        switch (spinnerBand4.getSelectedItem().toString()) {
            case "Black":
            case "Yellow":
            case "Orange":
            case "White":
                tolerance = "";
                break;
            case "Brown":
                tolerance = "±1%";
                break;
            case "Red":
                tolerance = "±2%";
                break;
            case "Green":
                tolerance = "±0.5%";
                break;
            case "Blue":
                tolerance = "±0.25%";
                break;
            case "Violet":
                tolerance = "±0.1%";
                break;
            case "Gray":
                tolerance = "±0.05%";
                break;
            case "Gold":
                tolerance = "±5%";
                break;
            case "Silver":
                tolerance = "±10%";
                break;
            case "None":
                tolerance = "±20%";
                break;
        }

        // Calculate resistance
        float resistanceOhms = resistanceValue * multiplier;
        String result = String.format("%.0f Ω %s", resistanceOhms, tolerance);

        tvResult.setText(result);
    }
}
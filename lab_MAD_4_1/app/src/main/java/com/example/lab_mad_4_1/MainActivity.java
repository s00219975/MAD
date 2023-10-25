package com.example.lab_mad_4_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        StringBuilder multiplier = new StringBuilder("1");
        String tolerance = "";

        List<String> colors = new ArrayList<String>() {{
            add("Black");
            add("Brown");
            add("Red");
            add("Orange");
            add("Yellow");
            add("Green");
            add("Blue");
            add("Violet");
            add("Gray");
            add("White");
            add("Gold");
            add("Silver");
        }};

        HashMap<String, Integer> basicColours = new HashMap<>();

        for (int i = 0; i < colors.size(); i++) {
            basicColours.put(colors.get(i), i);
        }

        resistanceValue = basicColours.get(spinnerBand1.getSelectedItem().toString()) * 10;
        resistanceValue += basicColours.get(spinnerBand2.getSelectedItem().toString());

        for (int i = 0; i < basicColours.get(spinnerBand3.getSelectedItem().toString()); i++) {
            multiplier.append("0");
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
        float resistanceOhms = resistanceValue * Integer.parseInt(String.valueOf(multiplier));
        String result = String.format("%.0f Ω %s", resistanceOhms, tolerance);

        tvResult.setText(result);
    }
}
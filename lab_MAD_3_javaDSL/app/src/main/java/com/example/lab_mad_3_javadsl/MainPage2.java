package com.example.lab_mad_3_javadsl;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainPage2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page2);

        Button buttonBalance = findViewById(R.id.buttonBalance);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);

        PieChart pieChart = findViewById(R.id.pieChart);

        // Create a list of PieEntries
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(40.0f, "Housing"));
        entries.add(new PieEntry(10.0f, "Food & Drink"));
        entries.add(new PieEntry(20.0f, "Shopping"));
        entries.add(new PieEntry(30.0f, "Education"));

        // Create a dataset
        PieDataSet dataSet = new PieDataSet(entries, "");

        // Define the custom colors using Color.parseColor
        int[] customColors = new int[] {
                Color.parseColor("#F9A085"),
                Color.parseColor("#B875E5"),
                Color.parseColor("#8EECB9"),
                Color.parseColor("#D46695"),
        };

        // Set the custom colors for the pie chart
        dataSet.setColors(customColors);
        dataSet.setValueTextSize(26f); // Set the value text size to 24
        // Set the value formatter to display integers (no decimal points)
        dataSet.setValueFormatter(new PercentValueFormatter());

        // Create a PieData object
        PieData data = new PieData(dataSet);

        // Set data and some chart properties
        pieChart.setData(data);
        pieChart.setUsePercentValues(true);
        pieChart.setHoleRadius(60f); // Hole in the center
        pieChart.setTransparentCircleRadius(40f); // Transparent circle around the hole
        pieChart.getDescription().setEnabled(false); // Disable description label

        // Customize text font size
        pieChart.setEntryLabelTypeface(Typeface.DEFAULT_BOLD);
        pieChart.setEntryLabelTextSize(18f);
        pieChart.setEntryLabelColor(Color.BLACK);

        // Disable the chart's legend
        Legend legend = pieChart.getLegend();
        legend.setEnabled(false);

        // Update the chart
        pieChart.invalidate();

        buttonBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to open the second activity
                Intent intentSecond = new Intent(v.getContext(), MainActivity.class);
                // Start the second activity
                startActivity(intentSecond);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to open the second activity
                Intent intentSecond = new Intent(v.getContext(), MainActivity.class);
                // Start the second activity
                startActivity(intentSecond);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to open the second activity
                Intent intentSecond = new Intent(v.getContext(), MainActivity.class);
                // Start the second activity
                startActivity(intentSecond);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to open the second activity
                Intent intentSecond = new Intent(v.getContext(), MainActivity.class);
                // Start the second activity
                startActivity(intentSecond);
            }
        });
    }
}
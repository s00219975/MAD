package com.example.lab_mad_3_javadsl;

import com.github.mikephil.charting.formatter.ValueFormatter;

public class PercentValueFormatter extends ValueFormatter {
    @Override
    public String getFormattedValue(float value) {
        // Format the value as an integer
        return String.valueOf((int) value) + "%";
    }
}

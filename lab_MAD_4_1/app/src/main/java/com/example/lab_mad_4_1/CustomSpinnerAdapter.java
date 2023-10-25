package com.example.lab_mad_4_1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomSpinnerAdapter extends ArrayAdapter<String> {
    private Context context; // Store the context for resource access

    public CustomSpinnerAdapter(Context context, int resource, String[] items) {
        super(context, resource, items);
        this.context = context; // Initialize the context
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        TextView textView = view.findViewById(android.R.id.text1);
        String itemText = getItem(position);
        if (itemText != null) {
            switch (itemText) {
                case "Black":
                    view.setBackgroundResource(R.color.black);
                    textView.setTextColor(context.getResources().getColor(R.color.white));
                    break;
                case "Brown":
                    view.setBackgroundResource(R.color.brown);
                    textView.setTextColor(context.getResources().getColor(R.color.white));
                    break;
                case "Red":
                    view.setBackgroundResource(R.color.red);
                    textView.setTextColor(context.getResources().getColor(R.color.white));
                    break;
                case "Orange":
                    view.setBackgroundResource(R.color.orange);
                    textView.setTextColor(context.getResources().getColor(R.color.white));
                    break;
                case "Yellow":
                    view.setBackgroundResource(R.color.yellow);
                    textView.setTextColor(context.getResources().getColor(R.color.black));
                    break;
                case "Green":
                    view.setBackgroundResource(R.color.orange);
                    textView.setTextColor(context.getResources().getColor(R.color.white));
                    break;
                case "Blue":
                    view.setBackgroundResource(R.color.blue);
                    textView.setTextColor(context.getResources().getColor(R.color.white));
                    break;
                case "Violet":
                    view.setBackgroundResource(R.color.violet);
                    textView.setTextColor(context.getResources().getColor(R.color.white));
                    break;
            }
        }
        return view;
    }
}




package com.example.lab_mad_3_javadsl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonHip;
    private Button buttonRock;
    private Button buttonSamba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonHip = findViewById(R.id.buttonHip);
        buttonRock = findViewById(R.id.buttonRock);
        buttonSamba = findViewById(R.id.buttonSamba);

        buttonHip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle invalid input values
                Toast.makeText(MainActivity.this, "You chose Hip Hop", Toast.LENGTH_LONG).show();

                // Create an Intent to open the second activity
                Intent intentSecond = new Intent(v.getContext(), MainPage2.class);
                // Start the second activity
                startActivity(intentSecond);
            }
        });

        buttonRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle invalid input values
                Toast.makeText(MainActivity.this, "You chose Rock 'n' Roll", Toast.LENGTH_LONG).show();

                // Create an Intent to open the second activity
                Intent intentSecond = new Intent(v.getContext(), MainPage2.class);
                // Start the second activity
                startActivity(intentSecond);
            }
        });

        buttonSamba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle invalid input values
                Toast.makeText(MainActivity.this, "You chose Samba", Toast.LENGTH_LONG).show();

                // Create an Intent to open the second activity
                Intent intentSecond = new Intent(v.getContext(), MainPage2.class);
                // Start the second activity
                startActivity(intentSecond);
            }
        });
    }
}
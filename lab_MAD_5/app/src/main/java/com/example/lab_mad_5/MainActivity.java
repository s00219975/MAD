package com.example.lab_mad_5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvStepsCount, tvTimerCount;
    private Button btnStart, btnStop, btnReset, btnShowRun;
    private int seconds = 0;
    private boolean isRunning = false;
    private boolean isCounting = false;
    private int stepCount = 0;
    private Handler timerHandler = new Handler();

    Intent intent1;



    private Runnable timerRunnableTime = new Runnable() {
        @Override
        public void run() {
            if (isRunning) {
                seconds++;
                tvTimerCount.setText(String.valueOf(seconds));
            }
            timerHandler.postDelayed(this, 1000);
        }
    };

    private Runnable timerRunnableSteps = new Runnable() {
        @Override
        public void run() {
            if (isCounting) {
                stepCount++;
                tvStepsCount.setText(String.valueOf(stepCount));
            }
            timerHandler.postDelayed(this, 750);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStepsCount = findViewById(R.id.tvStepsCount);
        tvTimerCount = findViewById(R.id.tvTimerCount);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnReset = findViewById(R.id.btnReset);
        btnShowRun = findViewById(R.id.btnShowRun);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRunning) {
                    btnStop.setEnabled(true);
                    btnReset.setEnabled(true);
                    isRunning = true;
                    isCounting = true;
                    timerHandler.removeCallbacks(timerRunnableTime); // Stop the previous timer runnable
                    timerHandler.postDelayed(timerRunnableTime, 0); // Start a new timer runnable
                    timerHandler.removeCallbacks(timerRunnableSteps); // Stop the previous timer runnable
                    timerHandler.postDelayed(timerRunnableSteps, 0); // Start a new timer runnable
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnShowRun.setEnabled(true);
                isRunning = false;
                isCounting = false;
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStop.setEnabled(false);
                btnReset.setEnabled(false);
                isRunning = false;
                isCounting = false;
                seconds = 0;
                stepCount = 0;
                tvStepsCount.setText(String.valueOf(stepCount));
                tvTimerCount.setText(String.valueOf(seconds));
            }
        });

        btnShowRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent1 = new Intent(MainActivity.this, MainActivity2.class);
                intent1.putExtra("seconds", seconds);
                intent1.putExtra("stepCount", stepCount);
                startActivity(intent1);
            }
        });
    }
}

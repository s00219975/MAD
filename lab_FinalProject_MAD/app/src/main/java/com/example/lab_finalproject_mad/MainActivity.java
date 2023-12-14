package com.example.lab_finalproject_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Button> allButtons;
    private List<Button> sequenceButtons;
    private Button currentButton;
    private TextView tvScore;
    Button btnRed, btnBlue, btnGreen, btnYellow, btnPlay;
    private Handler handler;
    private int sequenceIndex;
    private boolean isBlinking;

    int roundNumber = 0, score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        tvScore = findViewById(R.id.tvScore);

        score = getIntent().getIntExtra("score", 0);
        // Update the TextView with the new score
        tvScore.setText("Score: " + score);

        // Retrieve roundNumber from the Intent
        roundNumber = getIntent().getIntExtra("roundNumber", 0);
        int roundActual = roundNumber + 1;
        Toast.makeText(MainActivity.this, "Ready? Round " + roundActual, Toast.LENGTH_SHORT).show();

        // Use CountDownTimer to introduce a delay
        new CountDownTimer(3000, 1000) {


            @Override
            public void onTick(long millisUntilFinished) {
                // Code to be executed on each tick (not necessary for a delay)
            }

            @Override
            public void onFinish() {
                btnRed = findViewById(R.id.buttonRed);
                btnBlue = findViewById(R.id.buttonBlue);
                btnGreen = findViewById(R.id.buttonYellow);
                btnYellow = findViewById(R.id.buttonGreen);

                btnPlay = findViewById(R.id.buttonPlay);

                allButtons = new ArrayList<>();

                allButtons.add(btnRed);
                allButtons.add(btnBlue);
                allButtons.add(btnGreen);
                allButtons.add(btnYellow);

                sequenceButtons = new ArrayList<>();

                handler = new Handler();
                sequenceIndex = 0;
                isBlinking = false;

                blinkSequence();
            }
        }.start();


    }

    private void blinkSequence() {
        int sequenceLength = 4 + (roundNumber * 2);

        Collections.shuffle(allButtons); // Randomize button order

        while (allButtons.size() < sequenceLength) {
            int randomIndex = new Random().nextInt(allButtons.size());
            Button randomButton = allButtons.get(randomIndex);
            allButtons.add(randomButton);
        }

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sequenceIndex < sequenceLength) {
                    Button button = allButtons.get(sequenceIndex);
                    button.setAlpha(0.5f);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            button.setAlpha(1.0f);

                            sequenceIndex++;
                            sequenceButtons.add(button);
                            blinkSequence();
                        }
                    }, 500); // Blink duration, adjust as needed
                } else {
                    // Set an OnClickListener for the startGameButton
                    btnPlay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Call the function to initiate the blinking sequence and start GameActivity
                            startGameActivity();
                        }
                    });
                }
            }
        }, 500); // Delay before starting the sequence, adjust as needed
    }

    private void startGameActivity() {

        Intent intent = new Intent(this, GameActivity.class);
        ArrayList<String> buttonTexts = new ArrayList<>();

        for (Button button : sequenceButtons) {
            buttonTexts.add(button.getText().toString());
        }
        intent.putExtra("roundNumber", roundNumber);
        intent.putExtra("score", score);
        intent.putStringArrayListExtra("buttonTexts", buttonTexts);
        startActivity(intent);
    }
}
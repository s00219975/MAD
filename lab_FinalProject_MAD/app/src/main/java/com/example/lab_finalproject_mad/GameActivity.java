package com.example.lab_finalproject_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private List<Button> userSequence;
    private ArrayList<String> buttonTexts;

    private TextView tvScore;
    private List<Button> allButtons;
    Button btnRed, btnBlue, btnGreen, btnYellow;

    int roundNumber, score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        tvScore = findViewById(R.id.tvScore);

        btnRed = findViewById(R.id.buttonRed);
        btnBlue = findViewById(R.id.buttonBlue);
        btnGreen = findViewById(R.id.buttonYellow);
        btnYellow = findViewById(R.id.buttonGreen);

        allButtons = new ArrayList<>();
        allButtons.add(btnRed);
        allButtons.add(btnBlue);
        allButtons.add(btnGreen);
        allButtons.add(btnYellow);

        userSequence = new ArrayList<>();


        // Retrieve button texts from the intent
        buttonTexts = getIntent().getStringArrayListExtra("buttonTexts");
        roundNumber = getIntent().getIntExtra("roundNumber", 0);
        score = getIntent().getIntExtra("score", 0);

        tvScore.setText("Score: " + score);

        // Ensure buttonTexts is not null before proceeding
        if (buttonTexts == null || buttonTexts.isEmpty()) {
            Toast.makeText(this, "Error: Button texts not found", Toast.LENGTH_SHORT).show();
        }
        else {
            // Call setUserInteraction() after the sequenceButtons is retrieved
            setUserInteraction();
        }
    }

    private void setUserInteraction() {
        for (Button button : allButtons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    userSequence.add(button);
                    if (userSequence.size() == buttonTexts.size()) {
                        checkUserInput();
                    }
                }
            });
        }
    }

    private void checkUserInput() {
        boolean isCorrect = true;

        for (int i = 0; i < buttonTexts.size(); i++) {
            Button userButton = userSequence.get(i);
            String currentButtonText = buttonTexts.get(i);

            // Compare the text of the buttons
            if (!userButton.getText().equals(currentButtonText)) {
                // Incorrect sequence
                isCorrect = false;
                break;  // Break the loop when an incorrect button is found
            }
        }

        if (isCorrect) {
            // Correct sequence
            Toast.makeText(this, "Correct sequence!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            roundNumber++;
            score += 4;
            intent.putExtra("roundNumber", roundNumber);
            intent.putExtra("score", score);
            startActivity(intent);
        } else {
            // Incorrect sequence
            Toast.makeText(this, "Incorrect sequence! Game Over", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, GameOver.class);
            intent.putExtra("score", score);
            startActivity(intent);

        }
    }
}
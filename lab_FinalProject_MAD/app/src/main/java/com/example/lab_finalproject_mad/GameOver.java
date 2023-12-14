package com.example.lab_finalproject_mad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    private TextView tvCurrentScore;
    private EditText editTextName;
    private HighScoreDataSource dataSource;
    private SimpleCursorAdapter adapter;
    private ListView listViewScores;

    int yourScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        tvCurrentScore = findViewById(R.id.tvCurrentScore);
        editTextName = findViewById(R.id.editTextName);
        listViewScores = findViewById(R.id.listViewScores);

        yourScore = getIntent().getIntExtra("score", 0);
        tvCurrentScore.setText("Your Score: " + yourScore);

        dataSource = new HighScoreDataSource(this);
        dataSource.open();

        // Set up the ListView adapter
        Cursor cursor = dataSource.getAllHighScores();
        String[] columns = {DBHelper.COLUMN_PLAYER_NAME, DBHelper.COLUMN_SCORE};
        int[] to = {R.id.playerNameTextView, R.id.scoreTextView};
        adapter = new SimpleCursorAdapter(this, R.layout.list_item_layout, cursor, columns, to, 0);
        listViewScores.setAdapter(adapter);

        // Set up the Save button click listener
        Button buttonSave = findViewById(R.id.btnSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void saveData() {
        String playerName = editTextName.getText().toString().trim();
        String scoreString = String.valueOf(yourScore);

        if (!playerName.isEmpty() && !scoreString.isEmpty()) {
            int score = Integer.parseInt(scoreString);

            // Insert the data into the database
            dataSource.insertHighScore(playerName, score);

            // Update the ListView adapter
            Cursor newCursor = dataSource.getAllHighScores();
            adapter.changeCursor(newCursor);

            // Clear the input fields
            editTextName.getText().clear();
            tvCurrentScore.setText("Your Score: "); // Reset the score text to its default
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataSource.close();
    }
}
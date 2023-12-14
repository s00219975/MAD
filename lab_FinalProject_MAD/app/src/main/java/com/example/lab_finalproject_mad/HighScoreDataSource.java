package com.example.lab_finalproject_mad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class HighScoreDataSource {

    private SQLiteDatabase database;
    private DBHelper dbHelper;

    public HighScoreDataSource(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long insertHighScore(String playerName, int score) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_PLAYER_NAME, playerName);
        values.put(DBHelper.COLUMN_SCORE, score);

        return database.insert(DBHelper.TABLE_HIGH_SCORES, null, values);
    }

    public Cursor getAllHighScores() {
        String[] allColumns = {DBHelper.COLUMN_ID, DBHelper.COLUMN_PLAYER_NAME, DBHelper.COLUMN_SCORE};
        return database.query(DBHelper.TABLE_HIGH_SCORES, allColumns, null, null, null, null, DBHelper.COLUMN_SCORE + " DESC");
    }
}

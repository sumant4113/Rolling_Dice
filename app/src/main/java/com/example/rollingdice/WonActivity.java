package com.example.rollingdice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WonActivity extends AppCompatActivity {

    private static final String TAG = "WonActivity";
    TextView txtWon;
    Button btnRestart, btnExit;
    Intent iRestart, iExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        Log.d(TAG, "onCreate: +-+-");
        btnExit = findViewById(R.id.btn_exit);
        btnRestart = findViewById(R.id.btn_restart);
        txtWon = findViewById(R.id.txt_won);

//        iRestart = new Intent();

        iExit = new Intent(WonActivity.this, MainActivity.class);

        String rounds = getIntent().getStringExtra("rounds");
        String totalScore = getIntent().getStringExtra("totalScore");

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(iRestart);
                onBackPressed();
            }
        });

        txtWon.setText(String.format("Your score " + totalScore + " in " + rounds + " rounds"));

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "onBackPressed: +-+-");
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: +-+-");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: +-+-");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: +-+-");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: +-+-");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: +-+-");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: +-+-");
    }
}

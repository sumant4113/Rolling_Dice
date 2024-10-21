package com.example.rollingdice;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgDice;
    TextView txtScore, txtTotalScore;
    Button btnRoll;
    int rounds = 0, totalScore = 0;
    Intent iNext;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRoll = findViewById(R.id.btn_roll);
        imgDice = findViewById(R.id.img_dice);
        txtScore = findViewById(R.id.txt_score);
        txtTotalScore = findViewById(R.id.txt_totalScore);

        if (flag != 1) {
            iNext = new Intent(this, WonActivity.class);
            flag++;
        } else {
            recreate();
            flag = 0;
        }

    }

    public void rollDice(View view) {
        rounds++;
        Random random = new Random();
        int randomNum = random.nextInt(6) + 1;

        String s = Integer.toString(randomNum);
        totalScore = totalScore + randomNum;

        txtScore.setText(String.format("Score : %s", randomNum));
        txtTotalScore.setText(String.format("Total : " + totalScore));

        displayImage(s);
        if (totalScore >= 20) {
            iNext.putExtra("rounds", Integer.toString(rounds));
            iNext.putExtra("totalScore", Integer.toString(totalScore));

            startActivity(iNext);
        }


    }

    @SuppressLint("DiscouragedApi")
    private void displayImage(String s) {
        String imageName;
        int res;
        switch (s) {

            case "1":
                imageName = "img_dice1";
                res = getResources().getIdentifier(imageName, "drawable", this.getPackageName());
                imgDice.setImageResource(res);
                break;

            case "2":
                imageName = "img_dice2";
                res = getResources().getIdentifier(imageName, "drawable", this.getPackageName());
                imgDice.setImageResource(res);
                break;

            case "3":
                imageName = "img_dice3";
                res = getResources().getIdentifier(imageName, "drawable", this.getPackageName());
                imgDice.setImageResource(res);
                break;

            case "4":
                imageName = "img_dice4";
                res = getResources().getIdentifier(imageName, "drawable", this.getPackageName());
                imgDice.setImageResource(res);
                break;

            case "5":
                imageName = "img_dice5";
                res = getResources().getIdentifier(imageName, "drawable", this.getPackageName());
                imgDice.setImageResource(res);
                break;

            case "6":
                imageName = "img_dice6";
                res = getResources().getIdentifier(imageName, "drawable", this.getPackageName());
                imgDice.setImageResource(res);
                break;
            default:
                Toast.makeText(this, "Invalid number generated...", Toast.LENGTH_SHORT).show();
        }

    }


}
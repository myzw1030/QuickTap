package com.example.quicktap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreZone extends AppCompatActivity implements View.OnClickListener {

    public SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_zone);

        pref = getSharedPreferences("pref", MODE_PRIVATE);



        Intent intent = getIntent();
        String score = intent.getStringExtra("score");

        TextView textTime = (TextView)findViewById(R.id.textTime);
        TextView textNew = (TextView)findViewById(R.id.textNew);
        TextView textScore = (TextView)findViewById(R.id.textScore);
        TextView textHighScoreTime = (TextView)findViewById(R.id.textHighScoreTime);

        ((Button)findViewById(R.id.buttonHome)).setOnClickListener(this);
        ((Button)findViewById(R.id.buttonRetry)).setOnClickListener(this);

        textTime.setText(score);
        String score1 = pref.getString("score1", "");
        textHighScoreTime.setText("" + score1);

        int m = Integer.parseInt(score.substring(0, 2));
        int s = Integer.parseInt(score.substring(3,5));
        int ms = Integer.parseInt(score.substring(6,8));

        int m1 = Integer.parseInt(score1.substring(0, 2));
        int s1 = Integer.parseInt(score1.substring(3,5));
        int ms1 = Integer.parseInt(score1.substring(6,8));

        if (m <= m1) {
            if (s <= s1) {
                if (ms <= ms1) {
                    SharedPreferences.Editor edit = pref.edit();
                    edit.putString("score1", score);
                    edit.commit();
                }
            }

        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.buttonHome):
                Intent intentHome = new Intent(getApplication(),MainActivity.class);
                startActivity(intentHome);
                break;
            case (R.id.buttonRetry):
                Intent intentRetry = new Intent(getApplication(),GameAction3.class);
                startActivity(intentRetry);
                break;
        }
    }
}
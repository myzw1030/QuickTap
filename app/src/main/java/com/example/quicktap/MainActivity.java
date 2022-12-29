package com.example.quicktap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);

//        Button start = findViewById(R.id.start);
        ((Button)findViewById(R.id.start)).setOnClickListener(this);
        ((Button)findViewById(R.id.score)).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case(R.id.start):
                title.setText("Hello World");
                break;

            case(R.id.score):
                break;
        }
    }
}
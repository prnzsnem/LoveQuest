package com.ps.lovequest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Objects;

public class ResultActivity extends AppCompatActivity {
    TextView unMsg, msg;
    Button replay,exit;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        SessionKeeper session = new SessionKeeper(ResultActivity.this);
        unMsg = findViewById(R.id.username);
        msg = findViewById(R.id.message);
        replay = findViewById(R.id.replayBtn);
        exit = findViewById(R.id.exitBtn);

        HashMap<String, String> user = session.getPlayerInfo();
        String un = user.get(SessionKeeper.KEY_NAME);
        unMsg.setText("Hey! "+un+getString(R.string.result_text));

        HashMap<String, String> count = session.getTotalCount();
        int totCount = Integer.parseInt(Objects.requireNonNull(count.get(SessionKeeper.KEY_TOTAL_COUNT)));
        int id = getResources().getIdentifier("a"+totCount, "string", getPackageName());
        msg.setText(getString(id));

        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, GameActivity.class));
                finish();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
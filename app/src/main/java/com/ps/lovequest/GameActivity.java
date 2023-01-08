package com.ps.lovequest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;

public class GameActivity extends AppCompatActivity {

    Spinner answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10, answer11, answer12, answer13, answer14;
    Button resultBtn;
    ProgressDialog progressDialog;

    Handler handler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            progressDialog.dismiss();
            startActivity(new Intent(GameActivity.this, ResultActivity.class));
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final SessionKeeper session = new SessionKeeper(GameActivity.this);
        HashMap<String, String> user = session.getPlayerInfo();
        final String un = user.get(SessionKeeper.KEY_NAME);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        answer5 = findViewById(R.id.answer5);
        answer6 = findViewById(R.id.answer6);
        answer7 = findViewById(R.id.answer7);
        answer8 = findViewById(R.id.answer8);
        answer9 = findViewById(R.id.answer9);
        answer10 = findViewById(R.id.answer10);
        answer11 = findViewById(R.id.answer11);
        answer12 = findViewById(R.id.answer12);
        answer13 = findViewById(R.id.answer13);
        answer14 = findViewById(R.id.answer14);
        resultBtn = findViewById(R.id.resultBtn);

        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = answer1.getSelectedItemPosition(),
                        num2 = answer2.getSelectedItemPosition(),
                        num3 = answer3.getSelectedItemPosition(),
                        num4 = answer4.getSelectedItemPosition(),
                        num5 = answer5.getSelectedItemPosition(),
                        num6 = answer6.getSelectedItemPosition(),
                        num7 = answer7.getSelectedItemPosition(),
                        num8 = answer8.getSelectedItemPosition(),
                        num9 = answer9.getSelectedItemPosition(),
                        num10 = answer10.getSelectedItemPosition(),
                        num11 = answer11.getSelectedItemPosition(),
                        num12 = answer12.getSelectedItemPosition(),
                        num13 = answer13.getSelectedItemPosition(),
                        num14 = answer14.getSelectedItemPosition();

                int totalCount = num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + num9 + num10 + num11 + num12 + num13 + num14;
                if (totalCount <14){
                    Toast.makeText(getApplicationContext(), un+getString(R.string.inconvenience), Toast.LENGTH_LONG).show();
                }else{
                    progressDialog = ProgressDialog.show(GameActivity.this, "", "Processing please wait...");
                    if (totalCount < 28){ totalCount = totalCount * 2; }
                    session.createCountSession(""+totalCount);
                    handler.postDelayed(runnable, 2000);
                }
            }
        });
    }
}
package com.ps.lovequest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Spinner gender;
    Button play;
    SessionKeeper session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        name = findViewById(R.id.name);
        gender = findViewById(R.id.gender);
        play = findViewById(R.id.playBtn);
        session = new SessionKeeper(MainActivity.this);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nm = name.getText().toString();
                String gen = gender.getSelectedItem().toString();

                if (nm.isEmpty()){
                    name.setError("* Your name cannot be empty.");
                }else if (nm.length()<=1){
                    name.setError("* Insert your full name or first name but not short name.");
                }else{
                    session.createPlayerSession(nm, gen);
                    startActivity(new Intent(MainActivity.this, GameActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                }
            }
        });

    }
}

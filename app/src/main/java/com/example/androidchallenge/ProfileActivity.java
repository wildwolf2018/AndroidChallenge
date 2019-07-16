package com.example.androidchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar aboutToolBar = findViewById(R.id.profile_toolbar);
        setSupportActionBar(aboutToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Button backButton = findViewById(R.id.profile_back_button);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

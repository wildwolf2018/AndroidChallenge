package com.example.androidchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mAboutButton;
    private Button mProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar splashScreenBar = findViewById(R.id.description_toolbar);
        setSupportActionBar(splashScreenBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mAboutButton = findViewById(R.id.about_button);
        mProfileButton = findViewById(R.id.my_profile_button);

        setAboutButtonHandler();
        setProfileButtonHandler();

    }

    private void setAboutButtonHandler() {
        mAboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(aboutIntent);
            }
        });
    }

    private void setProfileButtonHandler() {
        mProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutIntent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(aboutIntent);
            }
        });
    }
}

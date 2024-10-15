package com.trup1.euphoria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;


import com.google.android.material.bottomnavigation.BottomNavigationView;


public class LibraryActivity extends AppCompatActivity {

    BottomNavigationView bnView;
    Button Love,Happy,Sad,Rock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        bnView = findViewById(R.id.bnView);
        Love=findViewById(R.id.love);
        Sad=findViewById(R.id.sad);
        Happy=findViewById(R.id.happy);
        Rock=findViewById(R.id.rock);


        Love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LibraryActivity.this,LoveActivity.class));
            }
        });

        Sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LibraryActivity.this,SadActivity.class));
            }
        });

        Happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LibraryActivity.this,HappyActivity.class));
            }
        });

        Rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LibraryActivity.this,RockActivity.class));
            }
        });

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_Search) {

                    startActivity(new Intent(LibraryActivity.this, SearchActivity.class));
                    finish();

                }
                   else if (id == R.id.nav_Home) {
                        startActivity(new Intent(LibraryActivity.this,HomeActivity.class));
                    finish();


                } else if (id == R.id.nav_Premium) {
                    startActivity(new Intent(LibraryActivity.this,PremiumActivity.class));
                    finish();

                } else {

                }
                return true;
            }


        });
        bnView.setSelectedItemId(R.id.nav_Library);
    }

}


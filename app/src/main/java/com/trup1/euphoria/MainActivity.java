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


public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;
    Button btnlogout;
    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnView = findViewById(R.id.bnView);



        btnlogout = findViewById(R.id.btnlogout);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();


                editor.putBoolean("flag", false);
                editor.apply();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));

            }


        });

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_Home) {
                    startActivity(new Intent(MainActivity.this,HomeActivity.class));

                } else if (id == R.id.nav_Search) {
                    startActivity(new Intent(MainActivity.this,SearchActivity.class));

                } else if (id == R.id.nav_Library) {
                    startActivity(new Intent(MainActivity.this,LibraryActivity.class));

                } else if (id == R.id.nav_Premium) {
                    startActivity(new Intent(MainActivity.this,PremiumActivity.class));

                } else {

                }
                return true;
            }


        });
        bnView.setSelectedItemId(R.id.nav_Home);
    }

}


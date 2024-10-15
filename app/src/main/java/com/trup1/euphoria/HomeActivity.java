package com.trup1.euphoria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.content.SharedPreferences;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;


import com.google.android.material.bottomnavigation.BottomNavigationView;




public class HomeActivity extends AppCompatActivity  {

    private ListView listView;
    ImageView Selena,Atif,Arijit,Taylor,StrongHeart,LegitGoal,Revenge,TrueStory,NewSong;
    public static final int REQUEST_CODE = 1;
    Button btnlogout;
    BottomNavigationView bnView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Selena=findViewById(R.id.selena_artist);
        Arijit=findViewById(R.id.arijit_artist);
        Taylor=findViewById(R.id.taylor_artist);
        Atif=findViewById(R.id.atif_artist);
        TrueStory=findViewById(R.id.true_story);
        LegitGoal=findViewById(R.id.legit_goal);
        StrongHeart=findViewById(R.id.strong_heart);
        Revenge=findViewById(R.id.revenge);
        NewSong=findViewById(R.id.newsongimg);


        // Retrieve list of artist names from wherever it's being stored


        // Set the adapter to the ListView
        bnView1 = findViewById(R.id.bnView1);

        Intent intent = getIntent();
        String txt = intent.getStringExtra("");



        // Get the selected image from the Intent extras


        btnlogout = findViewById(R.id.btnlogout);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();


                editor.putBoolean("flag", false);
                editor.apply();
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));

            }


        });
        NewSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, NewSongActivity.class));

            }
        });
        Taylor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, TaylorActivity.class));

            }
        });
        Arijit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ArijitActivity.class));

            }
        });
        Atif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AtifActivity.class));

            }
        });
        Selena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, SelenaActivity.class));

            }
        });
        TrueStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.iheart.com/podcast/1119-inner-cosmos-with-david-e-110885566/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        LegitGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.iheart.com/podcast/1119-the-mantawauk-caves-110170167/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        Revenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.iheart.com/podcast/552-dateline-nbc-43034875/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        StrongHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.iheart.com/podcast/270-crime-junkie-29319113/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        bnView1.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_Search) {
                    startActivity(new Intent(HomeActivity.this,SearchActivity.class));
                    finish();
                } else if (id == R.id.nav_Library) {
                    startActivity(new Intent(HomeActivity.this,LibraryActivity.class));
                    finish();

                } else if (id == R.id.nav_Premium) {
                    startActivity(new Intent(HomeActivity.this,PremiumActivity.class));
                    finish();

                } else {

                }
                return true;
            }


        });
        bnView1.setSelectedItemId(R.id.nav_Home);

    }

}


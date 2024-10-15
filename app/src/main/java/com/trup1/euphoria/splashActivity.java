package com.trup1.euphoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref=getSharedPreferences("login",MODE_PRIVATE);
                Boolean check=pref.getBoolean("flag",false);
                Intent INext;
                if(check){
                    INext=new Intent(splashActivity.this,MainActivity.class);
                }else {
                    INext=new Intent(splashActivity.this,LoginActivity.class);
                }
                startActivity(INext);
            }
        },6000);


    }
}
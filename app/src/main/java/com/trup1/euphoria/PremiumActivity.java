package com.trup1.euphoria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firestore.v1.StructuredQuery;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;


public class PremiumActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;
    Button btnlogout;
    TextView textview;
    BottomNavigationView bnView;
    Button Paybutton;
    Checkout checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium);

        Paybutton = findViewById(R.id.paybtn);
        bnView = findViewById(R.id.bnView);
        Checkout.preload(getApplicationContext());

        Paybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PremiumActivity.this,ReceiptDataActivity.class));

            }
        });

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_Search) {
                    startActivity(new Intent(PremiumActivity.this, SearchActivity.class));
                    finish();

                } else if (id == R.id.nav_Library) {
                    startActivity(new Intent(PremiumActivity.this, LibraryActivity.class));
                    finish();

                } else if (id == R.id.nav_Home) {
                    startActivity(new Intent(PremiumActivity.this, HomeActivity.class));
                    finish();

                } else {

                }
                return true;
            }


        });
        bnView.setSelectedItemId(R.id.nav_Premium);
    }




}







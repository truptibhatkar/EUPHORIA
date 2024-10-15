package com.trup1.euphoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdmMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm_main);
        Button button = findViewById(R.id.firebasebtn);
        Button button2=findViewById(R.id.logindatabtn);
        Button button3=findViewById(R.id.signupdatabtn);
        Button button4=findViewById(R.id.addartistbtn);
        Button button6=findViewById(R.id.reportbtn);
        Button button7=findViewById(R.id.transacbtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://console.firebase.google.com/u/0/project/euphoria-5dcfb/authentication/usage/current-billing"; // Replace this with the URL you want to redirect to
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://console.firebase.google.com/u/0/project/euphoria-5dcfb/authentication/users"; // Replace this with the URL you want to redirect to
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://console.firebase.google.com/u/0/project/euphoria-5dcfb/firestore/data/~2Fuser~2F7Mdo4Vq20NXgsTlB6kA6XmlSUXE3"; // Replace this with the URL you want to redirect to
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdmMainActivity.this,Add_Artist_Activity.class));
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String url = "https://dashboard.razorpay.com/app/reports"; // Replace this with the URL you want to redirect to
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String url = "https://dashboard.razorpay.com/app/payments"; // Replace this with the URL you want to redirect to
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);            }
        });
    }
}
package com.trup1.euphoria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class showReceiptActivity extends AppCompatActivity {
    TextView Name, Email, Phone, Bank, Id, DateTime;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_receipt);

        Name = findViewById(R.id.show_name);
        Email = findViewById(R.id.show_email);
        Phone = findViewById(R.id.show_phone);
        Bank = findViewById(R.id.show_bank);
        Id = findViewById(R.id.show_id);
        DateTime = findViewById(R.id.show_datetime);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm a");
        String dateTime = dateFormat.format(calendar.getTime());

        String showid = getIntent().getStringExtra("ms");
        Id.setText(showid);

        String showname = getIntent().getStringExtra("lname");
        Name.setText(showname);

        String showemail = getIntent().getStringExtra("lemail");
        Email.setText(showemail);

        String showphone = getIntent().getStringExtra("lphone");
        Phone.setText(showphone);

        String showbank = getIntent().getStringExtra("lbank");
        Bank.setText(showbank);

        @SuppressLint("CutPasteId") TextView dateTimeTextView = findViewById(R.id.show_datetime);
        dateTimeTextView.setText(dateTime);
        Toast.makeText(showReceiptActivity.this,"You Can Take Screenshot of Your Payment Reciept If Needed!",Toast.LENGTH_SHORT).show();

    }

}




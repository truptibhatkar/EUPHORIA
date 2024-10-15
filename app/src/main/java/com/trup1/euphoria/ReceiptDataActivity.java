package com.trup1.euphoria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class ReceiptDataActivity extends AppCompatActivity  {
    EditText Name,Email,Phone,Bank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_data);

        Name = findViewById(R.id.payee_name);
        Email = findViewById(R.id.payee_email);
        Phone = findViewById(R.id.payee_phone);
        Bank = findViewById(R.id.payee_bank);
        Button submit = findViewById(R.id.receiptdatasubmit);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString().trim();
                String bank = Bank.getText().toString().trim();
                String phone = Phone.getText().toString().trim();
                String name = Name.getText().toString();
                Intent intent1 = new Intent(ReceiptDataActivity.this, ReceiptActivity.class);

                intent1.putExtra("memail", email);
                intent1.putExtra("mname", name);
                intent1.putExtra("mphone", phone);
                intent1.putExtra("mbank", bank);

                if (email.isEmpty()) {
                    Email.setError("Email cannot be empty!");
                } else if (bank.isEmpty()) {
                    Bank.setError("Enter Bank Name!");
                } else if (name.contains("1")||name.contains("2")||name.contains("3")||name.contains("4")||name.contains("5")||name.contains("6")||
                        name.contains("7")||name.contains("8")||name.contains("9")||name.contains("0")||name.contains("+")||name.contains("-")||
                        name.contains("*")||name.contains("/")||name.contains("%")||name.contains("#")||name.contains("@")||name.contains("<")
                        ||name.contains(">")||name.contains("?")||name.contains("~")||name.contains("=")||name.contains("_")||name.contains("$")
                        ||name.contains("!")||name.contains("|")||name.contains("&")||name.contains("(")||name.contains(")")||name.contains("{")
                        ||name.contains("}")||name.contains("[")||name.contains("]")){
                    Name.setError("Enter Characters Only!");
                }else if (phone.isEmpty()) {
                    Phone.setError("Phone number cannot be empty!");
                }
                else if (!email.contains("@gmail.com")) {
                    Email.setError("Enter Valid Email!");
                } else if (phone.length() < 10) {
                    Phone.setError("10 Digits Required!");
                } else if (phone.length() > 10) {
                    Phone.setError("Phone Number Can Not Be Greater Than 10 Digits!");
                } else if (name.isEmpty()) {
                    Name.setError("Email cannot be empty!");
                } else {
                    startActivity(intent1);
                    finish();

                }
            }
        });
    }
}
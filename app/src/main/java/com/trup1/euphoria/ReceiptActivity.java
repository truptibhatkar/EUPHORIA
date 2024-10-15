package com.trup1.euphoria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class ReceiptActivity extends AppCompatActivity implements PaymentResultListener {
    TextView paytext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startPayment();
        setContentView(R.layout.activity_receipt);
    }

    public void startPayment() {
        String kname = getIntent().getStringExtra("mname");
        String kbank = getIntent().getStringExtra("mbank");

        Checkout checkout = new Checkout();
        checkout.setImage(R.drawable.euphoria);
        final Activity activity = this;
        try {
            JSONObject options = new JSONObject();
            options.put("name", getResources().getString(R.string.app_name));
            options.put("description", "Premium Payment");
            options.put("send_sms_hash", true);
            options.put("allow_rotation", false);
            options.put("currency", "INR");
            options.put("amount", "3000");
            options.put("notes", "{\"name\": \"" + kname + "\", \"bank_name\": \"" + kbank + "\"}");

            JSONObject preFill = new JSONObject();
            preFill.put("contact", "");
            options.put("prefill", preFill);

            checkout.open(activity, options);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error starting payment", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void onPaymentSuccess(String paymentId) {
        Toast.makeText(this,"Payment successful!! Your Payment Id is : "+paymentId,Toast.LENGTH_SHORT).show();

        String kemail = getIntent().getStringExtra("memail");
        String kname = getIntent().getStringExtra("mname");
        String kphone = getIntent().getStringExtra("mphone");
        String kbank = getIntent().getStringExtra("mbank");

        Intent intent1 =new Intent(this,showReceiptActivity.class);
        intent1.putExtra("lemail", kemail);
        intent1.putExtra("lname", kname);
        intent1.putExtra("lphone", kphone);
        intent1.putExtra("lbank", kbank);
        intent1.putExtra("ms", paymentId);

        startActivity(intent1);
        finish();
    }

    @Override
    public void onPaymentError(int code, String description) {
        Intent intent =new Intent(this,PremiumActivity.class);
        Toast.makeText(this, "Payment Failed!! Due to " + description, Toast.LENGTH_SHORT).show();
    }
}

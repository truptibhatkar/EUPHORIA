package com.trup1.euphoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdmLogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm_log);
        Button admloginButton=findViewById(R.id.mainadmlogbtn);
        EditText admemail = findViewById(R.id.admlogin_email);
        EditText admpassword = findViewById(R.id.admlogin_password);


        admloginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = admemail.getText().toString().trim();
                String  p= admpassword.getText().toString().trim();
                if (e.isEmpty()){
                    admemail.setError("Email cannot be empty!");
                }
                else if (p.isEmpty()){
                    admpassword.setError("Password cannot be empty!");
                }
                else if (!e.contains("@gmail.com")){
                    admemail.setError("Enter Valid Email!");
                }
                else if (e.equals("truptibhatkar2002@gmail.com")||e.equals("atharvag012@gmail.com")& p.equals("222222")){
                    startActivity(new Intent(AdmLogActivity.this,AdmMainActivity.class));
                }
                else {
                    Toast.makeText(AdmLogActivity.this, "User Does Not Exist!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}

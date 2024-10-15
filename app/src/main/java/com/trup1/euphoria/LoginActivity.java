package com.trup1.euphoria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        TextView mfpRedirectText=findViewById(R.id.fpRedirectText);

        EditText memail=findViewById(R.id.login_email);
        EditText mpassword=findViewById(R.id.login_password);
        Button mloginButton=findViewById(R.id.login_button);
        Button madmloginButton=findViewById(R.id.admlogbtn);
        TextView msignupRedirectText=findViewById(R.id.signupRedirectText);



        madmloginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,AdmLogActivity.class));
            }
        });
        mloginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String email = memail.getText().toString().trim();
                String pass = mpassword.getText().toString().trim();

                fAuth = FirebaseAuth.getInstance();

                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("flag", true);
                editor.apply();


                if (pass.isEmpty()) {
                    mpassword.setError("Password cannot be empty!!");
                } else if (email.isEmpty()) {
                    memail.setError("Email cannot be empty!!");
                }
                else if (!email.contains("@gmail.com")) {
                    memail.setError("Enter Valid Email!!");
                }else if (pass.length() < 6) {

                    Toast.makeText(LoginActivity.this, "Password must contain 6 characters", Toast.LENGTH_SHORT).show();
                }
                    else {
                    fAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Toast.makeText(LoginActivity.this, "Login successful!!!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                            } else {
                                Toast.makeText(LoginActivity.this, "No User Record Found!Try Again!" ,Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });


        msignupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });
        mfpRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ForgetPassActivity.class));
            }
        });

    }
}

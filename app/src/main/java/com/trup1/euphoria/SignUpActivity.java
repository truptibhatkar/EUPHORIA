package com.trup1.euphoria;

import static com.google.firebase.firestore.core.CompositeFilter.Operator.OR;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class SignUpActivity extends AppCompatActivity {

FirebaseAuth fAuth;
FirebaseFirestore fStore;
String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EditText memail = findViewById(R.id.signup_email);
        EditText mpassword = findViewById(R.id.signup_password);
        EditText mphone = findViewById(R.id.signup_phone);
        EditText mconfopass = findViewById(R.id.signup_confopass);
        EditText mname = findViewById(R.id.signup_name);



        Button signupButton = findViewById(R.id.signup_button);
        TextView loginRedirectText = findViewById(R.id.loginRedirectText);
        fAuth=FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();




        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = memail.getText().toString().trim();
                String pass = mpassword.getText().toString().trim();
                String phone = mphone.getText().toString().trim();
                String name = mname.getText().toString();
                String conpass = mconfopass.getText().toString().trim();


                if (email.isEmpty()) {
                    memail.setError("Email cannot be empty!");
                }
                else if (!email.contains("@gmail.com")) {
                    memail.setError("Enter valid Email!");
                }

                else if (name.contains("1")||name.contains("2")||name.contains("3")||name.contains("4")||name.contains("5")||name.contains("6")||
                        name.contains("7")||name.contains("8")||name.contains("9")||name.contains("0")||name.contains("+")||name.contains("-")||
                        name.contains("*")||name.contains("/")||name.contains("%")||name.contains("#")||name.contains("@")||name.contains("<")
                        ||name.contains(">")||name.contains("?")||name.contains("~")||name.contains("=")||name.contains("_")||name.contains("$")
                        ||name.contains("!")||name.contains("|")||name.contains("&")||name.contains("(")||name.contains(")")||name.contains("{")
                        ||name.contains("}")||name.contains("[")||name.contains("]")){
                    mname.setError("Enter Characters Only!");
                }else if (name.isEmpty()) {
                    mname.setError("Name cannot be empty");
                }  else if (phone.isEmpty()) {
                    mphone.setError("Phone number cannot be empty");
                } else if (pass.isEmpty()) {
                    mpassword.setError("Password cannot be empty!!");
                } else if (conpass.isEmpty()) {
                    mconfopass.setError("Confirm your Password");
                }
                else if (phone.length()<10) {
                    mphone.setError("Please enter your 10 digit phone number!");

                }else if (!pass.equals(conpass)) {
                    Toast.makeText(SignUpActivity.this, "Password Missmatched", Toast.LENGTH_SHORT).show();
                }
                else if (pass.length()<6){
                    Toast.makeText(SignUpActivity.this, "Password must contain 6 characters", Toast.LENGTH_SHORT).show();
                }
                else if(phone.length()<10){
                    Toast.makeText(SignUpActivity.this, "Enter 10 Digits!!", Toast.LENGTH_SHORT).show();

                }
                else if(phone.length()>10){
                    mphone.setError("Phone number can not be greater than 10 digits");

                }else
                fAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignUpActivity.this, "Registered successfully!!", Toast.LENGTH_SHORT).show();
                            userID= Objects.requireNonNull(fAuth.getCurrentUser()).getUid();
                            DocumentReference documentReference=fStore.collection("user").document(userID);
                            Map<String,Object> user =new HashMap<>();
                            user.put("Name",name);
                            user.put("Email",email);
                            user.put("Phone",phone);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {

                                    Log.d("TAG","onSuccess: user Profile is created for"+userID);
                                }
                            });
                            startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
                        }
                        else {
                            Toast.makeText(SignUpActivity.this, "Registraition Failed!! check you might have already Registered!", Toast.LENGTH_SHORT).show();

                        }

                    }
                });


            }

        });
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });

    }

}

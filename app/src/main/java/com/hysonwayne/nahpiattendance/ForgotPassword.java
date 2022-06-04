package com.hysonwayne.nahpiattendance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends LoginActivity {

    private Button resetPassword;
    private EditText userEmailAddress;
    private FirebaseAuth authProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        //getSupportActionBar().setTitle("Forgot Password");
        userEmailAddress = findViewById(R.id.inputEmail);
        resetPassword= findViewById(R.id.btnReset);



        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = userEmailAddress.getText().toString();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(ForgotPassword.this, "Please enter your Registered Email Address",Toast.LENGTH_SHORT).show();
                    userEmailAddress.setError("Email Address is Required!!!");
                    userEmailAddress.requestFocus();
                }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(ForgotPassword.this, "Please enter a Email Address",Toast.LENGTH_SHORT).show();
                    userEmailAddress.setError("A Valid Email Address is Required!!!");
                    userEmailAddress.requestFocus();
                }else {

                    resetPasswords(email);
                }
            }
        });

    }

    private void resetPasswords(String email) {
        authProfile = FirebaseAuth.getInstance();
        authProfile.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgotPassword.this,"Open Your Email Inbox to get the Reset Link", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(ForgotPassword.this,LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(ForgotPassword.this,"Something went Wrong!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
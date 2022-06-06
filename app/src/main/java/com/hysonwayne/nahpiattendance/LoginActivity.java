package com.hysonwayne.nahpiattendance;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText inputEmail, inputPassword;
    Button btnLogin,btnGoogle;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    TextView forgotPassword;
    FirebaseAuth mAuth;
    FirebaseUser mUser;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        progressDialog = new ProgressDialog(this);
        btnLogin = findViewById(R.id.btnLogin);
        btnGoogle = findViewById(R.id.btnGoogle);
        forgotPassword = findViewById(R.id.forgotPassword);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"You can now Reset Your Password", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,ForgotPassword.class));
            }
        });

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();



        TextView btn=findViewById(R.id.signUpText);
        btn.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));


        btnLogin.setOnClickListener(v -> performLogin());

        btnGoogle.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, GoogleSignActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        });

    }


    private void performLogin() {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();

        if (!email.matches(emailPattern)){
            inputEmail.setError("Enter Proper Email Address");
        }else if(password.isEmpty() || password.length()<8){
            inputPassword.setError("Enter Proper Password");
        } else {
            progressDialog.setMessage("Please be patient while Login...");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    progressDialog.dismiss();
                    sendUserToNextActivity();
                    Toast.makeText(LoginActivity.this, "Login Complete", Toast.LENGTH_SHORT).show();
                }else {
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, " Login Failed. Please enter correct details",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    private void sendUserToNextActivity() {
        Intent intent = new Intent(LoginActivity.this,mainscreen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


}

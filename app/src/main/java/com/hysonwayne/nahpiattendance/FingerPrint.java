package com.hysonwayne.nahpiattendance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class FingerPrint extends AppCompatActivity {

    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    ScrollView mFingerLayout;
    Button returnB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print);
        mFingerLayout = findViewById(R.id.fingerprint);
        returnB = findViewById(R.id.returnB);

        returnB.setOnClickListener(v -> startActivity(new Intent(FingerPrint.this, mainscreen.class)));


        //checking if a phone has Biometrics or not
        BiometricManager biometricManager = BiometricManager.from(this);
        switch (biometricManager.canAuthenticate()){
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Toast.makeText(getApplicationContext(),"Fingerprint is Unavailable for your Device",Toast.LENGTH_SHORT).show();
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Toast.makeText(getApplicationContext(),"Fingerprint Error for this Device",Toast.LENGTH_SHORT).show();
                break;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                Toast.makeText(getApplicationContext(),"Configure Fingerprint for Your Device",Toast.LENGTH_SHORT).show();
                break;

        }

        Executor executor= ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(FingerPrint.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(getApplicationContext(),"ERROR! Retry",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                mFingerLayout.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),"Successfully Authenticated",Toast.LENGTH_SHORT).show();
               // mFingerLayout.setOnClickListener(v -> startActivity(new Intent(FingerPrint.this,AttendanceOptions.class)));
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(getApplicationContext(),"Authentication Failed",Toast.LENGTH_SHORT).show();
            }
        });
        promptInfo = new BiometricPrompt.PromptInfo.Builder().setTitle("NAHPI Attendance")
                .setDescription("Use FingerPrint To Access Attendance").setDeviceCredentialAllowed(true)
                .build();
        biometricPrompt.authenticate(promptInfo);

    }
}
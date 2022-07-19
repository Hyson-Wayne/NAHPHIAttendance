package com.hysonwayne.nahpiattendance;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class Status extends AppCompatActivity {

    TextView fName, lName;
    Button goingB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        fName= findViewById(R.id.fName);
        lName = findViewById(R.id.sName);
        goingB = findViewById(R.id.going_back);
        goingB.setOnClickListener(v -> startActivity(new Intent(Status.this,mainscreen.class)));


        // getting my info
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null){
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personID = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();

            //setting to textview
            fName.setText(personFamilyName);
            lName.setText(personGivenName);

        }
    }
}
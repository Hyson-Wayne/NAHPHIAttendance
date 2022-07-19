package com.hysonwayne.nahpiattendance;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.hysonwayne.nahpiattendance.MyGroup.TeamRandomizer;

import java.text.DateFormat;
import java.util.Calendar;

public class mainscreen extends AppCompatActivity {

    ImageView logOut, userProfile,attendanceButton,groupButton, support,status;
    TextView userEmail;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        logOut = findViewById(R.id.logOut);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        userProfile = findViewById(R.id.profile_img);
        userEmail = findViewById(R.id.emailShow);
        support = findViewById(R.id.supportMe);
        status = findViewById(R.id.statusIC);
        groupButton = findViewById(R.id.groupI);


        attendanceButton = findViewById(R.id.imageAtt);


        status.setOnClickListener(v -> startActivity(new Intent(mainscreen.this,Status.class)));
        support.setOnClickListener(v -> startActivity(new Intent(mainscreen.this,AboutUs.class)));

        attendanceButton.setOnClickListener(v -> startActivity(new Intent(mainscreen.this,FingerPrint.class)));

        groupButton.setOnClickListener(v -> startActivity(new Intent(mainscreen.this, TeamRandomizer.class)));


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
            userEmail.setText(personEmail);
            Glide.with(this).load(personPhoto).into(userProfile);

        }

        //setting automatic time
        Calendar calender = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calender.getTime());
        TextView textViewDate = findViewById(R.id.date);
        textViewDate.setText(currentDate);


        //logging out
        logOut.setOnClickListener(v -> { mAuth.signOut();
            signOutUser();
        });

    }

    private void signOutUser() {
        Intent mainSignOut = new Intent(mainscreen.this,LoginActivity.class);
        mainSignOut.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainSignOut);
        finish();
    }

}
package com.hysonwayne.nahpiattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.DateFormat;
import java.util.Calendar;

public class mainscreen extends AppCompatActivity {

    ImageView logOut;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        logOut = findViewById(R.id.logOut);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        //setting automatic time
        Calendar calender = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calender.getTime());
        TextView textViewDate = findViewById(R.id.date);
        textViewDate.setText(currentDate);


        //logging out
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                signOutUser();

            }
        });




    }

    private void signOutUser() {
        Intent mainSignOut = new Intent(mainscreen.this,LoginActivity.class);
        mainSignOut.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainSignOut);
        finish();
    }

}
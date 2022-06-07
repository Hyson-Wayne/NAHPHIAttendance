package com.hysonwayne.nahpiattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class splash extends AppCompatActivity {

    private static final int DELAY_TIME = 6000;

    Animation topAnim, bottomAnim;

    ImageView splashimg;
    TextView appname;
    LottieAnimationView lottieAnimationView;
    FirebaseAuth mUserProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        appname = findViewById(R.id.app_names);
        splashimg = findViewById(R.id.img);
        lottieAnimationView = findViewById(R.id.lottie);
        mUserProfile = FirebaseAuth.getInstance();

        splashimg.setAnimation(topAnim);
        appname.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser firebaseUser = mUserProfile.getCurrentUser();


                if (firebaseUser != null){
                    Toast.makeText(splash.this, "Already Logged In", Toast.LENGTH_SHORT).show();


                    // starting the user activity
                    startActivity(new Intent(splash.this, mainscreen.class));
                }else {

                    // going to login activity
                    startActivity(new Intent(splash.this,MainActivity.class));


                }
            }
        },DELAY_TIME);

    }
    // checking if user is already logged in or not

}
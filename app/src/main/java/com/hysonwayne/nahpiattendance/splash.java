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

import com.airbnb.lottie.LottieAnimationView;


public class splash extends AppCompatActivity {

    private static final int DELAY_TIME = 5000;

    Animation topAnim, bottomAnim;

    ImageView splashimg;
    TextView appname;
    LottieAnimationView lottieAnimationView;

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

        splashimg.setAnimation(topAnim);
        appname.setAnimation(bottomAnim);
        //splashimg.animate().translationY(-2500).setDuration(1000).setStartDelay(5000);
       // appname.animate().translationY(2000).setDuration(1000).setStartDelay(5000);
       // lottieAnimationView.animate().translationY(1500).setDuration(1000).setStartDelay(5000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(splash.this,MainActivity.class));

            }
        },6000);

    }
}
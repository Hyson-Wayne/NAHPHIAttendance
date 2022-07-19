package com.hysonwayne.nahpiattendance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class GroupHomescreen extends AppCompatActivity {

    RadioGroup radioGroup;
    Button goBack, createGroups;
    RadioButton radioButton, radioButton2, radioButton3, radioButton4;
    TextView totStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_homescreen);


        radioButton2 = findViewById(R.id.radio_one);
        radioButton3 = findViewById(R.id.radio_two);
        radioButton4 = findViewById(R.id.radio_three);
        createGroups = findViewById(R.id.createGroupss);
        goBack = findViewById(R.id.goBack);
        goBack.setOnClickListener(v -> startActivity(new Intent(GroupHomescreen.this, NameGroups.class)));


        createGroups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if (radioButton2.isChecked()) {
//                    Intent intent = new Intent(GroupHomescreen.this, Groups2.class);
//                    startActivity(intent);
//                } else if (radioButton3.isChecked()) {
//                    Intent intent = new Intent(GroupHomescreen.this, Groups3.class);
//                    startActivity(intent);
//                } else {
//                    Intent intent = new Intent(GroupHomescreen.this, Groups4.class);
//                    startActivity(intent);
//                }
            }
        });


    }
}
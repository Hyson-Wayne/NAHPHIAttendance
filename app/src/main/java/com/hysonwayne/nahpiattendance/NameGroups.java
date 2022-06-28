package com.hysonwayne.nahpiattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class NameGroups extends AppCompatActivity {

    Button addNewStudent, createGroups, goBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_groups);


        addNewStudent = findViewById(R.id.addNew);
        createGroups = findViewById(R.id.createGroups);
        goBack = findViewById(R.id.goBacker);

        /////////////
        addNewStudent.setOnClickListener(v -> startActivity(new Intent(NameGroups.this,RegisterStudents.class)));
        createGroups.setOnClickListener(v -> startActivity(new Intent(NameGroups.this,GroupHomescreen.class)));
        goBack.setOnClickListener(v -> startActivity(new Intent(NameGroups.this,mainscreen.class)));
    }
}
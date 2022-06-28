package com.hysonwayne.nahpiattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class GroupHomescreen extends AppCompatActivity {

    RadioGroup radioGroup;
    Button goBack;
    RadioButton radioButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_homescreen);
        goBack = findViewById(R.id.goBack);
        goBack.setOnClickListener(v -> startActivity(new Intent(GroupHomescreen.this,NameGroups.class)));

        radioGroup = findViewById(R.id.radioGroup);
       // textView = findViewById(R.id.groupOf);

        Button create = findViewById(R.id.createGroupss);
        create.setOnClickListener(v -> {
            int radioId = radioGroup.getCheckedRadioButtonId();

            radioButton = findViewById(radioId);

           // textView.setText("Groups of: " + radioButton.getText());
        });
    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this, "Creating Groups of "+radioButton.getText(),
                Toast.LENGTH_SHORT).show();
    }
}
//////////////////////////////////
package com.hysonwayne.nahpiattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hysonwayne.nahpiattendance.databinding.ActivityStudentsRegisterBinding;

public class RegisterStudents extends AppCompatActivity {

    ActivityStudentsRegisterBinding binding;
    String fullName, registrationNumber, department;
    FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentsRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.registerBt.setOnClickListener(v -> {

            fullName = binding.fullName.getText().toString();
            registrationNumber = binding.registrationNumber.getText().toString();
            department = binding.department.getText().toString();

            if (!fullName.isEmpty() && !registrationNumber.isEmpty() && !department.isEmpty()){

                Users users = new Users(fullName, registrationNumber, department);
                db = FirebaseDatabase.getInstance();
                reference = db.getReference("Users");
                reference.child(fullName).setValue(users).addOnCompleteListener(task -> {

                    binding.fullName.setText("");
                    binding.registrationNumber.setText("");
                    binding.department.setText("");
                    Toast.makeText(RegisterStudents.this,"Successfully Registered",Toast.LENGTH_SHORT).show();

                });

            }

        });
    }
}
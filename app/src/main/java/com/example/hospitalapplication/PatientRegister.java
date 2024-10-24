package com.example.hospitalapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PatientRegister extends AppCompatActivity {
    Helperclass dbHelper;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_patient_register);
        EditText nameInput = findViewById(R.id.input_name);
        EditText admissionDateInput = findViewById(R.id.input_admission_date);
        EditText ailmentInput = findViewById(R.id.input_ailment);
        EditText doctorNameInput = findViewById(R.id.input_doctor_name);
        Button registerButton = findViewById(R.id.button_register_patient);
        dbHelper = new Helperclass(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameInput.getText().toString();
                String admissionDate = admissionDateInput.getText().toString();
                String ailment = ailmentInput.getText().toString();
                String doctorName = doctorNameInput.getText().toString();
                dbHelper.addPatient(name, admissionDate, ailment, doctorName);
                Toast.makeText(PatientRegister.this, "Patient Registered!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
package com.example.hospitalapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UpdateStatusUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_status_ui);
        Helperclass dbHelper = new Helperclass(this);
        EditText idInput = findViewById(R.id.input_patient_id);
        EditText statusInput = findViewById(R.id.input_status);
        Button updateButton = findViewById(R.id.button_update_patient);

        updateButton.setOnClickListener(v -> {
            int id = Integer.parseInt(idInput.getText().toString());
            String status = statusInput.getText().toString();
            dbHelper.updatePatientStatus(id, status);
            Toast.makeText(UpdateStatusUI.this, "Patient Status Updated", Toast.LENGTH_SHORT).show();
            finish();
        });

    }
}


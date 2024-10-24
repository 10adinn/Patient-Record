package com.example.hospitalapplication;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hospitalapplication.Helperclass;
import com.example.hospitalapplication.R;

public class ViewPatients extends AppCompatActivity {
    Helperclass dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_patients);
        dbHelper = new Helperclass(this);
        TableLayout tableLayout = findViewById(R.id.table_patients);
        Cursor cursor = dbHelper.getAllPatients();

        while (cursor.moveToNext()) {
            TableRow row = new TableRow(this);
            TextView idText = new TextView(this);
            TextView nameText = new TextView(this);
            TextView admissionDateText = new TextView(this);
            TextView ailmentText = new TextView(this);
            TextView doctorNameText = new TextView(this);
            TextView statusText = new TextView(this);

            idText.setTextColor(Color.parseColor("#FF000000"));
            nameText.setTextColor(Color.parseColor("#FF000000"));
            admissionDateText.setTextColor(Color.parseColor("#FF000000"));
            ailmentText.setTextColor(Color.parseColor("#FF000000"));
            doctorNameText.setTextColor(Color.parseColor("#FF000000"));
            statusText.setTextColor(Color.parseColor("#FF000000"));


            idText.setText(cursor.getString(0));
            nameText.setText(cursor.getString(1));
            admissionDateText.setText(cursor.getString(2));
            ailmentText.setText(cursor.getString(3));
            doctorNameText.setText(cursor.getString(4));
            statusText.setText(cursor.getString(5));

            row.addView(idText);
            row.addView(nameText);
            row.addView(admissionDateText);
            row.addView(ailmentText);
            row.addView(doctorNameText);
            row.addView(statusText);
            tableLayout.addView(row);
        }
        cursor.close();
    }
}
package com.example.hospitalapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Helperclass extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "PatientDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "patients";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ADMISSION_DATE = "admission_date";
    private static final String COLUMN_AILMENT = "ailment";
    private static final String COLUMN_DOCTOR_NAME = "doctor_name";
    private static final String COLUMN_STATUS = "status";

    public Helperclass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_ADMISSION_DATE + " TEXT, " +
                COLUMN_AILMENT + " TEXT, " +
                COLUMN_DOCTOR_NAME + " TEXT, " +
                COLUMN_STATUS + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addPatient(String name, String admissionDate, String ailment, String doctorName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_ADMISSION_DATE, admissionDate);
        values.put(COLUMN_AILMENT, ailment);
        values.put(COLUMN_DOCTOR_NAME, doctorName);
        values.put(COLUMN_STATUS, "Admitted");
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void updatePatientStatus(int id, String status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_STATUS, status);
        db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public Cursor getAllPatients() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
}
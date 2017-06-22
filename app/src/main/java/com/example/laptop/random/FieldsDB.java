package com.example.laptop.random;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FieldsDB extends SQLiteOpenHelper {
    public final static String DATABASE_NAME = "Habits.db";
    public final static int DATABASE_VERSION = 1;


    public FieldsDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_STATEMENT = "CREATE TABLE " + Fields.FieldsEntry.TABLE_NAME
                + " (" + Fields.FieldsEntry.NAME + " TEXT NOT NULL, "
                + Fields.FieldsEntry.HABIT + " TEXT NOT NULL, "
                + Fields.FieldsEntry.AGE + " INTEGER NOT NULL);";
        db.execSQL(SQL_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}

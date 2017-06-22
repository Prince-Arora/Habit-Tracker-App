package com.example.laptop.random;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class UserQueries extends AppCompatActivity {
    FieldsDB mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mDbHelper = new FieldsDB(this);
        ArrayList<Custom> a = displayDatabaseInfo();
        UserAdapter b = new UserAdapter(this, a);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(b);
    }
    ArrayList<Custom> displayDatabaseInfo() {
        ArrayList<Custom> g = new ArrayList<>();
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                Fields.FieldsEntry.NAME, Fields.FieldsEntry.HABIT,
                Fields.FieldsEntry.AGE,
        };
        Cursor cursor = db.query(
                Fields.FieldsEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
        try {
            int INDEX1 = cursor.getColumnIndex(Fields.FieldsEntry.NAME);
            int INDEX2 = cursor.getColumnIndex(Fields.FieldsEntry.HABIT);
            int INDEX3 = cursor.getColumnIndex(Fields.FieldsEntry.AGE);
            while (cursor.moveToNext()) {
                String NAME = cursor.getString(INDEX1);
                String HOBBEY = cursor.getString(INDEX2);
                int AGE = cursor.getInt(INDEX3);
                String Age1 = AGE + "";
                g.add(new Custom(NAME,HOBBEY, Age1));
            }
        } finally {
            cursor.close();
        }
        return g;
    }
}

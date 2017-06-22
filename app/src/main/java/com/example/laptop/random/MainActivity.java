package com.example.laptop.random;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1;
    EditText edit2;
    EditText edit3;
    public  FieldsDB mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        edit3 = (EditText) findViewById(R.id.Edit3);
        Button t1 = (Button) findViewById(R.id.btn1);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UserQueries.class);
                startActivity(intent);
            }
        });
    }
    private void insertPet() {
        String name = edit1.getText().toString().trim();
        String habit = edit2.getText().toString().trim();
        String age = edit3.getText().toString().trim();
        int age1 = Integer.parseInt(age);
        mDbHelper = new FieldsDB(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Fields.FieldsEntry.NAME, name);
        values.put(Fields.FieldsEntry.HABIT, habit);
        values.put(Fields.FieldsEntry.AGE, age);
        long newRowId = db.insert(Fields.FieldsEntry.TABLE_NAME, null, values);
        if (newRowId == -1) {
            Toast.makeText(this, "Error in Inserting Data", Toast.LENGTH_SHORT).show();}
             else {
                Toast.makeText(this,"Properly Inserted", Toast.LENGTH_SHORT).show();
            }
    }
    public void Insert(View v)
    {
        insertPet();
    }
}

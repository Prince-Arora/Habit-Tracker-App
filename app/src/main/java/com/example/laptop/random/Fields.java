package com.example.laptop.random;


import android.provider.BaseColumns;

/**
 * Created by LAPTOP on 31-05-2017.
 */

public final class Fields {
    private Fields() {
    }

    public static final class FieldsEntry implements BaseColumns {
        public final static String TABLE_NAME = "Habit";
        public final static String NAME = "name";
        public final static String HABIT = "playing";
        public final static String AGE = "age";

    }
}

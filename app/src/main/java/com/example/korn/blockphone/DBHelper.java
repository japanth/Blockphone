package com.example.korn.blockphone;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Korn on 11/25/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "blockphone";
    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "blockphone";
    public static final String COL_NUMBER = "col_number";




    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NUMBER + " VARCHAR(255));");

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
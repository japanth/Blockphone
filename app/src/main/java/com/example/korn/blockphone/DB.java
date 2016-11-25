package com.example.korn.blockphone;

/**
 * Created by Korn on 11/25/2016.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class DB {


    public static void insertnumber(Context context, String number) {
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String sql = "INSERT INTO " + DBHelper.TABLE_NAME + "(" + DBHelper.COL_NUMBER + ") VALUES ('" + number + "')";
        db.execSQL(sql);

        db.close();
        dbHelper.close();

    }

    public static void deletenumber(Context context, String name) {

        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(DBHelper.TABLE_NAME, DBHelper.COL_NUMBER + " = '" + name + "'", null);

        db.close();
        dbHelper.close();


    }

}

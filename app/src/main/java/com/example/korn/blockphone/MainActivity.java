package com.example.korn.blockphone;

/**
 * Created by Korn on 11/25/2016.
 */
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText add;
    Button btn_addz,btn_del;
    TextView show;


    static SQLiteDatabase mDb;
    static DBHelper mHelper;
    static Cursor mCursor;
    static final ArrayList<String> dirArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (EditText) findViewById(R.id.editText_add);
        btn_addz = (Button) findViewById(R.id.btn_addz);



        btn_addz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,AddnumberActivity.class);
                startActivity(intent);
            }
        });

        mHelper = new DBHelper(this);
        mDb = mHelper.getWritableDatabase();
        mCursor = mDb.rawQuery("SELECT "+DBHelper.COL_NUMBER +" FROM " + DBHelper.TABLE_NAME  ,null);

        mCursor.moveToFirst();
        dirArray.clear();

        while ( !mCursor.isAfterLast() ){
            dirArray.add( mCursor.getString(mCursor.getColumnIndex(DBHelper.COL_NUMBER)));
            mCursor.moveToNext();
        }



        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), dirArray);

        ListView listView = (ListView)findViewById(R.id.listView1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, final int arg2, long arg3) {


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.dialog_title));
                builder.setMessage(getString(R.string.dialog_message4)+" "+dirArray.get(arg2)+" ?");

                String positiveText = "YES";
                builder.setPositiveButton(positiveText,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // positive button logic

                                DB.deletenumber(getApplicationContext(),dirArray.get(arg2));
                                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                                startActivity(intent);
                            }
                        });
                String negativeText = "NO";
                builder.setNegativeButton(negativeText,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // negative button logic
                            }
                        });
                AlertDialog dialog = builder.create();
                // display dialog
                dialog.show();



            }
        });


    }




}

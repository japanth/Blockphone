package com.example.korn.blockphone;

/**
 * Created by Korn on 11/25/2016.
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddnumberActivity extends AppCompatActivity {

    EditText add;
    ImageView btn_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnumber);

        add =  (EditText) findViewById(R.id.editText_add);
        btn_add = (ImageView) findViewById(R.id.btn_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String allString = add.getText().toString();
                if (allString.length() == 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddnumberActivity.this);
                    builder.setTitle(getString(R.string.dialog_title));
                    builder.setMessage(getString(R.string.dialog_message3));

                    String positiveText = getString(android.R.string.ok);
                    builder.setPositiveButton(positiveText,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // positive button logic
                                }
                            });

                    String negativeText = getString(android.R.string.cancel);
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

                } else {


                    String mString = add.getText().toString().substring(0, 1);


                    if (allString.length() < 10 && !mString.equals("0")) {

                        AlertDialog.Builder builder2 = new AlertDialog.Builder(AddnumberActivity.this);
                        builder2.setTitle(getString(R.string.dialog_title));
                        builder2.setMessage(getString(R.string.dialog_message3));

                        String positiveText2 = getString(android.R.string.ok);
                        builder2.setPositiveButton(positiveText2,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // positive button logic
                                    }
                                });

                        String negativeText2 = getString(android.R.string.cancel);
                        builder2.setNegativeButton(negativeText2,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // negative button logic
                                    }
                                });
                        AlertDialog dialog2 = builder2.create();
                        // display dialog
                        dialog2.show();

                    } else if (allString.length() < 10 && mString.equals("0")) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(AddnumberActivity.this);
                        builder.setTitle(getString(R.string.dialog_title));
                        builder.setMessage(getString(R.string.dialog_message));

                        String positiveText = getString(android.R.string.ok);
                        builder.setPositiveButton(positiveText,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // positive button logic
                                    }
                                });

                        String negativeText = getString(android.R.string.cancel);
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
                    } else if (!mString.equals("0")) {


                        AlertDialog.Builder builder = new AlertDialog.Builder(AddnumberActivity.this);
                        builder.setTitle(getString(R.string.dialog_title));
                        builder.setMessage(getString(R.string.dialog_message2));

                        String positiveText = getString(android.R.string.ok);
                        builder.setPositiveButton(positiveText,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // positive button logic
                                    }
                                });

                        String negativeText = getString(android.R.string.cancel);
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


                    } else {

                        DB.insertnumber(getApplicationContext(), "" + add.getText());

                        Intent intent = new Intent(AddnumberActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

    }
}

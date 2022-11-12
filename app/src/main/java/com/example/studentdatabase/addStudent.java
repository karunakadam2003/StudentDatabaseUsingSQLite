package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;

import java.security.PublicKey;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;





public class addStudent extends AppCompatActivity {
    EditText ename,eroll_no,eyear,PhNo;
    Button add;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        ename=(EditText)findViewById(R.id.editname);
        eroll_no=(EditText)findViewById(R.id.editroll);
        eyear=(EditText)findViewById(R.id.edityear);
        PhNo = (EditText)findViewById(R.id.editPhNo);

        add=(Button)findViewById(R.id.addbuttontodatabase);

        db=openOrCreateDatabase("studentDatabase", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS studentDatabase(rollno INTEGER,name VARCHAR,year INTEGER,phone INTEGER);");


        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(eroll_no.getText().toString().trim().length()==0||
                        ename.getText().toString().trim().length()==0||
                        eyear.getText().toString().trim().length()==0 ||PhNo.getText().toString().trim().length()==0)
                {
                    showMessage("Error", "Please enter all values");
                    return;
                }
                db.execSQL("INSERT INTO studentDatabase VALUES('"+eroll_no.getText()+"','"+ename.getText()+ "','"+eyear.getText()+"','"+PhNo.getText()+"');");
                showMessage("Success", "Record added successfully");
                clearText();
            }
        });



    }
    public void showMessage(String title,String message)
    {

        Builder builder=new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText()
    {
        eroll_no.setText("");
        ename.setText("");
        eyear.setText("");
        PhNo.setText("");

        eroll_no.requestFocus();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //   getMenuInflater().inflate(R.menu.student_main, menu);
        return true;
    }

}
package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class deleteStudent extends AppCompatActivity {

    EditText ename,eroll_no,eyear;
    Button delete;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);
        ename=(EditText)findViewById(R.id.editname);
        eroll_no=(EditText)findViewById(R.id.editroll);
        eyear=(EditText)findViewById(R.id.edityear);
        delete=(Button)findViewById(R.id.deleteToTheDatabasebtn);

        db=openOrCreateDatabase("studentDatabase", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS studentDatabase(rollno INTEGER,name VARCHAR,year INTEGER,phNo INTEGER);");





        delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(eroll_no.getText().toString().trim().length()==0)
                {
                    showMessage("Error", "Please enter Rollno");
                    return;
                }
                Cursor c=db.rawQuery("SELECT * FROM studentDatabase WHERE rollno='"+eroll_no.getText()+"'", null);
                if(c.moveToFirst())
                {
                    db.execSQL("DELETE FROM studentDatabase WHERE rollno='"+eroll_no.getText()+"'");
                    showMessage("Success", "Record Deleted");
                }
                else
                {
                    showMessage("Error", "Invalid Rollno");
                }

            }
        });


    }
    public void showMessage(String title,String message)
    {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
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


        eroll_no.requestFocus();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //   getMenuInflater().inflate(R.menu.student_main, menu);
        return true;
    }
}
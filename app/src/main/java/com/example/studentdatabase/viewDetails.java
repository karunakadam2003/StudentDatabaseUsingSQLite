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
import android.widget.TextView;

import org.w3c.dom.Text;

public class viewDetails extends AppCompatActivity {

    EditText eroll_no;
    TextView ename,eyear,PhNo;
    Button view;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        ename=(TextView)findViewById(R.id.editname);
        eroll_no=(EditText)findViewById(R.id.editroll);
        eyear=(TextView)findViewById(R.id.edityear);
        PhNo = (TextView)findViewById(R.id.editPhNo) ;
        view=(Button)findViewById(R.id.button2);

        db=openOrCreateDatabase("studentDatabase", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS studentDatabase(rollno INTEGER,name VARCHAR,year INTEGER,phNo INTEGER);");






        view.setOnClickListener(new View.OnClickListener() {

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
                    ename.setText(c.getString(1));
                    eroll_no.setText(c.getString(0));
                    eyear.setText(c.getString(2));
                    PhNo.setText(c.getString(3));



                }
                else
                {
                    showMessage("Error", "Invalid Rollno");
                    clearText();
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
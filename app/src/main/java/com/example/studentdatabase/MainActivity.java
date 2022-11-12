package com.example.studentdatabase;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView addStudent,  deleteStudent, findStudent, viewDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        System.out.println("Hello");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addStudent = (CardView)findViewById(R.id.add);
        deleteStudent = (CardView)findViewById(R.id.delete);
        findStudent = (CardView)findViewById(R.id.find);
        viewDetails = (CardView)findViewById(R.id.viewDetails);

        addStudent.setOnClickListener(this);
        deleteStudent.setOnClickListener(this);
        findStudent.setOnClickListener(this);
        viewDetails.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent i;


        switch (view.getId()){
            case R.id.add : i = new Intent(this,addStudent.class); startActivity(i);
                break;
            case R.id.delete : i = new Intent(this,deleteStudent.class);startActivity(i);
                break;
            case R.id.find : i = new Intent(this,updateStudent.class);startActivity(i);
                break;
            case R.id.viewDetails : i = new Intent(this,viewDetails.class);startActivity(i);
                break;
            default: break;
        }
    }

}
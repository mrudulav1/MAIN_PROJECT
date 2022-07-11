package com.example.digital_indenting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class student_home extends AppCompatActivity implements View.OnClickListener {
    Button prof,lab,attende,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);
        prof = (Button) findViewById(R.id.button);
        lab = (Button) findViewById(R.id.button3);
        attende = (Button) findViewById(R.id.button4);
        logout = (Button) findViewById(R.id.button5);
        prof.setOnClickListener(this);
        lab.setOnClickListener(this);
        attende.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==prof){
            Intent i = new Intent(getApplicationContext(),Profilr.class);
            startActivity(i);
        }
//        else if (view==lab){
//            Intent i = new Intent(getApplicationContext(),view_labequip.class);
//            startActivity(i);
//
//        }
        else if (view==attende){
            Intent i = new Intent(getApplicationContext(),my_attendence.class);
            startActivity(i);
        }
        else if (view==logout){
            Intent i = new Intent(getApplicationContext(),login.class);
            startActivity(i);
        }

    }
}
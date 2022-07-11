package com.example.digital_indenting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ip_connect extends AppCompatActivity implements View.OnClickListener {
    EditText et;
    Button btn_connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip_connect);
        et = findViewById(R.id.ipid);
        btn_connect = findViewById(R.id.ip_btn);
        btn_connect.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (et.getText().toString().length() == 0) {
            et.setError("Missing");
        } else {


            SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor ed = sh.edit();
            ed.putString("ip", et.getText().toString());
            ed.commit();

            Intent ii = new Intent(getApplicationContext(), login.class);
            startActivity(ii);

        }
    }
}
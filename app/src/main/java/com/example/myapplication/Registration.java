package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button reg=(Button) findViewById(R.id.button);




        reg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                EditText eu=(EditText) findViewById(R.id.editTextTextPersonName);
                EditText ep=(EditText) findViewById(R.id.editTextTextPassword);

                String un=eu.getText().toString();
                String pw=ep.getText().toString();

                Intent i=new Intent(getApplicationContext(),LoginPage.class);
                i.putExtra("username",un);
                i.putExtra("password",pw);
                startActivity(i);
            }
        });
    }
}
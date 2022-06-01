package com.example.myapplication.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
private Button start,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        start =findViewById(R.id.startButton);
        stop =findViewById(R.id.stopButton);


        start.setOnClickListener( this);
        stop.setOnClickListener( this);
    }

    @Override
    public void onClick(View view) {
        if (view == start){
            startService(new Intent(this,NewService.class));
        }
        else if (view == stop){
           stopService(new Intent(this,NewService.class));
        }

    }
}
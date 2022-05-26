package com.example.myapplication.samples;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.myapplication.R;

public class TimePickerActivity extends AppCompatActivity {
TimePicker picker;
Button btnGet;
TextView tvw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        picker=(TimePicker) findViewById(R.id.timePicker1);
        tvw=(TextView) findViewById(R.id.textview4);

        picker.setIs24HourView(true);
        btnGet=(Button) findViewById(R.id.button11);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
         int hour=1 ,minute=5 ;
         String am_pm;

         if (Build.VERSION.SDK_INT >=23){
             hour = picker.getHour();
             minute=picker.getMinute();

         }
         if (hour > 12){
             am_pm="PM";
             hour =hour -12;

         }
         else{
             am_pm="AM";
         }
         tvw.setText("Selected Hour:"+hour +":"+ minute+ " "+am_pm);
            }
        });
    }
}
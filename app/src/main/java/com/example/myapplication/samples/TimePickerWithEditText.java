package com.example.myapplication.samples;

import static androidx.appcompat.widget.AppCompatDrawableManager.get;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.myapplication.R;

import java.util.Calendar;

public class TimePickerWithEditText extends AppCompatActivity {
EditText eText;
TextView tvw;
Button btnGet;
TimePickerDialog picker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_with_edit_text);

        tvw=(TextView) findViewById(R.id.textview5);
        eText=(EditText) findViewById(R.id.editText1);

        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr=Calendar.getInstance();
                int hour=cldr.get(Calendar.HOUR_OF_DAY);
                int minutes=cldr.get(Calendar.MINUTE);


                 picker = new TimePickerDialog(TimePickerWithEditText.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                        eText.setText(sHour + ":" + sMinute);
                    }
                }, hour, minutes, true);
                picker.show();
            }
        });
        btnGet =(Button) findViewById(R.id.button12);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               tvw.setText("Selected Time:"+eText.getText());
            }
        });
    }
}
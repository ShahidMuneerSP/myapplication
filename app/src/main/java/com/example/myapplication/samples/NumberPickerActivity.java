package com.example.myapplication.samples;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.myapplication.R;

public class NumberPickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_picker);


        final TextView tv=(TextView) findViewById(R.id.tv);
        NumberPicker np=(NumberPicker) findViewById(R.id.np);

        tv.setTextColor(Color.parseColor("#ffd32b3b"));


        np.setMinValue(0);
        np.setMaxValue(10);

        np.setWrapSelectorWheel(true);
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker Picker, int oldVal, int newVal) {
              tv.setText("Selected Number:"+newVal);
            }
        });
    }
}
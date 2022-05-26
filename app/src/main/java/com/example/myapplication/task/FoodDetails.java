package com.example.myapplication.task;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.samples.ImageAdapter;

public class FoodDetails extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        GridView gv=(GridView) this.<View>findViewById(R.id.foodgrid);
        gv.setAdapter(new GridAdapter(this));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getApplicationContext(), "Image position:" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {

    }

    private void setAdapter(ImageAdapter imageAdapter) {

    }

}


package com.example.myapplication.samples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.myapplication.R;

public class GridImage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_image);

        GridView gv=(GridView) this.<View>findViewById(R.id.gridview);
        gv.setAdapter(new ImageAdapter(this));

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

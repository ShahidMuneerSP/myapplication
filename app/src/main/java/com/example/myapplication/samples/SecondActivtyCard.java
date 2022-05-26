package com.example.myapplication.samples;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class  SecondActivtyCard extends AppCompatActivity {
    ImageView selectedImage;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SetContentView(R.layout.activity_second_card);

        selectedImage =(ImageView) findViewById(R.id.selectedImage);
        Intent intent=getIntent();
        selectedImage.setImageResource(intent.getIntExtra("image",0));
    }

    private void SetContentView(int activity_second_card) {
    }
}

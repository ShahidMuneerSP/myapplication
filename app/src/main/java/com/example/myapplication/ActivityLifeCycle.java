package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ActivityLifeCycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
    }

    @Override 
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle","Onstart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle","OnResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle","OnPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle","OnStop invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle","OnDestroy invoked");
    }
}
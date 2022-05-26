package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ImplicitIntent extends AppCompatActivity {
EditText urled;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
        urled =(EditText) findViewById(R.id.gourl);

    }

    public void gotofacebook(View view) {
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
        startActivity(i);
    }



    public void gotourl(View view) {
        String url=urled.getText().toString();
        Intent i =new Intent(Intent.ACTION_VIEW,Uri.parse("https://www."+url+".com"));
        startActivity(i);
    }
}
package com.example.myapplication.samples;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.Manifest.permission;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

public class PhoneCallEx extends AppCompatActivity {
    private EditText txtPhone;
private Button btn;
    private int MY_PERMISSIONS_REQUEST_CALL_PHONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call_ex);

        txtPhone =(EditText) findViewById(R.id.mblTxt);
        btn =(Button) findViewById(R.id.btncall);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPhoneNumber();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions,  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode ==101){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                callPhoneNumber();
            }
        }
    }
    public void callPhoneNumber(){
        try{
            if(Build.VERSION.SDK_INT >22){
                if(ActivityCompat.checkSelfPermission(this, permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(PhoneCallEx.this,new String[]{ permission.CALL_PHONE},MY_PERMISSIONS_REQUEST_CALL_PHONE);
                    return;
                }
                Intent callIntent =new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+ txtPhone.getText().toString()));
                startActivity(callIntent);
            }else
            {
                Intent callIntent=new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+ txtPhone.getText().toString()));
                startActivity(callIntent);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
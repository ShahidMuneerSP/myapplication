package com.example.myapplication.samples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

public class SMSActivity extends AppCompatActivity {
EditText phonenumber,message;
Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsactivity);
        send=findViewById(R.id.button13);
        phonenumber=findViewById(R.id.editText);
        message=findViewById(R.id.editText1);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String number=phonenumber.getText().toString();
            String msg=message.getText().toString();
            try {
                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(number,null,msg,null,null);
                Toast.makeText(getApplicationContext(), "Message sent", Toast.LENGTH_LONG).show();
            }catch (Exception e){
                Toast.makeText(getApplicationContext(), "Some fields are empty", Toast.LENGTH_LONG).show();
            }
            }
        });
    }
}
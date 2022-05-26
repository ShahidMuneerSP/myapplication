package com.example.myapplication.samples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.myapplication.R;

public class WifiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        Button btn=(Button) findViewById(R.id.wifiSwitch);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
                    Intent panelIntent=new Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY);

                    startActivityForResult(panelIntent,0);
                }
                else{
                    WifiManager wifiManager=(WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
                    wifiManager.setWifiEnabled(true);
                }

            }
        });
    }

    }

package com.example.myapplication.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class BroadActivity extends Activity {
    TextView textview;
    Button button;
    IntentFilter intentFilter;
    int deviceStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad);

        button = (Button) findViewById(R.id.btn1);
        textview = (TextView) findViewById(R.id.textView1);
        intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFilter intentfilter = null;
                BroadActivity.this.registerReceiver(broadcastreciever, null);
            }
        });
    }
    private BroadcastReceiver broadcastreciever = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            deviceStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            if (deviceStatus == BatteryManager.BATTERY_STATUS_CHARGING) {
                textview.setText("Battery Status = Charging ");
            }
            if (deviceStatus == BatteryManager.BATTERY_STATUS_DISCHARGING) {
                textview.setText("Battery Status = Discharging ");
            }
            if (deviceStatus == BatteryManager.BATTERY_STATUS_FULL) {
                textview.setText("Battery Status = Battery Full");
            }
        }

    };
}

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
//import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

 import android.webkit.WebView;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import com.example.myapplication.notifications.ServiceActivity;
import com.example.myapplication.samples.BluetoothActivity;
import com.example.myapplication.samples.CameraActivity;
import com.example.myapplication.samples.CardWithRecycler;
import com.example.myapplication.samples.ContextMenuEx;
import com.example.myapplication.samples.FragmentExample;
import com.example.myapplication.samples.GridImage;
import com.example.myapplication.samples.LoginUsingShared;
import com.example.myapplication.samples.NetworkConnectivityActivity;
import com.example.myapplication.samples.PhoneCallEx;
import com.example.myapplication.samples.PopUpMenuEx;
import com.example.myapplication.samples.RecyclerViewDemo;
import com.example.myapplication.samples.SearchViewEx;
import com.example.myapplication.samples.SnackBar;
import com.example.myapplication.samples.SqliteWithoutOpenHelper;
import com.example.myapplication.samples.SubMenuEx;
import com.example.myapplication.samples.TimePickerActivity;
import com.example.myapplication.samples.TimePickerWithEditText;
import com.example.myapplication.samples.VideoActivity;
import com.example.myapplication.samples.WifiActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img= this.<ImageView>findViewById(R.id.splashimg);
        Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        img.startAnimation(anim);


//        Handler obj=new Handler();
//         obj.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent=new Intent(MainActivity.this,LoginPage.class);
//                startActivity(intent);
//            }
 //       },5000);
        Thread obj=new Thread(){
        public void run(){
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent=new Intent(getApplicationContext(), ServiceActivity.class);
                startActivity(intent);
            }
        };
        obj.start();
    }

}
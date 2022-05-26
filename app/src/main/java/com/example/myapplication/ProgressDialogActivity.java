package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

public class ProgressDialogActivity extends AppCompatActivity {
    Button b1;
    private ProgressDialog progress;
    private Object msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);
        b1 = (Button) findViewById(R.id.button1);
    }

    public void download(View view) {
        progress = new ProgressDialog(ProgressDialogActivity.this);
        progress.setMax(100);
        progress.setMessage("Downloading Music");
        progress.setTitle("ProgressDialog");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.show();
        progress.setCancelable(false);

        Handler handle =new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                progress.incrementProgressBy(2);
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (progress.getProgress() <= progress.getMax()){
                        Thread.sleep(2000);
                        handle.sendMessage(handle.obtainMessage());
                        if (progress.getProgress()==progress.getMax()){
                            progress.dismiss();
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

    }


}
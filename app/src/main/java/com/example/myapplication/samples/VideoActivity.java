package com.example.myapplication.samples;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.myapplication.R;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView videoView=(VideoView) findViewById(R.id.vdVw);

        MediaController mediaController=new MediaController(this);
        Uri uri=Uri.parse("android.resourse://"+getPackageName()+ "/" + R.raw.video_demo);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
    }
}
package com.example.movieplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List vdlist;
    private VideoView videoView;
    private int position;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        khoiTao();
        setControl();
        setEvent();
    }

    private void setEvent() {
        mediaController = new MediaController(this);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video1);
        mediaController.setAnchorView(videoView);
        mediaController.setPrevNextListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = "" + vdlist.get(position++);
                if (position > vdlist.size() - 1){
                    position = 0;
                }
                Uri nextUri = Uri.parse(s);
                videoView.setVideoURI(nextUri);
                videoView.start();
            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "" + vdlist.get(position--);
                if (position < vdlist.size() - 1){
                    position = 0;
                }
                Uri preUri = Uri.parse(s);
                videoView.setVideoURI(preUri);
                videoView.start();
            }
        });

        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (!(position < vdlist.size())) {
                    return;
                }
                String s = "" + vdlist.get(position++);
                Uri nextUri = Uri.parse(s);
                videoView.setVideoURI(nextUri);
                videoView.start();
            }
        });

    }

    private void setControl() {
        videoView = (VideoView) findViewById(R.id.videoView);
    }

    private void khoiTao() {
        vdlist = new ArrayList<>();
        vdlist.add("android.resource://" + getPackageName() + "/" + R.raw.video1);
        vdlist.add("android.resource://" + getPackageName() + "/" + R.raw.ironman);
        vdlist.add("android.resource://" + getPackageName() + "/" + R.raw.captain);

    }

}

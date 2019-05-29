package com.example.videolistview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    ListView listView;
    ArrayList<String> videoList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView)findViewById(R.id.videoView);
        listView = (ListView)findViewById(R.id.lvVideo);
        videoList = new ArrayList<>();
        videoList.add("video1");
        videoList.add("video2");
        videoList.add("video3");

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, videoList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.video1));
                        break;
                    case 1:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.video2));
                        break;
                    case 2:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.video3));
                        break;
                        default:
                            break;
                }
                videoView.setMediaController(new MediaController(MainActivity.this));
                videoView.requestFocus();
                videoView.start();
            }
        });
    }

}

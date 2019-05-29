package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

public class MenuGameActivity extends AppCompatActivity {

    TextView makeby;
    ImageButton btnBai3la, btnQuayBia, btnBauCua, btnXingau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_game_main);
        setControl();
        setNhapNhayMekaeBy();

        btnBai3la.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuGameActivity.this, Bai3LaActivity.class);
                startActivity(intent);
            }
        });

        btnQuayBia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuGameActivity.this, QuayChaiActivity.class);
                startActivity(intent);
            }
        });

        btnBauCua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuGameActivity.this, BauCuaActivity.class);
                startActivity(intent);
            }
        });

        btnXingau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuGameActivity.this, XiNgauActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setControl(){
        makeby = (TextView)findViewById(R.id.makeby);
        btnBai3la = (ImageButton)findViewById(R.id.imBtnBai3la);
        btnQuayBia = (ImageButton)findViewById(R.id.imBtnChaiBia);
        btnBauCua = (ImageButton)findViewById(R.id.imBtnBauCua);
        btnXingau = (ImageButton)findViewById(R.id.imBtnXingau);
    }

    public void setNhapNhayMekaeBy(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.nhapnho);
        makeby.startAnimation(animation);
    }
}

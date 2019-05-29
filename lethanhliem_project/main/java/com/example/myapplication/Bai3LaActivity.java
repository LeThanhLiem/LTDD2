package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bai3LaActivity extends AppCompatActivity {
    ImageView im1, im2, im3;
    List<Integer> card;
    TextView tv;
    int count = 0;
    int diem1, diem2;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baibala_main);
        im1 = findViewById(R.id.im1);
        im2 = findViewById(R.id.im2);
        im3 = findViewById(R.id.im3);
        btnBack = findViewById(R.id.btnBack);
        tv = findViewById(R.id.tvDiem);
        init();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai3LaActivity.this, MenuGameActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        card = new ArrayList<>();
        card.add(11);
        card.add(22);
        card.add(33);
        card.add(44);
        card.add(55);
        card.add(66);
        card.add(77);
        card.add(88);
        card.add(99);
        card.add(100);
        card.add(110);
        card.add(120);
        card.add(130);
    }

    private int setCard(int bai){
        int im = 0 ;
        switch (bai){
            case 11 :
                im = R.drawable.mot;
                break;
            case 22 :
                im = R.drawable.hai;
                break;
            case 33 :
                im = R.drawable.ba;
                break;
            case 44 :
                im = R.drawable.bon;
                break;
            case 55 :
                im = R.drawable.nam;
                break;
            case 66 :
                im = R.drawable.sau;
                break;
            case 77 :
                im = R.drawable.bay;
                break;
            case 88 :
                im = R.drawable.tam;
                break;
            case 99 :
                im = R.drawable.chin;
                break;
            case 100:
                im = R.drawable.muoi;
                break;
            case 110 :
                im = R.drawable.boi;
                break;
            case 120 :
                im = R.drawable.dam;
                break;
            case 130 :
                im = R.drawable.gia;
                break;
        }
        return im;
    }
    public void danhBai(){
        Collections.shuffle(card);
        im1.setImageResource(setCard(card.get(0)));
        im2.setImageResource(setCard(card.get(1)));
        im3.setImageResource(setCard(card.get(2)));
    }

    public void onChoi(View view) {

        if(count == 0){
            danhBai();
            tv.setText("Điểm của người thứ 1: " +(card.get(0)%10+ card.get(1)%10+card.get(2)%10)%10);
            diem1 = (card.get(0)%10+ card.get(1)%10+card.get(2)%10)%10;
            count++;

        }else if(count == 1){
            danhBai();
            tv.setText("Điểm của người thứ 2: " +(card.get(0)%10+ card.get(1)%10+card.get(2)%10)%10);
            diem2 = (card.get(0)%10+ card.get(1)%10+card.get(2)%10)%10;
            count++;
            if (diem1 > diem2){
                new AlertDialog.Builder(this)
                        .setTitle("")
                        .setMessage("Người thứ 2 đã thua! " +
                                "Mời người thứ 2 nhấn nút OK để tới hình phạt!")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Bai3LaActivity.this, result.class);
                                startActivity(intent);
                            }
                        })

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
            else if (diem1 < diem2){
                new AlertDialog.Builder(this)
                        .setTitle("")
                        .setMessage("Người thứ 1 đã thua! " +
                                "Mời người thứ 1 nhấn nút OK để tới hình phạt!")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Bai3LaActivity.this, result.class);
                                startActivity(intent);
                            }
                        })

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }



        }
        else if(count > 1)
            new AlertDialog.Builder(this)
                    .setTitle("")
                    .setMessage("Hết lượt mời bạn nhấn nút Chơi Lại !")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Continue with delete operation
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();


    }

    public void onChoiLai(View view){
        count = 0;
        im1.setImageResource(R.drawable.mausau);
        im2.setImageResource(R.drawable.mausau);
        im3.setImageResource(R.drawable.mausau);
    }
}

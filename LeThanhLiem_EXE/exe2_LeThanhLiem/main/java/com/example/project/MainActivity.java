package com.example.project;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView dice_img, dice_img1;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private DiceAdapter adapter;
    private List<Dices> DicesData;
    private Random random = new Random();
    private int lastDir, lastDir1;
    private boolean role_dice, role_dice1;
    private SensorManager sensorManager;
    private float vibrate = 0;
    private Sensor sensor;
    private int valueDice1, valueDice2;
    private float lastX, lastY, lastZ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        setAdapter();
        setSensor();
    }

    public void setControl() {
        dice_img = (ImageView) findViewById(R.id.dice);
        dice_img1 = (ImageView) findViewById(R.id.dice1);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
    }

    public void setEvent(){
        DicesData = new ArrayList<>();
        adapter = new DiceAdapter(this, DicesData);

    }

    public void rollDice() {
        if (!role_dice) {
            int randomNum = random.nextInt(6) + 1;

            float pivotX = dice_img.getWidth() / 2;
            float pivotY = dice_img.getHeight() / 2;

            Animation rotate = new RotateAnimation(lastDir, randomNum, pivotX, pivotY);
            rotate.setDuration(100);
            rotate.setFillAfter(true);

            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    role_dice1 = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    role_dice1 = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            lastDir = randomNum;
            dice_img.startAnimation(rotate);

            switch (randomNum) {
                case 1:
                    dice_img.setImageResource(R.drawable.dice_black_1);
                    valueDice1 = 1;
                    break;
                case 2:
                    dice_img.setImageResource(R.drawable.dice_black_2);
                    valueDice1 = 2;
                    break;
                case 3:
                    dice_img.setImageResource(R.drawable.dice_black_3);
                    valueDice1 = 3;
                    break;
                case 4:
                    dice_img.setImageResource(R.drawable.dice_black_4);
                    valueDice1 = 4;
                    break;
                case 5:
                    dice_img.setImageResource(R.drawable.dice_black_5);
                    valueDice1 = 5;
                    break;
                case 6:
                    dice_img.setImageResource(R.drawable.dice_black_6);
                    valueDice1 = 6;
                    break;
            }
        }
    }

    public void rollDice1() {
        if (!role_dice1) {
            int randomNum = random.nextInt(6) + 1;

            float pivotX = dice_img.getWidth() / 2;
            float pivotY = dice_img.getHeight() / 2;

            Animation rotate = new RotateAnimation(lastDir1, randomNum, pivotX, pivotY);
            rotate.setDuration(100);
            rotate.setFillAfter(true);

            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    role_dice = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    role_dice = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            lastDir1 = randomNum;
            dice_img1.startAnimation(rotate);

            switch (randomNum) {
                case 1:
                    dice_img1.setImageResource(R.drawable.dice_black_1);
                    valueDice2 = 1;
                    break;
                case 2:
                    dice_img1.setImageResource(R.drawable.dice_black_2);
                    valueDice2 = 2;
                    break;
                case 3:
                    dice_img1.setImageResource(R.drawable.dice_black_3);
                    valueDice2 = 3;
                    break;
                case 4:
                    dice_img1.setImageResource(R.drawable.dice_black_4);
                    valueDice2 = 4;
                    break;
                case 5:
                    dice_img1.setImageResource(R.drawable.dice_black_5);
                    valueDice2 = 5;
                    break;
                case 6:
                    dice_img1.setImageResource(R.drawable.dice_black_6);
                    valueDice2 = 6;
                    break;
            }
        }
    }

    public void setAdapter(){
            recyclerView = findViewById(R.id.recycler);
            layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(layoutManager);
            adapter = new DiceAdapter(this, (ArrayList<Dices>) DicesData, R.layout.recyclerview_row_item);
            recyclerView.setAdapter(adapter);
    }

    private void setSensor() {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(sensor.TYPE_ACCELEROMETER) != null) {
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener((SensorEventListener) this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
            vibrate = sensor.getMaximumRange() / 2;
        }
    }

    public void letShake(SensorEvent event){
        float x = Math.abs(lastX - event.values[0]);
        float y = Math.abs(lastY - event.values[1]);
        float z = Math.abs(lastZ - event.values[2]);

        if (x > vibrate){
            rollDice();
            rollDice1();
        }
        else if (y > vibrate){
            rollDice1();
            rollDice();
        }
        else{
            rollDice1();
            rollDice();
        }

        lastY = event.values[1];
        lastZ = event.values[2];
        lastX = event.values[0];
    }

    public void onSensorChanged(SensorEvent event){
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            letShake(event);
        }
    }
}

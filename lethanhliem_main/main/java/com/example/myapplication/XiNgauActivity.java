package com.example.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class XiNgauActivity extends AppCompatActivity {

    private ImageView dice_img;
    private Random random = new Random();
    private int lastDir;
    private boolean role_dice;
    private SensorManager sm;
    private float acelVal;
    private float acelLast;
    private float shake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xingau_main);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        acelVal = SensorManager.GRAVITY_EARTH;
        acelLast = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;

        setControl();
        setEvent();
    }

    public void setControl() {
        dice_img = (ImageView) findViewById(R.id.dice);
    }

    public void setEvent() {
        dice_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
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

            lastDir = randomNum;
            dice_img.startAnimation(rotate);

            switch (randomNum) {
                case 1:
                    dice_img.setImageResource(R.drawable.dice_black_1);
                    Toast.makeText(this, "you role one :>", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    dice_img.setImageResource(R.drawable.dice_black_2);
                    Toast.makeText(this, "you role two :>", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    dice_img.setImageResource(R.drawable.dice_black_3);
                    Toast.makeText(this, "you role three :>", Toast.LENGTH_SHORT).show();
                    break;
                case 4:
                    dice_img.setImageResource(R.drawable.dice_black_4);
                    Toast.makeText(this, "you role four :>", Toast.LENGTH_SHORT).show();
                    break;
                case 5:
                    dice_img.setImageResource(R.drawable.dice_black_5);
                    Toast.makeText(this, "you role five :>", Toast.LENGTH_SHORT).show();
                    break;
                case 6:
                    dice_img.setImageResource(R.drawable.dice_black_6);
                    Toast.makeText(this, "you role six :>", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    private final SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            acelLast = acelVal;
            acelVal = ((float) Math.sqrt((double) x * x + y * y + z * z));
            float delta = acelVal - acelLast;
            shake = shake * 0.9f + delta;

            if (shake > 5) {
                rollDice();
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

    };
}
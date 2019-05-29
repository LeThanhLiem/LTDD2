package com.example.exe3_animation;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewGroup transitionContainer;
    private TextView textView;
    private Button button;
    private ImageView imTornado, imStrike, imGoku, imThanos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    public void setControl(){
        transitionContainer = (ViewGroup)findViewById(R.id.transaction_container);
        textView = (TextView)findViewById(R.id.text);
        button = (Button)findViewById(R.id.btnStart);
        imTornado = (ImageView)findViewById(R.id.imTonardo);
        imStrike = (ImageView)findViewById(R.id.imStrike);
        imGoku = (ImageView)findViewById(R.id.goku);
        imThanos = (ImageView)findViewById(R.id.enemy);
    }

    public void setEvent(){
        button.setOnClickListener(new View.OnClickListener() {

            boolean visible;
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(transitionContainer);
                visible = !visible;
                imGoku.setVisibility(visible ? View.VISIBLE : View.GONE);
                imTornado.setVisibility(visible ? View.VISIBLE : View.GONE);
                imStrike.setVisibility(visible ? View.VISIBLE : View.GONE);
                imTornado.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setAnimationTornadoTimes();
                        setAnimationGoku();
                        setAnimationStrike();
                        setAnimationEnemy();
                    }
                });

            }
        });
    }

    public void setAnimationStrike(){
        TranslateAnimation animationStrike = new TranslateAnimation(0f, 1000f, 0f, 00f);
        animationStrike.setDuration(2000);
        animationStrike.setRepeatMode(Animation.REVERSE);
        //animationStrike.setRepeatCount(Animation.INFINITE);
        imStrike.startAnimation(animationStrike);
    }

    private void setAnimationTornadoTimes(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.quay);
        imTornado.startAnimation(animation);
    }

    private void setAnimationGoku(){
        TranslateAnimation animationPlane = new TranslateAnimation(0f, 500f, 0f, 00f);
        animationPlane.setDuration(2000);
        imGoku.startAnimation(animationPlane);
    }

    private void setAnimationEnemy(){
        Animation animationEnemy = AnimationUtils.loadAnimation(this, R.anim.fadeout);
        imThanos.startAnimation(animationEnemy);
    }
}

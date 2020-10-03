package com.rolladice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class PlayVersus extends AppCompatActivity {


    private static final Random RANDOM = new Random();
    private long mLastClickTime = 0;
    private Button roll;
    private Button exit;
    private Button reset;
    private ImageView imageViewPC, imageViewYou;
    private TextView textViewResultYou, textViewResultPC;

    int value;
    int value2;

    public static  int randomValue(){
        return RANDOM.nextInt(6) +1;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_versus);
        roll = (Button) findViewById(R.id.buttonRoll);
        exit = (Button) findViewById(R.id.buttonExit);
        reset = (Button) findViewById(R.id.buttonReset);
        imageViewPC = (ImageView) findViewById(R.id.imageViewPC);
        imageViewYou = (ImageView) findViewById(R.id.imageViewYou);
        textViewResultYou = (TextView) findViewById(R.id.textViewResultYou);
        textViewResultPC = (TextView) findViewById(R.id.textViewResultPC);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.rollingsound);


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayVersus.this, MainActivity.class);
                startActivity(intent);
            }
        });


        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (SystemClock.elapsedRealtime() - mLastClickTime < 1200){
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                final Animation animation1 = AnimationUtils.loadAnimation(PlayVersus.this, R.anim.shake);
                final Animation animation2 = AnimationUtils.loadAnimation(PlayVersus.this, R.anim.shake);
                value = randomValue();
                value2 = randomValue();
                mp.start();
                final Animation.AnimationListener animationListener = new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        int res = getResources().getIdentifier("dice_"+ value, "drawable", "com.rolladice");
                        int res2 = getResources().getIdentifier("dice_"+ value2, "drawable", "com.rolladice");

                        if(animation == animation2){
                            imageViewYou.setImageResource(res);
                            imageViewPC.setImageResource(res2);
                        }
                    }
                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                };

                animation1.setAnimationListener(animationListener);
                animation2.setAnimationListener(animationListener);

                imageViewPC.startAnimation(animation2);
                imageViewYou.startAnimation(animation2);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        String staropomYou = textViewResultYou.getText().toString();
                        String staropomPC = textViewResultPC.getText().toString();
                        int staroYou = Integer.parseInt(staropomYou);
                        int staroPC = Integer.parseInt(staropomPC);
                        if(value > value2){
                            staroYou = staroYou+1;
                            textViewResultYou.setText(String.valueOf(staroYou));
                        }
                        else if(value2 > value){
                            staroPC = staroPC+1;
                            textViewResultPC.setText(String.valueOf(staroPC));
                        }

                    }
                }, 600);
            }

        });



        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PlayVersus.this, PlayVersus.class);
                startActivity(intent);
            }
        });

        
    }
}

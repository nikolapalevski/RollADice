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

public class PlayYamb extends AppCompatActivity {

    public static final Random RANDOM = new Random();
    private long mLastClickTime = 0;
    private Button roll;
    private Button exit;
    private Button reset;
    private Button extra;
    int br = 3;
    boolean f1= false;
    boolean f2= false;
    boolean f3= false;
    boolean f4= false;
    boolean f5= false;
    boolean f6= false;

    boolean v1= true;
    boolean v2= true;
    boolean v3= true;
    boolean v4= true;
    boolean v5= true;
    boolean v6= true;

    int pom1 = 0;
    int pom2= 0;
    int pom3 = 0;
    int pom4 = 0;
    int pom5 = 0;
    int pom6 = 0;

    boolean vlegov1 = false;
    boolean vlegov2 = false;
    boolean vlegov3 = false;
    boolean vlegov4 = false;
    boolean vlegov5 = false;
    boolean vlegov6 = false;
    private ImageView imageView, imageView2, imageView3, imageView4, imageView5, imageView6;
    private TextView textViewRolls;

    public static  int randomValue(){
        return RANDOM.nextInt(6) +1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_yamb);
        roll = (Button) findViewById(R.id.rollButton);
        exit = (Button) findViewById(R.id.exitButton);
        reset = (Button) findViewById(R.id.resetButton);
        extra = (Button) findViewById(R.id.extraButton);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        textViewRolls = (TextView) findViewById(R.id.textViewRolls);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.rollingsound);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayYamb.this, MainActivity.class);
                startActivity(intent);
            }
        });

        extra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(br== 3){
                    br= br+2;
                    textViewRolls.setText("You have "+br +" rolls left !");
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayYamb.this, PlayYamb.class);
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
                br--;
                extra.setEnabled(false);

                if (br >= 0) {

                    if(f1==false || f2==false || f3==false || f4==false || f5==false || f6==false){
                        mp.start();
                    }

                    textViewRolls.setText("You have "+br +" rolls left !");

                    final Animation animation1 = AnimationUtils.loadAnimation(PlayYamb.this, R.anim.shake);
                    final Animation animation2 = AnimationUtils.loadAnimation(PlayYamb.this, R.anim.shake);

                    final Animation.AnimationListener animationListener = new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            final int[] r1 = {randomValue()};
                            final int[] r2 = {randomValue()};
                            final int[] r3 = {randomValue()};
                            final int[] r4 = {randomValue()};
                            final int[] r5 = {randomValue()};
                            final int[] r6 = {randomValue()};

                            int res =0;


                            imageView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    if(f1==true && v1==false) {
                                        if(vlegov1) {
                                            imageView.setImageResource(getResources().getIdentifier("dice_"+ pom1, "drawable", "com.rolladice"));
                                            vlegov1=false;
                                            f1=false;
                                            v1=true;
                                            r1[0] =pom1;
                                        }
                                    }
                                    else{
                                        f1=true;
                                        v1=false;
                                        imageView.setImageResource(getResources().getIdentifier("dice_"+ r1[0] + "b", "drawable", "com.rolladice"));
                                        pom1 = r1[0];
                                        vlegov1 = true;
                                    }
                                }
                            });

                            imageView2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    if(f2==true && v2==false) {
                                        if(vlegov2) {
                                            imageView2.setImageResource(getResources().getIdentifier("dice_"+ pom2, "drawable", "com.rolladice"));
                                            vlegov2=false;
                                            f2=false;
                                            v2=true;
                                            r2[0] =pom2;
                                        }
                                    }
                                    else{
                                        f2=true;
                                        v2=false;
                                        imageView2.setImageResource(getResources().getIdentifier("dice_"+ r2[0] + "b", "drawable", "com.rolladice"));
                                        pom2 = r2[0];
                                        vlegov2 = true;
                                    }
                                }
                            });

                            imageView3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    if(f3==true && v3==false) {
                                        if(vlegov3) {
                                            imageView3.setImageResource(getResources().getIdentifier("dice_"+ pom3, "drawable", "com.rolladice"));
                                            vlegov3=false;
                                            f3=false;
                                            v3=true;
                                            r3[0] =pom3;
                                        }
                                    }
                                    else{
                                        f3=true;
                                        v3=false;
                                        imageView3.setImageResource(getResources().getIdentifier("dice_"+ r3[0] + "b", "drawable", "com.rolladice"));
                                        pom3 = r3[0];
                                        vlegov3 = true;
                                    }
                                }
                            });

                            imageView4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    if(f4==true && v4==false) {
                                        if(vlegov4) {
                                            imageView4.setImageResource(getResources().getIdentifier("dice_"+ pom4, "drawable", "com.rolladice"));
                                            vlegov4=false;
                                            f4=false;
                                            v4=true;
                                            r4[0] =pom4;
                                        }
                                    }
                                    else{
                                        f4=true;
                                        v4=false;
                                        imageView4.setImageResource(getResources().getIdentifier("dice_"+ r4[0] + "b", "drawable", "com.rolladice"));
                                        pom4 = r4[0];
                                        vlegov4 = true;
                                    }
                                }
                            });

                            imageView5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    if(f5==true && v5==false) {
                                        if(vlegov5) {
                                            imageView5.setImageResource(getResources().getIdentifier("dice_"+ pom5, "drawable", "com.rolladice"));
                                            vlegov5=false;
                                            f5=false;
                                            v5=true;
                                            r5[0] =pom5;
                                        }
                                    }
                                    else{
                                        f5=true;
                                        v5=false;
                                        imageView5.setImageResource(getResources().getIdentifier("dice_"+ r5[0] + "b", "drawable", "com.rolladice"));
                                        pom5 = r5[0];
                                        vlegov5 = true;
                                    }
                                }
                            });

                            imageView6.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    if(f6==true && v6==false) {
                                        if(vlegov6) {
                                            imageView6.setImageResource(getResources().getIdentifier("dice_"+ pom6, "drawable", "com.rolladice"));
                                            vlegov6=false;
                                            f6=false;
                                            v6=true;
                                            r6[0] =pom6;
                                        }
                                    }
                                    else{
                                        f6=true;
                                        v6=false;
                                        imageView6.setImageResource(getResources().getIdentifier("dice_"+ r6[0] + "b", "drawable", "com.rolladice"));
                                        pom6 = r6[0];
                                        vlegov6 = true;
                                    }
                                }
                            });

                            res = getResources().getIdentifier("dice_" + r1[0], "drawable", "com.rolladice");

                            int res2 = getResources().getIdentifier("dice_" + r2[0], "drawable", "com.rolladice");
                            int res3 = getResources().getIdentifier("dice_" + r3[0], "drawable", "com.rolladice");
                            int res4 = getResources().getIdentifier("dice_" + r4[0], "drawable", "com.rolladice");
                            int res5 = getResources().getIdentifier("dice_" + r5[0], "drawable", "com.rolladice");
                            int res6 = getResources().getIdentifier("dice_" + r6[0], "drawable", "com.rolladice");

                            if (animation == animation2) {

                                if(f1== false && v1==true) {
                                    imageView.setImageResource(res);
                                }
                                if(f2== false && v2==true) {
                                    imageView2.setImageResource(res2);
                                }
                                if(f3== false && v3==true) {
                                    imageView3.setImageResource(res3);
                                }
                                if(f4== false && v4==true) {
                                    imageView4.setImageResource(res4);
                                }
                                if(f5== false && v5==true) {
                                    imageView5.setImageResource(res5);
                                }
                                if(f6== false && v6==true) {
                                    imageView6.setImageResource(res6);
                                }
                            }
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    };

                    animation1.setAnimationListener(animationListener);
                    animation2.setAnimationListener(animationListener);

                    if(f1== false && v1 == true){
                        imageView.startAnimation(animation2);
                    }
                    if(f2== false && v2 == true){
                        imageView2.startAnimation(animation2);
                    }
                    if(f3== false && v3 == true){
                        imageView3.startAnimation(animation2);
                    }
                    if(f4== false && v4 == true){
                        imageView4.startAnimation(animation2);
                    }
                    if(f5== false && v5 == true){
                        imageView5.startAnimation(animation2);
                    }
                    if(f6== false && v6 == true){
                        imageView6.startAnimation(animation2);
                    }
                }

                if(f1 && f2 && f3 && f4 && f5 && f6){
                    br = br+1;
                    textViewRolls.setText("You have "+br +" rolls left !");
                }
                if(br < 0 ){
                    textViewRolls.setText("You have 0 rolls left !");
                }

            }
        });


    }
}

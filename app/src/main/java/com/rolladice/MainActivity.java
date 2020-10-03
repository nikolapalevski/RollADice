package com.rolladice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button playVersus;
    private Button playYamb;
    private Button desktop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        playVersus = findViewById(R.id.playVersus);
        playYamb = findViewById(R.id.playYamb);
        desktop = findViewById(R.id.buttonDesktop);
        playVersus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToPlayVersus();
            }
        });
        playYamb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToPlayYamb();
            }
        });
        desktop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://roll-a-dice.netlify.app/"));
                startActivity(intent);
            }
        });

    }

    private void moveToPlayVersus(){

        Intent intent = new Intent(MainActivity.this, PlayVersus.class);
        startActivity(intent);
    }
    private void moveToPlayYamb(){
        Intent intent = new Intent(MainActivity.this, PlayYamb.class);
        startActivity(intent);
    }

}

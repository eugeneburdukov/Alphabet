package com.alphabet.alphabet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button11;
    Button button12;
    Button button13;
    MediaPlayer mediaPlayer;
    ImageView imageView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button11 = findViewById(R.id.button11);
        button11.setOnClickListener(this);
        button12 = findViewById(R.id.button12);
        button12.setOnClickListener(this);
        button13 = findViewById(R.id.button13);
        button13.setOnClickListener(this);
        imageView1 = findViewById(R.id.imageView1);
        imageView1.setOnClickListener(this);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this, R.raw.abcsong);
        mediaPlayer.start();
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.button11:
                mediaPlayer.stop();
                intent = new Intent(MainActivity.this, StudyActivity.class);
                startActivity(intent);
                break;
            case R.id.button12:
                mediaPlayer.stop();
                intent = new Intent(MainActivity.this, TestActivity.class);
                startActivity(intent);
                break;
            case R.id.button13:
                mediaPlayer.stop();
                intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.imageView1:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                } else {
                    mediaPlayer = MediaPlayer.create(this, R.raw.abcsong);
                    mediaPlayer.start();
                }
        }
    }
}
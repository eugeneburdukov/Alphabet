package com.alphabet.alphabet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonLearning;
    Button buttonExercising;
    Button buttonAbout;
    MediaPlayer mediaPlayer;
    ImageView imageView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLearning = findViewById(R.id.button11);
        buttonLearning.setOnClickListener(this);
        buttonExercising = findViewById(R.id.button12);
        buttonExercising.setOnClickListener(this);
        buttonAbout = findViewById(R.id.button13);
        buttonAbout.setOnClickListener(this);
        imageView1 = findViewById(R.id.imageView1);
        imageView1.setOnClickListener(this);

        /*mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this, R.raw.abcsong);
        mediaPlayer.start();*/
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.button11:
//                mediaPlayer.stop();
                intent = new Intent(MainActivity.this, ExerciseActivityNew.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
            case R.id.button12:
//                mediaPlayer.stop();
/*                intent = new Intent(MainActivity.this, ExerciseActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);*/
                break;
            case R.id.button13:
                intent = new Intent(MainActivity.this, TestDesignActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
            /*    break;
            case R.id.imageView1:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                } else {
                    mediaPlayer = MediaPlayer.create(this, R.raw.abcsong);
                    mediaPlayer.start();
                }*/
        }
    }
}
package com.alphabet.alphabet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StudyActivity extends AppCompatActivity implements View.OnClickListener{
    Button buttonPrevious;
    Button buttonPlay;
    Button buttonNext;
    TextView textHome;
    ImageView imageLetter;
    int index;
    int[] images = new int[]{R.drawable.anew, R.drawable.bnew, R.drawable.cnew,
            R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h,
            R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l, R.drawable.m,
            R.drawable.n, R.drawable.o, R.drawable.p, R.drawable.q, R.drawable.r,
            R.drawable.s, R.drawable.t, R.drawable.u, R.drawable.v, R.drawable.w,
            R.drawable.x, R.drawable.y, R.drawable.z};
    int[] sounds = new int[]{R.raw.a, R.raw.b, R.raw.c, R.raw.d, R.raw.e, R.raw.f,
            R.raw.g, R.raw.h, R.raw.i, R.raw.j, R.raw.k, R.raw.l, R.raw.m, R.raw.n,
            R.raw.o, R.raw.p, R.raw.q, R.raw.r, R.raw.s, R.raw.t, R.raw.u, R.raw.v,
            R.raw.w, R.raw.x, R.raw.y, R.raw.z};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        index = 0;
        buttonPrevious = findViewById(R.id.buttonPrevious);
        buttonPrevious.setOnClickListener(this);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(this);
        buttonNext = findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(this);
        imageLetter = findViewById(R.id.imageViewLetternextgen1);
        imageLetter.setImageResource(images[index]);
        textHome = findViewById(R.id.hometext);
        textHome.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.buttonPrevious:
                if (index > 0) {
                    index--;
                    imageLetter.setImageResource(images[index]);
                } else {
                    buttonPrevious.setEnabled(false);
                }
                if (!buttonNext.isEnabled()) {
                    buttonNext.setEnabled(true);
                }
                break;
            case R.id.buttonPlay:
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer = MediaPlayer.create(this, sounds[index]);
                mediaPlayer.start();
                break;
            case R.id.buttonNext:
                if (index < 25) {
                    index++;
                    imageLetter.setImageResource(images[index]);
                } else {
                    buttonNext.setEnabled(false);
                }
                if (!buttonPrevious.isEnabled()) {
                    buttonPrevious.setEnabled(true);
                }
                break;
            case R.id.hometext:
                intent = new Intent(StudyActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }
    }
}
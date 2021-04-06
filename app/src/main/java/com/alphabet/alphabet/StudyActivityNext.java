package com.alphabet.alphabet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class StudyActivityNext extends AppCompatActivity implements View.OnClickListener {
    Button buttonnext1;
    Button buttonnext2;
    Button buttonnext3;
    ImageView imageView;
    int index;
    int[] images = new int[]{R.drawable.a, R.drawable.b, R.drawable.c,
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
        setContentView(R.layout.activity_study_layout);

        buttonnext1 = findViewById(R.id.button21);
        buttonnext1.setOnClickListener(this);
        buttonnext2 = findViewById(R.id.button22);
        buttonnext2.setOnClickListener(this);
        buttonnext3 = findViewById(R.id.button23);
        buttonnext3.setOnClickListener(this);
        imageView = findViewById(R.id.imageViewLetter21);
        index = 0;
        imageView.setImageResource(images[index]);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.button21:
                if (index > 0) {
                    index--;
                    imageView.setImageResource(images[index]);
                } else {
                    buttonnext1.setEnabled(false);
                }
                if (!buttonnext3.isEnabled()) {
                    buttonnext3.setEnabled(true);
                }
                break;
            case R.id.button22:
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer = MediaPlayer.create(this, sounds[index]);
                mediaPlayer.start();
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Жми кнопку 'ЗВУК', повторяй за мной!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
                break;
            case R.id.button23:
                if (index < 25) {
                    index++;
                    imageView.setImageResource(images[index]);
                } else {
                    buttonnext3.setEnabled(false);
                }
                if (!buttonnext1.isEnabled()) {
                    buttonnext1.setEnabled(true);
                }
        }
    }
}
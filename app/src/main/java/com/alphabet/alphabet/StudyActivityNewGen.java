package com.alphabet.alphabet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class StudyActivityNewGen extends AppCompatActivity implements View.OnClickListener{
    Button buttonnextgen1;
    Button buttonnextgen2;
    Button buttonnextgen3;
    TextView hometext;
    ImageView imageViewLetternextgen1;
    int index;
    int[] images = new int[]{R.drawable.abcnew, R.drawable.bnew, R.drawable.cnew,
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
        setContentView(R.layout.activity_study_new_gen_layout);

        buttonnextgen1 = findViewById(R.id.buttonnextgen1);
        buttonnextgen1.setOnClickListener(this);
        buttonnextgen2 = findViewById(R.id.buttonnextgen2);
        buttonnextgen2.setOnClickListener(this);
        buttonnextgen3 = findViewById(R.id.buttonnextgen3);
        buttonnextgen3.setOnClickListener(this);
        imageViewLetternextgen1 = findViewById(R.id.imageViewLetternextgen1);
        index = 0;
        imageViewLetternextgen1.setImageResource(images[index]);
        hometext = findViewById(R.id.hometext);
        hometext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.buttonnextgen1:
                if (index > 0) {
                    index--;
                    imageViewLetternextgen1.setImageResource(images[index]);
                } else {
                    buttonnextgen1.setEnabled(false);
                }
                if (!buttonnextgen3.isEnabled()) {
                    buttonnextgen3.setEnabled(true);
                }
                break;
            case R.id.buttonnextgen2:
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer = MediaPlayer.create(this, sounds[index]);
                mediaPlayer.start();
                /*Toast toast = Toast.makeText(getApplicationContext(),
                        "Жми кнопку 'ЗВУК', повторяй за мной!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();*/
                break;
            case R.id.buttonnextgen3:
                if (index < 25) {
                    index++;
                    imageViewLetternextgen1.setImageResource(images[index]);
                } else {
                    buttonnextgen3.setEnabled(false);
                }
                if (!buttonnextgen1.isEnabled()) {
                    buttonnextgen1.setEnabled(true);
                }
                break;
            case R.id.hometext:
                intent = new Intent(StudyActivityNewGen.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }
    }
}
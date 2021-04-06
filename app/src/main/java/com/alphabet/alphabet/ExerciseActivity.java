package com.alphabet.alphabet;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExerciseActivity extends AppCompatActivity implements View.OnClickListener {
    Button button31;
    Button button32;
    Button button33;
    ImageView imageView3;
    TextView textView32;
    TextView textView34;
    int position;
    int correctAnswer;
    int incorrectAnswer;
    Toast toast;
    MediaPlayer mediaPlayer;


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
        setContentView(R.layout.activity_exercise_layout);

        button31 = findViewById(R.id.button31);
        button31.setOnClickListener(this);
        button32 = findViewById(R.id.button32);
        button32.setOnClickListener(this);
        button33 = findViewById(R.id.button33);
        button33.setOnClickListener(this);
        imageView3 = findViewById(R.id.imageView3);
        imageView3.setOnClickListener(this);
        textView32 = findViewById(R.id.textView32);
        textView32.setText("0");
        textView34 = findViewById(R.id.textView34);
        textView34.setText("0");
        correctAnswer = 0;
        incorrectAnswer = 0;
        mediaPlayer = new MediaPlayer();

        setLetter();
    }

    @Override
    public void onClick(View v) {
        if ((correctAnswer + incorrectAnswer) == 26) {
            if (correctAnswer == 26) {
                toast = Toast.makeText(getApplicationContext(),
                        "Поздравляю! Вы выучили алфавит!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
                mediaPlayer = MediaPlayer.create(this, R.raw.clapping);
                mediaPlayer.start();
            } else {
                toast = Toast.makeText(getApplicationContext(),
                        "Предлагаю вернуться к изучению алфавита!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
                mediaPlayer = MediaPlayer.create(this, R.raw.sad);
                mediaPlayer.start();
            }
            return;
        }

        switch (v.getId()) {
            case R.id.button31:
                if (position == 1) {
                    setLetter();
                    correctAnswer++;
                    textView32.setText(String.valueOf(correctAnswer));
                } else {
                    setLetter();
                    incorrectAnswer++;
                    textView34.setText(String.valueOf(incorrectAnswer));
                }
                break;
            case R.id.button32:
                if (position == 2) {
                    setLetter();
                    correctAnswer++;
                    textView32.setText(String.valueOf(correctAnswer));
                } else {
                    setLetter();
                    incorrectAnswer++;
                    textView34.setText(String.valueOf(incorrectAnswer));
                }
                break;
            case R.id.button33:
                if (position == 3) {
                    setLetter();
                    correctAnswer++;
                    textView32.setText(String.valueOf(correctAnswer));
                } else {
                    setLetter();
                    incorrectAnswer++;
                    textView34.setText(String.valueOf(incorrectAnswer));
                }
        }
    }

    private void setLetter() {
        String[] abc = new String[]{"Aa", "Bb", "Cc", "Dd", "Ee", "Ff", "Gg", "Hh", "Ii",
                "Jj", "Kk", "Ll", "Mm", "Nn", "Oo", "Pp", "Qq", "Rr", "Ss", "Tt", "Uu", "Vv",
                "Ww", "Xx", "Yy", "Zz"};
        Random random = new Random();
        List<Integer> letters = new ArrayList<>();

        int index;
        do {
            index = random.nextInt(26);
        } while (letters.contains(index));

        letters.add(index);

        position = random.nextInt(3) + 1;

        switch (position) {
            case 1:
                button31.setText(abc[index]);
                if (index >= 24) {
                    button32.setText(abc[1]);
                    button33.setText(abc[0]);
                } else {
                    button32.setText(abc[index + 1]);
                    button33.setText(abc[index + 2]);
                }
                break;
            case 2:
                button32.setText(abc[index]);
                if (index >= 24) {
                    button31.setText(abc[1]);
                    button33.setText(abc[0]);
                } else {
                    button31.setText(abc[index + 1]);
                    button33.setText(abc[index + 2]);
                }
                break;
            case 3:
                button33.setText(abc[index]);
                if (index >= 24) {
                    button31.setText(abc[1]);
                    button32.setText(abc[0]);
                } else {
                    button31.setText(abc[index + 1]);
                    button32.setText(abc[index + 2]);
                }
        }

        imageView3.setImageResource(images[index]);
    }
}
package com.alphabet.alphabet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExerciseActivityNew extends AppCompatActivity implements View.OnClickListener {
    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    ImageView imageViewLetter;
    TextView textViewCorrect;
    TextView textViewIncorrect;
    TextView textViewHome;
    int position;
    int correctAnswer;
    int incorrectAnswer;
    Toast toast;
    MediaPlayer mediaPlayer;
    Intent intent;

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
        setContentView(R.layout.activity_exercise_activity_new);

        buttonOne = findViewById(R.id.buttonOne);
        buttonOne.setOnClickListener(this);
        buttonTwo = findViewById(R.id.buttonTwo);
        buttonTwo.setOnClickListener(this);
        buttonThree = findViewById(R.id.buttonThree);
        buttonThree.setOnClickListener(this);
        imageViewLetter = findViewById(R.id.imageViewLetter);
        imageViewLetter.setOnClickListener(this);
        textViewCorrect = findViewById(R.id.textViewCorrect);
        textViewCorrect.setText("0");
        textViewIncorrect = findViewById(R.id.textViewIncorrect);
        textViewIncorrect.setText("0");
        textViewHome = findViewById(R.id.textViewHome);
        textViewHome.setOnClickListener(this);
        correctAnswer = 0;
        incorrectAnswer = 0;
        mediaPlayer = new MediaPlayer();

        setLetter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonOne:
                if (position == 1) {
                    setLetter();
                    correctAnswer++;
                    textViewCorrect.setText(String.valueOf(correctAnswer));
                } else {
                    setLetter();
                    incorrectAnswer++;
                    textViewIncorrect.setText(String.valueOf(incorrectAnswer));
                }
                break;
            case R.id.buttonTwo:
                if (position == 2) {
                    setLetter();
                    correctAnswer++;
                    textViewCorrect.setText(String.valueOf(correctAnswer));
                } else {
                    setLetter();
                    incorrectAnswer++;
                    textViewIncorrect.setText(String.valueOf(incorrectAnswer));
                }
                break;
            case R.id.buttonThree:
                if (position == 3) {
                    setLetter();
                    correctAnswer++;
                    textViewCorrect.setText(String.valueOf(correctAnswer));
                } else {
                    setLetter();
                    incorrectAnswer++;
                    textViewIncorrect.setText(String.valueOf(incorrectAnswer));
                }
                break;
            case R.id.textViewHome:
                intent = new Intent(ExerciseActivityNew.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
        }
        if ((correctAnswer + incorrectAnswer) == 5) {
            Intent result = new Intent(ExerciseActivityNew.this, ResultsActivity.class);
            result.putExtra("correctAnswer", correctAnswer);
            result.putExtra("incorrectAnswer", incorrectAnswer);
            startActivity(result);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            return;
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
                buttonOne.setText(abc[index]);
                if (index >= 24) {
                    buttonTwo.setText(abc[1]);
                    buttonThree.setText(abc[0]);
                } else {
                    buttonTwo.setText(abc[index + 1]);
                    buttonThree.setText(abc[index + 2]);
                }
                break;
            case 2:
                buttonTwo.setText(abc[index]);
                if (index >= 24) {
                    buttonOne.setText(abc[1]);
                    buttonThree.setText(abc[0]);
                } else {
                    buttonOne.setText(abc[index + 1]);
                    buttonThree.setText(abc[index + 2]);
                }
                break;
            case 3:
                buttonThree.setText(abc[index]);
                if (index >= 24) {
                    buttonOne.setText(abc[1]);
                    buttonTwo.setText(abc[0]);
                } else {
                    buttonOne.setText(abc[index + 1]);
                    buttonTwo.setText(abc[index + 2]);
                }
        }
        imageViewLetter.setImageResource(images[index]);
    }
}
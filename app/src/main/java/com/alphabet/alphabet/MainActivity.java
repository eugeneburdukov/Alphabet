package com.alphabet.alphabet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonLearning;
    Button buttonExercising;
    Button buttonAbout;
    ImageView imageView1;
    Toast toastSuccess;
    LayoutInflater layoutInflater;
    View layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLearning = findViewById(R.id.button11);
        buttonLearning.setOnClickListener(this);
        buttonExercising = findViewById(R.id.button13);
        buttonExercising.setOnClickListener(this);
        imageView1 = findViewById(R.id.imageView1);
        imageView1.setOnClickListener(this);
        buttonAbout = findViewById(R.id.button12);
        /*layoutInflater = getLayoutInflater();
        layout = layoutInflater.inflate(R.layout.toast_success_layout, (ViewGroup) findViewById(R.id.toast_layout));
        toastSuccess = new Toast(getApplicationContext());
        toastSuccess.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toastSuccess.setDuration(Toast.LENGTH_SHORT);
        toastSuccess.setView(layout);*/
        buttonAbout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.button11:
                intent = new Intent(MainActivity.this, StudyActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
            case R.id.button13:
                intent = new Intent(MainActivity.this, ExerciseActivityNew.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;
            case R.id.button12:
                intent = new Intent(MainActivity.this, AboutActivityContraint.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }
    }

//    public void getToast() {
//        buttonAbout = findViewById(R.id.button12);
//
//        layoutInflater = getLayoutInflater();
//        layout = layoutInflater.inflate(R.layout.toast_success_layout, (ViewGroup) findViewById(R.id.toast_layout));
//
//        toastSuccess = new Toast(getApplicationContext());
//
//        toastSuccess.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
//        toastSuccess.setDuration(Toast.LENGTH_SHORT);
//        toastSuccess.setView(layout);
//        buttonAbout.setOnClickListener(this);
//    }
}
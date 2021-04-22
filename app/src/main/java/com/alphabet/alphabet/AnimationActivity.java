package com.alphabet.alphabet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {
    LottieAnimationView lottieAnimationView;
    TextView textViewHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        textViewHome = findViewById(R.id.textViewHome);
        textViewHome.setOnClickListener(this);
        /*lottieAnimationView = findViewById(R.id.animationViewTree);*/
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textViewHome:
                Intent intent = new Intent(AnimationActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }
    }
}
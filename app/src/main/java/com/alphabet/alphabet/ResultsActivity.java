package com.alphabet.alphabet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageViewStar;
    TextView textViewResultCor;
    TextView textViewHome;
    Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_layout);

        textViewHome = findViewById(R.id.textViewHome);
        textViewHome.setOnClickListener(this);
        imageViewStar = findViewById(R.id.imageViewStar);
        textViewResultCor = findViewById(R.id.textViewResultCor);
        mIntent = getIntent();
        int intValue1 = mIntent.getIntExtra("correctAnswer", 0);
        String score = "Score " + intValue1 + " /  26";
        SpannableString spannableString = new SpannableString(score);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        spannableString.setSpan(boldSpan, 6, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textViewResultCor.setText(spannableString);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textViewHome:
                Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }
    }
}
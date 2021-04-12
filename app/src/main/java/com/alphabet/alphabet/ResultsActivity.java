package com.alphabet.alphabet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    ImageView imageViewStar;
    TextView textViewResultCor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_layout);

        imageViewStar = findViewById(R.id.imageViewStar);
        textViewResultCor = findViewById(R.id.textViewResultCor);


        Intent mIntent = getIntent();
        int intValue1 = mIntent.getIntExtra("correctAnswer", 0);
        int intValue2 = mIntent.getIntExtra("incorrectAnswer", 0);

        String text = "Score " + intValue1 + " /  26";
        SpannableString spannableString = new SpannableString(text);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        spannableString.setSpan(boldSpan, 6, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textViewResultCor.setText(spannableString);
    }
}
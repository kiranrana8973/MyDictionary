package com.dictionaryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MeaningActivity extends AppCompatActivity {

    private TextView tvMeaning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meaning);

        Bundle bundle = getIntent().getExtras();
        String meaning = bundle.getString("meaning");

        tvMeaning = findViewById(R.id.tvMeaning);
        //setting the meaning in textview
        tvMeaning.setText(meaning);
    }
}
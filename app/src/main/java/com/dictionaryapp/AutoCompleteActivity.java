package com.dictionaryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoCompleteActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;
    private String[] language ={"C","C++","Java",".NET","iOS","Android","ASP.NET","PHP"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_auto_complete);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.select_dialog_item,
                language
                );

        autoCompleteTextView.setAdapter(stringArrayAdapter);
        autoCompleteTextView.setThreshold(1); // Will start working from first character

    }
}


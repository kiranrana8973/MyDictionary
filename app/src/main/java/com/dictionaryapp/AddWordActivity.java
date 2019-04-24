package com.dictionaryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class AddWordActivity extends AppCompatActivity {
    EditText etWord,etDefinition;
    Button btnAddWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
        etWord = findViewById(R.id.etWord);
        etDefinition = findViewById(R.id.etMeaning);
        btnAddWord = findViewById(R.id.btnAddWord);

        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });
    }
    private void Save() {
        try {
            PrintStream printStream = new PrintStream(openFileOutput("words.txt", MODE_PRIVATE | MODE_APPEND));
            printStream.println(etWord.getText().toString() + "->" + etDefinition.getText().toString());
            Toast.makeText(this, "Saved to" + getFilesDir(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


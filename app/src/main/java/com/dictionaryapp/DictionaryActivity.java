package com.dictionaryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryActivity extends AppCompatActivity {

    private ListView lstDictionary;
    private Map<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        lstDictionary = findViewById(R.id.lstDictionary);
        dictionary = new HashMap<>();

        // Read All the words from word.txt file
        readFromFile();

        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet())
        );
        lstDictionary.setAdapter(adapter);

        lstDictionary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key = parent.getItemAtPosition(position).toString(); // Get the current position
                String meaning = dictionary.get(key);   // Get the meaning of current position key
                // Intent will call MeaningActivity from DictionaryActivity
                Intent intent = new Intent(DictionaryActivity.this, MeaningActivity.class);
                // We have to pass the message from this activity to MeaningActivity
                intent.putExtra("meaning", meaning);
                startActivity(intent);
            }
        });
    }

    private void readFromFile() {
        Scanner scan = new Scanner(getResources().openRawResource(R.raw.words));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.split("->");
            dictionary.put(parts[0], parts[1]);
        }
    }
}



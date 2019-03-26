package com.dictionaryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DictionaryActivity extends AppCompatActivity {

    private ListView lstDictionary;
    private Map<String, String> dictionary;

    public static final String words[] = {
            "Yeta Aunus", "Come here",
            "Uta janus", "Go there",
            "Nameste", "Hello",
            "Kata chau ?", "Where are you ?",
            "Kata Jane ?", "Where are you going?"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        lstDictionary = findViewById(R.id.lstDictionary);

        dictionary = new HashMap<>();
        for (int i = 0; i < words.length; i += 2) {
            dictionary.put(words[i], words[i + 1]); // putting key and value in hashmap
        }
        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet())
        );
        lstDictionary.setAdapter(adapter);
    }
}

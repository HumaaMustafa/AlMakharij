package com.example.almakharijapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private List<QuizQuestions>questionsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        questionsList = new ArrayList<>();

        addQuestions();
    }

    private void addQuestions() {
        questionsList.add(new QuizQuestions())
    }
}
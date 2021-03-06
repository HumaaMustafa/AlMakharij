package com.example.almakharijapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity3 extends AppCompatActivity {

    private TextView Ques , Score;
    private RadioGroup radioG;
    private RadioButton r1 , r2, r3;
    private Button next;

    int totalQues , counter=0 , scor ;

    ColorStateList color;
    boolean ans;

    private List<QuizQuestions> questionsList;

    private QuizQuestions currentQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        questionsList = new ArrayList<>();
        Ques = findViewById(R.id.textView5);
        Score = findViewById(R.id.textView6);

        radioG = findViewById(R.id.radioGroup1);
        r1 = findViewById(R.id.op4);
        r2 = findViewById(R.id.op5);
        r3 = findViewById(R.id.op6);

        next = findViewById(R.id.next2);

        color = r1.getTextColors();



        addQuestions();
        totalQues = questionsList.size();
        showNextQuestion();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ans == false) {
                    if (r1.isChecked() || r2.isChecked() || r3.isChecked()) {
                        checkAns();

                    } else {
                        Toast.makeText(MainActivity3.this, "Please Select an option", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void checkAns() {
        ans = true;
        RadioButton rSelected= findViewById(radioG.getCheckedRadioButtonId());
        int ansNO = radioG.indexOfChild(rSelected)+1;
        if(ansNO==currentQ.getAnsCorr()){
            scor++;
            Score.setText("Score: "+scor);
        }
        r1.setTextColor(Color.RED);
        r2.setTextColor(Color.RED);
        r3.setTextColor(Color.RED);
        switch(currentQ.getAnsCorr()){
            case 1:
                r1.setTextColor(Color.GREEN);
                break;

            case 2:
                r2.setTextColor(Color.GREEN);
                break;

            case 3:
                r3 .setTextColor(Color.GREEN);
                break;

        }
        if(counter<totalQues){
            next.setText("Next");

        }else{
            next.setText("Finish");
        }
    }


    private void showNextQuestion() {
        radioG.clearCheck();
        r1.setTextColor(color);
        r2.setTextColor(color);
        r3.setTextColor(color);
        if (counter< totalQues){
            currentQ = questionsList.get(counter);
            Ques.setText(currentQ.getQuestion());
            r1.setText(currentQ.getOpt1());
            r2.setText(currentQ.getOpt2());
            r3.setText(currentQ.getOpt3());
            counter++;
            next.setText("Submit");
            ans = false;
        }
        else{
            Intent i = new Intent(MainActivity3.this, MainActivity4.class);
            i.putExtra("key",scor);
            startActivity(i);

        }

    }

    private void addQuestions() {
        final int min = 1;
        final int max = 6;
        final int random = new Random().nextInt((max - min) + 1) + min;
        switch(random) {
            case 1:
                questionsList.add(new QuizQuestions("??", "End of Throat", "Middle of Throat", "Start of the Throat", 1));
                questionsList.add(new QuizQuestions("??", "End of Throat", "Middle of Throat", "Start of the Throat", 1));
                questionsList.add(new QuizQuestions("??", "End of Throat", "Middle of Throat", "Start of the Throat", 2));
                questionsList.add(new QuizQuestions("??", "End of Throat", "Middle of Throat", "Start of the Throat", 2));
                questionsList.add(new QuizQuestions("??", "End of Throat", "Middle of Throat", "Start of the Throat", 3));
                break;
            case 2:
                questionsList.add(new QuizQuestions("??", "End of Throat", "Middle of Throat", "Start of the Throat", 3));
                questionsList.add(new QuizQuestions("??", "Base of Tongue which is near Uvula touching the mouth roof", "Portion of Tongue near its base touching the roof of mouth", "Middle of Throat", 1));
                questionsList.add(new QuizQuestions("??", "Base of Tongue which is near Uvula touching the mouth roof", "Portion of Tongue near its base touching the roof of mouth", "Middle of Throat", 1));
                questionsList.add(new QuizQuestions("??", "Portion of Tongue near its base touching the roof of mouth", "Tongue touching the center of the mouth roof", "One side of the tongue touching the molar teeth", 2));
                questionsList.add(new QuizQuestions("??", "Portion of Tongue near its base touching the roof of mouth", "Portion of Tongue near its base touching the roof of mouth", "Tongue touching the center of the mouth roof", 3));
                break;
            case 3:
                questionsList.add(new QuizQuestions("??", "Tongue touching the center of the mouth roof", "Portion of Tongue near its base touching the roof of mouth", "One side of the tongue touching the molar teeth", 1));
                questionsList.add(new QuizQuestions("??", "Tongue touching the center of the mouth roof", "Portion of Tongue near its base touching the roof of mouth", "One side of the tongue touching the molar teeth", 3));
                questionsList.add(new QuizQuestions("??", "Rounded tip of the tongue touching the base of the frontal 6 teeth", "Rounded tip of the tongue touching the base of the frontal 8 teeth", "Rounded tip of the tongue and some portion near it touching the base of the frontal 4 teeth", 2));
                questionsList.add(new QuizQuestions("??", "Rounded tip of the tongue touching the base of the frontal 8 teeth", "Rounded tip of the tongue and some portion near it touching the base of the frontal 4 teeth", "Rounded tip of the tongue touching the base of the frontal 6 teeth", 3));
                questionsList.add(new QuizQuestions("??", "Rounded tip of the tongue touching the base of the frontal 8 teeth", "Rounded tip of the tongue and some portion near it touching the base of the frontal 4 teeth", "Rounded tip of the tongue touching the base of the frontal 6 teeth", 2));
                break;
            case 4:
                questionsList.add(new QuizQuestions("??", "Rounded tip of the tongue and some portion near it touching the base of the frontal 4 teeth", "Tip of the tongue touching the base of the front 2 teeth", "Rounded tip of the tongue touching the base of the frontal 8 teeth", 2));
                questionsList.add(new QuizQuestions("??", "Tip of the tongue touching the tip of the frontal 2 teeth", "Tongue touching the center of the mouth roof", "Mouth empty space while speaking words like  ?????? ?????? ??????", 1));
                questionsList.add(new QuizQuestions("??", "Mouth empty space while speaking words like  ?????? ?????? ??????", "While pronouncing the ending sound of  ??  or ?? , bring the vibration to the nose", "Tip of the tongue comes between the front top and bottom teeth", 3));
                questionsList.add(new QuizQuestions("??", "Outer part of both lips touch each other", "While pronouncing the ending sound of  ??  or ?? , bring the vibration to the nose", "Rounding both lips and not closing the mouth", 2));
                questionsList.add(new QuizQuestions("??", "Rounding both lips and not closing the mouth", "Outer part of both lips touch each other", "Inner part of the both lips touch each other", 3));
                break;
            case 5:
                questionsList.add(new QuizQuestions("??", "Rounding both lips and not closing the mouth", "Inner part of the both lips touch each other", "Outer part of both lips touch each other", 1));
                questionsList.add(new QuizQuestions("??????", "Mouth empty space while speaking words like  ?????? ?????? ??????", "Rounding both lips and not closing the mouth", "Tip of the tongue touching the tip of the frontal 2 teeth", 1));
                questionsList.add(new QuizQuestions("??", "Mouth empty space while speaking words like  ?????? ?????? ??????", "Tip of the tongue touching the tip of the frontal 2 teeth", "Tip of the two upper jaw teeth touches the inner part of the lower lip", 3));
                questionsList.add(new QuizQuestions("??", "Tongue touching the center of the mouth roof", "Rounding both lips and not closing the mouth", "Tip of the tongue touching the tip of the frontal 2 teeth", 3));
                break;

        }
    }

}
package com.example.almakharijapp;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity2 extends AppCompatActivity {

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
        setContentView(R.layout.activity_main2);

        questionsList = new ArrayList<>();
        Ques = findViewById(R.id.textView3);
        Score = findViewById(R.id.textView4);

        radioG = findViewById(R.id.radioGroup);
        r1 = findViewById(R.id.op1);
        r2 = findViewById(R.id.op2);
        r3 = findViewById(R.id.op3);

        next = findViewById(R.id.next3);

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
                        Toast.makeText(MainActivity2.this, "Please Select an option", Toast.LENGTH_SHORT).show();
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
            finish();
        }
    }

    private void addQuestions() {
        questionsList.add(new QuizQuestions(" أ", "End of Throat", "Middle of Throat", "Start of the Throat", 1));
        questionsList.add(new QuizQuestions(" ہ", "End of Throat", "Middle of Throat", "Start of the Throat", 1));
        questionsList.add(new QuizQuestions("ح", "End of Throat", "Middle of Throat", "Start of the Throat", 2));
        questionsList.add(new QuizQuestions("ع", "End of Throat", "Middle of Throat", "Start of the Throat", 2));
        questionsList.add(new QuizQuestions(" خ", "End of Throat", "Middle of Throat", "Start of the Throat", 3));
        questionsList.add(new QuizQuestions("غ", "End of Throat", "Middle of Throat", "Start of the Throat", 3));
        questionsList.add(new QuizQuestions("ق", "Base of Tongue which is near Uvula touching the mouth roof", "Portion of Tongue near its base touching the roof of mouth", "Middle of Throat", 1));
        questionsList.add(new QuizQuestions("ک", "Base of Tongue which is near Uvula touching the mouth roof", "Portion of Tongue near its base touching the roof of mouth", "Middle of Throat", 1));
        questionsList.add(new QuizQuestions("", "", "", "", 1));
        questionsList.add(new QuizQuestions("", "", "", "", 1));
        questionsList.add(new QuizQuestions("", "", "", "", 1));
        questionsList.add(new QuizQuestions("", "", "", "", 1));
        questionsList.add(new QuizQuestions("", "", "", "", 1));
        questionsList.add(new QuizQuestions("", "", "", "", 1));
        questionsList.add(new QuizQuestions("", "", "", "", 1));
        questionsList.add(new QuizQuestions("", "", "", "", 1));


    }
}
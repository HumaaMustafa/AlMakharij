package com.example.almakharijapp;

public class QuizQuestions {
    private  String question , opt1 , opt2 , opt3;
    private  int ansCorr;


    public QuizQuestions(String question, String opt1, String opt2, String opt3, int ansCorr) {
        this.question = question;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.ansCorr = ansCorr;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnsCorr() {
        return ansCorr;
    }

    public void setAnsCorr(int score) {
        this.ansCorr = ansCorr;
    }

}

package com.Felixpat.chetu.DataStructures;

/**
 * Created by Chetu on 18-12-2017.
 */

public class Question {
    int id;
    String question;
    String one;
    String two;
    String three;
    String four;
    int answer;
    int given;

    public Question(int id, String question, String one, String two, String three, String four, int answer, int given) {
        this.id = id;
        this.question = question;
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.answer = answer;
        this.given = given;
    }

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

    public String getFour() {
        return four;
    }

    public void setFour(String four) {
        this.four = four;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getGiven() {
        return given;
    }

    public void setGiven(int given) {
        this.given = given;
    }
}


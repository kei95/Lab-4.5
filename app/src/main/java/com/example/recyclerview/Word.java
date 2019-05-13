package com.example.recyclerview;

public class Word {
    private String word;
    private int num;

    public Word(String word, int num){
        this.word = word;
        this.num = num;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getDefinition() { return num;}

    public void setDefinition(int num) { this.num = num; }
}

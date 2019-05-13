package com.example.recyclerview;

import java.util.ArrayList;

public class WordList {
    private ArrayList<Word> mWords;

    public  WordList(){
        this.mWords = new ArrayList<>();
        addWord("bail");
        addWord("ghosted" );
        addWord("chillin");
        addWord("chicks");
        addWord("Dope");
        addWord("Vancouverrite");
    }

    public void addWord(String word){
        int num = this.mWords.size() + 1;
        if(mWords.isEmpty()){
            num = this.mWords.size() + 1;
            this.mWords.add(new Word(word, num));
        }
        this.mWords.add(new Word(word, num));
    }

    public ArrayList<Word> getmWords() {
        return mWords;
    }

    public Word getWord(int index){
        return this.mWords.get(index);
    }

    public void set(int mPosition, String s) {
        Word target = this.getWord(mPosition);
        target.setWord(s);
    }

    public int size(){
        return mWords.size();
    }

    public void reset(){
        mWords.removeAll(mWords);
        addWord("bail");
        addWord("ghosted" );
        addWord("chillin");
        addWord("chicks");
        addWord("Dope");
        addWord("Vancouverrite");
    }
}
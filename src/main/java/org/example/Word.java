package org.example;

public class Word {
    private int level;
    private String wordName;
    private String meaning;

    public Word() {};
    public Word(int level, String wordName, String meaning) {
        this.level = level;
        this.wordName = wordName;
        this.meaning = meaning;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return wordName;
    }

    public void setName(String name) {
        this.wordName = wordName;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        String star = "";
        for(int i = 0; i < level; i++) star += "*";
        String str = String.format("%-3s", star) +
                String.format("%15s", wordName) +
                String.format("  " + meaning);
        return str;
    }
}



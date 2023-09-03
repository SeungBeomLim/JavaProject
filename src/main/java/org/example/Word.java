package org.example;

public class Word {
    // word의 데이터
    private int level;
    private String wordName;
    private String meaning;

    // 생성자
    public Word(){};
    public Word(int level, String wordName, String meaning) {
        this.level = level;
        this.wordName = wordName;
        this.meaning = meaning;
    }

    // getter 및 setter
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
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
        for(int i = 0; i < level; i++)
            star += "*";

        String str = String.format("%-3s", star)
                + String.format("%15s", wordName)
                + "  " + meaning;

        return str;
    }
}

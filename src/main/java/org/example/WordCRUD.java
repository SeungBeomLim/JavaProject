package org.example;

import java.util.Scanner;
import java.util.ArrayList;

public class WordCRUD implements ICRUD {
    ArrayList<Word> note;

    public WordCRUD() {
        note = new ArrayList<>();
    }

    @Override
    public void create(Scanner s) {
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
        int level = s.nextInt();
        String wordName = s.next();
        System.out.print("뜻 입력 : ");
        String meaning = s.next();
        Word word = new Word(level, wordName, meaning);
        note.add(word);
        System.out.println("새 단어가 단어장에 추가되었습니다 !!!\n");
    }

    @Override
    public void read() {
        System.out.println("[             단어장 목록             ]");
        System.out.println("-------------------------------------");
        for(int i = 0; i < note.size(); i++) {
            System.out.println((i+1) + " " + note.get(i).toString());
        }
        System.out.println("-------------------------------------\n");
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}

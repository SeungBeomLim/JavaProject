package org.example;

import java.util.Scanner;
import java.util.ArrayList;
public class WordCRUD implements ICRUD{
    Scanner s = new Scanner(System.in);
    ArrayList<Word> vocaNote;

    public WordCRUD() {
        vocaNote = new ArrayList<>();
    }

    @Override
    public void add() {
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
        int level = s.nextInt();
        String name = s.next();
        System.out.print("뜻 입력: ");
        String meaning = s.next();

        Word word = new Word(level, name, meaning);
        vocaNote.add(word);
        System.out.println("새 단어가 단어장에 추가되었습니다 !!!\n");
    }

    @Override
    public void read() {
        System.out.println("[ 단어장 목록 ]");
        System.out.println("-------------------------------\n");
        for (int i = 0; i < vocaNote.size(); i++) {
            System.out.println((i+1) + " " + vocaNote.get(i).toString());
        }
        System.out.println("-------------------------------\n");
    }

    @Override
    public String update() {
        return null;
    }

    @Override
    public String delete() {
        return null;
    }
}

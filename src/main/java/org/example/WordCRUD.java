package org.example;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class WordCRUD implements ICRUD {
    ArrayList<Word> note;
    final String fname = "Dictionary.txt";

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
    public void readByLevel(Scanner s) {
        System.out.print("난이도를 입력해주세요 : ");
        int level = s.nextInt();
        System.out.println("           [난이도 별 단어장]           ");
        System.out.println("-------------------------------------");
        for(int i = 0; i < note.size(); i++) {
            if(note.get(i).getLevel() == level) {
                System.out.print((i + 1) + " ");
                System.out.println(note.get(i).toString());
            }
        }
        System.out.println("-------------------------------------");
    }

    @Override
    public void search(Scanner s) {
        System.out.print("=> 단어 검색 : ");
        String keyword = s.next();
        System.out.println("-------------------------------------");
        for(int i = 0; i < note.size(); i++) {
            String word = note.get(i).getName();
            if(word.contains(keyword)) {
                System.out.print((i + 1) + " ");
                System.out.println(note.get(i).toString());
            }
        }
        System.out.println("-------------------------------------");
    }

    @Override
    public void update(Scanner s) {
        search(s);
        System.out.print("=> 수정할 번호 선택 : ");
        int id = s.nextInt();
        System.out.print("=> 수정할 뜻 입력 : ");
        String meaning = s.next();
        note.get(id-1).setMeaning(meaning);
        System.out.println("단어가 수정되었습니다.");

    }

    @Override
    public void delete(Scanner s) {
        search(s);
        System.out.print("삭제할 번호 선택 : ");
        int id = s.nextInt();
        System.out.print("정말로 삭제하실래요?(Y/N) ");
        String ans = s.next();
        if(ans.equalsIgnoreCase("Y")) {
            note.remove(id-1);
            System.out.println("단어가 삭제되었습니다.");
        }
        else
            System.out.println("취소되었습니다.");
    }

    @Override
    public void saveFile() {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter(fname));
            for(Word one : note) {
                pr.write(one.toFileString() + "\n");
            }
            pr.close();
            System.out.println("=> 데이터 저장 완료!!\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void loadFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            int count = 0;

            while (true) {
                line = br.readLine();
                if (line == null) break;

                String data[] = line.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[2];
                note.add(new Word(level, word, meaning));
                count ++;
            }
            br.close();
            System.out.println("=> " + count + "개 로딩 완료 !!\n");
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}

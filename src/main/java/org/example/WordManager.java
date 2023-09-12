package org.example;

import java.util.Scanner;
public class WordManager implements IWORDMANAGER{
    Scanner s = new Scanner(System.in);
    WordCRUD wordCRUD;
    WordManager() {
        wordCRUD = new WordCRUD();
    }

    @Override
    public void start() {
        wordCRUD.loadFile();
        System.out.println("*** 영단어 마스터 ***\n");
        menu();
    }

    @Override
    public void menu() {
        while (true) {
            System.out.println("********************\n" +
                    "1. 모든 단어 보기\n" +
                    "2. 수준별 단어 보기\n" +
                    "3. 단어 검색\n" +
                    "4. 단어 추가\n" +
                    "5. 단어 수정\n" +
                    "6. 단어 삭제\n" +
                    "7. 파일 저장\n" +
                    "0. 나가기\n" +
                    "********************");
            System.out.print("=> 원하는 메뉴는 ? ");
            int menu = s.nextInt();

            if(menu == 0) {
                System.out.print("프로그램 종료! 다음에 만나요~");
                break;
            }
            else selectMenu(menu);

        }
    }
    public void selectMenu(int menu) {
        if(menu == 1) {
            wordCRUD.read();
        }
        else if(menu == 2) {
            wordCRUD.readByLevel(s);

        }
        else if(menu == 3) {
            wordCRUD.search(s);
        }
        // 단어 추가
        else if(menu == 4) {
            wordCRUD.create(s);
        }
        else if(menu == 5) {
            wordCRUD.update(s);
        }
        else if(menu == 6) {
            wordCRUD.delete(s);
        }
        else if(menu == 7) {
            wordCRUD.saveFile();
        }
    }
}

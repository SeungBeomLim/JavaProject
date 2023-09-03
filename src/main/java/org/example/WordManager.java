package org.example;

import java.util.Scanner;

public class WordManager {
    WordCRUD wordCRUD;

    WordManager() {
        wordCRUD = new WordCRUD();
    }

    public void start() {
        System.out.println("**** 영단어 마스터 ****");
        menu();
    }
    public void menu() {
        while(true) {
            System.out.println("******************** \n" +
                    "1. 모든 단어 보기\n" +
                    "2. 수준별 단어 보기\n" +
                    "3. 단어 검색\n" +
                    "4. 단어 추가\n" +
                    "5. 단어 수정\n" +
                    "6. 단어 삭제\n" +
                    "7. 파일 저장\n" +
                    "0. 나가기\n" +
                    "********************");
            System.out.print("=> 원하는 메뉴는? ");
            Scanner s = new Scanner(System.in);
            int menu = s.nextInt();

            if (menu == 0) {
                System.out.println("프로그램이 종료되었습니다~");
                break;
            }

            else if (menu == 4) {
                wordCRUD.add();
            }

            else if (menu == 1) {
                wordCRUD.read();
            }

            else if  (menu == 5) {
                wordCRUD.update();
            }
        }
    }
}

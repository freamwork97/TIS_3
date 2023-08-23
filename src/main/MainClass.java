package main;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
//       스캐너를 이용
//       1. 학생등록
//       2. 학생상세조회
//       3. 학생목록조회
//       를 선택하는 코드를 작성

        Scanner sc = new Scanner(System.in);

        boolean run = true;
        while (run) {
            System.out.println("1. 학생등록 2. 학생상세목록 3. 학생목록조회 4.정보수정 5.삭제  0. 종료");
            System.out.print("선택 : ");
            String menu = sc.next();
            if (menu.equals("1")) {
                System.out.println("학생등록");
            } else if (menu.equals("2")) {
                System.out.println("학생상세목록");
            } else if (menu.equals("3")) {
                System.out.println("학생목록조회");
            } else if (menu.equals("4")) {
                System.out.println("정보수정");
            } else if (menu.equals("5")) {
                System.out.println("삭제");
            } else if (menu.equals("0")) {
                run = false;
                System.out.println("종료");
            } else {
                System.out.println("다시입력");
            }
        }
    }
}
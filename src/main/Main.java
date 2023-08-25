package main;


import service.Service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Service service = new Service();
        boolean run = true;
        while (run) {
            System.out.println("=======================게시판=======================");
            System.out.println("1.글작성 2.글목록 3.글수정 4.글삭제 5.검색 0.종료");
            System.out.println("===================================================");

            System.out.print("선택 : ");
            String menu = scanner.next();
            if (menu.equals("1")) {
                System.out.println("글작성");
                service.write();
            } else if (menu.equals("2")) {
                System.out.println("글목록");
                service.findall();
                service.find();
            } else if (menu.equals("3")) {
                System.out.println("글수정");
                service.update();
            } else if (menu.equals("4")) {
                System.out.println("글삭제");
                service.delete();
            } else if (menu.equals("5")) {
                System.out.println("검색");
            } else if (menu.equals("0")) {
                run = false;
                System.out.println("종료");
            } else {
                System.out.println("다시선택");
            }
        }
    }
}
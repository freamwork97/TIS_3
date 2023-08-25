package main;


import service.Service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Service service = new Service();
        boolean run = true;

        while (run) {
            System.out.println("=============회원관리=============");
            System.out.println("1.회원가입 2.로그인 3.회원목록 4.회원수정");
            System.out.println("5.회원탈퇴 6.로그아웃 0. 종료");
            System.out.println("=================================");
            System.out.print("선택 : ");
            String menu = scanner.next();

            if (menu.equals("1")) {
                System.out.println("회원가입");
                service.save();
            } else if (menu.equals("2")) {
                System.out.println("로그인");
                service.login();
            } else if (menu.equals("3")) {
                System.out.println("회원목록조회");
                service.findAll();
            } else if (menu.equals("4")) {
                System.out.println("회원목록수정");
                service.update();
            } else if (menu.equals("5")) {
                System.out.println("회원탈퇴");
                service.delete();
            } else if (menu.equals("6")) {
                service.logout();
            } else if (menu.equals("0")) {
                run = false;
                System.out.println("종료");
            } else {
                System.out.println("다시선택");
            }
        }
    }
}
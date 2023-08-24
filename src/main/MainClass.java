package main;

import java.util.Scanner;

import service.StudentService;

public class MainClass {
    public static void main(String[] args) {
//       스캐너를 이용
//       1. 학생등록
//       2. 학생상세조회
//       3. 학생목록조회
//       를 선택하는 코드를 작성

        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();
        boolean run = true;
        while (run) {
            System.out.println("1.학생등록 2.학생조회 3.학생목록 4.정보수정 5.삭제  0.종료");
            System.out.print("선택 : ");
            String menu = sc.next();
            if (menu.equals("1")) {
                System.out.println("학생등록");
                studentService.save();
            } else if (menu.equals("2")) {
                /*
                    service의 findById 메서드 호출
                    service의 findById
                     - id값을 입력받고 repository의 findById로 id값을 넘김
                     - 입력받은 id에 해당하는 학생 데이터 리턴
                     - 리턴 받은 값 출력
                 */
                System.out.println("학생조회");
                studentService.findById()
            } else if (menu.equals("3")) {
                System.out.println("학생목록");
                studentService.findAll();
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
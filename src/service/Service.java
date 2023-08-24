package service;

import dto.DTO;
import reposit.Reposit;

import java.util.List;
import java.util.Scanner;

public class Service {
    //로그인 여부 판단 static 필드
    private static String loginEmail = null;
    Scanner scanner = new Scanner(System.in);
    Reposit reposit = new Reposit();

    public void save() {
        System.out.print("이메일 : ");
        String email = scanner.next();
        System.out.print("비밀번호 : ");
        String passwd = scanner.next();
        System.out.print("이름 : ");
        String name = scanner.next();
        System.out.print("전화번호 : ");
        String phone = scanner.next();
        DTO dto = new DTO(email, passwd, name, phone);

        boolean result = reposit.save(dto);

        if (result) {
            System.out.println("등록성공");
        } else {
            System.out.println("등록실패");
        }
    }

    public void findAll() {
        for (DTO dto : reposit.findAll()) {
            System.out.println(dto.toString());
        }
    }

    public void delete() {
        System.out.print("삭제할 ID :");
        String id = scanner.next();
        DTO dto = reposit.delete(id);
        if (dto == null) {
            System.out.println("찾는 정보 X");
        } else {
            System.out.println("삭제학생 정보 : " + dto);
        }
    }

    public void login() {
        System.out.print("이메일 : ");
        String email = scanner.next();
        System.out.print("비밀번호 : ");
        String passwd = scanner.next();
        DTO loginresult = reposit.login(email, passwd);
        if (loginresult == null) {
            System.out.println("로그인실패");
        } else {
            System.out.println("로그인성공");
            loginEmail = email;
        }
    }

    public void logout() {
        System.out.println("로그아웃되었습니다.");
        loginEmail = null;
    }

}

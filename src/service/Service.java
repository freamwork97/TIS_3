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
        String email = null;
        while (true) {
            System.out.print("이메일 : ");
            email = scanner.next();
            boolean check = reposit.check(email);
            if (check == false) {
                System.out.println("이미 사용중입니다");
            } else {
                break;
            }
        }

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
        if (loginEmail == null) {
            System.out.println("로그인 후 사용 가능");
        } else {
            System.out.println("비밀번호 확인 중");
            System.out.print("비밀번호 : ");
            String passwd = scanner.next();
            DTO dto = reposit.delete(passwd);
            if (dto == null) {
                System.out.println("삭제실패");
            } else {
                System.out.println("삭제학생 정보 : " + dto);
                loginEmail = null;
            }
        }

    }

    public void login() {
        if (loginEmail == null) {
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
        } else {
            System.out.println("로그인 상태입니다.");
        }

    }

    public void logout() {
        if (loginEmail != null) {
            System.out.println("로그아웃되었습니다.");
            loginEmail = null;
        } else {
            System.out.println("로그인 후 사용 가능");
        }
    }

    public void update() {
        if (loginEmail == null) {
            System.out.println("로그인 후 사용 가능");
        } else {
            System.out.println("비밀번호 확인 후 사용 가능");
            System.out.print("비밀번호 : ");
            String passwd = scanner.next();
            DTO update = reposit.update(passwd);
            if (update == null) {
                System.out.println("비밀번호를 확인해주시오");
            } else {
                System.out.println("새로운 비밀번호 : ");
                String newpasswd = scanner.next();
                System.out.println("새로운 전화번호 : ");
                String newphone = scanner.next();

                update.setPasswd(newpasswd);
                update.setPhone(newphone);
                System.out.println("변경완료");
            }
        }
    }

}

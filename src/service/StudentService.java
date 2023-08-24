package service;

import dto.StudentDTO;
import repository.StudentRepository;

import java.util.Scanner;

public class StudentService {
    // 학생등록 메서드
    // 매개변수 없음
    // 리턴 없음
    // 메서드 이름 : save()
    // 실행내용
    // 스캐너로 이름(studentName), 학과(studentMajor), 전화번호(studentMobile) 입력받고
    // 입력값을 DTO객체에 담아서 StudentRepository의 save() 메서드로 전달
    Scanner sc = new Scanner(System.in);
    StudentRepository studentRepository = new StudentRepository();

    public void save() {
        System.out.print("이름 : ");
        String studentName = sc.next();
        System.out.print("학과 : ");
        String studentMajor = sc.next();
        System.out.print("전화 : ");
        String studentMobile = sc.next();
//      DTO 객체
        StudentDTO sdto = new StudentDTO();
        sdto.setStudentName(studentName);
        sdto.setStudentMajor(studentMajor);
        sdto.setStudentMobile(studentMobile);

//      DTO 객체를 StudentRepository의 save() 메서드로 전달하여 리턴을 boolean으로 받음
        boolean result = studentRepository.save(sdto);
//      repository의 save() 내용
//      넘겨받은 dto 객체를 리스트에 추가하고 추가하면 true 리턴

        if (result) {
            System.out.println("등록성공");
        } else {
            System.out.println("등록실패");
        }
    }

    /*
        findAll() 메서드
        Main에서 3번 선택시 호출되는 메서드
        실행내용
         - Repository의 findAll 메서드를 호출하여 리스트를 리턴
         - 리턴받은 리스트에 담긴 데이터를 for문을 이용하여 출력
     */
    public void findAll() {
        for (StudentDTO sdto : studentRepository.findAll()) {
            System.out.println(sdto.toString());
        }
    }

    public void findById() {

        System.out.println("StudentService.findById");
//      조회기능 선택시 목록을 먼저 보여줌
//      서비스클래스에서 정의한 findAll() 메서드 호출
        for (StudentDTO sdto : studentRepository.findAll()) {
            System.out.println(sdto.toString());
        }
//      조회할 id 입력
        System.out.print("조회할 ID : ");
        String id = sc.next();
//      입력받은 id를 repository로 넘겨서 DTO 객체를 리턴받음
        StudentDTO sdto = studentRepository.findById(id);
//      조회결과 출력
        if (sdto == null) {
            System.out.println("찾는 정보 X");
        } else {
            System.out.println("조회학생 정보 : " + sdto);
        }
    }

    public void deleteId() {
        System.out.print("삭제할 ID : ");
        String id = sc.next();
        StudentDTO sdto = studentRepository.deleteId(id);
        if (sdto == null) {
            System.out.println("찾는 정보 X");
        } else {
            System.out.println("삭제학생 정보 : " + sdto);
        }
    }

    public void update() {
        System.out.print("수정할 ID : ");
        String id = sc.next();
        StudentDTO sdto = studentRepository.findById(id);

        if(sdto==null){
            System.out.println("찾는 정보x");
        }
        else{
            System.out.print("이름 : ");
            String studentName = sc.next();
            System.out.print("학과 : ");
            String studentMajor = sc.next();
            System.out.print("전화 : ");
            String studentMobile = sc.next();

            sdto.setStudentName(studentName);
            sdto.setStudentMajor(studentMajor);
            sdto.setStudentMobile(studentMobile);

            System.out.println("수정정보 : "+sdto);
        }



    }
}

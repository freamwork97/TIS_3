package service;

import dto.BoardDTO;
import reposit.Reposit;

import java.util.Scanner;

public class Service {
    Scanner scanner = new Scanner(System.in);
    Reposit reposit = new Reposit();
    public void write() {

        System.out.print("제목 : ");
        String title = scanner.next();
        System.out.print("작성자 : ");
        String writer= scanner.next();
        System.out.println("내용");
        System.out.print(">");
        String contents = scanner.next();
        System.out.print("비밀번호 : ");
        String pass=scanner.next();
        BoardDTO dto= new BoardDTO(title,writer,contents,pass);
        boolean result = reposit.write(dto);
        
        if(result){
            System.out.println("등록성공");
        }else {
            System.out.println("등록실패");
        }
    }
    public void findall(){
        reposit.findall();
    }
    public void find(){
        System.out.print("조회할 글 번호 입력 : ");
        String num = scanner.next();
        reposit.find(num);
    }

    public void update(){
        reposit.findall();
        System.out.print("수정할 글 번호 입력 : ");
        String num = scanner.next();
        BoardDTO update = reposit.update(num);
        if(update!=null){
            System.out.print("비밀번호 입력 : ");
            String pass = scanner.next();
            if(pass.equals(update.getBoardPass())){
                System.out.print("제목 수정 : ");
                String title= scanner.next();
                System.out.println("내용수정");
                System.out.println(">");
                String content = scanner.next();
                update.setBoardTitle(title);
                update.setBoardContents(content);
            }else {
                System.out.println("비밀번호X");
            }
        }
        else{
            System.out.println("없는 글입니다.");
        }
    }

    public void delete() {
        reposit.findall();
        System.out.print("삭제할 글 번호 입력 : ");
        String num = scanner.next();
        BoardDTO delete = reposit.delete(num);
        if(delete!=null){
            System.out.println("삭제완료");
        }
        else{
            System.out.println("없는 글입니다.");
        }

    }
}

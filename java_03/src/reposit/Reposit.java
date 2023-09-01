package reposit;

import dto.BoardDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reposit {
    private List<BoardDTO> dtoList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Boolean write(BoardDTO dto) {
        return dtoList.add(dto);
    }

    public void findall() {
        for (BoardDTO dto : dtoList) {
            System.out.println(dto.writelist());
        }
    }

    public void find(String num) {
        for (BoardDTO dto : dtoList) {
            if (Integer.parseInt(num) == dto.getId()) {
                int i = dto.getBoardHits() + 1;
                dto.setBoardHits(i);
                System.out.println(dto.toString());
            }
        }
    }

    public BoardDTO update(String num) {
        for (BoardDTO dto : dtoList) {
            if (Integer.parseInt(num) == dto.getId()) {
                return dto;
            }
        }
        return null;
    }


    public BoardDTO delete(String num) {
        return null;
    }
}

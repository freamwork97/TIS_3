package repository;

import dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    // 학생정보를 저장할 리스트
    private List<StudentDTO> studentDTOList = new ArrayList<>();

    public Boolean save(StudentDTO sdto) {
        // id 값을 하나로 증가시켜 함께 저장
        // 현재 리스트에 저장된 학생수 가져오고 1증가
        int size = studentDTOList.size();
        sdto.setId((long) size + 1);  //long=
//      신규 학생 리스트에 추가
        return studentDTOList.add(sdto);

    }

    public List<StudentDTO> findAll() {
        return studentDTOList;
    }

    public StudentDTO findById(String id) {
        for (StudentDTO sdto : studentDTOList) {
            if (Long.parseLong(id) == sdto.getId()) {
                return sdto;
            }
        }
//      반복문을 돌려서 일치하는 결과 없으면 null리턴
        return null;
    }

    public StudentDTO deleteId(String id) {
        for (StudentDTO sdto : studentDTOList) {
            if (Long.parseLong(id) == sdto.getId()) {
                studentDTOList.remove(sdto);
                return sdto;
            }
        }
        return null;

    }
}

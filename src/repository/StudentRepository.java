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
        sdto.setId((long) size + 1);
//      신규 학생 리스트에 추가
        return studentDTOList.add(sdto);

    }

    public List<StudentDTO> findAll() {
        return studentDTOList;
    }

    public List<StudentDTO> findById(String inputid) {
        Long id = Long.parseLong(inputid);
        for (StudentDTO sdto : studentDTOList) {
            if (id.equals(sdto.getId())) {
                findAll();
            }
        }
        return studentDTOList;
    }

}

package reposit;

import dto.DTO;

import java.util.ArrayList;
import java.util.List;

public class Reposit {

    private List<DTO> DTOList = new ArrayList<>();

    public Boolean save(DTO dto) {
        return DTOList.add(dto);
    }

    public List<DTO> findAll() {
        return DTOList;
    }

    public DTO delete(String id) {
        for (DTO dto : DTOList) {
            if (Integer.parseInt(id) == dto.getId()) {
                DTOList.remove(dto);
                return dto;
            }
        }
        return null;
    }

    public DTO login(String email, String passwd) {
        for (DTO dto : DTOList) {
            if (email.equals(dto.getEmail()) &&
                    passwd.equals(dto.getPasswd())) {
                return dto;

            }
        }
        return null;
    }

}

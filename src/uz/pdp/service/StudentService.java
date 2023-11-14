package uz.pdp.service;

import uz.pdp.payload.StudentDTO;

import java.util.List;

public interface StudentService {

    //1
    List<StudentDTO> getByGroup(Integer GroupId);

    //2
    StudentDTO getById(Integer id);

    //3
    StudentDTO add(StudentDTO StudentDTO);

    //4
    StudentDTO edit(Integer id, StudentDTO StudentDTO);

    //5
    boolean delete(Integer id);

    //6
    String read(Integer id);

    //7
    boolean serialize();

    //8
    boolean deserialize();

}

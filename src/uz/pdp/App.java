package uz.pdp;

import uz.pdp.entity.Address;
import uz.pdp.entity.Group;
import uz.pdp.payload.StudentDTO;
import uz.pdp.service.StudentServiceImpl;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        StudentServiceImpl studentService = StudentServiceImpl.getInstance();
        studentService.deserialize();

        studentService.add(new StudentDTO(
                1234
                ,"firstName1"
                ,"lastName1"
                ,99899123
                , LocalDate.of(2000,01,01)
                ,new Group(1234,"GroupName1")
                ,new Address(1234,"Uzb","Tash","Shaykhantahur")
                ,"biographyFilePathExample.txt"
        ));

    }
}

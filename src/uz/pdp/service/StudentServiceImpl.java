package uz.pdp.service;

import uz.pdp.entity.Group;
import uz.pdp.entity.Student;
import uz.pdp.payload.StudentDTO;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class StudentServiceImpl implements StudentService{

    private static StudentServiceImpl instance;

    public List<Student> students = Collections.synchronizedList(new ArrayList<>());

    private static Lock lock = new ReentrantLock();

    private static Logger logger = Logger.getLogger("StudentService");

    private StudentServiceImpl() {
    }

    public static StudentServiceImpl getInstance() {

        if (Objects.isNull(instance)) {
            lock.lock();
            if (Objects.isNull(instance)) {
                instance = new StudentServiceImpl();
            }
            lock.unlock();
        }

        return instance;
    }
//    Kiruvchi parametr sifatida group id si kelsa shu groupga tegishli studentlarni qaytaruvchi metod yozilsin

    @Override
    public List<StudentDTO> getByGroup(Integer GroupId) {
        return students
                .stream()
                .filter(student -> student.getGroup().getId().equals(GroupId))
                .map(this::toDTO)
                .toList();
    }

    @Override
    public StudentDTO getById(Integer id) {
        Optional<Student> optionalStudent = students
                .stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();

        Student student = optionalStudent.orElseThrow(() -> new RuntimeException("No any student with this id : " + id));
        return toDTO(student);
    }

    @Override
    public StudentDTO add(StudentDTO studentDTO) {

        int id = students.size() + 1;

        List<Group> groups = GroupServiceImpl.getInstance().groups;

        GroupService groupService = GroupServiceImpl.getInstance();

        Group group = groupService.getByIdOrElseThrow(studentDTO.getGroup().getId());

        Student student = new Student(
                id,
                studentDTO.getFirstName(),
                studentDTO.getLastName(),
                studentDTO.getPhoneNumber(),
                studentDTO.getBirthDate(),
                group,
                studentDTO.getAddress(),
                studentDTO.getBiographyFilePath()
        );

        students.add(student);

        return toDTO(student);
    }

    @Override
    public StudentDTO edit(Integer id, StudentDTO studentDTO) {
        Optional<Student> optionalStudent = students
                .stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();

        Student student = optionalStudent.orElseThrow(() -> new RuntimeException("No any student with this id : " + id));

        student.setId(studentDTO.getId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setBirthDate(studentDTO.getBirthDate());
        student.setGroup(studentDTO.getGroup());
        student.setAddress(studentDTO.getAddress());
        student.setBiographyFilePath(studentDTO.getBiographyFilePath());

        GroupService groupServiceService = GroupServiceImpl.getInstance();
        Group group = groupServiceService.getByIdOrElseThrow(studentDTO.getGroup().getId());
        student.setGroup(group);

        return toDTO(student);
    }

    @Override
    public boolean delete(Integer id) {

        Optional<Student> optionalStudent = students
                .stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();

        Student student1 = optionalStudent.orElseThrow(() -> new RuntimeException("No any student with this id : " + id));

        try {

            Student student = student1;

            students.remove(student);

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String read(Integer id) {
        Optional<Student> optionalStudent = students
                .stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();

        Student student1 = optionalStudent.orElseThrow(() -> new RuntimeException("No any student with this id : " + id));

        Student student = student1;

        Path path = Paths.get(student.getBiographyFilePath());


        return readFileViaFileInputStream(path);
    }

    @Override
    public boolean serialize() {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("db/students.txt"))) {

            objectOutputStream.writeObject(students);
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deserialize() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("db/students.txt"))){

            students = (List<Student>)objectInputStream.readObject();

            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

//    Methods

    public StudentDTO toDTO(Student student) {
        return new StudentDTO(
                student.getId()
                ,student.getFirstName()
                ,student.getLastName()
                ,student.getPhoneNumber()
                ,student.getBirthDate()
                ,student.getGroup()
                ,student.getAddress()
                ,student.getBiographyFilePath()
        );
    }

    private String readFileViaFileInputStream(Path path) {
        try(InputStream inputStream = new FileInputStream(path.toFile())) {

            byte[] bytes = inputStream.readAllBytes();

            return new String(bytes);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

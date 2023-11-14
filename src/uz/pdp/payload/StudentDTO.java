package uz.pdp.payload;

import uz.pdp.entity.Address;
import uz.pdp.entity.Group;

import java.time.LocalDate;

public class StudentDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private LocalDate birthDate;
    private Group group;
    private Address address;
    private String biographyFilePath;

    public StudentDTO(Integer id, String firstName, String lastName, Integer phoneNumber, LocalDate birthDate, Group group, Address address, String biographyFilePath) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.group = group;
        this.address = address;
        this.biographyFilePath = biographyFilePath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getBiographyFilePath() {
        return biographyFilePath;
    }

    public void setBiographyFilePath(String biographyFilePath) {
        this.biographyFilePath = biographyFilePath;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", birthDate=" + birthDate +
                ", group=" + group +
                ", address=" + address +
                ", biographyFilePath='" + biographyFilePath + '\'' +
                '}';
    }
}

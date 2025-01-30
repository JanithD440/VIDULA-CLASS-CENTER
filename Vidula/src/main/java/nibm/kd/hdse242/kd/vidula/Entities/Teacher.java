package nibm.kd.hdse242.kd.vidula.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String teacherID;

    private String teacherName;
    private String teacherAddress;
    private int age;
    private String gender;
    private String subject;
    private String teacherPhone;

    public Teacher() {

    }

    public Teacher(String teacherID, String teacherName, String teacherAddress, String gender, String subject, String teacherPhone, int age) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.teacherAddress = teacherAddress;
        this.gender = gender;
        this.subject = subject;
        this.teacherPhone = teacherPhone;
        this.age = age;
    }
    public String getTeacherID() {
        return teacherID;
    }
    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }
    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getTeacherPhone() {
        return teacherPhone;
    }
    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }
    public String getTeacherAddress() {
        return teacherAddress;
    }
    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }
}

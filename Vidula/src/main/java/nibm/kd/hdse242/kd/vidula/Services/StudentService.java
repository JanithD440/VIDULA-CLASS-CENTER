package nibm.kd.hdse242.kd.vidula.Services;

import nibm.kd.hdse242.kd.vidula.Entities.Student;
import nibm.kd.hdse242.kd.vidula.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student getStudentById(String id) {
        return studentRepository.getReferenceById(id);
    }
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
    public Student updateStudentById(String id, Student student) {
        return studentRepository.save(student);
    }
    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }
}

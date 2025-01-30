package nibm.kd.hdse242.kd.vidula.Services;

import jakarta.persistence.EntityNotFoundException;
import nibm.kd.hdse242.kd.vidula.Entities.Student;
import nibm.kd.hdse242.kd.vidula.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student getStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with ID " + id + " not found"));
    }
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
    public Student updateStudentById(String id, Student student) {
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException("Student with ID " + id + " not found");
        }
        return studentRepository.save(student);
    }
    public void deleteStudentById(String id) {
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException("Student with ID " + id + " not found");
        }
        studentRepository.deleteById(id);
    }
}

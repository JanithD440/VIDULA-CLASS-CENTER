package nibm.kd.hdse242.kd.vidula.Controllers;

import nibm.kd.hdse242.kd.vidula.Entities.Student;
import nibm.kd.hdse242.kd.vidula.Services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public Student getOneStudent(@PathVariable String id){
        return studentService.getStudentById(id);
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student student){
        return studentService.updateStudentById(id, student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id){
        studentService.deleteStudentById(id);
    }
}

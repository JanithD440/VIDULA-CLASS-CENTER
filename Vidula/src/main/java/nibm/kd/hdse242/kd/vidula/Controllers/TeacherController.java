package nibm.kd.hdse242.kd.vidula.Controllers;

import nibm.kd.hdse242.kd.vidula.Entities.Teacher;
import nibm.kd.hdse242.kd.vidula.Services.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }
    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable String id) {
        return teacherService.getTeacherById(id);
    }
    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }
    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable String id, @RequestBody Teacher teacher) {
        return teacherService.updateTeacherById(id, teacher);
    }
    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable String id) {
        teacherService.deleteTeacherById(id);
    }
}

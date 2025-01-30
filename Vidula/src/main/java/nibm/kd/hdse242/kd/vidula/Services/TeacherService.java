package nibm.kd.hdse242.kd.vidula.Services;

import jakarta.persistence.EntityNotFoundException;
import nibm.kd.hdse242.kd.vidula.Entities.Teacher;
import nibm.kd.hdse242.kd.vidula.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
    public Teacher getTeacherById(String id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Teacher with ID " + id + " not found"));
    }
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
    public Teacher updateTeacherById(String id, Teacher teacher) {
        if (!teacherRepository.existsById(id)) {
            throw new EntityNotFoundException("Teacher with ID " + id + " not found");
        }
        return teacherRepository.save(teacher);
    }
    public void deleteTeacherById(String id) {
        if (!teacherRepository.existsById(id)) {
            throw new EntityNotFoundException("Teacher with ID " + id + " not found");
        }
        teacherRepository.deleteById(id);
    }
}

package nibm.kd.hdse242.kd.vidula.Services;

import nibm.kd.hdse242.kd.vidula.Entities.Teacher;
import nibm.kd.hdse242.kd.vidula.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
    public Teacher getTeacherById(String id) {
        return teacherRepository.getReferenceById(id);
    }
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
    public Teacher updateTeacherById(String id, Teacher teacher) {
        return teacherRepository.save(teacher);
    }
    public void deleteTeacherById(String id) {
        teacherRepository.deleteById(id);
    }
}

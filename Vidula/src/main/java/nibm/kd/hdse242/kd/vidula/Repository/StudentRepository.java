package nibm.kd.hdse242.kd.vidula.Repository;

import nibm.kd.hdse242.kd.vidula.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}

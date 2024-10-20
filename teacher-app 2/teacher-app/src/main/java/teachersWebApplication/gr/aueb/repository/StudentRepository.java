package teachersWebApplication.gr.aueb.repository;

import teachersWebApplication.gr.aueb.model.Student;
import org.springframework.data.repository.CrudRepository;
public interface StudentRepository extends CrudRepository<Student, Integer> {
    public Long countById(Integer id);
}

package teachersWebApplication.gr.aueb.repository;

import teachersWebApplication.gr.aueb.model.Teacher;
import org.springframework.data.repository.CrudRepository;
    public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
        public Long countById(Integer id);
    }

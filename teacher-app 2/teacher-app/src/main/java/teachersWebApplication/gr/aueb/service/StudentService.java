package teachersWebApplication.gr.aueb.service;

import teachersWebApplication.gr.aueb.exception.StudentException;
import teachersWebApplication.gr.aueb.model.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    public void save(Student student);

    public Student getStudentById(Integer id) throws StudentException;

    public void delete(Integer id) throws StudentException;
}

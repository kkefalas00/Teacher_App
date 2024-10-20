package teachersWebApplication.gr.aueb.service.impl;

import teachersWebApplication.gr.aueb.model.Student;
import teachersWebApplication.gr.aueb.repository.StudentRepository;
import teachersWebApplication.gr.aueb.service.StudentService;
import teachersWebApplication.gr.aueb.exception.StudentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student getStudentById(Integer id) throws StudentException {
        Optional<Student> res = studentRepository.findById(id);
        if (res.isPresent()) {
            return res.get();
        }
        throw new StudentException("Student with this id was not found");
    }

    public void delete(Integer id) throws StudentException {
        Long count = studentRepository.countById(id);
        if (count == null || count == 0) {
            throw new StudentException("Student with this id was not found");
        }
        studentRepository.deleteById(id);
    }

}
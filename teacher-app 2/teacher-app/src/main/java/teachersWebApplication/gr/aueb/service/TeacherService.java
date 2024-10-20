package teachersWebApplication.gr.aueb.service;

import teachersWebApplication.gr.aueb.exception.TeacherException;
import teachersWebApplication.gr.aueb.model.Teacher;

import java.util.List;

public interface TeacherService {

    public List<Teacher> getAllTeachers();

    public void save(Teacher teacher);

    public Teacher getTeacherById(Integer id) throws TeacherException ;

    public void delete(Integer id) throws TeacherException;
}

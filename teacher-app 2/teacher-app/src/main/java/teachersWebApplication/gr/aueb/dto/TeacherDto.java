package teachersWebApplication.gr.aueb.dto;

import teachersWebApplication.gr.aueb.model.Student;
import teachersWebApplication.gr.aueb.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherDto {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean enabled;
    private List<StudentDto> studentsDtos;

    public TeacherDto toTeacherDto(Teacher teacher){
        TeacherDto teacherDto = new TeacherDto();
        if(teacher!=null){
            id = teacher.getId();
            email = teacher.getEmail();
            password = teacher.getPassword();
            firstName = teacher.getFirstName();
            lastName = teacher.getLastName();
            enabled = teacher.getEnabled();
            for (Student student: teacher.getStudents()) {
                StudentDto studentDto = new StudentDto();
                studentDto.toStudentDto(student);
                studentsDtos.add(studentDto);
            }
            return teacherDto;
        }
        return null;
    }

    public Teacher toTeacher() {
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setEmail(email);
        teacher.setPassword(password);
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setEnabled(enabled);
        List<Student> students = new ArrayList<>();
        for (StudentDto studentDto: studentsDtos) {
            Student student = studentDto.toStudent();
            students.add(student);
        }
        return teacher;
    }

}
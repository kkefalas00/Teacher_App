package teachersWebApplication.gr.aueb.dto;

import teachersWebApplication.gr.aueb.model.Student;

public class StudentDto {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean enabled;
    private TeacherDto teacherDto;

    public StudentDto toStudentDto(Student student){
        if(student!=null){
            StudentDto studentDto = new StudentDto();
            id = student.getId();
            email = student.getEmail();
            password = student.getPassword();
            firstName = student.getFirstName();
            lastName = student.getLastName();
            enabled = student.getEnabled();
            teacherDto.toTeacherDto(student.getTeacher());
            return studentDto;
        }
        return null;
    }

    public Student toStudent() {
        Student student = new Student();
        student.setId(id);
        student.setEmail(email);
        student.setPassword(password);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEnabled(enabled);
        student.setTeacher(teacherDto.toTeacher());
        return student;
    }
}

package teachersWebApplication.gr.aueb.controller;

import teachersWebApplication.gr.aueb.exception.StudentException;
import teachersWebApplication.gr.aueb.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import teachersWebApplication.gr.aueb.model.Teacher;
import teachersWebApplication.gr.aueb.service.impl.StudentServiceImpl;
import teachersWebApplication.gr.aueb.service.impl.TeacherServiceImpl;

import java.util.List;

@Controller
public class StudentController {
    @Autowired private StudentServiceImpl studentServiceImpl;
    @Autowired private TeacherServiceImpl teacherServiceImpl;
    @GetMapping("/students")
    public String showStudentList(Model model) {
        List<Student> listStudents = studentServiceImpl.getAllStudents();
        model.addAttribute("listStudents", listStudents);

        return "students";
    }

    @GetMapping("/students/new")
    public String showStudentForm(Model model) {
        List<Teacher> teacherList = teacherServiceImpl.getAllTeachers();
        model.addAttribute("student", new Student());
        model.addAttribute("teachers", teacherList);
        model.addAttribute("pageTitle", "Add New Student");
        return "student_form";
    }

    @PostMapping("/students/save")
    public String saveStudent(Student student, RedirectAttributes ra) {
        studentServiceImpl.save(student);

        ra.addFlashAttribute("message", "The student has been saved successfully.");
        return "redirect:/students"; // Redirect to the listing page after successful save
    }

    @GetMapping("/students/edit/{studentId}")
    public String showStudentEditForm(@PathVariable("studentId") Integer id, Model model, RedirectAttributes ra) {
        try {
            Student student = studentServiceImpl.getStudentById(id);
            model.addAttribute("student", student);
            model.addAttribute("pageTitle", "Here you can edit the student you chose");

            return "student_form";
        } catch (StudentException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/students";
        }
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            studentServiceImpl.delete(id);
            ra.addFlashAttribute("message", "The student with id " + id + " has been deleted.");
        } catch (StudentException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/students";
    }
}
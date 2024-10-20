package teachersWebApplication.gr.aueb.controller;

import teachersWebApplication.gr.aueb.exception.TeacherException;

import teachersWebApplication.gr.aueb.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import teachersWebApplication.gr.aueb.service.impl.TeacherServiceImpl;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired private TeacherServiceImpl teacherServiceImpl;

    @GetMapping("/teachers")
    public String showTeacherList(Model model) {
        List<Teacher> listTeachers = teacherServiceImpl.getAllTeachers();
        model.addAttribute("listTeachers", listTeachers);

        return "teachers";
    }

    @GetMapping("/teachers/new")
    public String showTeacherForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("pageTitle", "Add New Teacher");
        return "teacher_form";
    }

    @PostMapping("/teachers/save")
    public String saveTeacher(Teacher teacher, RedirectAttributes ra) {
        teacherServiceImpl.save(teacher);
        ra.addFlashAttribute("message", "The teacher has been saved successfully.");
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/edit/{teacherId}")
    public String showTeachersEditForm(@PathVariable("teacherId") Integer id, Model model, RedirectAttributes ra) {
        try {
            Teacher teacher = teacherServiceImpl.getTeacherById(id);
            model.addAttribute("teacher", teacher);
            model.addAttribute("pageTitle", "Here you can edit the teacher you chose");

            return "teacher_form";
        } catch (TeacherException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/teachers";
        }
    }

    @GetMapping("/teachers/delete/{teacherId}")
    public String deleteTeacher(@PathVariable("teacherId") Integer id, RedirectAttributes ra) {
        try {
            teacherServiceImpl.delete(id);
            ra.addFlashAttribute("message", "The teacher has been deleted successfully.");
        } catch (TeacherException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/teachers";
    }
}
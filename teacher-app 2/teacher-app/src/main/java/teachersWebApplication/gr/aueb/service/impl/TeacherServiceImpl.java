package teachersWebApplication.gr.aueb.service.impl;

import teachersWebApplication.gr.aueb.model.Teacher;
import teachersWebApplication.gr.aueb.repository.TeacherRepository;
import teachersWebApplication.gr.aueb.service.TeacherService;
import teachersWebApplication.gr.aueb.exception.TeacherException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class TeacherServiceImpl implements TeacherService {
        private TeacherRepository teacherRepository;
        @Autowired
        public TeacherServiceImpl(TeacherRepository teacherRepository){
            this.teacherRepository = teacherRepository;
        }

        public List<Teacher> getAllTeachers() {
            return (List<Teacher>) teacherRepository.findAll();
        }

        public void save(Teacher teacher) {

            teacherRepository.save(teacher);
        }

        public Teacher getTeacherById(Integer id) throws TeacherException {
            Optional<Teacher> res = teacherRepository.findById(id);
            if (res.isPresent()) {
                return res.get();
            }
            throw new TeacherException("Error! Teacher with this id was not found");
        }

        public void delete(Integer id) throws TeacherException {
            Long count = teacherRepository.countById(id);
            if (count == null || count == 0) {
                throw new TeacherException("Error! Teacher with this id was not found");
            }
            teacherRepository.deleteById(id);
        }
    }


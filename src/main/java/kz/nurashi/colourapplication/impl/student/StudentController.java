package kz.nurashi.colourapplication.impl.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    private final StudentService studentService;


    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }



    @PostMapping("students")
    public void registerStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
    }
}

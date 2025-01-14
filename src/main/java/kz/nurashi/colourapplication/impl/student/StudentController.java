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

    @DeleteMapping(path = "students/{id}")
    public void deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
    }


    @PutMapping(path = "students/{id}")
    public void updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
        System.out.println("Worked/////////////////////////////////////////////////");
        studentService.updateStudent(student.getId(), student.getName(), student.getEmail());
    }
}

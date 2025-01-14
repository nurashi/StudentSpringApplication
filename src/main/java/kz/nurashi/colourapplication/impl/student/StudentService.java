package kz.nurashi.colourapplication.impl.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public void addNewStudent(Student student) {

        Optional<Student> studentOptional = studentRepository.findByEmail(student.getEmail());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("This email already exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Integer studentId) {
        if(!studentRepository.existsById(studentId)) {
            throw new IllegalStateException("This student not exists");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Integer id,String name, String email){
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student not found"));

        System.out.println("name: " + name);
        System.out.println("email: " + email);
        System.out.println("prev email " + student.getEmail());

        if(name != null && email != null && !Objects.equals(email, student.getEmail())) {

            student.setName(name);
            Optional<Student> studentOptional = studentRepository.findByEmail(email);
            if(studentOptional.isPresent()) {
                throw new IllegalStateException("This email already exists");
            }
            student.setEmail(email);
        }
        studentRepository.save(student);
    }
}

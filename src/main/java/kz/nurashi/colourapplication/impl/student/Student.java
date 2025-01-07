package kz.nurashi.colourapplication.impl.student;

import jakarta.persistence.*;
import jakarta.persistence.Id;


import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student  {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private int id;
    private String name;
    private LocalDate dob;
    private String email;

    @Transient
    private Integer age;

    public Student() {};
    public Student(int id,
                   String name,
                   LocalDate dob,
                   String email) {
        setId(id);
        setName(name);
        setDob(dob);
        setEmail(email);
    }

    public Student(String name,
                   LocalDate dob,
                   String email) {
        setName(name);
        setDob(dob);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(getDob(), LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


package com.springboot.demo.student;

import java.time.LocalDate;
import java.util.List;

public class StudentService {
    public List<Student> getStudents(){
        return List.of(
                new Student(
                        1L,
                        "Maria",
                        21,
                        LocalDate.of(1996,2,3),
                        "maria.cool@gmail.com"
                )
        );
    }
}

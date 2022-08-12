package com.springboot.demo.student;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
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

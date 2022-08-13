package com.springboot.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
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

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
       if(studentRepository.findStudentByEmail(student.getEmail()).isPresent()){
           throw new IllegalStateException("E-Mail already exists!");
       }
       studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Student Id "+ id + "does not exists!");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Student with "+id+" does not exists!"));
        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            System.out.println(name);
            student.setName(name);
        }
        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
           Optional<Student> exists = studentRepository.findStudentByEmail(email);
           if(exists.isPresent()){
               throw new IllegalStateException("E-Mail taken!");
           }
           student.setEmail(email);
        }
    }
}

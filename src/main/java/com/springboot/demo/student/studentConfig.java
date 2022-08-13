package com.springboot.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class studentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student emily = new Student(
                    "Max",
                    LocalDate.of(2000, Month.FEBRUARY, 3),
                    "test@test.com"
            );
            Student alex = new Student(
                    "Alex",
                    LocalDate.of(2000, Month.MARCH, 3),
                    "test@test.com"
            );
            repository.saveAll(
                    List.of(emily, alex)
            );
        };
    }
}

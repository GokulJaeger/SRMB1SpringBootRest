package com.org.springrest4.springrest4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.org.springrest4.springrest4.model.Account;
import com.org.springrest4.springrest4.model.AccountId;
import com.org.springrest4.springrest4.model.Course;
import com.org.springrest4.springrest4.model.Student;
import com.org.springrest4.springrest4.repository.AccountRepository;
import com.org.springrest4.springrest4.repository.CourseRepository;
import com.org.springrest4.springrest4.repository.EmployeeRepository;
import com.org.springrest4.springrest4.repository.StudentRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springrest4Application {

    
	public static void main(String[] args) {
		SpringApplication.run(Springrest4Application.class, args);
	}

    @Bean
    public CommandLineRunner mappingDemo1(AccountRepository accountRepository,
                                         EmployeeRepository employeeRepository) {
        return args -> {

            accountRepository.save(new Account("458666", "Checking", 4588,"Gokul"));
            accountRepository.save(new Account("458689", "Checking", 2500,"Sachin"));
            accountRepository.save(new Account("424265", "Saving", 100000,"Karthik"));


            List<Account> accounts = accountRepository.findByAccountType("Checking");
            accounts.forEach(System.out::println);


            Optional<Account> account = accountRepository.findById(new AccountId("424265", "Saving"));
            account.ifPresent(System.out::println);

            // employeeRepository.save(new Employee(new EmployeeId(100L, 10L),
            //         "Natsu Drag", "natsu@example.com", "123456"));
            // employeeRepository.save(new Employee(new EmployeeId(101L, 20L),
            //         "Eren JAeger", "eren@example.com", "654321"));

            // List<Employee> employees = employeeRepository.findByEmployeeIdDepartmentId(20L);
            // employees.forEach(System.out::println);


            // Optional<Employee> employee = employeeRepository.findById(new EmployeeId(100L, 10L));
            // employee.ifPresent(System.out::println);
        };
    }

    @Bean
    public CommandLineRunner mappingDemo2(StudentRepository studentRepository,
                                         CourseRepository courseRepository) {
        return args -> {


            Student student = new Student("Goku", 15, "8th");
            Student student1 = new Student("Vegeta", 18, "9th");
            studentRepository.save(student);
            studentRepository.save(student1);

            Course course1 = new Course("Machine Learning", "ML", 12, 1500);
            Course course2 = new Course("Database Systems", "DS", 8, 800);
            Course course3 = new Course("Web Basics", "WB", 10, 0);


            courseRepository.saveAll(Arrays.asList(course1, course2, course3));

            student.getCourses().addAll(Arrays.asList(course1, course2, course3));
            student1.getCourses().addAll(Arrays.asList(course1, course2, course3));

            studentRepository.save(student);
            studentRepository.save(student1);
            System.out.println(studentRepository.findByNameContaining("Goku"));
        };
    }
}

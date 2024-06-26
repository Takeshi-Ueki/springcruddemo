package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {

			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {

		// studentオブジェクトの作成
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@lub2code.com");

		// studentオブジェクトの保存
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// 保存したstudentのidを表示
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}

package com.icsfs.training.jdbc.service;

import java.util.List;
import java.util.Scanner;

import com.icsfs.training.jdbc.entities.Student;
import com.icsfs.training.jdbc.repository.JDBCRepositoryImpl;

public class JDBCService {

	private JDBCRepositoryImpl jdbcRepositoryImpl = new JDBCRepositoryImpl();

	public void addStudent() {
		Scanner scanner = new Scanner(System.in);
		int id;

		while (true) {
			System.out.println("Enter student id number: ");
			id = scanner.nextInt();

			if (jdbcRepositoryImpl.validateStudentId(id)) {
				break;
			}
		}

		scanner = new Scanner(System.in);

		System.out.println("Enter student name: ");
		String name = scanner.nextLine();

		System.out.println("Enter student email: ");
		String email = scanner.nextLine();

		System.out.println("Enter student average: ");
		int average = scanner.nextInt();

		Student student = new Student(id, name, average, email);

		jdbcRepositoryImpl.insertStudent(student);
	}

	public void updateStudentInfo() throws Exception {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student id number: ");
		int id = scanner.nextInt();
		Student studentInfo = jdbcRepositoryImpl.retrieveStudentInfo(id);
		if (studentInfo != null) {
			System.out.println(studentInfo);
			scanner = new Scanner(System.in);
			System.out.println("Enter student new name: ");
			String name = scanner.nextLine();

			System.out.println("Enter student new email: ");
			String email = scanner.nextLine();

			System.out.println("Enter student new average: ");
			int average = scanner.nextInt();

			studentInfo.setAverage(average);
			studentInfo.setEmail(email);
			studentInfo.setName(name);

			jdbcRepositoryImpl.updateStudentInfo(studentInfo);

		} else {
			throw new Exception("Error >> student not found");
		}

	}

	public void showAllStudentsInfo() {
		List<Student> students = jdbcRepositoryImpl.retrieveAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	public void deleteStudentRecord() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student id number: ");
		int id = scanner.nextInt();
		Student studentInfo = jdbcRepositoryImpl.retrieveStudentInfo(id);
		if (studentInfo != null) {
			System.out.println(studentInfo);
			scanner = new Scanner(System.in);
			System.out.println("Are you sure?  yes or no");
			String answer = scanner.nextLine();

			if (answer.equalsIgnoreCase("yes")) {
				int rowsDeleted = jdbcRepositoryImpl.deleteStudentRecord(id);
				if (rowsDeleted > 0) {
					System.out.println("student record deleted.");
				} else {
					System.out.println("no record found.");
				}
			} else {
				System.out.println("aborting delete operation.");
			}

		} else {
			throw new Exception("Error >> student not found");
		}
	}
}

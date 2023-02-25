package com.icsfs.training.jdbc;

import java.util.Scanner;

import com.icsfs.training.jdbc.service.JDBCService;

public class JDBCMain {

	private static JDBCService jdbcService = new JDBCService();

	public static void main(String[] args) {

		boolean menuBoolean = true;
		boolean reEnterMenu = false;
		String result;
		while (menuBoolean) {
			result = reEnterMenu ? "one of the menu options: " : "your Choice: ";

			if (!reEnterMenu) {
				System.out.println("========= Menu ========");
				System.out.println("1- Add Student" + System.lineSeparator() + "2- Update Student"
						+ System.lineSeparator() + "3- Delete Student" + System.lineSeparator() + "4- Show All Students"
						+ System.lineSeparator() + "5- Quit");
			}
			System.out.println("=======================");
			System.out.println("Please Enter " + result);

			Scanner scanner = new Scanner(System.in);

			int input = scanner.nextInt();

			reEnterMenu = false;

			switch (input) {
			case 1:
				System.out.println("Adding new student: ");
				jdbcService.addStudent();
				break;
			case 2:
				System.out.println("Updating student informations: ");
				try {
					jdbcService.updateStudentInfo();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Delete student record: ");
				try {
					jdbcService.deleteStudentRecord();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Showing All Students information: ");
				jdbcService.showAllStudentsInfo();
				break;
			case 5:
				System.out.println("Quitting... ");
				menuBoolean = false;
				break;
			default:
				reEnterMenu = true;
				break;
			}
		}

	}
}

package edu.alpha.ems.controller;

import java.util.Scanner;

import edu.alpha.ems.service.EmployeeService;

public class EmployeeController {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("WelCome To EMS");
		while (true) {
			System.out.println("SELECT The Below Option");
			System.out.println("1.Employee\n2.Project\n3.Department\n4.Exist");
			int choice = read.nextInt();
			switch (choice) {
			case 1:
				EmployeeService.employeeService(read);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				read.close();
				System.exit(0);
				break;
			default:
				System.out.println("Select the Correct Choice!!");
				break;
			}
		}
	}
}

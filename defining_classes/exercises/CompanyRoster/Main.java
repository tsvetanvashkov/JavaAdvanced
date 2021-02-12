package defining_classes.exercises.CompanyRoster;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberInput = Integer.parseInt(scan.nextLine());
		Map<String, Department> departments = new HashMap<String, Department>();
		while (numberInput-- > 0) {
			String[] input = scan.nextLine().split("\\s+");
			 String name = input[0];
			 double salary = Double.parseDouble(input[1]);
			 String position = input[2];
			 String department = input[3];
			 departments.putIfAbsent(department, new Department());
			 Employee employee = null;
			 if (input.length == 6) {
				String email = input[4];
				int age = Integer.parseInt(input[5]);
				employee = new Employee(name, salary, position, department, email, age);
			}else if (input.length == 5) {
				if (input[4].matches("^\\d$")) {
					int age = Integer.parseInt(input[4]);
					employee = new Employee(name, salary, position, department, age);
				}else {
					String email = input[4];
					employee = new Employee(name, salary, position, department, email);
				}
			}else if (input.length == 4) {
				employee = new Employee(name, salary, position, department);
			}
			 departments.get(department).addEmployee(employee);

		}
		scan.close();
		double bestAverage = Double.MIN_VALUE;
		String bestDepartment = "";
		for (Map.Entry<String, Department> entry : departments.entrySet()) {
			if (entry.getValue().averageSelary() > bestAverage) {
				bestAverage = entry.getValue().averageSelary();
				bestDepartment = entry.getKey();
			}
			
		}
		
		System.out.printf("Highest Average Salary: %s\n", bestDepartment);
		departments.get(bestDepartment).employeePrint();
		
		

	}

}

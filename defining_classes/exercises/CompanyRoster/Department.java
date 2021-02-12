package defining_classes.exercises.CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private List<Employee> employeeList;
	
	public Department() {
		this.employeeList = new ArrayList<Employee>();
	}
	
	public void addEmployee(Employee employee) {
		this.employeeList.add(employee);
	}
	
	public double averageSelary() {
		double average = 0.0;
		for (Employee employee : this.employeeList) {
			average += employee.getSalary();
		}
		return average / this.employeeList.size();
	}
	
	public void employeePrint() {
		this.employeeList.stream()
						.sorted((f, s) -> {
							double first = f.getSalary();
							double second = s.getSalary();
							return Double.compare(second, first);
						})
						.forEach(e -> System.out.println(e.toString()));
		
	}

}

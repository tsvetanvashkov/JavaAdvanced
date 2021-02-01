package sets_and_maps_advanced.lab;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentsGrades {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberStudents = Integer.parseInt(scan.nextLine());
		TreeMap<String, ArrayList<Double>> studentsRecord = new TreeMap<String, ArrayList<Double>>();
		while (numberStudents-- > 0) {
			String[] input = scan.nextLine().split("\\s+");
			String student = input[0];
			double grade = Double.parseDouble(input[1]);
			if (!studentsRecord.containsKey(student)) {
				ArrayList<Double> gradesRecord = new ArrayList<Double>();
				gradesRecord.add(grade);
				studentsRecord.put(student, gradesRecord);
			}else {
				ArrayList<Double> gradesRecord = studentsRecord.get(student);
				gradesRecord.add(grade);
			}
			
		}
		scan.close();
		studentsRecord.forEach((k, v) -> {
			System.out.printf("%s -> ", k);
			for (Double grad : v) {
				System.out.printf("%.2f ", grad);
			}
			double average = v.stream()
								.mapToDouble(Double::doubleValue)
								.average()
								.getAsDouble();
			System.out.printf("(avg: %.2f)\n", average);
		});
						
	}

}

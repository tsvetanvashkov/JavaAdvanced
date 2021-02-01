package sets_and_maps_advanced.lab;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberInputs = Integer.parseInt(scan.nextLine());
		TreeMap<String, double[]> registerAcademy = new TreeMap<String, double[]>();
		while (numberInputs-- > 0) {
			String name = scan.nextLine();
			double[] score = Arrays.stream(scan.nextLine().split("\\s+"))
									.mapToDouble(Double::parseDouble)
									.toArray();
			registerAcademy.put(name, score);
		}
		scan.close();
		printRegister(registerAcademy);
		
	}

	private static void printRegister(TreeMap<String, double[]> registerAcademy) {
		
		registerAcademy.forEach((kay, value) -> {
			System.out.printf("%s is graduated with ", kay);
			BigDecimal average = new BigDecimal(0);
			for (int i = 0; i < value.length; i++) {
				BigDecimal num = new BigDecimal(value[i]);
				average = average.add(num);
			}
			BigDecimal length = new BigDecimal(value.length);
			average = average.divide(length);
			System.out.println(average);
		});
		
	}

}

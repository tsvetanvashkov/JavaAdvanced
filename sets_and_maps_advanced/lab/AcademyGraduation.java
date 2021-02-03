package sets_and_maps_advanced.lab;

import java.text.DecimalFormat;
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
			DecimalFormat num = new DecimalFormat("###.################");
			System.out.printf("%s is graduated with ", kay);
			double average = Arrays.stream(value).average().orElse(0);
			System.out.println(num.format(average));
		});
		
	}

}

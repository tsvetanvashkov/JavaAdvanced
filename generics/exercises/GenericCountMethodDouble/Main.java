package generics.exercises.GenericCountMethodDouble;

import java.util.Scanner;

import generics.exercises.GenericCountMethodStrings.Box;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numberInput = Integer.parseInt(scan.nextLine());
		Box<Double> box = new Box<Double>();
		while (numberInput-- > 0) {
			Double input = Double.parseDouble(scan.nextLine());
			box.addValue(input);
		}
		Double toCompare = Double.parseDouble(scan.nextLine());
		scan.close();
		System.out.println(box.countGreaterElements(toCompare));

	}
	
}

package sets_and_maps_advanced.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Sets {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Set<String> carNumber = new LinkedHashSet<String>();
		String input = scan.nextLine();
		while (!input.equals("END")) {
			String[] command = input.split(",\\s+");
			String direction = command[0];
			String number = command[1];
			switch (direction) {
			case "IN":
				carNumber.add(number);
				break;
			case "OUT":
				carNumber.remove(number);
				break;
			}
			input = scan.nextLine();
		}
		scan.close();
		printCarNumbers(carNumber);

	}

	private static void printCarNumbers(Set<String> carNumber) {
		if (carNumber.isEmpty()) {
			System.out.println("Parking Lot is Empty");
		}else {
			for (String number : carNumber) {
				System.out.println(number);
			}
		}	
		
	}

}

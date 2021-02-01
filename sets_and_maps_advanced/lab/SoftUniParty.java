package sets_and_maps_advanced.lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Set<String> reservation = new TreeSet<String>();
		String input = scan.nextLine();
		while (!input.equals("PARTY")) {
			reservation.add(input);
			input = scan.nextLine();
		}
		while (!input.equals("END")) {
			reservation.remove(input);
			input = scan.nextLine();
		}
		scan.close();
		printCarNumbers(reservation);

	}

	private static void printCarNumbers(Set<String> reservation) {
		System.out.println(reservation.size());
		for (String guests : reservation) {
			System.out.println(guests);
		}
		
	}

}

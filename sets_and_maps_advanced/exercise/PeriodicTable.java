package sets_and_maps_advanced.exercise;

import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberInputs = Integer.parseInt(scan.nextLine());
		TreeSet<String> chemicalElements = new TreeSet<String>();
		while (numberInputs-- > 0) {
			String[] elements = scan.nextLine().split("\\s+");
			for (int i = 0; i < elements.length; i++) {
				chemicalElements.add(elements[i]);
			}
		}
		scan.close();
		chemicalElements.forEach(e -> {
			System.out.print(e + " ");
		});

	}

}

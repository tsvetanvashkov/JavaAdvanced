package sets_and_maps_advanced.exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
								.mapToInt(Integer::parseInt)
								.toArray();
		int firstLength = input[0];
		int secondLength = input[1];
		LinkedHashSet<Integer> firstSet = new LinkedHashSet<Integer>();
		LinkedHashSet<Integer> secondSet = new LinkedHashSet<Integer>();
		while (firstLength-- > 0) {
			int num = Integer.parseInt(scan.nextLine());
			firstSet.add(num);
		}
		while (secondLength-- > 0) {
			int num = Integer.parseInt(scan.nextLine());
			secondSet.add(num);
		}
		scan.close();
		firstSet.forEach(e -> {
			if (secondSet.contains(e)) {
				System.out.print(e + " ");
			}
		});
		
	}

}






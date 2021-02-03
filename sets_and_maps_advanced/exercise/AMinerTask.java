package sets_and_maps_advanced.exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinerTask {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedHashMap<String, Integer> mineer = new LinkedHashMap<String, Integer>();
		String input = scan.nextLine();
		int count = 1;
		String resource = "";
		while (!input.equals("stop")) {
			if ((count % 2) != 0) {
				resource = input;
			}else {
				int quantity = Integer.parseInt(input);
				if (!mineer.containsKey(resource)) {
					mineer.put(resource, quantity);
				}else {
					int value = mineer.get(resource);
					mineer.put(resource, (value + quantity));
				}
				
			}
			input = scan.nextLine();
			count++;
		}
		scan.close();
		mineer.forEach((k, v) -> {
			System.out.printf("%s -> %d\n", k, v);
		});

	}

}

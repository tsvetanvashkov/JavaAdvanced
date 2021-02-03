package sets_and_maps_advanced.exercise;

import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] input = scan.nextLine().toCharArray();
		TreeMap<Character, Integer> symbolsMap = new TreeMap<Character, Integer>();
		for (int i = 0; i < input.length; i++) {
			if (!symbolsMap.containsKey(input[i])) {
				symbolsMap.put(input[i], 1);
			}else {
				symbolsMap.put(input[i], symbolsMap.get(input[i]) + 1);
			}
		}
		scan.close();
		symbolsMap.forEach((k, v) -> {
			System.out.printf("%s: %d time/s\n", k, v);
		});

	}

}

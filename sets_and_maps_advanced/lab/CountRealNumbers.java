package sets_and_maps_advanced.lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double[] input = Arrays.stream(scan.nextLine().split("\\s+"))
							.mapToDouble(Double::parseDouble)
							.toArray();
		scan.close();
		Map<Double, Integer> numbersWithCounts = new LinkedHashMap<Double, Integer>();
		for (double num : input) {
			if (!numbersWithCounts.containsKey(num)) {
				numbersWithCounts.put(num, 1);
			}else {
				numbersWithCounts.put(num, numbersWithCounts.get(num) + 1);
			}
	
		}
		
		numbersWithCounts.forEach((k, v) -> {
			System.out.printf("%.1f -> %d\n", k, v);
		});

	}

}

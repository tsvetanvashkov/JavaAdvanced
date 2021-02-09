package functional_programming.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] numbers = Arrays.stream(scan.nextLine().split(",\\s+"))
										.mapToInt(Integer::parseInt)
										.filter(n -> n % 2 == 0)
										.toArray();
		scan.close();
		
		System.out.println(formatArray(numbers));
		
		Arrays.sort(numbers);
		
		System.out.println(formatArray(numbers));

	}
	
	public static String formatArray(int[] arr) {
		return Arrays.stream(arr)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(", "));
	}

}

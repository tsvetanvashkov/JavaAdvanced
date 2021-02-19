package functional_programming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Function<int[], Integer> getMinElement = numbers -> Arrays.stream(numbers)
																	.min()
																	.getAsInt();
		int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
								.mapToInt(Integer::parseInt)
								.toArray();
		scan.close();
		int minElement = getMinElement.apply(numbers);
		System.out.println(minElement);
	}

}

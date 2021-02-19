package functional_programming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
				.mapToInt(Integer::parseInt)
				.toArray();
		Function<int[], int[]> addOne = arr -> Arrays.stream(arr)
														.map(num -> num += 1)
														.toArray();
		Function<int[], int[]> multiplyBYTwo = arr -> Arrays.stream(arr)
															.map(num -> num *= 2)
															.toArray();
		Consumer<int[]> printConsumer = arr -> Arrays.stream(arr)
												.forEach(e -> System.out.print(e + " "));
												
		String command = scan.nextLine();
		while (!command.equals("end")) {
			switch (command) {
			case "add":
				numbers = addOne.apply(numbers);
				break;
			case "multiply":
				numbers = multiplyBYTwo.apply(numbers);
				break;
			case "subtract":
				numbers = subtractOne(numbers);
				break;
			case "print":
				printConsumer.accept(numbers);
				System.out.println();
				break;

			}
			
			command = scan.nextLine();
		}
		scan.close();

	}
	
	public static int[] subtractOne(int[] numbers) {
		return Arrays.stream(numbers)
					.map(num -> num -= 1)
					.toArray();
	}

}

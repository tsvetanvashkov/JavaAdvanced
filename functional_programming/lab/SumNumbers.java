package functional_programming.lab;

import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(",\\s+");
		scan.close();
		
		Function<String, Integer> parser = x -> Integer.parseInt(x);
		
		int sum = getSum(parser, input);

		printOutput(sum, input.length);

	}

	private static void printOutput(int sum, int length) {
		System.out.printf("Count = %d\n", length);
		System.out.printf("Sum = %d\n", sum);
		
	}

	private static int getSum(Function<String, Integer> parser, String[] input) {
		int sum = 0;
		for (String s : input) {
			sum += parser.apply(s);
		}
		return sum;
	}

}

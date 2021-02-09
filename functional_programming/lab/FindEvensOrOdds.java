package functional_programming.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
							.mapToInt(Integer::parseInt)
							.toArray();
		String command = scan.nextLine();
		scan.close();
		int[] output = command.equals("odd")
								? getNumbers(input[0], input[1] + 1, n -> n % 2 != 0 )
								: getNumbers(input[0], input[1] + 1, n -> n % 2 == 0);
		for (int i : output) {
			System.out.printf("%d ", i);
		}
								
	}

	private static int[] getNumbers(int start, int end, IntPredicate predicate) {
		int[] output = IntStream.range(start, end)
									.filter(predicate)
									.toArray();
		return output;
	}

}

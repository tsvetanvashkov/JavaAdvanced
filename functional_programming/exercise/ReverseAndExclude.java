package functional_programming.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
										.map(Integer::parseInt)
										.collect(Collectors.toList());
		int num = Integer.parseInt(scan.nextLine());
		scan.close();
		Collections.reverse(numbers);
		Predicate<Integer> predicate = e -> e % num != 0;
		numbers.stream()
				.filter(e -> predicate.test(e))
				.forEach(e -> System.out.print(e + " "));

	}

}

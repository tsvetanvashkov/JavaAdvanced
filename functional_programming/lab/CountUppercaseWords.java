package functional_programming.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Predicate<String> UpperCase = word -> Character.isUpperCase(word.charAt(0));
		List<String> result = Arrays.stream(scan.nextLine().split("\\s+"))
									.filter(UpperCase)
									.collect(Collectors.toList());
		scan.close();
		System.out.println(result.size());
		System.out.println(result.stream().collect(Collectors.joining(System.lineSeparator())));

	}

}

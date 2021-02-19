package functional_programming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int length = Integer.parseInt(scan.nextLine());
		String[] names = scan.nextLine().split("\\s+");
		Predicate<String> lengthPredicate = name -> name.length() <= length;
		Arrays.stream(names)
				.filter(lengthPredicate)
				.forEach(e -> System.out.println(e));
		scan.close();
		
	}

}

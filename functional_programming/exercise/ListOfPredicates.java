package functional_programming.exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = Integer.parseInt(scan.nextLine());
		Set<Integer> numbersSet = Arrays.stream(scan.nextLine().split("\\s+"))
											.mapToInt(Integer::parseInt)
											.boxed()
											.collect(Collectors.toCollection(HashSet::new));
		scan.close();
		Predicate<Integer> isDevisible = num -> {
			for (Integer divider : numbersSet) {
				if ((num % divider) != 0) {
					return false;
				}
			}
			return true;
		};
		for (int i = 1; i <= number; i++) {
			boolean res = isDevisible.test(i);
			if (res) {
				System.out.print(i + " ");
			}
		}
		
	}

}

package sets_and_maps_advanced.lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Voina_NumberGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedHashSet<Integer> firstDeck = new LinkedHashSet<Integer>();
		firstDeck = Arrays.stream(scan.nextLine().split("\\s+"))
				.map(Integer::parseInt)
				.collect(Collectors.toCollection(LinkedHashSet::new));
		LinkedHashSet<Integer> secondDeck = new LinkedHashSet<Integer>();
		secondDeck = Arrays.stream(scan.nextLine().split("\\s+"))
				.map(Integer::parseInt)
				.collect(Collectors.toCollection(LinkedHashSet::new));
		scan.close();
		int rounds = 50;
		
		while (rounds-- > 0 && !firstDeck.isEmpty() && !secondDeck.isEmpty()) {
			int first = firstDeck.iterator().next();
			firstDeck.remove(first);
			int second = secondDeck.iterator().next();
			secondDeck.remove(second);
			if (first > second) {
				firstDeck.add(first);
				firstDeck.add(second);
			}else if (second > first) {
				secondDeck.add(first);
				secondDeck.add(second);
			}
		}
		
		if (firstDeck.size() > secondDeck.size() ) {
			System.out.println("First player win!");
		}else if (firstDeck.size() < secondDeck.size()) {
			System.out.println("Second player win!");
		}else {
			System.out.println("Draw!");
		}

	}

}

package functional_programming.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
	
	static List<String> names = null;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		names = Arrays.stream(scan.nextLine().split("\\s+"))
									.collect(Collectors.toList());
		String line = scan.nextLine();
		while (!line.equals("Party!")) {
			String[] tokens = line.split("\\s+");
			switch (tokens[0]) {
			case "Double":
				addOneMore(getPredicate(tokens));
				break;
			case "Remove":
				removeName(getPredicate(tokens));
				break;
			}
			
			line = scan.nextLine();
		}
		scan.close();
		if (names.isEmpty()) {
			System.out.println("Nobody is going to the party!");
		}else {
			Collections.sort(names);
			System.out.println(names.toString().replaceAll("([\\[\\]])", "") + " are going to the party!");
		}

	}

	private static void removeName(Predicate<String> predicate) {
		names.removeIf(predicate);
		
	}

	private static void addOneMore(Predicate<String> predicate) {
		List<String> namesToAdd = new ArrayList<String>();
		names.stream()
				.filter(predicate)
				.forEach(namesToAdd::add);
		names.addAll(namesToAdd);
		
	}

	private static Predicate<String> getPredicate(String[] tokens) {
		Predicate<String> predicate = null;
		if (tokens[1].equals("StartsWith")) {
			predicate = name -> name.startsWith(tokens[2]);
		}else if (tokens[1].equals("EndsWith")) {
			predicate = name -> name.endsWith(tokens[2]);
		}else {
			predicate = name -> name.length() == Integer.parseInt(tokens[2]);
		}
		return predicate;
	}

}

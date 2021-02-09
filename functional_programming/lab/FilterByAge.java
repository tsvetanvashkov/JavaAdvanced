package functional_programming.lab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByAge {
	
	public static class Person{
		String name;
		int age;
		
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		Function<String, Person> parsePerson = str -> {
			String[] tokens = str.split(",\\s+");
			return new Person(tokens[0], Integer.parseInt(tokens[1]));
		};
		List<Person> people = new ArrayList<FilterByAge.Person>();
		while (num-- > 0) {
			people.add(parsePerson.apply(scan.nextLine()));
		}
		String condition = scan.nextLine();
		int ageCondition = Integer.parseInt(scan.nextLine());
		String format = scan.nextLine();
		scan.close();
		people = condition.equals("older") 
						? filterPeople(people, p -> p.age >= ageCondition)
						: filterPeople(people, p -> p.age <= ageCondition);
		System.out.println(formatPeople(people, getFormatterFunction(format), System.lineSeparator()));

	}
	
	private static Function<Person, String> getFormatterFunction(String type) {
		switch (type) {
		case "name":
			return p -> p.name;

		case "age":
			return p -> String.valueOf(p.age);
		case "name age":
			return p -> p.name + " - " + String.valueOf(p.age);
		default:
			throw new IllegalStateException("Unkniwn format type" + type);	
		}
	}

	public static String formatPeople(Collection<Person> people, Function<Person, String> formatter, String delimiter) {
		return people.stream()
				.map(formatter::apply)
				.collect(Collectors.joining(delimiter));
	}
	
	public static List<Person> filterPeople(Collection<Person> people, Predicate<Person> predicate){
		return people.stream()
				.filter(predicate)
				.collect(Collectors.toList());
	}

}
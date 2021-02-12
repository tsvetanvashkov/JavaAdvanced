package defining_classes.exercises.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberInput = Integer.parseInt(scan.nextLine());
		List<Person> uperAge = new ArrayList<Person>();
		while (numberInput-- > 0) {
			String[] input = scan.nextLine().split("\\s+");
			String name = input[0];
			int age = Integer.parseInt(input[1]);
			Person person = new Person(name, age);
			uperAge = checkAge(uperAge, person, 30);
		}
		scan.close();
		uperAge.stream()
			.sorted((f, s) -> f.getName().compareTo(s.getName()))
			.forEach(p -> {
				System.out.println(p.toString());
			});

	}

	private static List<Person> checkAge(List<Person> uperAge, Person person, int limit) {
		if (person.getAge() > limit) {
			uperAge.add(person);
		}
		return uperAge;
	}

}

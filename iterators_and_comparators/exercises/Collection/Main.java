package iterators_and_comparators.exercises.Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<String> data = Arrays.stream(scan.nextLine().split("\\s+"))
									.skip(1)
									.collect(Collectors.toList());
		ListyIterator listyIterator = new ListyIterator(data);
		String line = scan.nextLine();
		while (!line.equals("END")) {
			switch (line) {
			case "HasNext":
				System.out.println(listyIterator.iterator().hasNext());
				break;
			case "Move":
				System.out.println(listyIterator.move());
				break;
			case "Print":
				try {
					listyIterator.print();
				} catch (IllegalStateException e) {
					System.out.println(e.getMessage());
				}
				break;
			case "PrintAll":
				try {
					listyIterator.printAll();
					System.out.println();
				} catch (IllegalStateException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			
			line = scan.nextLine();
		}
		scan.close();

	}

}

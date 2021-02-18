package generics.exercises.GenericCountMethodStrings;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numberInput = Integer.parseInt(scan.nextLine());
		Box<String> box = new Box<String>();
		while (numberInput-- > 0) {
			String input = scan.nextLine();
			box.addValue(input);
		}
		String toCompare = scan.nextLine();
		scan.close();
		System.out.println(box.countGreaterElements(toCompare));

	}

}

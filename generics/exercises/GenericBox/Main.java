package generics.exercises.GenericBox;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numberInput = Integer.parseInt(scan.nextLine());
		while (numberInput-- > 0) {
			String input = scan.nextLine();
			Box<String> box = new Box<String>(input);
			System.out.println(box);
		}
		scan.close();

	}

}

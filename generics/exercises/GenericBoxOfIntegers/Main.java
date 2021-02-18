package generics.exercises.GenericBoxOfIntegers;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numberInput = Integer.parseInt(scan.nextLine());
		while (numberInput-- > 0) {
			int input = Integer.parseInt(scan.nextLine());
			Box<Integer> box = new Box<Integer>(input);
			System.out.println(box);
		}
		scan.close();

	}

}
package generics.exercises.GenericSwapMethodIntiger;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numberInput = Integer.parseInt(scan.nextLine());
		Box<Integer> box = new Box<Integer>();
		while (numberInput-- > 0) {
			Integer input = Integer.parseInt(scan.nextLine());
			box.addValue(input);
		}
		int[] index = Arrays.stream(scan.nextLine().split("\\s+"))
								.mapToInt(Integer::parseInt)
								.toArray();
		int index1 = index[0];
		int index2 = index[1];
		box.swap(index1, index2);
		scan.close();
		System.out.println(box);

	}

}

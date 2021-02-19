package iterators_and_comparators.exercises.StackIterator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CustomStack customStack =new CustomStack();
		String[] initialValues = scan.nextLine().split(",\\s+");
		
		customStack.push(Integer.parseInt(initialValues[0].split("\\s")[1]));
		
		for (int i = 1; i < initialValues.length; i++) {
			customStack.push(Integer.parseInt(initialValues[i].trim()));
		}
		
		String line = scan.nextLine();
		while (!line.equals("END")) {
			if (line.equals("Pop")) {
				try {
					customStack.pop();
				} catch (IllegalStateException e) {
					System.out.println(e.getMessage());
				}
			}else {
				customStack.push(Integer.parseInt(line.split("\\s+")[1]));
			}
			line = scan.nextLine();
		}
		scan.close();
		for (int i = 0; i < 2; i++) {
			for (Integer element : customStack) {
				System.out.println(element);
			}
		}
		
	}

}

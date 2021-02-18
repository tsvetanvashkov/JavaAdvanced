package generics.exercises.CustomList;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CustomList<String> custumList = new CustomList<String>();
		String input = scan.nextLine();
		while (!input.equals("END")) {
			String[] tokens = input.split("\\s+");
			String command = tokens[0];
			switch (command) {
			case "Add":
				String elementAdd = tokens[1];
				custumList.add(elementAdd);
				break;
			case "Remove":
				int index = Integer.parseInt(tokens[1]);
				custumList.remove(index);
				break;
			case "Contains":
				String elementContains = tokens[1];
				System.out.println(custumList.contains(elementContains));
				break;
			case "Swap":
				int index1 = Integer.parseInt(tokens[1]);
				int index2 = Integer.parseInt(tokens[2]);
				custumList.swap(index1, index2);
				break;
			case "Greater":
				String element = tokens[1];
				System.out.println(custumList.countGreaterThan(element));
				break;
			case "Max":
				System.out.println(custumList.getMax());
				break;
			case "Min":
				System.out.println(custumList.getMin());
				break;
			case "Print":
				System.out.println(custumList);
				break;
			}
			
			input = scan.nextLine();
		}
		scan.close();

	}

}

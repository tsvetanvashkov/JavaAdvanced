package sets_and_maps_advanced.exercise;

import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, String> phoneBook = new HashMap<String, String>();
		phoneBook = fillPhonebook(scan, phoneBook);
		getContact(scan, phoneBook);

	}

	private static void getContact(Scanner scan, HashMap<String, String> phoneBook) {
		String name = scan.nextLine();
		while (!name.equals("stop")) {
			if (phoneBook.containsKey(name)) {
				System.out.printf("%s -> %s\n", name, phoneBook.get(name));
			}else {
				System.out.printf("Contact %s does not exist.\n", name);
			}
			name = scan.nextLine();
		}
		
	}

	private static HashMap<String, String> fillPhonebook(Scanner scan, HashMap<String, String> phoneBook) {
		String input = scan.nextLine();
		while (!input.equals("search")) {
			String[] info = input.split("-");
			String name = info[0];
			String number = info[1];
			phoneBook.put(name, number);
			input = scan.nextLine();
		}
		return phoneBook;
	}

}

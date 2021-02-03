package sets_and_maps_advanced.exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberInputs = Integer.parseInt(scan.nextLine());
		LinkedHashSet<String> usernames = new LinkedHashSet<String>();
		while (numberInputs-- > 0) {
			String user = scan.nextLine();
			usernames.add(user);
		}
		scan.close();
		printUsernames(usernames);

	}

	private static void printUsernames(LinkedHashSet<String> usernames) {
		for (String user : usernames) {
			System.out.println(user);
		}
		
	}

}

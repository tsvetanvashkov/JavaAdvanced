package sets_and_maps_advanced.exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedHashMap<String, String> emailsMap = new LinkedHashMap<String, String>();
		String input = scan.nextLine();
		int count = 1;
		String name = "";
		while (!input.equals("stop")) {
			if ((count % 2) != 0) {
				name = input;
			}else {
				String[] mail = input.split("[.]");
				if (!mail[1].equals("us") && !mail[1].equals("uk") && !mail[1].equals("com")) {
					emailsMap.put(name, input);
				}

			}
			input = scan.nextLine();
			count++;
		}
		scan.close();
		emailsMap.forEach((k, v) -> {
			System.out.printf("%s -> %s\n", k, v);
		});

	}

}

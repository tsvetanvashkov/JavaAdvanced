package stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque<String> stack = new ArrayDeque<String>();
		String input = scan.nextLine();
		String currentURL = null;
		while (!input.equals("Home")) {
			if (input.equals("back")) {
				if (stack.isEmpty()) {
					System.out.println("no previous URLs");
				}else {
					currentURL =stack.pop();
					System.out.println(currentURL);
				}
				
			}else {
				if (currentURL != null) {
					stack.push(currentURL);
				}
				currentURL = input;
				System.out.println(currentURL);
			}
			
			input = scan.nextLine();
		}
		scan.close();

	}

}

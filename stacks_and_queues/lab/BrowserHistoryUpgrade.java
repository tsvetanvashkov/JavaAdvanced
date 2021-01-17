package stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque<String> stack = new ArrayDeque<String>();
		ArrayDeque<String> queue = new ArrayDeque<String>();
		String input = scan.nextLine();
		String currentURL = null;
		while (!input.equals("Home")) {
			if (input.equals("back")) {
				if (stack.isEmpty()) {
					System.out.println("no previous URLs");
				}else {
					queue.offerFirst(currentURL);
					currentURL = stack.pop();
					System.out.println(currentURL);
				}
				
			}else if (input.equals("forward")) {
				if (queue.isEmpty()) {
					System.out.println("no next URLs");
				}else {
					currentURL = queue.peek();
					System.out.println(queue.poll());
				}
			}else {
				if (currentURL != null) {
					stack.push(currentURL);
				}
				if (!queue.isEmpty()) {
					queue.clear();
				}
				currentURL = input;
				System.out.println(currentURL);
			}
			
			input = scan.nextLine();
		}
		scan.close();

	}

}

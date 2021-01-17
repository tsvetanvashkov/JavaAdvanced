package stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == '(') {
				stack.push(i);
			}else if (ch == ')') {
				int startIndex = stack.pop();
				String counters = input.substring(startIndex, i + 1);
				System.out.println(counters);
			}
		}

	}

}

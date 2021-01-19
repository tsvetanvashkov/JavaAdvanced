package stack_and_queue.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] input = scan.nextLine().toCharArray();
		scan.close();
		char[] openChar = {'{', '[', '('};
		char[] closeChar = {'}', ']', ')'};
		ArrayDeque<Character> stack = new ArrayDeque<Character>();
		boolean isBalanced = true;
		
		if ((input.length) % 2 == 0) {
			for (int i = 0; i < (input.length / 2); i++) {
				boolean notPushed = true;
				for (int j = 0; j < openChar.length; j++) {
					if (input[i] == openChar[j]) {
						stack.push(closeChar[j]);
						notPushed = false;
						break;
					}
				}
				if (notPushed) {
					isBalanced = false;
					break;
				}
			}
			for (int i = (input.length / 2); i < input.length; i++) {
				if (input[i] != stack.pop()) {
					isBalanced = false;
					break;
				}
			}
		}else {
			isBalanced = false;
		}
		
		if (isBalanced) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	
	}

}

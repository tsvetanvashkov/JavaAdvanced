package stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque<String> stack = new ArrayDeque<String>();
		String[] input = scan.nextLine().split("\\s+");
		scan.close();
		Collections.addAll(stack, input);
		while (stack.size() > 1) {
			int num1 = Integer.valueOf(stack.pop());
			String op = stack.pop();
			int num2 = Integer.valueOf(stack.pop());
			
			switch (op) {
			case "+":
				stack.push(String.valueOf(num1 + num2));
				break;
			case "-":
				stack.push(String.valueOf(num1 - num2));
				break;
			}
		}
		
		System.out.println(stack.pop());

	}

}

package stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int decimal = scan.nextInt();
		scan.close();
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		if (decimal == 0) {
			stack.push(0);
		}else {
			while (decimal != 0) {
				stack.push(decimal % 2);
				decimal /= 2;
			}
		}
		while (stack.size() != 0) {
			System.out.print(stack.pop());
		}

	}

}

package stack_and_queue.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberComands = Integer.parseInt(scan.nextLine());
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		ArrayDeque<Integer> max = new ArrayDeque<Integer>();
		while (numberComands > 0) {
			int[] command = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			switch (command[0]) {
			case 1:
				stack.push(command[1]);
				if (max.isEmpty()) {
					max.push(command[1]);
				}else {
					if (max.peek() < stack.peek()) {
						max.push(command[1]);
					}else {
						max.push(max.peek());
					}
				}
				break;
			case 2:
				stack.pop();
				max.pop();
				break;
			case 3:
				System.out.println(max.peek());
				break;
			}
			numberComands--;
		}
		scan.close();

	}

}

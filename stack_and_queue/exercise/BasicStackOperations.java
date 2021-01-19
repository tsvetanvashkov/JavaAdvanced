package stack_and_queue.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int[] sequence = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		scan.close();
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		stack = pushingToStack(stack, sequence, input[0]);
		stack = popingFromStack(stack, input[1]);
		printing(stack, input[2]);
		
	}

	private static void printing(ArrayDeque<Integer> stack, int x) {
		if (stack.contains(x)) {
			System.out.println("true");
		}else {
			if (stack.isEmpty()) {
				System.out.println("0");
			}else {
				printSmallestElementFromStack(stack);
			}
		}
		
	}

	private static void printSmallestElementFromStack(ArrayDeque<Integer> stack) {
		int small = Integer.MAX_VALUE;
		for (Integer num : stack) {
			if (num < small) {
				small = num;
			}
			stack.pop();
		}
		System.out.println(small);
		
	}

	private static ArrayDeque<Integer> popingFromStack(ArrayDeque<Integer> stack, int s) {
		while (s > 0) {
			stack.pop();
			s--;
		}
		return stack;
	}

	private static ArrayDeque<Integer> pushingToStack(ArrayDeque<Integer> stack, int[] sequence, int n) {
		for (int i = 0; i < sequence.length; i++, n--) {
			if (n == 0) {
				break;
			}
			stack.push(sequence[i]);
		}
		return stack;
	}

}

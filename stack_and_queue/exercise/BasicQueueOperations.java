package stack_and_queue.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int[] sequence = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		scan.close();
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		queue = offeringToStack(queue, sequence, input[0]);
		queue = pollingFromStack(queue, input[1]);
		printing(queue, input[2]);

	}

	private static void printing(ArrayDeque<Integer> queue, int x) {
		if (queue.contains(x)) {
			System.out.println("true");
		}else {
			if (queue.isEmpty()) {
				System.out.println("0");
			}else {
				printSmallestElementFromStack(queue);
			}
		}
		
	}

	private static void printSmallestElementFromStack(ArrayDeque<Integer> queue) {
		int small = Integer.MAX_VALUE;
		for (Integer num : queue) {
			if (num < small) {
				small = num;
			}
			queue.poll();
		}
		System.out.println(small);
		
	}

	private static ArrayDeque<Integer> pollingFromStack(ArrayDeque<Integer> queue, int s) {
		while (s > 0) {
			queue.poll();
			s--;
		}
		return queue;
	}

	private static ArrayDeque<Integer> offeringToStack(ArrayDeque<Integer> queue, int[] sequence, int n) {
		for (int i = 0; i < sequence.length; i++, n--) {
			if (n == 0) {
				break;
			}
			queue.offer(sequence[i]);
		}
		return queue;
	}

}

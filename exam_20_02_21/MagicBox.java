package exam_20_02_21;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MagicBox {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ArrayDeque<Integer> firstQueue = getValuesQ(scan);
		ArrayDeque<Integer> secondStack = getValuesS(scan);
		List<Integer> myCollection = new ArrayList<Integer>();
		
		while (!firstQueue.isEmpty() && !secondStack.isEmpty()) {
			int sum = firstQueue.peek() + secondStack.peek();
			if ((sum % 2) == 0) {
				myCollection.add(sum);
				firstQueue.poll();
				secondStack.poll();
			}else {
				firstQueue.offer(secondStack.poll());
			}
		}
		
		if (firstQueue.isEmpty()) {
			System.out.println("First magic box is empty.");
		}else if (secondStack.isEmpty()) {
			System.out.println("Second magic box is empty.");
		}
		
		int listSum = 0;
		for (Integer value : myCollection) {
			listSum += value;
		}
		if (listSum >= 90) {
			System.out.printf("Wow, your prey was epic! Value: %d", listSum);
		}else {
			System.out.printf("Poor prey... Value: %d", listSum);
		}
		

	}

	private static ArrayDeque<Integer> getValuesS(Scanner scan) {
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		int[] sequence = Arrays.stream(scan.nextLine().split("\\s+"))
								.mapToInt(Integer::parseInt)
								.toArray();
		for (int value : sequence) {
			stack.push(value);
		}
		return stack;
	}

	private static ArrayDeque<Integer> getValuesQ(Scanner scan) {
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		int[] sequence = Arrays.stream(scan.nextLine().split("\\s+"))
								.mapToInt(Integer::parseInt)
								.toArray();
		for (int value : sequence) {
			queue.offer(value);
		}
		return queue;
	}

}

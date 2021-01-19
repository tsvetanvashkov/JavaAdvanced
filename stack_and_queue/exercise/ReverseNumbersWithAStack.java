package stack_and_queue.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		Arrays.stream(scan.nextLine()
				.split("\\s+"))
				.mapToInt(Integer::parseInt)
				.forEach(e -> stack.push(e));
		
		scan.close();
		String output = "";
		for (Integer num : stack) {
			output += num + " ";
		}
		System.out.println(output.trim());
	}

}

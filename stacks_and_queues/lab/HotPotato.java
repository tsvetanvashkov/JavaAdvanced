package stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class HotPotato {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque<String> queue = new ArrayDeque<String>();
		Arrays.stream(scan.nextLine()
				.split("\\s+"))
				.forEach(e -> queue.offer(e));
		int length = scan.nextInt();
		scan.close();
		
		while (queue.size() > 1) {
			for (int i = 1; i < length; i++) {
				queue.offer(queue.poll());
			}
			System.out.println("Removed " + queue.poll());
		}
		System.out.println("Last is " + queue.poll());

	}

}

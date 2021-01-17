package stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MathPotato {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque<String> queue = new ArrayDeque<String>();
		Arrays.stream(scan.nextLine()
				.split("\\s+"))
				.forEach(e -> queue.offer(e));
		int length = scan.nextInt();
		scan.close();
		int cycle = 1;
		
		while (queue.size() > 1) {
			for (int i = 1; i < length; i++) {
				queue.offer(queue.poll());
			}
			if (isPrime(cycle)) {
				System.out.println("Prime " + queue.peek());
			}else {
				System.out.println("Removed " + queue.poll());
			}
			cycle++;
		}
		System.out.println("Last is " + queue.poll());

	}

	private static boolean isPrime(int cycle) {
		if (cycle == 1) {
			return false;
		}
		for (int i = 2; i <= (cycle / 2); i++) {
			if ((cycle % i) == 0) {
				return false;
			}
		}
		return true;
	}

}

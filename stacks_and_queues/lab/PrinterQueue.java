package stacks_and_queues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque<String> queue = new ArrayDeque<String>();
		String input = scan.nextLine();
		
		while (!input.equals("print")) {
			if (input.equals("cancel")) {
				String file = queue.poll();
				if (file == null) {
					System.out.println("Printer is on standby");
				}else {
					System.out.println("Canceled " + file);
				}
			}else {
				queue.offer(input);
			}
			input = scan.nextLine();
		}
		
		scan.close();
		for (String filePrint : queue) {
			System.out.println(filePrint);
		}

	}

}

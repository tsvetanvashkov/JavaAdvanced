package stack_and_queue.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberOfOperations = Integer.parseInt(scan.nextLine());
		String text = "";
		ArrayDeque<String> stack = new ArrayDeque<String>();
		
		while (numberOfOperations > 0) {
			String[] command = scan.nextLine().split("\\s+");
			switch (command[0]) {
			case "1":
				text = text.concat(command[1]);
				stack.push(text);
				break;
			case "2":
				text = text.substring(0, (text.length() - Integer.parseInt(command[1])));
				stack.push(text);
				break;
			case "3":
				System.out.println(text.charAt(Integer.parseInt(command[1]) - 1));
				break;
			case "4":
				
				if (stack.isEmpty()) {
					break;
				}else {
					stack.pop();
					if (stack.isEmpty()) {
						text = "";
					}else {
						text = stack.peek();
					}
					
				}
				
				break;
			}
			numberOfOperations--;
		}
		scan.close();

	}

}

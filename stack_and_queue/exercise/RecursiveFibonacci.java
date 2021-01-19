package stack_and_queue.exercise;

import java.util.Scanner;

public class RecursiveFibonacci {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.close();
		int output = getFibonacci(num + 1);
		System.out.println(output);
		

	}

	private static int getFibonacci(int num) {
		int[] f = new int[num + 2];
		f[0] = 0;
		f[1] = 1;
		for (int i = 2; i <= num; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		
		return f[num];
	}

}

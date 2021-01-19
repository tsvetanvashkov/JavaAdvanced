package stack_and_queue.exercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Robotics {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Map<String, List<Integer>> robots = new LinkedHashMap<String, List<Integer>>();
		ArrayDeque<String> productsQueue = new ArrayDeque<String>();
		robots = getMapOfRobots(robots, scan);
		int[] clock = Arrays.stream(scan.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();
		productsQueue = getProducts(productsQueue, scan);
		getRun(robots, clock, productsQueue);
		
	}

	private static void getRun(Map<String, List<Integer>> robots, int[] clock, ArrayDeque<String> productsQueue) {
		while (!productsQueue.isEmpty()) {
			clock = time(clock);
			String product = productsQueue.poll();
			boolean notTakeProduct = true;
			for (Map.Entry<String, List<Integer>> entry: robots.entrySet()) {
				List<Integer> robotParameters = entry.getValue();
				if (robotParameters.get(1) > 0) {
					robotParameters.set(1, (robotParameters.get(1) - 1));
				}
				if (robotParameters.get(1) == 0 && notTakeProduct) {
					notTakeProduct = false;
					robotParameters.set(1, robotParameters.get(0));
					printing(entry.getKey(), product, clock);
				}
			}
			if (notTakeProduct) {
				productsQueue.offer(product);
			}
		
		}
		
	}

	private static void printing(String robot, String product, int[] clock) {
		System.out.printf("%s - %s [%02d:%02d:%02d]\n", robot, product, clock[0], clock[1], clock[2]);
		
	}

	private static int[] time(int[] clock) {
		clock[2]++;
		if (clock[2] >= 60) {
			clock[2] = 0;
			clock[1]++;
		}
		if (clock[1] >= 60) {
			clock[1] = 0;
			clock[0]++;
		}
		if (clock[0] >= 24) {
			clock[0] = 0;
		}	
		return clock;
	}

	private static ArrayDeque<String> getProducts(ArrayDeque<String> productsQueue, Scanner scan) {
		String product = scan.nextLine();
		while (!product.equals("End")) {
			productsQueue.offer(product);
			product = scan.nextLine();
		}
		return productsQueue;
	}

	private static Map<String, List<Integer>> getMapOfRobots(Map<String, List<Integer>> robots, Scanner scan) {
		String[] inputRobots = scan.nextLine().split("[;-]");
		for (int i = 0; i < inputRobots.length; i += 2) {
			List<Integer> values = new ArrayList<Integer>();
			values.add(Integer.parseInt(inputRobots[i + 1]));
			values.add(0);
			robots.put(inputRobots[i], values);
		}
		return robots;
	}

}

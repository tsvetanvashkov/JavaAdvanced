package defining_classes.lab.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		Map<Integer, BankAccount> bankUsers = new HashMap<Integer, BankAccount>();
		while (!input.equals("End")) {
			String[] command = input.split("\\s+");
			String output;
			switch (command[0]) {
			case "Deposit":
				int id = Integer.parseInt(command[1]);
				if (!bankUsers.containsKey(id)) {
					output = "Account does not exist";
					break;
				}
				double amount = Double.parseDouble(command[2]);
				bankUsers.get(id).deposit(amount);
				output = "Deposited " + (int)amount + " to ID" + id;
				break;
			case "SetInterest":
				double newInterest = Double.parseDouble(command[1]);
				BankAccount.setInterestRate(newInterest);
				output = null;
				break;
			case "GetInterest":
				int iD = Integer.parseInt(command[1]);
				if (!bankUsers.containsKey(iD)) {
					output = "Account does not exist";
					break;
				}
				int years = Integer.parseInt(command[2]);
				double interest = bankUsers.get(iD).getInterest(years);
				output = String.format("%.2f", interest);
				break;
			default:
				BankAccount bankAccount = new BankAccount();
				bankUsers.put(bankAccount.getId(), bankAccount);
				output = "Account ID" + bankAccount.getId() + " created";
				break;
			}
			if (output != null) {
				System.out.println(output);
			}
			input = scan.nextLine();
		}
		scan.close();

	}

}

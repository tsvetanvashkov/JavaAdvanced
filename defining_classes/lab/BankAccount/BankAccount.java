package defining_classes.lab.BankAccount;

public class BankAccount {
	private static int accauntCount = 1;
	private static double interestRate = 0.02;
	private double balance;
	private int id;
	
	public BankAccount() {
		this.id = accauntCount;
		accauntCount++;
		
	}
	
	public int getId() {
		return id;
	}

	public static void setInterestRate(double interestRate) {
		BankAccount.interestRate = interestRate;
	}
	
	public double getInterest(int years) {
		return balance * interestRate * years;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	

}

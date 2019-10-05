
public class SavingsAccount extends Account {
	private double monthlyInterestRate;
	private double monthlyInterestPayment;

	public SavingsAccount() {
		
	}

	public SavingsAccount(double balance, double monthlyInterestRate) {
		super(balance);
		this.monthlyInterestRate = monthlyInterestRate;
	}

	public void applyPaymentToBalance() {
		// assumes montlyInterestPayment = balance * monthlyInterestRate
		this.monthlyInterestPayment = balance * monthlyInterestRate;
		this.balance += monthlyInterestPayment;
	}
	
	public double getMonthlyInterestPayment() {
		return monthlyInterestPayment;
	}
}


public class CheckingAccount extends Account {

	private double monthlyFee;
	public CheckingAccount() {
		
	}

	public double getMonthlyFee() {
		return monthlyFee;
	}

	public CheckingAccount(double balance, double monthlyFee) {
		super(balance);
		this.monthlyFee = monthlyFee;
	}

	public void subtractMonthlyFee() {
		//this.setBalance(getBalance() - monthlyFee);
		this.balance -= monthlyFee;
	}
}

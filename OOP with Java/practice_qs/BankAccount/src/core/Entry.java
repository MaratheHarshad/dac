package core;

public class Entry {
	
	
	String transactionDate;
	String narration;
	double withdrawalAmount;
	
	public String getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}


	public String getNarration() {
		return narration;
	}


	public void setNarration(String narration) {
		this.narration = narration;
	}


	public double getWithdrawalAmount() {
		return withdrawalAmount;
	}


	public void setWithdrawalAmount(double withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}


	public double getDepositAmount() {
		return depositAmount;
	}


	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}


	double depositAmount;
	
	
	public Entry(String transactionDate, String narration, double withdrawalAmount, double depositAmount) {
		super();
		this.transactionDate = transactionDate;
		this.narration = narration;
		this.withdrawalAmount = withdrawalAmount;
		this.depositAmount = depositAmount;
	}
	
	
	
}

package core;

public enum ServicePlan {
	
	SILVER(1000), GOLD(2000), DIAMOND(5000), PLATINUM(10000);
	
	private int amount;
	
	private ServicePlan(int amount) {
//		super(name(), ordinal())
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}

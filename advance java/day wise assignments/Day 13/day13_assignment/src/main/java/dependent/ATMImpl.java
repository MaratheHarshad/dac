package dependent;

import dependency.CustomerNotification;
import dependency.Transport;

public class ATMImpl implements ATM {
	
	private Transport myTransport;
	private CustomerNotification customerNotification;
	private double cash;

	private ATMImpl(double cash) {
		this.cash = cash;
		System.out.println("in cnstr of " + getClass().getName() + " cash is : " + this.cash);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);// dependent obj is calling dependency's method to inform the bank
		customerNotification.alertCustomer("Money deposited successfully....");
	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
		customerNotification.alertCustomer("Hello, withdraw amount "+amt);
	}

	// custom init method
	public void myInit() {
		System.out.println("in init " + myTransport);// not null
	}

	// custom destroy method
	public void myDestroy() {
		System.out.println("in destroy " + myTransport);// not null
	}
	
	
	
	public void setMyTransport(Transport myTransport) {
		this.myTransport = myTransport;
	}

	public void setCustomerNotification(CustomerNotification customerNotification) {
		this.customerNotification = customerNotification;
	}

	//factory method based D.I
	public static ATMImpl myFactoryMethod(double cash) {
		System.out.println("in factory method "+cash);
		return new ATMImpl(cash);
	}

}

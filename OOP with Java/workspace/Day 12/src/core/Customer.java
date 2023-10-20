package core;

import java.time.LocalDate;
import java.util.Objects;

public class Customer {
	
	private int customer_id;
	private String firsName;
	private String lastName;
	private String email; // PK 
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private LocalDate lastSubscriptionDate;
	private ServicePlan plan;
	
		
	public Customer(String firsName, String lastName, String email, String password, double registrationAmount,
			LocalDate dob, LocalDate lastSubscriptionDate, ServicePlan plan) {
		super();
		this.firsName = firsName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.lastSubscriptionDate = lastSubscriptionDate;
		this.plan = plan;
		this.customer_id = ++Customer.idCount;
	}

	// Overloaded constructor for equals method
	public Customer(String email) {
		super();
		this.email = email;
	}


	static int idCount;
	
	static {
	}
	
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", firsName=" + firsName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", registrationAmount=" + registrationAmount + ", dob=" + dob
				+ ", lastSubscriptionDate" + lastSubscriptionDate + ", plan=" + plan + "]";
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		if(obj instanceof Customer) {
			
			Customer other = (Customer) obj;
			
			return this.email.equals(other.email);
		}
		
		return false;
		
	}
	
	
	public LocalDate getLastSubscriptionDate() {
		return lastSubscriptionDate;
	}

	public void setLastSubscriptionDate(LocalDate lastSubscriptionDate) {
		this.lastSubscriptionDate = lastSubscriptionDate;
	}

	
	

	
}


/*
 * Customer management system Supply Options 1. Sign up (customer registration)
 * 2. Sign in (login) i/p : email n password 3. Change password i/p : email n
 * old password n new password 4. Un subscribe customer i/p : customer email
 * 
 * 5. Display all customers. 0. Exit
 * 
 * Design Identify the core classes/enums involved 1. Customer class (core
 * class) state : customer id(int) ,first name, last name
 * (string),email(string),password(string),registrationAmount(double),dob(
 * LocalDate),plan(ServicePlan : enum) idGenerator : static Must generate
 * customer ids automatically : auto increment) PK(UID) : email
 * 
 * ctors 1. all args ctor 2. PK based ctor
 * 
 * Will you need to override toString n equals ?
 * 
 * 
 * 2. ServicePlan : enum ServicePlan charges : SILVER : 1000 GOLD : 2000 DIAMOND
 * : 5000 PLATINUM : 10000
 * 
 * 
 * 3. custom exception class
 * 
 * 4. validation rules 4.1 no dup customers (i.e if the customer tries to
 * register using existing email , throw exception)
 * 
 * 4.2 Validate plan plan must be of supported types
 * 
 * 4.3 reg amount must match with the plan
 * 
 * 
 * 5. Tester, with UI , scanner Create a template as discussed n test the
 * functionality
 */

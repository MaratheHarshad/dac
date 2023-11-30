package dependency;

public class SmsBasedNotification implements CustomerNotification {

	@Override
	public void alertCustomer(String msg) {
		System.out.println("SmsBasedNotification : " + msg);
		
	}
	
}

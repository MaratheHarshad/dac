package dependency;

public class EmailBasedNotification implements CustomerNotification {

	@Override
	public void alertCustomer(String msg) {
		System.out.println("EmailBasedNotification : " + msg);
		
	}
	
}

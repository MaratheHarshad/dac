package threads2.copy;

import static java.lang.Thread.*;

//implements Runnable
public class MyRunnableTask implements Runnable {
	
	// data is shared resourse among multiple threads
	int data = 1;
	
	
	/*
	 * This lock is not working correctly for 3 threads
	 * (try excuting programm multiple times we would get an , inconsistency
	 * 
	 */
	// acquire lock 
	boolean acquire = false;

	
	@Override
	public void run() /* throws InterruptedException */ {
		System.out.println(currentThread() + " strted");
		
		while(acquire) {
//			System.out.println("inside while" + currentThread().getName());
			try {
				Thread.sleep(1000); // throws checked exc
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		acquire = true;
		
		data++;
		
		System.out.println("inside thread  " + currentThread().getName() + " : " + data);
		
		
		acquire = false;
		System.out.println(currentThread().getName() + " over");
	}

}

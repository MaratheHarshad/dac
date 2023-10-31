package threads2.copy;

public class Tester {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread());// Thread [main,5,main]
		// create a runnable task
		MyRunnableTask task = new MyRunnableTask();
		//Thread(Runnable target,String name)
		Thread t1=new Thread(task,"one");
		Thread t2=new Thread(task,"two");
		Thread t3=new Thread(task,"three");
		//start the same
		t1.start();
		t2.start();
		t3.start();
		// How many RUNNABLE(except GC) ? main + 3 child threads
		// B.L (thrd exec logic) : main
		
		System.out.println("main over....");

	}

}

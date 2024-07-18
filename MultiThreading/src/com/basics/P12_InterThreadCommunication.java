package com.basics;

public class P12_InterThreadCommunication
{
	
	/*
	 * InterThreadCommunication is only possible if and only if two threads accessing two synchronized 
	 * methods with same or different locks.
	 * 
	 * wait();
	 * wait(timeInMilliseconds);
	 * 
	 * notify();
	 * notifyAll();
	 * 
	 * 
	 *  These all methods should be used in synchronised areas only.
	 *  Otherwise, they will ILLEGAL MONITOR STATE exception
	 *  
	 */
	
	public static synchronized void m1()
	{
		try
		{	
			//wait method should be called on lock not thread
			System.out.println("t1 started waiting");
			P12_InterThreadCommunication.class.wait();
			System.out.println("Notification recieved");
			System.out.println("t1 waiting completed");
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static synchronized void m2()
	{
		try
		{	
			//wait method should be called on lock not thread
			System.out.println("t2 started waiting");
			P12_InterThreadCommunication.class.wait();
			System.out.println("Notification recieved");
			System.out.println("t2 waiting completed");
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static synchronized void m3()
	{
		try
		{	
			//wait method should be called on lock not thread
			System.out.println("t3 started waiting");
			P12_InterThreadCommunication.class.wait();
			System.out.println("Notification recieved");
			System.out.println("t3 waiting completed");
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static synchronized void m4()
	{
		System.out.println("t4 entered m4 method...");
		System.out.println("t4 method notified");
		P12_InterThreadCommunication.class.notifyAll();
		System.out.println("t4 exited m4 method...");
	}
	
	
	
	public static void main(String[] args) throws InterruptedException
	{
		Thread t1 = new Thread(()->{ P12_InterThreadCommunication.m1(); }, "t1");
		Thread t2 = new Thread(()->{ P12_InterThreadCommunication.m2(); }, "t2");
		Thread t3 = new Thread(()->{ P12_InterThreadCommunication.m3(); }, "t3");
		Thread t4 = new Thread(()->{ P12_InterThreadCommunication.m4(); }, "t4");
		
		t1.start();
		t2.start();
		t3.start();
		
		Thread.sleep(10000);
		
		t4.start();
		
		/*
		 * Here t4 communicates its messgae to t1,t2,t3 through notifyAll() of lock
		 */
		
	}

}

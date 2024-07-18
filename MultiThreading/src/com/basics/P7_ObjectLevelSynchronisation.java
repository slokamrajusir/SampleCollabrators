package com.basics;

public class P7_ObjectLevelSynchronisation
{	
	
	static int count = 1000;
	
	
	public synchronized void m1()
	{
		for(int i=1; i<=100; i++)
			count += 100;
	}
	
	public synchronized void m2()
	{
		for(int i=1; i<=1020; i++)
			count += 200;
	}

	public static void main(String[] args) throws InterruptedException
	{
		
		P7_ObjectLevelSynchronisation p = new P7_ObjectLevelSynchronisation();
		
		Thread t1 = new Thread( ()-> { p.m1(); } );
		Thread t2 = new Thread( ()-> { p.m2(); } );
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		/*
		 * Same process as static synchonisation, here the lock will be on OBJECT LEVEL LOCK
		 */
		
		System.out.println("Final Count is "+ count);
	}

}

package com.basics;

public class P8_ExecutingTwoSynchronisedMethodsParallely
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
	
	
	public static synchronized void m3()
	{
		for(int i=1; i<=100; i++)
			count += 100;
	}
	
	public static synchronized void m4()
	{
		for(int i=1; i<=1020; i++)
			count += 200;
	}

	public static void main(String[] args) throws InterruptedException
	{
		
		P8_ExecutingTwoSynchronisedMethodsParallely p = new P8_ExecutingTwoSynchronisedMethodsParallely();
		
		Thread t1 = new Thread( ()-> { p.m1(); } );
		Thread t2 = new Thread( ()-> { p.m2(); } );
		Thread t3 = new Thread( ()-> { p.m3(); } );
		Thread t4 = new Thread( ()-> { p.m4(); } );
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		
		/*
		 * Now ypou will get different outputs each time we execute the program,
		 * Because the lock of static methods and lock of instance methods is different.
		 * so we cannot achieve complete synchronisation here.
		 * 
		 * 
		 * 
		 */
		
		System.out.println("Final Count is "+ count);
	}

}

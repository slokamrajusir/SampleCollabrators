package com.basics;

public class P10_SynchronizedBlocksWithClasses
{	
	

	
	public static void m1()
	{		
		synchronized (P10_SynchronizedBlocksWithClasses.class)
		{
			for(int i=1; i<=20; i++)
				System.out.println("M1 -- Class Lock---" + Thread.currentThread().getName()+"---"+i);
		}
		
	}
	
	public static void m2()
	{	
		synchronized (P10_SynchronizedBlocksWithClasses.class)
		{
			for(int i=1; i<=20; i++)
				System.out.println("M2 -- Class Lock---" + Thread.currentThread().getName()+"---"+i);
		}
	}
	
	

	public static void main(String[] args) throws InterruptedException
	{
		// Now iam going to create three threads to do operations on count field which is static
		
		Thread t1 = new Thread( ()->{ P10_SynchronizedBlocksWithClasses.m1(); } );
		Thread t2 = new Thread( ()->{ P10_SynchronizedBlocksWithClasses.m2(); } );
		
		
		t1.start();
		t2.start(); 
		
		
		t1.join();
		t2.join();
		
		
		System.out.println("Program completed Successfully");
		
	}

}

package com.basics;

public class P9_SynchronizedBlocks
{	
	
	static final Object lock1 = new Object();
	static final Object lock2 = new Object();
	
	public void m1()
	{	
		System.out.println("M1 method entered");
		synchronized(lock1)
		{
			for(int i=1; i<=20; i++)
			{
				System.out.println("M1 method ---- "+Thread.currentThread().getName()+"-----"+"Lock1---"+i);
			}
		}
		System.out.println("M1 method exited");
	}
	
	public void m2()
	{	
		System.out.println("M2 method entered");
		synchronized(lock1)
		{
			for(int i=1; i<=20; i++)
			{
				System.out.println("M2 method ---- "+Thread.currentThread().getName()+"-----"+"Lock1---"+i);
			}
		}
		System.out.println("M2 method exited");
	}
	
	public void m3()
	{	
		System.out.println("M3 method entered");
		synchronized(lock2)
		{
			for(int i=1; i<=20; i++)
			{
				System.out.println("M3 method ---- "+Thread.currentThread().getName()+"---Lock2---"+i);
			}
		}
		System.out.println("M3 method exited");
	}
	
	public void m4()
	{	
		System.out.println("M4 method entered");
		synchronized (lock2)
		{
			for(int i=1; i<=20; i++)
			{
				System.out.println("M4 method ---- "+Thread.currentThread().getName()+"---Lock2---"+i);
			}
		}
		System.out.println("M4 method exited");
	}

	public static void main(String[] args) throws InterruptedException
	{
		/*
		 * In static and instance synchronization, we dont have any privilage to choose which object should act as
		 * Lock for synchronization.
		 * But here we can use any object for synchronization.
		 * 
		 * When two or more synchronized blocks are holding same lock object,
		 * then each block will be executed one at a time, not parllelly.
		 * 
		 */
		
		P9_SynchronizedBlocks p = new P9_SynchronizedBlocks();
		
		
		Thread t1 = new Thread( ()->{p.m1(); }, "t1");
		Thread t2 = new Thread( ()->{p.m2(); }, "t2"); // Acts upon lock1
		
		Thread t3 = new Thread( ()->{p.m3(); }, "t3");
		Thread t4 = new Thread( ()->{p.m4(); }, "t4");// Acts upon lock2
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		
	
		
	}

}

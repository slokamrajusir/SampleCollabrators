package com.basics;


import java.io.FileReader;
import java.util.Scanner;

public class P11_SynchronizedBlockWithClasses
{	
	

	
	public static void m1()
	{		
		synchronized (FileReader.class)
		{
			for(int i=1; i<=20; i++)
				System.out.println("M1 -- Class Lock---" + Thread.currentThread().getName()+"---"+i);
		}
		
	}
	
	public static void m2()
	{	
		synchronized (Scanner.class)
		{
			for(int i=1; i<=20; i++)
				System.out.println("M2 -- Class Lock---" + Thread.currentThread().getName()+"---"+i);
		}
	}
	
	

	public static void main(String[] args) throws InterruptedException
	{
		// Now iam going to create three threads to do operations on count field which is static
		
		Thread t1 = new Thread( ()->{ P11_SynchronizedBlockWithClasses.m1(); } );
		Thread t2 = new Thread( ()->{ P11_SynchronizedBlockWithClasses.m2(); } );
		
		
		t1.start();
		t2.start(); 
		
		
		t1.join();
		t2.join();
		
		/*
		 * 
		 * Here synchronization is not possible because we used two different classes as locks for Synchronized blocks.
		 * 
		 * 
		 */
		System.out.println("Program completed Successfully");
		
	}

}

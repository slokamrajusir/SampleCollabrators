package com.basics;

public class P5_MultipleThreadsUsingSharedResources
{	
	
	static int count = 10000;
	
	public static void m1()
	{	
		for(int i=1; i<=10000; i++)
		count+=100;
	}
	
	public static void m2()
	{	
		for(int i=1; i<=4; i++)
		count+=2000;
	}
	
	public static void m3()
	{	
		for(int i=1; i<=5; i++)
		count+=3000;
	}

	public static void main(String[] args) throws InterruptedException
	{
		// Now iam going to create three threads to do operations on count field which is static
		
		Thread t1 = new Thread( ()->{ P5_MultipleThreadsUsingSharedResources.m1(); } );
		Thread t2 = new Thread( ()->{ P5_MultipleThreadsUsingSharedResources.m2(); } );
		Thread t3 = new Thread( ()->{ P5_MultipleThreadsUsingSharedResources.m3(); } );
		
		t1.start(); // +3000
		t2.start(); // +8000
		t3.start(); // +15000 so total should be 36000
		
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println("Final count is ---- "+ count);
		// As you can observe, that each time the output changes, that means we are loosing 
		// accuracy of our output, because these threads are competing eachother to update values 
		// of count, during that process, the variable loosing accuracy.
		// Because in this scenario, during each updation, Each thread carries the Cache copy 
		// of static variable to their stack , update that cache copy and then replaces the original one with this updated one
		// As a result Inconsitencies occuring in this program 
	}

}

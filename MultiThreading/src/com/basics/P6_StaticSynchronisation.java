package com.basics;

public class P6_StaticSynchronisation
{

	//Shared Resource on which all threads are trying to Access
    static int count = 10000;
	
	public static synchronized void m1()
	{	
		for(int i=1; i<=10000; i++)
		count+=100;
	}
	
	public static synchronized void m2()
	{	
		for(int i=1; i<=4; i++)
		count+=2000;
	}
	
	public static synchronized void m3()
	{	
		for(int i=1; i<=5; i++)
		count+=3000;
	}
	
	/*
	 * Static Synchronization in java
	 * 
	 * Here three threads are acting independently with different tasks,
	 * but indirectly, they all are trying to perform operations on static field count
	 * Because of shared resource,we apply the Synchronization concept here.
	 * 
	 * Understand the Execution Flow of the Program
	 * 
	 * 1)Jvm calls main method through main thread
	 * 2)t1 thread created
	 * 3)t2 thread created
	 * 4) t3 thread created
	 * 
	 * So there are total four methods are in active state
	 * 
	 */
	
	public static void main(String[] args) throws InterruptedException
	{
		
		Thread t1 = new Thread( ()->{ P6_StaticSynchronisation.m1(); } , "t1" );
		Thread t2 = new Thread( ()->{ P6_StaticSynchronisation.m2(); }, "t2");
		Thread t3 = new Thread( ()->{ P6_StaticSynchronisation.m3(); }, "t3" );
		
		t1.start();
		t2.start(); // All threads are started Each thread object created in the heap memory
		t3.start(); // And the corresponding call stacks are created in stack Area
		
		/*
		 * Assume among the 3 threads, t2 has been scheduled to executed the task,
		 * Being a Synchronized static method, t2 will acquire CLASS LEVEL LOCK and starts executing the task
		 * Now after its alloted time completes, then t2 thread will comes to RUNNABLE state and retains CLASS LOCK
		 * alongwith it.
		 * It waits for ThreadScheduler to let it in.
		 * Again it starts the exeuting the task.
		 * After the task completion, the thread t2 releases the CLASS LEVEL LOCK, and it will enter into DEAD State
		 * 
		 * Same Process Repeats for every Thread till all threads completion.
		 * 
		 * 
		 */
		
		
		
		
		
		t1.join();
		t2.join();  // The method join() is called to wait for the thread to die on which it was called.
		t3.join();
		
		// In this program the main thread waits till the remaining three threads enter into DEAD state
		// And then the main thread gets value of Count after all Operations.
		
		// If we dont apply join methods on three thread objects, the main tries to read value of count prematurely.
		
		System.out.println("Final Count is "+count);
	}

}

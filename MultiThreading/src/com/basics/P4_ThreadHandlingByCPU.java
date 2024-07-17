package com.basics;

public class P4_ThreadHandlingByCPU
{

	public static void main(String[] args)
	{
		Runnable r1 = ()->{ /* Run method implementation*/};
		Thread t1 = new Thread(r1);
		
		
		Runnable r2 = ()->{ /* Run method implementation*/};
		Thread t2 = new Thread(r2);
		
		// Before the start method Newly created threads are in NEW born state
		
		t1.start();
		t2.start();
		
		// Now the threads are in RUNNABLE state
		
		//After sometime the CPU allocates time for each thread, when a thread is starts executing 
		// its task, then the thread will be RUNNING state
		
		// After the alloted time is over, then the thread will come to the RUNNABLE state
		// This process continues till the Task is completed
		// The Thread will do To and Fro motion from RUNNABLE to RUNNING
		
		
	}

}

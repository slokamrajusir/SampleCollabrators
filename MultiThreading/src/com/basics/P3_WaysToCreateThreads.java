package com.basics;


class A extends Thread
{	@Override
	public void run()
	{
		// code for the task to be executed
	}
}

class B implements Runnable
{

	@Override
	public void run()
	{
		// code for the task to be executed
		
	}
	
}



public class P3_WaysToCreateThreads
{
	public static void main(String[] args)
	{
		// Now iam going to create threads in different ways
		 
		// 1) Extending thread class and overriding run() method and calling start method on subclass object
		
		A a = new A();
		// Here A is a Thread because of IS - A relationship
		a.start();
		
		// 2) Anonymous inner class, nothing but short form of type 1
		
		Thread t1 = new Thread()
				{ // A subclass of Thread class without name
					
					@Override
					public void run()
					{
						// Task to be executed
					}
					
				};
		 t1.start();
		 
		 // 3) Implementing runnable interface which contains run() method
		 B r1 = new B();
		 Thread t2 = new Thread(r1);
		 t2.start();// start() method from t2 calls the run method of r1
		 
		 // 4) similar to type 3, but with Lambda expressions
		 Runnable r2 = () -> { /* Implementation of run method*/  };
		 Thread t3 = new Thread(r2);
		 t3.start();
		 
		 
		 // 5) Short form for type 4
		 Thread t4 = new Thread(  ()->{ /*Run method implementation*/  }  );
		 t4.start();
		 
	}
}

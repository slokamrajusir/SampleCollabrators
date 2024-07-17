package com.basics;

 class P2_WithMultipleThreads
{

	public static void main(String[] args) throws InterruptedException
	{
//		Targets:
//		
//		1)Find the sum of all elements
//		2)Find the sum of all odd elements
//		3)Find the sum of all even elements
//		4)Find the sum of all  prime elements
		
		
//     Output:
//		        Sum of all  even elements in the Array is ==== 2521800
//				Sum of all odd elements in the Array is ==== 32577600
//				Sum of all elements in the Array is ==== 35099400
//				Sum of all prime elements in the Array is ==== 5841232
//				Total time taken by a FOUR threads to run all tasks is 2 milliseconds
				
	long starttime = System.currentTimeMillis();	
	Thread t1 = new Thread()
		{
			public void run()
			{
				AllSum(Arr);
			}

		};
		t1.start();
		
		Thread t2 = new Thread()
		{
			public void run()
			{
				EvenSum(Arr);
			}

		};
		
		t2.start();
		 
		Thread t3 = new Thread()
		{
			public void run()
			{
				OddSum(Arr);
			}

		};
		
		t3.start();
		
		Thread t4 = new Thread()
		{
			public void run()
			{
				PrimeSum(Arr);
			}

		};
		
		t4.start();
		
		
		long endtime = System.currentTimeMillis();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		
		System.out.println("Total time taken by a FOUR threads to run all tasks is "+(endtime - starttime)+ " milliseconds");

	}
	
	
static int[] Arr = new int[1200];
	
	static
	{
		for( int i=0; i<Arr.length; i++)
		{
			if(i % 2 == 0)
				Arr[i] = 7*i + 10;
			else
				Arr[i] = 89*i + 896;
		}
	}

	
	
	
	
	// Methods to execute tasks
	
	
		// Task 1 : Find the sum of all numbers
		
		public static void AllSum(int[] A)
		{	
			int sum = 0;
			for(int n : A)
			{
				sum += n;
			}
			
			System.out.println("Sum of all elements in the Array is ==== "+ sum);
		}
		
		
		
		// Task 2 : Find the even sum
		
		public static void EvenSum(int[] A)
		{	
			int sum = 0;
			for(int n : A)
			{	
				if(n%2==0)
				    sum += n;
			}
			
			System.out.println("Sum of all  even elements in the Array is ==== "+ sum);
		}
		// Task 3 : Find the odd sum
		public static void OddSum(int[] A)
		{	
			int sum = 0;
			for(int n : A)
			{	
				if(n%2 != 0)
				     sum += n;
			}
			
			System.out.println("Sum of all odd elements in the Array is ==== "+ sum);
		}
		// Task 4 : Find the Prime numbers sum
		public static void PrimeSum(int[] A)
		{	
			int sum = 0;
			for(int n : A)
			{	
				if(isPrime(n))
				        sum += n;
			}
			
			System.out.println("Sum of all prime elements in the Array is ==== "+ sum);
		}
		
		public static boolean isPrime(int n)
		{	
			if(n==0 || n==1)
			{
				return false;
			} 
			else
			{
				for(int i=2; i<= (n-1); i++)
				{
					if( n%i == 0)
					{
						return false;
					}
				}
			}
			
			return true;
			
		}
	}



package com.basics;

 class P1_WithSingleThread
{	
//	Output:
//	        Sum of all elements in the Array is ==== 35099400
//			Sum of all  even elements in the Array is ==== 2521800
//			Sum of all odd elements in the Array is ==== 32577600
//			Sum of all prime elements in the Array is ==== 5841232
//			Total time taken by a SINGLE thread to run all tasks is 21 milliseconds

	public static void main(String[] args)
	{
		Thread t = new Thread()
		{
			public void run()
			{	
				long starttime = System.currentTimeMillis();
				AllSum(Arr);
				EvenSum(Arr);
				OddSum(Arr);
				PrimeSum(Arr);
				long endtime = System.currentTimeMillis();
				System.out.println("Total time taken by a SINGLE thread to run all tasks is "+(endtime - starttime)+ " milliseconds");
			}

		};
		t.start();


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




package com.Begin.start;

public class HelloWorld {

	public static void main(String[] args) {

		int marks = 53;
		
		if(marks >= 0 && marks <= 34) {
			System.out.println("Fail...");
		}else if(marks >= 35 && marks <= 50){
			System.out.println("Third Div...");
			}else if(marks >= 51 && marks <= 70) {
				System.out.println("Second Dive...");
			}else if(marks >= 71 && marks <= 90) {
				System.out.println("Distinction...");
			}else System.out.println("Wrong data..");
		
	}

}



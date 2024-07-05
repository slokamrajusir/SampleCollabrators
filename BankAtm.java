package com.slokam;

import java.util.Scanner;

public class BankAtm {

	public static void main(String[] args) throws NetworkIssue {
		
		double balance = 100000;
		
		double wd ;
		
		Scanner in = null;
		
		
		Boolean NetworkSignal = true;
		
		if(NetworkSignal) {
			System.out.println("enter withdraw amount");
		try  {
			in = new Scanner(System.in);
			wd = Double.parseDouble(in.nextLine());
			if(wd<=balance) {
				balance = balance-wd;
				System.out.println("your balance is" + " "+ balance);
			} else {
			   throw new BalanceError("you dont have enough balance");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
		
		} else {
			throw new NetworkIssue("Please check Internet connection");
		}
		
	}
}

package com.slokam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Fconnected {

	public void connectionToFile(String path) {
    
		FileReader fr = null ;
		BufferedReader br = null;
		if(path!=null) {
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			for(String s= br.readLine(); s!=null;s=br.readLine()) {
			  System.out.println(s);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("catch block end");
		}finally {
			System.out.println("In finally block");
			try {
				br.close();
				fr.close();
				
			} catch (IOException | NullPointerException e) {
				e.printStackTrace();
				System.out.println("in finally catch block");
			}
			System.out.println("finally block end");
		}
		}else {
			System.out.println("path is null");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("main method starts");
		Fconnected fc =null;;
		try {
			fc = new Fconnected();
		fc.connectionToFile("C:\\Users\\samba\\OneDrive\\Desktop\\slokam\\details.txt");
		}catch(NullPointerException ne){
		 ne.printStackTrace();
		}
		System.out.println("main method end");
	}

}

//list of total calories consumed each day///////////
//a list of days when more calories than required are consumed
//average calaories consumed during each of the three meals//////////

import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class lab1{

	public static void health(int[] sum, String[] day){
		for(int i=0; i<sum.length; i++){
			if(sum[i]>2250){
				System.out.printf("On %s, you took %d and was over consumed.%n", day[i], sum[i]);
			}
		}
		return;
	}

	public static void averageMeal(int[] b, int[] l, int[]d){
		int bb = 0;
		int ll = 0;
		int dd = 0;
		for(int i=0; i<b.length; i++){
			bb = bb+b[i];
			ll = ll+l[i];
			dd = dd+d[i];
		}
		System.out.println("The average of breakfast is " + (double)bb/7 + ".");
		System.out.println("The average of lunch is " + (double)ll/7 + ".");
		System.out.println("The average of dinner is " + (double)dd/7 + ".");
		return;
	}

	public static void printsum(int[] b, int[] l, int[] d, int[] sum){
		for(int i=0; i<b.length; i++){
			System.out.printf("%d ", sum[i]);
		}
		System.out.println("");
		return;
	}

	public static void sum(int[] b, int[] l, int[] d, int[] sum){
		for(int i=0; i<b.length; i++){
			sum[i] = b[i]+l[i]+d[i];
		}
		return;
	}

	public static void print(int[] b, int[] l, int[] d){
		for(int i=0; i<b.length; i++){
			System.out.println(b[i] + " " + l[i] + " " + d[i]);
		}
		return;
	}

	public static void main(String[] args)throws FileNotFoundException {
		Scanner scnr = new Scanner(new File("input.txt"));
		int[] breakfast = new int[7];
		int[] lunch = new int[7];
		int[] dinner = new int[7];
		int counter = 0;
		int repeater = 0;
		String[] cal;
		String[] day = {"Monday", "Tuesday", "Wendsday", "Thursday", "Friday", "Saturday", "Sunday"};
		
		System.out.println("test1");
		
		while(scnr.hasNextLine()){
			String line = scnr.nextLine();
			cal = line.split(" ");
			if(cal.length()!=3){
				System.out.println("Error occurred.");
				System.exit(0);
			}
			breakfast[counter] = Integer.parseInt(cal[repeater]); repeater++;
			lunch[counter] = Integer.parseInt(cal[repeater]); repeater++;
			dinner[counter] = Integer.parseInt(cal[repeater]); repeater=0;
			counter++;
		}
		scnr.close();//closing scanner
		
		/*
		for(int i=0; i<3; i++){
			for(int j=0; j<7; j++){
				if(i==0) breakfast[j] = Integer.parseInt(cal[j]);
				if(i==1) lunch[j] = Integer.parseInt(cal[j]);
				else dinner[j] = Integer.parseInt(cal[j]);
			}
		}*/
		
		print(breakfast, lunch, dinner);
		
		int[] sum = new int[7];
		sum(breakfast, lunch, dinner, sum);
		printsum(breakfast, lunch, dinner, sum);
		health(sum, day);
		averageMeal(breakfast, lunch, dinner);
		
	}
}
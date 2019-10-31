/**Lab1-Array-FileReader**
			9/7/2018
		Ken Amamori**/

import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Calories{

	public static void health(int[] b, int[] l, int[] d){
		int[] sum = calSum(b, l, d);
		String[] day = {"Monday", "Tuesday", "Wendsday", "Thursday", "Friday", "Saturday", "Sunday"};
		for(int i=0; i<sum.length; i++){
			if(sum[i]>2250){
				System.out.printf("On %s, you took %d and was over consumed.%n", day[i], sum[i]);
			}
		}
		System.out.println("");
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
		System.out.println("The average calories of breakfast is " + (double)bb/7 + ".");
		System.out.println("The average calories of lunch is " + (double)ll/7 + ".");
		System.out.println("The average calories of dinner is " + (double)dd/7 + ".");
		return;
	}
	
	public static int[] calSum(int[] b, int[] l, int[] d){
		int[] sum = new int[7];;
		for(int i=0; i<b.length; i++){
			sum[i] = b[i]+l[i]+d[i];
		}
		return sum;
	}

	public static void main(String[] args){
		int[] breakfast = new int[7];
		int[] lunch = new int[7];
		int[] dinner = new int[7];
		int counter = 0;
		int repeater = 0;
		String[] cal;
		String[] day = {"Monday", "Tuesday", "Wendsday", "Thursday", "Friday", "Saturday", "Sunday"};
		int limit = 2250;
		int[] sum = new int[7];
	
		try{
			Scanner scnr = new Scanner(new File("input.txt"));
			while(scnr.hasNextLine()){
				counter++;
				if(counter==8){
					System.out.println("Error occurred. The row should be up to 7.");
					System.exit(0);
				}
				String line = scnr.nextLine();
				cal = line.split(" ");
				if(cal.length!=3){
					System.out.println("Error occurred. The data should be 3 numbers per line.");
					System.exit(0);
				}
				breakfast[counter-1] = Integer.parseInt(cal[repeater]); repeater++;
				lunch[counter-1] = Integer.parseInt(cal[repeater]); repeater++;
				dinner[counter-1] = Integer.parseInt(cal[repeater]); repeater=0;
			}
			scnr.close();
		}catch(FileNotFoundException e){
			System.out.println("No file found.");
			System.exit(0);
		}catch(NumberFormatException nfe){
			System.out.println("Format error occurred.");
			System.exit(0);
		}
		if(counter!=7){
			System.out.println("Not enough rows");
			System.exit(0);
		}
		
		sum = calSum(breakfast, lunch, dinner);
		for(int i=0; i<sum.length; i++){
			System.out.printf("You consumed %d calories on %s.%n", sum[i], day[i]);
		}
		System.out.println();
		health(breakfast, lunch, dinner);
		averageMeal(breakfast, lunch, dinner);
			
	}
}
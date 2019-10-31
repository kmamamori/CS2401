/*Ken Amamori
MW 10:30-11:50am- Lec
MW3:00-4:20pm-Lab
Lab 7*/

import java.util.Arrays; //sorting
import java.util.Scanner;

class Search{

	public static int binarySearch(double[] arr, double sv){
		int s = 0;//startign point
		int e = arr.length-1;//ending point
		while(s<=e){//while s is smaller or equal to e
			if(arr[(int)((s+e)/2)]<sv){//compare the mdiddle value is smaller than sv
				s=(int)((s+e)/2)+1;//move the starting point
			}else if(arr[(int)((s+e)/2)]>sv){//compare the mdiddle value is smaller than sv
				e=(int)((s+e)/2)-1;//move the ending point
			}else return (int)((s+e)/2);//return the index
		}
		return -1;//not found
	}

	public static int linearSearch(double[] arr, double sv){
		for(int i=0; i<arr.length; i++){//go through each element in array
			if(arr[i]==sv) return i;//return index if the values are the same
		}
		return -1;//not found
	}//*/

	public static int size(){
		System.out.println("Please type the length of the array");
		Scanner in = new Scanner(System.in);
		return in.nextInt();//return the input from the user
	}
	
	public static double[] createArray(){
		double[] arr = new double[size()];//create an array of size()
		for(int i=0; i<arr.length; i++){//go through the array
			arr[i] = Math.round((Math.random()*(arr.length))*100.0)/100.0;//get an random value
		}
		return arr;//return the array
	}
		
	public static void main(String[] m){
		double[] arr = createArray(); //create the array
		Arrays.sort(arr);//sort the array to be abl to use linear search
		long L = 0;//long var for Linear search
		long B = 0;//long var for binary search
		for(int i=0; i<50; i++){//iterate for 50 times to get the average
			double sv = arr[(int)(Math.random()*(arr.length-1))];
			System.out.printf("\nThe value - %f\n", sv);
			long L1st = System.nanoTime();//before LS
			int linearS = linearSearch(arr, sv);//LINEAR SEARCH
			long L2nd = System.nanoTime();//after LS
			System.out.println("Index of the value using Linear Search " + linearS);
			long B1st = System.nanoTime();//before BS
			int binaryS = binarySearch(arr, sv);//BINARYSEARCH
			long B2nd = System.nanoTime();//after BS
			System.out.println("Index of the value using Binary Search " + binaryS);
			L=L+(L2nd-L1st);//get total time for LS
			B=B+(B2nd-B1st);//get the total time for BS
		}
		System.out.println("Linear Search: TotalTime="+L+", AverageTime="+(L/50));//total and average time
		System.out.println("Binary Search: TotalTime="+B+", AverageTime="+(B/50));//total and average time
	}
}
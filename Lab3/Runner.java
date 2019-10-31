/******Lab3-Object *********************
****** 9/28/2018 **********************
******	Lec: MW10:30-11:50 am ***********
****** Lab: MW3:00-4:20 pm *************
****** Ken M. Amamori ******************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Runner{

	//calculate the average of cubic package 
	public static void aveSize(Package[] size){
		int count = 0;
		float sum = 0;
		for(int i=0; i<size.length; i++){//go to each elements in the array if it is cubic
			if(size[i].isCube()){//check if it is cubic
				count++;
				sum=sum+size[i].getVolume();
			}
		}
		System.out.println("The average volume of cubic package(s) is/are " + sum/count + ".");
		return;
	}
	
	//print out the dimensions of the cubic package
	public static void cubicDimension(Package[] size){
		for(int i=0; i<size.length; i++){//go through each elements in array
			if(size[i].isCube()){
				System.out.printf("The package-%d is cubic and the dimensions are %.2f, %.2f, and %.2f.%n", i+1, size[i].getW(), size[i].getH(), size[i].getL());
			}
		}
		return;
	}

	//count the amount of the cubic package
	public static void Cubic(Package[] size){
		int count = 0;
		for(int i=0; i<size.length; i++){
			if(size[i].isCube()) count++;//add one to count when it finds a cubic package
		}
		System.out.println("They is/are " + count + " cubic package(s).");
		System.out.println("They is/are " + (size.length-count) + " noncubic package(s).");
		return;
	}

	//find the largest package in the array and print out
	public static void largestPackage(Package[] size){
		int L = 0;
		float max = size[L].getVolume();
		for(int i=1; i<size.length; i++){//go to each elements in the array to compare with max
			if(max<size[i].getVolume()) L=i;
		}
		System.out.printf("The largest package \n\tIndex: %d \n\tDimension: %.2f %.2f %.2f \n\tVolume: %.2f%n", L, size[L].getW(), size[L].getH(), size[L].getL(), size[L].getVolume());
		return;
	}
	
	//get the file name from the user and return it
	public static String typeFile(){
		System.out.println("Please type the name of the file without the part of .txt.");
		Scanner scnr = new Scanner(System.in);
		return scnr.next();
	}
	
	//read the text file and create an array of object
	public static void readFile(Package[] Packages, String fn){
		int iter = 0;
		try{
			Scanner scnr = new Scanner(new File(fn));
			while(scnr.hasNextLine()){
				String line = scnr.nextLine();
				String[] split = line.split(" ");
				Packages[iter] = new Package(Float.parseFloat(split[0]), Float.parseFloat(split[1]), Float.parseFloat(split[2]));//create a object with an parameter of WLH
				iter++;
			}
			scnr.close();
		}catch(FileNotFoundException err){//get the exception and run the rest
			System.out.println("File was not found.");
			System.exit(0);
		}
		return;
	}
	
	//count how many lines there is in the text file
	public static int len(String name){
		int i=0;
		try{
			Scanner scnr = new Scanner(new File(name));
			while(scnr.hasNextLine()){//continue adding one as long as there is a line
				scnr.nextLine(); i++;
			}
			scnr.close();
		}catch(FileNotFoundException e){
			System.out.println("File weas not found.");
			System.exit(0);
		}
		return i;
	}
	
	public static void main(String[] args){
		String name = typeFile()+".txt";//get the name of the text file
		Package[] size= new Package[len(name)];//create an array of object with the size of 6

		readFile(size, name);//create an object
		largestPackage(size);//find the largest pakcage
		Cubic(size);//count each cubic package
		cubicDimension(size);//print out the dimension of the cubic pakcage
		aveSize(size);//calculate the average of the cubic package
	}
}
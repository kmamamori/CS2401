import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Calories1{

	public static void maxT(int[][] meal, String[] type){
		int max = Integer.MIN_VALUE;
		for(int i=0; i<meal[0].length; i++){
			for(int j=0; j<meal.length; j++){
				if(max<meal[j][i]){
					max=meal[j][i];
				}
			}
			System.out.printf("The max calories of all %s was %d.%n", type[i], max);
			max=Integer.MIN_VALUE;
		}
		return;
	}

	public static void maxD(int[][] meal, String[] day){
		int maxC = Integer.MIN_VALUE;
		for(int i=0; i<meal.length; i++){
			for(int j=0; j<meal[i].length; j++){
				if(maxC<meal[i][j]){
					maxC=meal[i][j];
				}
			}
			System.out.printf("The max calories on %s was %d.%n", day[i], maxC);
			maxC=Integer.MIN_VALUE;
		}
		System.out.println();
		return;
	}

	public static void aveMeal(int[][] meal, String[] type){
		int[] sumM = new int[meal[0].length];
		for(int i=0; i<meal[0].length; i++){
			for(int j=0; j<meal.length; j++){
				sumM[i]+=meal[j][i];
			}
		}
		for(int i=0; i<sumM.length; i++){
			System.out.printf("The average of all the %s was %.2f.%n", type[i], (double) sumM[i]/7);
		}
		System.out.println();
		return;
	}

	public static void aveDay(int[] sumD, String[] day){
		for(int i=0; i<sumD.length; i++){
			System.out.printf("On %s, the average calories consumed was %.2f.%n", day[i], (double)sumD[i]/3);
		}
		System.out.println();
		return;
	}

	public static int[] sumDay(int[][] meal, String[] day){
		int[] sumD = new int[meal.length];
		for(int i=0; i<meal.length; i++){
			for(int j=0; j<meal[i].length; j++){
				sumD[i]+=meal[i][j];
			}
			System.out.printf("On %s, you consumed %d calories.%n", day[i], sumD[i]);
		}
		System.out.println();
		return sumD;
	}

	public static void printAll(int[][] meal){
		for(int i=0; i<meal.length; i++){
			for(int j=0; j<meal[i].length; j++){
				System.out.printf("%d ", meal[i][j]);
			}
			System.out.println();
		}
		return;
	}

	public static void readFile(String fileName, int[][] meal){
		try{
			Scanner scnr = new Scanner(new File(fileName));
			int iter = 0;
			while(scnr.hasNextLine()){
				iter++;
				if(iter==8){
					System.out.println("ERROR!! The columns should be 7.");
					System.exit(0);
				}
				String line = scnr.nextLine();
				String[] split = line.split(" ");
				if(split.length!=3){
					System.out.println("ERROR!! The number of rows is not three.");
					System.exit(0);
				}
				for(int i=0; i<split.length; i++){
					meal[iter-1][i] = Integer.parseInt(split[i]);
				}
			}
			if(iter<7){
				System.out.println("ERROR!! The number of columns is not seven.");
				System.exit(0);
			}
			scnr.close();
		}catch(FileNotFoundException e){
			System.out.printf("ERROR!! There is no file called %s", fileName);
			System.exit(0);
		}	
	}
	
	public static void main(String[] args)throws FileNotFoundException{
		int[][] meal = new int[7][3];
		String fileName = "input1.txt";
		String[] day = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		String[] type = {"Breakfast", "Lunch", "Dinner"};
		
		readFile(fileName, meal);//create array
		int[] sumD = sumDay(meal, day);//sum of each day
		aveDay(sumD, day);//average of each day
		aveMeal(meal, type);//average of each meal type
		maxD(meal, day);//max of each day
		maxT(meal, type);//max of each meal type
		
	}
}
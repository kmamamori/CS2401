import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Calories2{

	public static int MaxRow(int[][] meal){
		int len = meal[0].length;
		for(int i=1; i<meal.length; i++){
			if(len<meal[i].length){
				len=meal[i].length;
			}
		}
		return len;
	}

	public static void aveM(int[][] meal){
		int[] sum = new int[MaxRow(meal)];
		int[] length = new int[sum.length];
		for(int i=0; i<meal.length; i++){
			for(int j=0; j<meal[i].length; j++){
				sum[j]=sum[j]+meal[i][j]; length[j]++;
			}
		} 
		for(int i=0; i<sum.length; i++){
			System.out.printf("The average calories of Meal-%d was %.2f.%n", i+1, (double)sum[i]/length[i]);
		}
		return;
	}
	
	public static void aveD(int[][] meal, String[] day){
		int sum = 0;
		for(int i=0; i<meal.length; i++){
			for(int j=0; j<meal[i].length; j++){
				sum = sum + meal[i][j];
			}
		System.out.printf("On %s, the average calories was %.2f.%n", day[i], (double)sum/meal[i].length);
		sum=0;
		}
		System.out.println();
		return;
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

	public static void readFile(String fileN, int[][] meal){
		int iter = 0;
		try{
			Scanner scnr = new Scanner(new File(fileN));
			while(scnr.hasNextLine()){
				if(iter==7){
					System.out.println("The text file shuould be 7 lines");
					System.exit(0);
				}
				String line = scnr.nextLine();
				String[] split = line.split(" ");
				meal[iter] = new int[split.length];
				for(int i=0; i<split.length; i++){
					meal[iter][i] = Integer.parseInt(split[i]);
				}
				iter++;
			}
		}catch(FileNotFoundException err){
			System.out.printf("Couldn't find %s", fileN);
			System.exit(0);
		}
		if(iter<7){
			System.out.println("The text file should be 7 lines.");
			System.exit(0);
		}
		return;
	}

	public static void main(String[] args){
		int[][] meal = new int[7][];
		String fileName = "input2.txt";
		String[] day = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};				
		readFile(fileName, meal);
		aveD(meal, day);
		aveM(meal);
	}
	
}
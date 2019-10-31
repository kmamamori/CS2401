import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class scanner{
	public static void main(String[] args) /*throws FileNotFoundException*/{
	
		int sum=0;
		try{
			Scanner scnr = new Scanner(new File("num.txt"));
			//int sum=0;
			while(scnr.hasNextLine()){
				String line = scnr.nextLine();
				int num = Integer.parseInt(line);
				sum = sum+num;
			}
			scnr.close();
		}catch(FileNotFoundException e){
			System.out.println("File not found.");
		}/*catch(IOException e){
			System.out.print("IOE");
		}*/
		System.out.println(sum);
		
	}
}
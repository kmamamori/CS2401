/***** Lab8 ****************************
****** 11/19/2018 **********************
******	Lec: MW10:30-11:50 am ***********
****** Lab: MW3:00-4:20 pm *************
****** Ken M. Amamori ******************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Calculator{

	public static void printinfo(String line){
		int ans = calculation(line);//return the answer for the equa.
		if(ans==(-1))//the equation is invalid
			System.out.printf("The equation: \"%s\" is invalid.\n", line);
		else//valid equation
			System.out.printf("The equation: \"%s\" is %d.\n", line, ans);
		return;
	}

	public static int calculation(String line){
		GenericStack stack = new GenericStack();//create a stack
		stack.createStack();//create the top
		char num;//declare char
		int i=0;
		for(i=0; i<line.length(); i++){//go through all the elements in the string
			if(Character.isDigit(num=line.charAt(i))){//if the first element is numerical
				stack.push(Character.getNumericValue(num));//push the number
			}else if(!stack.isEmpty()){//if stack is not empty
				int a = (int)stack.pop();//pop top
				if(!stack.isEmpty()){//if stack is not empty
					int b = (int)stack.pop();//pop top which will be the
					if(line.charAt(i)=='*'){//operation *
						stack.push(b*a);//push the result
					}else if(line.charAt(i)=='/'){//operation /
						stack.push(b/a);//push the result
					}else if(line.charAt(i)=='+'){//operation +
						stack.push(b+a);//push the result
					}else if(line.charAt(i)=='-'){//operation -
						stack.push(b-a);//push the result
					}else{ //symbol is neither numerical nor operation
						return -1;
					}//ifs
				}else{//stack empty
					break;
				}
			}else{//stack empty
				break;
			}//empty if
		}//for
		if(i==line.length()){//checks if iterated all the string
			int ans = (int)stack.pop();//get the last value
			if(stack.isEmpty())	return ans; // check if the numbers was invalid
			else return -1;
		}
		else	return -1;
	}

	public static String fn(){
		Scanner sc = new Scanner(System.in); //scanner
		System.out.println("Enter the name of the file.");
		return sc.next();//return the input from the user
	}

	public static void main(String[] args){
		try{ //try and catch
			Scanner scnr = new Scanner(new File(fn()+".txt")); //scna the file
			while(scnr.hasNextLine()){ //while there is a line
				String line = scnr.nextLine(); //store the first line
				printinfo(line); //calculate the equation and print out
			}
			scnr.close(); //close scanner
		}catch(FileNotFoundException err){ //catch
			System.out.println("File was not found");
			System.exit(0); //stop the program
		}
	}
}

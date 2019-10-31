/***** Lab8 ****************************
****** 11/19/2018 **********************
******	Lec: MW10:30-11:50 am ***********
****** Lab: MW3:00-4:20 pm *************
****** Ken M. Amamori ******************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class testing{

	public static void printAll(GenericStack s){
		if(s==null) return;
		GenericStack temp = new GenericStack();
		for(int i=0; i<5; i++){
			int p = (int)s.pop();
			if(i%2==0)
				System.out.print(p+" ");
			temp.push(p);
		}
		for(int i=0; i<5; i++){
			s.push((int)temp.pop());
		}
	}


	public static void main(String[] args){
		GenericStack s = new GenericStack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		printAll(s);
		System.out.println();
		printAll(s);
	}
}

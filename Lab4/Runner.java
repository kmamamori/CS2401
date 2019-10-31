/***** Lab4-LinedList********************
****** 10/12/2018 ***********************
******	Lec: MW10:30-11:50 am ***********
****** Lab: MW3:00-4:20 pm *************
****** Ken M. Amamori ******************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class Runner{

	/*calculate the average volume of cubic box*/
	public static void aveVolCubic(Box head){
		float sum=0;
		int c=0;
		/*run as long as head is not null*/
		while(head!=null){
			if(head.isCube()){//if the box at head is cubic
				sum+=head.getVolume();//calculate the sum
				c++;
			}
			head=head.next;//go to the next object
		}
		System.out.printf("%n%nThe average volumn of all cubic boxes: %.2f.", sum/c);
		return;
	}//end method

	/*calculate the average box of the LL*/
	public static void aveVol(Box head){
		float sum = 0;
		int c=0;
		/*run as long as head is not null*/
		while(head!=null){
			sum+=head.getVolume();//sum the volume of the LL
			c++;
			head=head.next;//go to the next object in LL
		}
		System.out.printf("%n%nThe average volumn of all boxes: %.2f.", sum/c);
		return;
	}//end method
		
	/*find the largest box in the LL*/
	public static void findMaxCubic(Box head){
		//check if the head is null
		if(findCubic(head)==0){
			System.out.printf("%n%nThere isn't any cubic box in the Linked List.");
			return;
		}
		float max = Integer.MIN_VALUE;
		Box temp = null;
		int p=0;
		int c=0;
		//run as long as head is not null
		while(head!=null){
			//true if head is cubic and has greater volume
			if(max<head.getVolume() && head.isCube()){
				max=head.getVolume();
				temp = head;//get the largest box
				p=c;
			}
			head=head.next;//move to the next object
			c++;
		}
		System.out.printf("%n%nThe largest cubic box: Index-%d, Dimension: %.2f %.2f %.2f, Volume: %.2f.", p, temp.getW(), temp.getH(), temp.getL(), temp.getVolume());
		return;//return
	}	
	
	/*find the smallest cubic box in the LL*/
	public static void findMinCubic(Box head){
		//check if the head is null
		if(findCubic(head)==0){
			System.out.printf("%n%nThere isn't any cubic box in the Linked List.");
			return;
		}
		Box temp = null;
		int p=0;
		int c=0;
		float min = Integer.MAX_VALUE;
		//run as long as head is null
		while(head!=null){
			if(head.isCube() && min>head.getVolume()){//true when head is cubic and volume is smaller
				min = head.getVolume();
				temp = head;//get the object where the smallest object
				p=c;
			}
			head=head.next;//move to the next object
			c++;
		}
		System.out.printf("%n%nThe smallest cubic box: Index-%d, Dimension: %.2f %.2f %.2f, Volume: %.2f.", p, temp.getW(), temp.getH(), temp.getL(), temp.getVolume());
		return;//return
	}

	/*count the number of cubic box in the LL*/
	public static int findCubic(Box head){
		int i=0;//counter
		/*Run as long as head is not null*/
		while(head!=null){
			if(head.isCube()){//true if it is cube
				i++;
			}
			head=head.next;//move to next node
		}
		//System.out.printf("%n%nThere are %d cubic box.", i);
		return i;
	}
	
	/*find the largest box in the LL*/
	public static void maxBox(Box head){
		float max = Integer.MIN_VALUE;
		Box temp = null;
		int p=0;
		int c=0;
		//Run as long as head is not null
		while(head!=null){
			if(max<head.getVolume()){//compare the max with node
				max=head.getVolume();
				temp = head;//get the object where is the largest LL
				p=c;
			}
			head=head.next;//move to the next object
			c++;
		}
		System.out.printf("%n%nThe largest box: Index-%d, Dimension: %.2f %.2f %.2f, Volume: %.2f.", p, temp.getW(), temp.getH(), temp.getL(), temp.getVolume());
		return;//return
	}
	
	/*find the smallest box in LL*/
	public static void minBox(Box head){
		float min = Integer.MAX_VALUE;
		Box temp = null;
		int p=0;
		int c=0;
		//run as long as head is not null
		while(head!=null){
			//true if the volume is smaller
			if(min>head.getVolume()){
				min = head.getVolume();
				temp = head;
				p=c;
			}
			head=head.next;//move to the next object
			c++;
		}
		System.out.printf("%n%nThe smallest box: Index-%d, Dimension: %.2f %.2f %.2f, Volume: %.2f.", p, temp.getW(), temp.getH(), temp.getL(), temp.getVolume());
		return;//return
	}
	
	/*read the file and create a linked with the inforamtion of text file*/
	public static Box createLL(){
		boolean one = true;
		Box head = new Box();//create the head of LL
		Box temp = head;//create temporary objectf for head
		/*try and catch*/
		try{
			System.out.println("Please type the name of the file without txt.");
			Scanner fn = new Scanner(System.in);
			Scanner scnr = new Scanner(new File(fn.next()+".txt"));//read the file
			/*if the text file is empty*/
			if(scnr.hasNextLine()==false){
				System.out.println("No content in the text file. Please check again.");
				System.exit(0);
			}//close if
			/*while loop in order to go through all the lines in the text file*/
			while(scnr.hasNextLine()){
				String line = scnr.nextLine();
				String[] split = line.split(" ");
				/*check if there are exactly 3 numbers in a line*/
				if(split.length!=3){
					System.out.println("Error! 3 numbers per line.");
					System.exit(0);
				}
				/*Run only once to set the value of head*/
				if(one){
					temp.setAll(Float.parseFloat(split[0]), Float.parseFloat(split[1]), Float.parseFloat(split[2]));//setter
					one=false;//change one to false
				}
				/*run if it is not head*/
				else{
					temp.next = new Box(Float.parseFloat(split[0]), Float.parseFloat(split[1]), Float.parseFloat(split[2]));
					temp=temp.next;
				}
			}
		}catch(FileNotFoundException err){//run when FileNotFoundException occurs
			System.out.println("File not found. Please check again.");
			System.exit(0);
		}
		return head;//return head
	}
	
	public static void main(String[] args){
		Box head = createLL();//create LL -1
		minBox(head);//find the smalles-2
		maxBox(head);//find the largest  -3
		System.out.printf("%n%nThere are %d cubic box.", findCubic(head));//count cubics in LL -4
		findMinCubic(head);//find the smallest cubic -5
		findMaxCubic(head);//find the largest cubic -6
		aveVol(head);//calculate the average volume of all boxes -7
		aveVolCubic(head);//calculate the average volume of cubic boxes -8
	}
}
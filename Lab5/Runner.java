/***** Lab5-LinkeddList********************
****** 10/22/2018 ***********************
******	Lec: MW10:30-11:50 am ***********
****** Lab: MW3:00-4:20 pm *************
****** Ken M. Amamori ******************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class Runner{

	public static void inserting(LinkedList ll){
		System.out.printf("\n\n\nInserting a node into linkedlist.\n");
		System.out.println("Type the width of the box.");
		Scanner scw = new Scanner(System.in);
		float w = scw.nextFloat();
		System.out.println("Type the height of the box.");
		Scanner sch = new Scanner(System.in);
		float h = sch.nextFloat();
		System.out.println("Type the length of the box.");
		Scanner scl = new Scanner(System.in);
		float l = scl.nextFloat();
		Box newbox = new Box(w, h, l);//creating a new box
		System.out.printf("Select the position where you want to insert the new box\n");
		ll.printAllBoxes();//printing every node in LL
		Scanner scp = new Scanner(System.in);
		//successfully adding into LL
		if(ll.insertNode(newbox, scp.nextInt())){
			System.out.println("Successfully inserted.");
			ll.printAllBoxes();//printing every node in LL to demostrate
		}//*/
		else{
			System.out.println("Inserting the new node was fail.");
		}//*/
		return;
	}

	public static void removing(LinkedList ll){
		System.out.printf("\n\n\nSelect the position of node which you want to remove from the list.\n");
		ll.printAllBoxes();//printing every node in LL
		Scanner scnr = new Scanner(System.in);
		int repos = scnr.nextInt();//getting the position
		//successfully removed the node at repos in LL
		if(ll.removeNode(repos)){
			System.out.println("The node was successfully removed from the list.");
			ll.printAllBoxes();//printing every node in LL to demo
		}
		else{
			System.out.println("The node at position could not be removed from the list.");
		}
		return;
	}

	public static void findCubic(LinkedList ll){
		int i=0;
		ll.initiateIterator();//initializing iterator
		Box temp = ll.getBox(i);//getting the first node 
		//go throught each node in LL
		while(temp!=null){
			//counting each cubic box
			if(temp.isCube()){
				i++;
			}
			temp=ll.getNextBox();//node.next
		}
		System.out.printf("\nThere is/are %d cubic(s) box.", i);
		return;
	}

	public static void largestBox(LinkedList ll){
		float max = Integer.MIN_VALUE;
		int i=0;
		int j=0;
		ll.initiateIterator();//initializing iterator
		//go to each node
		while(ll.getNextBox()!=null){
			float curr = ll.getBox(i).getVolume();
			if(max<curr){//comparing
				max=curr;
				j=i;
			}//closing if
			i++;
		}//closing while
		System.out.printf("\nLargest Box: ");
		ll.getBox(j).printAll(j);//printing
		return;
	}//*/
		
	public static void smallestBox(LinkedList ll){
		float min = Integer.MAX_VALUE;
		int i=0;
		int j=0;
		ll.initiateIterator();//initializing iterator
		//go to each node in LL
		while(ll.getNextBox()!=null){
			float curr = ll.getBox(i).getVolume();
			if(min>curr){//comparing
				min=curr;
				j=i;
			}
			i++;
		}//closing while
		System.out.printf("\nSmallest Box: ");
		 ll.getBox(j).printAll(j);//printing
		return;
	}//*/

	public static LinkedList readFile(){
		boolean one = true;
		LinkedList ll = new LinkedList();
		try{
			System.out.println("Please type the name of the file without '.txt'.");
			Scanner fn = new Scanner(System.in);
			Scanner scnr = new Scanner(new File(fn.next()+".txt"));
			if(scnr.hasNextLine()==false){
				System.out.println("No content in the file. Please check it again.");
				System.exit(0);
			}
			//go each line in text file
			while(scnr.hasNextLine()){
				String line = scnr.nextLine();
				String[] split = line.split(" ");
				if(split.length!=3){//checking if there are 3 numbers
					System.out.println("Error! It has to be 3 numbers per line.");
					System.exit(0);
				}
				Box newbox = new Box(Float.parseFloat(split[0]), Float.parseFloat(split[1]), Float.parseFloat(split[2]));//creating box
				ll.addNode(newbox);//creating LL
			}
		}catch(FileNotFoundException err){//error occurs
			System.out.println("File not found. Please check again.");
			System.exit(0);
		}
		ll.printAllBoxes();//printing each node
		ll.initiateIterator();//initializing iterator
		ll.printReverse();//printing reverse
		return ll;
	}


	public static void main(String[] args){
		LinkedList ll = readFile();//#1 create LL and print in two ways
		smallestBox(ll);//#2 report smallest box
		largestBox(ll);//#3 report largest box
		findCubic(ll);//#4 count cubic box
		removing(ll);//#5 removing a node
		inserting(ll);//#6 inserting a node
	}
}
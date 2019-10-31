/*Lab-6
Ken Amamori
11/01/2018
Lec: MW10:30am-11:50am, Lab:MW3:00pm-4:20pm*/

public class StringNode{
	public String head; //create a string variable called head
	public StringNode next; //create a SringNode variable called next
	 StringNode(){} // defalult constructor
	 
	 StringNode(String s){ //constructor with string in paramerter
	 	head=s;
	 }
	 
	 StringNode(String s, StringNode tail){ //constrctor with string and StringNode
	 	head = s;
		next=tail;
	 }
}
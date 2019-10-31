/*Lab-6
Ken Amamori
11/01/2018
Lec: MW10:30am-11:50am, Lab:MW3:00pm-4:20pm*/

import java.util.Random;

public class Operations{

	/*Create a new string for each node*/
	static String getRandString(int length){
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";//containing all the characters of alphabet
		String str = "";
		Random ran = new Random();//use this to get a random number
		for (int i=0; i<length; i++){//0 to length
			str = str + Character.toString(chars.charAt(ran.nextInt(26)));//char at random number and create a string 
		}
		return str;//return
	}
	
	/* Write a recursive method to print all the strings in separate lines.
	This method cannot contain any loop (that is, uses of for, while, do while are prohibited).   */
	public static void printMyList(StringNode m){
		if(m==null) return;//return if m is null
		System.out.printf("%s\n", m.head);//print out
		printMyList(m.next);//call a mehtod to get the following node
	}
	
	/*Write a recursive method to retrieve the number of strings that are longer than the length provided in the parameter.
	This method cannot contain any loop.*/
	public static int countKLengthStrings(StringNode m, int k){
		if(m==null)	return 0;//return 0 if m is null
		if(m.head.length()==k) return 1+countKLengthStrings(m.next, k);//return 1 to count the length and call the mehtod to get the next line
		return countKLengthStrings(m.next, k);//call the method to get the following node
	}
	
	/*Write a recursive method to retrieve the largest String from the list.
	Assume that there is at least one String in the given list when the method is called from the main function.
	This method cannot contain any loop*/
	public static String longestStringOfMyList(StringNode m){
		if(m.next==null) return m.head;//return the string if node is at the last position
		String newstr = "";
		if(m.head.length()>(newstr=longestStringOfMyList(m.next)).length()){//compare the length of m and m.next
			return m.head;//return the larger string if the conditing is true
		}
		return newstr;//returning the larger string
	}
	
	/*Write a recersive method to compute the lenth of a list.
	this method cannot contain any loop*/
	public static int lengthOfMyList(StringNode m){
		if(m==null) return 0;//return 0 if m is null
		return 1 + lengthOfMyList(m.next);//return 1 and the method with next node to count the length
	}
	
	/*Write a recursive method named reverseMyList that will reverse a give linked list m.
	return the head of the reversed linked list. It is fine if you need to modify the given linked list to obtain the reversed one.*/
	public static StringNode reverseMyList(StringNode m){
		if(m==null || m.next==null) return m;//return m if m or next node m is null
		StringNode newm = m.next;//store the next element of node into new node
		m.next = null;//get rid of rest of the nodes
		StringNode rest = reverseMyList(newm);//declare a new node with infomatin of newm
		newm.next = m;//make newm followed by m
		return rest;//return rest
	}
		
	/*Write a recursive method to remove the first occurrence of a specific String from a list. 
	As an example, if your list initially contains AA BB CC DD BB KK and if your removee is BB, the returned list should contain AA C DD BB KK after the removal.
	Return a new head.
	You must make sure that the parameter list M remains intact after return the new list to the main method. 
	This mehtod cannot contain any loop*/
	public static StringNode removeAStringFromMyList(StringNode m, String removee){
		if(m.next==null){//return null if m is at the last position
			StringNode temp = new StringNode(m.head);//declare a new node with string of m
			return temp;//return temp
		}
		StringNode prev = removeAStringFromMyList(m.next, removee);
		StringNode newh = new StringNode(m.head);//declare a new node with string of m
		if(m.head==removee){//if the string is same as removee
			return prev;//return prev
		}else{//else case
			newh.next = prev;// next node of newh is prev
			//return newh.next = prev;
			return newh;
		}
	}

	/*Write a recursive method to insert a String(insertee) into a specific position of a list.
	Positions start from 0 (head). 
	This method cannot contain any loop*/
	public static StringNode insertAStringIntoMyList(StringNode m, String insertee, int position){
		if(m==null || position<0) return null;//if m is null or position is less than 0
		if(position==0 && m!=null){//if position is 0 and m is not null
			StringNode newLL = new StringNode(insertee);//delcare a new node called newLL with info of insertee
			newLL.next = m;//newLL followed m
			return m = newLL;//return m
		}
		if(position==1){//if if position is 1
			StringNode newLL = new StringNode(insertee);//decalre a new node called newLL with info of isertee
			StringNode temp = m.next;//create a temp variable-temp with info of m.next 
			m.next = newLL;//m followed by newLL
			newLL.next=temp;//newLL followed by temp
			return m;//return m
		}
		m.next = insertAStringIntoMyList(m.next, insertee, position-1);//call the method with next position of node and position-1. store the return info to m.next
		return m;//return m
	}
	
	/*Write a recursive method to verify if the strings are lexicographically ordered in a linked list.
	Return true if they are ordered, false otherwise.
	This mehtod cannot contain any loop*/
	public static boolean isListInOrder(StringNode m){
		if(m==null || m.next==null) return true;//return true if m or m.next is null
		if((int)m.head.charAt(0)<(int)m.next.head.charAt(0))//if the first letter of m is less than m.next is 
			return isListInOrder(m.next);//call the method with next node
		return false;//return false if the codition is false
	}//*/
	
	/*Write a recursive method that will count how many strings of a jgiven linked list are palindromes.
	The method must call another recursive method named isPalindrome to verify is a String is a palindrome, or not.
	Palindrome checks must NOT be case-sensitive.
	Neither countPalindromes nor isPalindrome may contain loops*/
	public static int countPalindromes(StringNode m){
		if(m==null) return 0;//return 0 if m is null
		if(isPalindromes(m.head)){//if return type of isPalindromes is true
			System.out.printf("Palindrome: %s\n", m.head);//print out
			return 1+countPalindromes(m.next);//return 1 and call the method with next node of m
		}
		return countPalindromes(m.next);//call the method with next node of m
	}
	
	public static boolean isPalindromes(String s){
		if(s.length()==1 || s.length()==0) return true;//return true if the length is 1 or 0
		if(Character.toUpperCase(s.charAt(0))==Character.toUpperCase(s.charAt(s.length()-1)))//true if the first and last elements are the same
			return isPalindromes(s.substring(1, s.length()-1));//call the method with substring the first and last element
		return false;//return false since it is not palindrome
	}

	public static void main(String[] args){
		StringNode L=new StringNode("0"+getRandString(2+(int)(Math.random()*5))); //create a new node with the return type fro getRandString
		StringNode temp = L; //create a temporary variable temp
		for(int i=1; i<=9; i++){//iterate for 8 times 
			temp.next=new StringNode(i+getRandString(2+(int)(Math.random()*5)));//create a rest fo the node with getRandString
			temp=temp.next; //move to the following node
		}
		
		System.out.println("All Strings in the list:");
		printMyList(L);//call a method to print out
		System.out.println();
		
		boolean b=isListInOrder(L); //call a method which checks if the linked list is in order
		System.out.println("List is ordered: " +b);
		System.out.println();//*/
		
		System.out.println("Count of k-length strings");
		System.out.println("k\tNo. of Strings with lenth k");
		for(int k=0; k<7; k++){//iterate for 6 times
			System.out.println(k+"\t"+countKLengthStrings(L, k)); //count the length of each node
		}//*/

		System.out.println("Longest String="+longestStringOfMyList(L)); //print out the longest string in LL
		System.out.println("Length="+lengthOfMyList(L));//*/ the length of the LL

		L=reverseMyList(L); //reverse a linked list
		System.out.println("All string in the reversed list: ");
		printMyList(L);//print out the LL
		System.out.println();//*/
		
		System.out.println("Remove a given String");
		StringNode LL=removeAStringFromMyList(L, L.next.next.head);//remove a node in LL when it finds the same string
		System.out.println("All strings in the new list:");
		printMyList(LL); //print out the whole LL
		System.out.println();//*/
		
		System.out.println("All strings in the previous list:");
		printMyList(L);//print out the whole LL
		System.out.println();//*/
		
		System.out.println("Insert a string in a position of the new list:");
		LL=insertAStringIntoMyList(LL, "Hello world", 3); //insert a new node at 3
		printMyList(LL); //print out the whole list
		System.out.println();//*/
		
		b = isListInOrder(L); //checks if the LL is in order
		System.out.println("List is ordered: "+b);
		System.out.println();//*/
		
		LL=insertAStringIntoMyList(LL, "ABBA", 3); //insert a string into LL at postiion 3
		LL=insertAStringIntoMyList(LL, "DogeeseSeeGod", 3);//*/ insert a string into LL at postion 3
		
		int c=countPalindromes(LL); //counts the number of palindeomes
		System.out.println("Found "+c+" Palindromes.");//*/
	}
}
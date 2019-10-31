/***** Lab8 ****************************
****** 11/19/2018 **********************
******	Lec: MW10:30-11:50 am ***********
****** Lab: MW3:00-4:20 pm *************
****** Ken M. Amamori ******************/

class GenericStack{

	private Node top;

	void createStack(){//create an empty stack
		top = null;
	}
	boolean isEmpty(){//check if it is empty
		return (top==null); //return true or false depending on condition
	}
	void push(int newele){//add an element to the top of the stack
		Node nn = new Node();//create object
		nn.info = newele; //store the new info
		nn.next = top; //adding new element
		top = nn; //set top
	}
	public Object pop(){//return the top value and remove the element
		Node temp = top; //creating a temp node
		top = top.next; //set to the next  node
		return temp.info; //return value
	}
	void popAll(){//remove all the element
		top = null; //erase
	}
	public Object peek(){//return the top value without deleting
		if(isEmpty()){ //empty stack
			System.out.println("The stack is empty.");
			return -1;
		}else return top.info; //return top value
	}

}

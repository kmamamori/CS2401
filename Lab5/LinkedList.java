/***** Lab5-LinkeddList********************
****** 10/22/2018 ***********************
******	Lec: MW10:30-11:50 am ***********
****** Lab: MW3:00-4:20 pm *************
****** Ken M. Amamori ******************/

public class LinkedList{
	private Box head;
	private Box iterator;
	
	LinkedList(){}
	
	/*Add b as the last node of the linked list.*/
	void addNode(Box b){
		Box temp = head;//create a temp variabe
		if(head==null){//check if head exist
			head=b;
			return;
		}
		/*go to each node in box (one after)*/
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=b;//adding
		return;
	}//*/
	
	/*Insert b in position pos. If insertion is successful return true, otherwise return false.*/
	boolean insertNode(Box b, int pos){
		Box temp = head;//creating a temp variable
		//check if pos is valid and b is not null
		if(pos<0 || b==null)
			return false;
		//adding into first node
		if(pos==0){
			b.next=head;
			head=b;
			return true;	
		}
		//go to node at pos in LL
		while(temp!=null && pos!=1){ 
			temp=temp.next;
			pos--;
		}
		//add the new node if temp is at pos in LL
		if(pos==1 && temp!=null){
			Box temp1 = temp.next;
			temp.next=b;
			b.next=temp1;
			return true;
		}
		return false;
	}
	
	/**print width, height, length, and volume of each of the boxes in this linked list.*/
	void printAllBoxes(){
		int i=0;
		Box temp = head;//create a temp variabe
		/*go throught all nodes in LL*/
		while(temp!=null){
			temp.printAll(i);
			temp=temp.next;
			i++;
		}
		return;
	}
	
	/**remove the box in position pos. return true if removal is successful, otherwise return false.*/
	boolean removeNode(int pos){
		if(head==null || pos<0)//check if pos is invalid and head is exist
			return false;
		Box temp = head;//create temp variable
		//removing the first node
		if(pos==0){
			head=head.next;
			temp.next=null;
			return true;
		}
		/*move to node pos-1 to remove the next node*/
		while(temp.next!=null && pos!=1){
			temp=temp.next;
			pos--;
		}
		//if temp is at pos in LL
		if(pos==1 && temp.next!=null){
			temp.next=temp.next.next;
			return true;
		}
		return false;
	}//*/
	
	/**return the box in position pos. return null when pos is invalid*/
	Box getBox(int pos){
		if(pos<0)//return null if pos is invalid
			return null;
		Box temp = head;//create temporally variable
		/*stop at pos or when temp is null*/
		while(temp!=null && pos!=0){
			temp=temp.next;
			pos--;
		}
		//when node exist at pos
		if(pos==0 && temp!=null){
			return temp;			
		}
		else{
			return null;
		}
	}//*/
	
	void printReverse(){
		int size=0;
		if(iterator==null){//checks if iterator is not null
			return;
		}
		//find the size fo the node
		do{
			size++;//add first
		}while(getNextBox()!=null);//as long as iterator is not null
		//run the size of LL
		while(size!=0){
			initiateIterator();
			//get the last node in LL
			for(int i=0; i<size-1; i++){
				iterator=getNextBox();
			}
			iterator.printAll(size-1);//print out 
			size--;
		}
		return;
	}
	
	/**initiate the iterator variable*/
	void initiateIterator(){
		iterator = head;//initializaing
		return;
	}
	
	/**return the box in the current iterator position*/
	Box getNextBox(){
		return iterator = iterator.next;
	}
}
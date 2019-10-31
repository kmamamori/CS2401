/***** Lab9 ****************************
****** 11/23/2018 **********************
****** Lec: MW10:30-11:50 am ***********
****** Lab: MW3:00-4:20 pm *************
****** Ken M. Amamori ******************/

public class Queue{
	private int QUEUE_SIZE = 5; //begining size is 5
	private Object[] items;
	private int front, back, count;

	public Queue(){
		items = new Object[QUEUE_SIZE];
		front = 0; // set front to 0
		back = QUEUE_SIZE -1; //back
		count = 0; //count is 0
	}

	public boolean isEmpty(){ //check if Queue is empty
		return count ==0;
	}

	public boolean isFull(){ //check if Queue is full
		return count == QUEUE_SIZE;
	}

	public void enqueue(Object newItem){
		if(!isFull()){ //not full Queue
			back=(back+1) % QUEUE_SIZE; //move back to next place
			items[back] = newItem; //store new item
			count++; //increased the size
			return;
		}else{
			System.out.println("Queue is full. Doubling the size.");
			QUEUE_SIZE = QUEUE_SIZE*2; //doubling the size
			System.out.println("New max. size is: " + QUEUE_SIZE);
			Object[] temp = items; //temporary value
			items = new Object[QUEUE_SIZE]; //new array with new size
			int j=0;
			for(int i=front; j<temp.length; i=(i+1)%temp.length){ //iterate for temp's size
				items[j]=temp[i]; //store each value
				back = j++; //j increments one and store j into back
			}
			front=0; //set front to 0
			enqueue(newItem); //enqueue the new items
			System.out.println("Entered the new item.");
			return;
		}
	}

	public Object dequeue(){
		if(!isEmpty()){
			Object queueFront = items[front];
			front = (front+1) % QUEUE_SIZE; //move front
			count--; //subtrating one
			return queueFront; //return front value
	}else //empty Queue
		System.out.println("Trying to dequeue from empty queue");
		return null;
	}

	public void dequeueAll(){ //erase queue
		items = new Object[QUEUE_SIZE]; //erase the existing Queue by creating a new one
		front = 0;
		back = QUEUE_SIZE -1;
		count =0; //no data
	}

	public Object peek(){
		if (!isEmpty()){ //not empty
			return items[front]; //return the value at front
		}
		else //empty Queue
			System.out.println("Trying to peek with empty queue");
		return null;
	}

	public int size(){
		return count; //return the size for Queue
	}
}// End of class Queue

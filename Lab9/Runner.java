/***** Lab9 ****************************
****** 11/23/2018 **********************
****** Lec: MW10:30-11:50 am ***********
****** Lab: MW3:00-4:20 pm *************
****** Ken M. Amamori ******************/

class Runner{

	public static void reverseQueue(Queue q){
		System.out.printf("\nI am goint to reverse my Queue.\n");
		int size = q.size(); //store the size of Queue
		Object[] rev = new Object[size]; //create a new array
		for(int i=0; i<size; i++){ //iterate for the size of Queue
			rev[size-1-i] = q.dequeue();//store each value in reversed order
		}
		for(int i=0; i<size; i++){ //iterate for the size of Queue
			q.enqueue(rev[i]); //enqueue every value in the array
		}
		printQueue(q); //print all the element
		return;
	}//*/

	public static void findMaxInQueue(Queue q){
		int max = Integer.MIN_VALUE; //store the smallest number
		int temp; //temporary variable
		for(int i=0; i<q.size(); i++){ //to through each value in queue
			if(max < (temp=(int)q.dequeue())) //compare the value
				max=temp; //upadate data
			q.enqueue(temp); //put back the value into queue
		}
		System.out.printf("\nThe largest number in the queue is: %d\n", max);
		return;
	}

	public static void printQueue(Queue q){
		System.out.println("My queue is as follows:");
		for(int i=0; i<q.size(); i++){ //go through all the queues
			Object v = q.dequeue(); //get the first value
			System.out.print(v+" ");
			q.enqueue(v); //put back the value
		}
		return;
	}

	public static void main(String[] arg){
		Queue q = new Queue(); //creating an instance
		/*Enqueue 10, 20, 30, 40, 50*/
		q.enqueue(10);	q.enqueue(20);	q.enqueue(30);	q.enqueue(40);	q.enqueue(50);
		printQueue(q); //print all the queues
		System.out.printf("\nI am going to dequeue one element.\n");
		q.dequeue(); //removing the first element
		printQueue(q); //print all the queues
		reverseQueue(q); //reversing the order
		System.out.printf("\nI am goint to enqueue 60.\n");
		q.enqueue(60); //enqueue 60
		printQueue(q); //print all the queues
		System.out.printf("\nI am goint to enqueue 70.\n");
		q.enqueue(70); //enqueue 70
		printQueue(q); //print all the queues
		reverseQueue(q); //reversing the order
		findMaxInQueue(q); //finding the max value
		printQueue(q); //print all the queues
	}
}

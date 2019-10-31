class stack{

	public Node top;
	
	public void push(int data){		
		Node nn = new Node();
		nn.data = data;
		nn.next = top;
		top = nn;
	}
	
	public int pop(){
		Node temp = top;
		top = top.next;
		return top.data;
	}
	
	
}
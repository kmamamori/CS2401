class BubbleSort{

	public static void bubbleSort(int[] array, int pos){
		if(pos==1)
			return;
			
		for(int i=0; i<pos; i++){
			if(array[i]>array[i+1]){
				int temp = array[i+1];
				array[i] = array[i+1];
				array[i+1] = temp;
			}
		}
		bubbleSort(array, pos-1);
	}
	
	public static void main(String[] args){
		int[] array = {70, 229, 19, 10, 4};
		bubbleSort(array, array.length-1);
		for(int i=0; i<array.length; i++){
			System.out.printf("%d ", array[i]);
		}
	}
}
import java.util.Random;

class class1105{

	public static int[] randNums(int size){
		Random ran = new Random();
		int[] array = new int[size];
		for(int i=0; i<size; i++){
			array[i] = ran.nextInt(size*size);
			//System.out.printf("%d ", array[i]);
		}
		return array;
	}

	public static void iHateSkool(int[] x){
		int p=0;
		for(int i=0; i<x.length*x.length; i++)
			for(int j=i; j<x.length; j++)
				p++;
		//System.out.print(p+" ");
	}
	
	public static void main(String[] args){
		int size = 100000;
		int[] arr = randNums(size);
		
		long first = System.currentTimeMillis();
		iHateSkool(arr);
		//iHateSkool(randNums(size));
		long second = System.currentTimeMillis();
		System.out.println("Time: Second-First "+second + " " + first + " " + (second-first));
	}
}
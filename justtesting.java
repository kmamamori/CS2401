class justtesting{
	public static void main(String[] arg){
		Object[] arr = new Object[5];
		for(int i=0; i<arr.length; i++){
			arr[i] = i*3+i;
		}
		//arr = new Object[10]; //ok

		Object[] temp = arr;
		arr = new Object[10];
		for(int i=0; i<temp.length; i++){
			arr[i] = temp[i];
		}//*/
		for(int i=0; i<temp.length; i++){
			System.out.printf("%d ",(int)arr[i]);
		}
		System.out.println("");
		arr[temp.length] = 8;
		for(int i=0; i<6; i++){
			System.out.printf("%d ", (int)arr[i]);
		}
	}
}

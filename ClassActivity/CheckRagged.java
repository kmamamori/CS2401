class CheckRagged{
	
	
	
	public static boolean isRagged(int[][] array){
		int len = array[0].length;
		for(int i=0; i<array.length; i++){
			if(len!=array[i].length){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		
		int[][] array = {{1,2,3},{1,2}};
		int[][] array1 = {{1,2,3},{1,2,3}};
		boolean check = isRagged(array1);
		System.out.println(check);
		
		
	}
	
	
}
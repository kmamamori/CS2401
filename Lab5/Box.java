/***** Lab5-LinkeddList********************
****** 10/22/2018 ***********************
******	Lec: MW10:30-11:50 am ***********
****** Lab: MW3:00-4:20 pm *************
****** Ken M. Amamori ******************/

class Box{
	
	//attributes
	private float width;
	private float height;
	private float length;
	Box next;
	
	//constructors
	Box(){}
	Box(float w, float h, float l){
		width=w;
		height = h;
		length = l;
	}
	
	//setter
	void setAll(float w, float h, float l){
		width=w;
		height=h;
		length=l;
	}
	
	//getter
	float getW(){
		return width;
	}
	float getH(){
		return height;
	}
	float getL(){
		return length;
	}
	float getVolume(){//return the volume
		return (width*height*length);
	}
	boolean isCube(){//check if box is cubic
		if(width==height && height==length) return true;
		return false;
	}
	void printAll(int p){//printing evrything about the box
		System.out.printf("Position-%d, Width-%.2f, Height-%.2f, Length-%.2f, Volume-%.2f%n", p, width, height, length, getVolume());
		return;
	}
}
/******Lab3-Object *********************
****** 9/28/2018 **********************
******	Lec: MW10:30-11:50 am ***********
****** Lab: MW3:00-4:20 pm *************
****** Ken M. Amamori ******************/

class Package{
	
	//attributes
	private float width;
	private float height;
	private float length;
	
	//Default constructor
	Package(){}
	//constructor with parameter
	Package(float w, float h, float l){
		width = w;
		height = h;
		length = l;
	}
	
	//setter
	void setW(float w){
		width = w;
	}
	void setH(float h){
		height = h;
	}
	void setL(float l){
		length = l;
	}
	
	//getter
	float getW(){
		return this.width;
	}
	float getH(){
		return this.height;
	}
	float getL(){
		return this.length;
	}
	//calculate the volume of the package and return it
	float getVolume(){
		return width*height*length;
	}
	boolean isCube(){//verify if the package is cube
		if(width==height && height==length) return true;
		else return false;
	}
}
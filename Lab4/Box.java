//Lab4

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
}
class Flight{
	private String StartDest;
	private String EndDest;
	private double TimeofFlight;
	private int seats;
	private boolean avaiSeats;//check if the full is full
	private String airline;
	private int numOfpass;
	private double distance;
	
	Flight(){}
	
	//setter
	void setStartDest(String SD){
		StartDest = SD;
	}
	void setEndDest(String ED){
		StartDest = ED;
	}
	void setTimeofFlight(double TF){
		TimeofFlight = TF;
	}
	void setSeats(int S){
		seats = S;
	}
	void setAvaiSeats(boolean AV){
		avaiSeats = AV;
	}
	void setAirlines(String AL){
		airlines = AL;
	}
	void setNumOfpass(int NP){
		numOfpass = NP;
	}
	void setDistatnce(double D){
		distance = SD;
	}
	
	//getter
	String getStartDest(String SD){
		return StartDest;
	}
	String getEndDest(String ED){
		return StartDest;
	}
	double getTimeofFlight(double TF){
		return TimeofFlight;
	}
	int getSeats(int S){
		return seats;
	}
	boolean getAvaiSeats(boolean AV){
		return avaiSeats;
	}
	String getAirlines(String AL){
		return airlines;
	}
	int getNumOfpass(int NP){
		return numOfpass;
	}
	double getDistatnce(double D){
		return distance;
	}
	
	
	double calSpeed(double distance, double TimeOfFlight){
		return distance/timeOfFlight;
	}
	int calRemSeats(int seats, int numOfpass){
		return (seats-numOfpass);
	}
	boolean checkFull(int numOfpass, int seats){
		if((double)numOfpass/seats>0.8){
			return true;
		}
		return false;
	}	
}
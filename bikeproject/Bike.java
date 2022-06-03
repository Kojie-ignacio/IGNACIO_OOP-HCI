//Francis Inigo Ignacio
//BSIT2-1
//OOP
package bikeproject;

public class Bike implements BikeParts{

	private String handleBars, frame, tyres, seatType;
	private int NumGears;
	private final String make;
	
	public Bike(){	
		this.make = "Oracle Cycles";
	}
	
	public Bike(String handleBars, String frame, String tyres, String seatType, int numGears) {
		this.handleBars = handleBars;
		this.frame = frame;
		this.tyres = tyres;
		this.seatType = seatType;
		NumGears = numGears;
		this.make = "Oracle Cycles";
	}

	protected void printDescription()
	{
		System.out.println("\n" + this.make + "\n" 
				          + "This bike has " + this.handleBars + " handlebars on a " 
				          + this.frame + " frame with " + this.NumGears + " gears."  
				          + "\nIt has a " + this.seatType + " seat with " + this.tyres + " tyres.");
	}

	@Override
	public String getHandleBars() {
		return this.handleBars;
	}

	@Override
	public void setHandleBars(String newValue) {
		this.handleBars = newValue;
	}

	@Override
	public String getTyres() {
		return this.tyres;
	}

	@Override
	public void setTyres(String newValue) {
		this.tyres = newValue;		
	}

	@Override
	public String getSeatType() {
		return this.seatType;
	}

	@Override
	public void setSeatType(String newValue) {
		this.seatType = newValue;		
	}

}
	
	


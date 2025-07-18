public class Bicycle{
	// the bicycle class
	// has three fields.
	public int cadence;
	public int gear;
	public int speed;

	// the Bicycle class has
	// one constructor
	public Bicycle(int startCadence, int startSpeed, int startGear) {
		gear = startGear;
		speed = startSpeed;
		cadence = startCadence;
	}

	// the Bicycle class has
	// four methods
	public void setCadence(int newValue) {
		cadence = newValue;
	}

	public void applyBreak(int decrement) {
		speed -= decrement;
	}

	public void setGear(int newValue) {
		gear = newValue;
	}

	public void speedUp(int increment) {
		speed += increment;
	}
}

public class MountainBike extends Bicycle {
	// the MountainBike subclass has
	// one field
	public int seatHeight;

	// the MountainBike subclass has
	// one constructor
	public MountainBike(int startHeight, int startCadence, int startSpeed, int startGear) {
		super(startCadence, startSpeed, startGear);
		seatHeight = startHeight;
	}

	// the MountainBike subclass has
	// one method
	public void seatHeight(int newValue){
		seatHeight = newValue;
	}
}


























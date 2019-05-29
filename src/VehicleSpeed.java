
import cruiseControlSimulator.*;

public class VehicleSpeed implements Executable {
	
	WheelSpeedSensor leftWheel;
	WheelSpeedSensor rightWheel;
	
	double vehicleSpeed;
	private final double acceptedDifferenceSpeed = 5.0; // Maximal akzeptierte Differenz zwischen den zwei Rädern
	
	
	VehicleSpeed( WheelSpeedSensor[] sensors ) {
		leftWheel = sensors[0];
		rightWheel = sensors[1];
	}
	
	public double getVehicleSpeed() {
		return vehicleSpeed;
	}
	
	
	public void every100ms() {
		double leftSpeed = leftWheel.getWheelSpeed();
		double rightSpeed = rightWheel.getWheelSpeed();
		if( Math.abs( leftSpeed - rightSpeed) >= this.acceptedDifferenceSpeed ) {
			CruiseControl.log( 2,"[VehicleSpeed] acceptedDifferenceSpeed exceeded! accepted"+ this.acceptedDifferenceSpeed +"DifferenceSpeed: "+ (leftSpeed - rightSpeed) );
		}
		vehicleSpeed = (leftSpeed + rightSpeed) / 2;
		CruiseControl.log( 2,"[VehicleSpeed] vehicle speed " + vehicleSpeed);
	}

	public void everyKeypress() { // in this Class not needed
		
	}
}

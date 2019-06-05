
import cruiseControlSimulator.*;

public class BrakePedal implements Executable {
	DigitalPort ncBrakePedal; // normaly close
	DigitalPort noBrakePedal; // normaly open

	boolean braking = false;
	boolean braking_error = false;

	BrakePedal(DigitalPort[] brakePedal){
		ncBrakePedal = brakePedal[0];
		noBrakePedal = brakePedal[1];
	}

	public void every100ms() {
		if(ncBrakePedal.getState() == ncBrakePedal.getClosedState() && noBrakePedal.getState() == noBrakePedal.getClosedState()) {
			braking = true;
			CruiseControl.log(1, "[BrakePedal] braking = true");
		} else if(ncBrakePedal.getState() == ncBrakePedal.getOpenState() && noBrakePedal.getState() == noBrakePedal.getOpenState()) {
			braking = false;
			CruiseControl.log(1, "[BrakePedal] braking = false");
		} else {
			braking_error = true;
			CruiseControl.log(1, "[BrakePedal] Error kein gleicher Zustand der Bremspedale!");
		}
	}
	public void everyKeypress() {

	}

}

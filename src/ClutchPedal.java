
import cruiseControlSimulator.*;

public class ClutchPedal implements Executable {
	DigitalPort clutchPedal;
	Controller controller;
	ClutchPedal(DigitalPort clutch, Controller c) {
		clutchPedal = clutch;
		controller = c;
	}
	boolean state = false;
	public void every100ms() {
		this.state = clutchPedal.getState();
		if(this.state) {
			CruiseControl.log(1, "[Controller] ClutchPressed");
			controller.cancelPressed();
		}
	}
	public void everyKeypress() {
		
	}
	public boolean getClutchPressed() {
		if(this.state == clutchPedal.getOpenState()) {
			CruiseControl.log(3, "[ClutchPedal] Clutch pressed");
			return true;
		}
		return false;
	}
	
}


import cruiseControlSimulator.*;

public class ClutchPedal implements Executable {
	DigitalPort clutchPedal;
	ClutchPedal(DigitalPort clutch) {
		clutchPedal = clutch;
	}
	boolean state = false;
	public void every100ms() {
		
	}
	public void everyKeypress() {
		this.state = clutchPedal.getState();
	}
	public boolean getClutchPressed() {
		if(this.state == clutchPedal.getOpenState()) {
			return true;
		}
		return false;
	}
	
}


import cruiseControlSimulator.*;

public class BrakePedal implements Executable {
	DigitalPort ncBrakePedal; // normaly close
	DigitalPort noBrakePedal; // normaly open
	
	BrakePedal(DigitalPort[] brakePedal){
		ncBrakePedal = brakePedal[0];
		noBrakePedal = brakePedal[1];
	}
	
	public void every100ms() {
		
	}
	public void everyKeypress() {
		
	}
	
}

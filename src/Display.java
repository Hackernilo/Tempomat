
import cruiseControlSimulator.*;

public class Display {
	InstrumentPanelCluster Instrument;
	Display(InstrumentPanelCluster instrumentPanelCluster) {
		Instrument = instrumentPanelCluster;
	}
	
	public void setCruiseOnLamp (boolean state) {
		Instrument.setCruiseOnLamp(state);
	}
	public void setCruiseSetLamp(boolean state) {
		Instrument.setCruiseSetLamp(state);
	}
	public void show_speed(int speed) {
		Instrument.setCruiseSpeed(speed);
	}
	
}

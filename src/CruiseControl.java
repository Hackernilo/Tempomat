
import cruiseControlSimulator.*;

public class CruiseControl {

	public static void main(String[] args) {

		//Simulator sim = new Simulator();

		//EngineControl engineControl = sim.getEngineControl();
		//engineControl.requestAcceleration(10);

		Simulator sim = new Simulator();

		// Vehicle Speed
		WheelSpeedSensor[] wheelSpeedSensors = sim.getWheelSpeedSensors();
		VehicleSpeed spd = new VehicleSpeed( wheelSpeedSensors );
		sim.addListener(spd);

		
		Controller controller = new Controller ( spd, sim.getEngineControl() );
		sim.addListener(controller);

		// Analog Lever
		AnalogPort analogPort = sim.getLeverPort();
		Lever lever = new Lever( analogPort, controller );
		sim.addListener(lever);

		// Display Ausgabe
		InstrumentPanelCluster instrumentPanelCluster = sim.getInstrumentPanelCluster();
		Display dp = new Display( instrumentPanelCluster );
		
		
		// Temporaere zum testen

		dp.setCruiseOnLamp(true);
		dp.setCruiseSetLamp(true);
		dp.show_speed(55);

		// Ende Temporaer

		DigitalPort clutch = sim.getClutchPedalPort();
		ClutchPedal cp = new ClutchPedal(clutch, controller);
		sim.addListener(cp);

		DigitalPort[] brakePorts = sim.getBrakePedalPorts();
		BrakePedal bp = new BrakePedal( brakePorts );
		sim.addListener(bp);

		//Governor go = new Governor();
		//sim.addListener(gov);

		sim.start();
	}

	/**
	 * Diese Funktion ist zum Loggen in der Konsole gedacht. Wenn etwas ausgegeben werden soll auf 
	 * die Konsolle nehmen wir diese Funktion. Dadurch kann man ganz einfach die Konsolenausgabe ausschalten. 
	 * Die Funktion enthält den Ausgabestring und ein debuglevel. Um so niedriger die Zahl um so wichtiger, 
	 * ist die Information.
	 * @param debuglevel Wie wichtig ist die Information 1 ganz wichtig, 5 unwichtig
	 * @param s Ausgabestring
	 */
	public static void log(int debuglevel, String s) {  // Debug function 
		if(debuglevel < 6 ) {
			System.out.println(s);
		}

	}

}


import cruiseControlSimulator.*;

public class Lever implements Executable {
	AnalogPort leverAnalogPort;
	Controller controller;
	double leverVoltage;
	// Lever
	boolean leverCruise = false;
	boolean leverCancel = false;
	boolean leverSetMinus = false;
	boolean leverResPlus = false;
	boolean leverIdle = false;
	// Error
	boolean error = false;
	
	Lever(AnalogPort analogPort, Controller ctrl) {
		leverAnalogPort = analogPort;
		controller = ctrl;
	}
	// Lever Voltage States
	private double TempomatMin = 1.0;
	private double TempomatMax = 1.5;
	private double CancelMin = 1.5;
	private double CancelMax = 2.0;
	private double ResPlusMin = 2.0;
	private double ResPlusMax = 2.5;
	private double SetMinusMin = 2.5;
	private double SetMinusMax = 3;
	private double IdleMin = 3;
	private double IdleMax = 4;
	
	public void every100ms() { 
		this.resetLever();
	}
	
	public void everyKeypress() { 
		this.leverVoltage = leverAnalogPort.getVoltage();
		CruiseControl.log(3, "[LEVER] getVoltage: " + leverAnalogPort.getVoltage() + 
							" getMaxVoltage:" + leverAnalogPort.getMaxVoltage() +
							" getMinVoltage:" + leverAnalogPort.getMinVoltage());
		this.translate_Analoginput();
		// Logging for Debugging purposes
		CruiseControl.log(5, "[LEVER] Tempomat: "+ this.leverCruise);
		CruiseControl.log(5, "[LEVER] Cancel: "+ this.leverCancel);
		CruiseControl.log(5, "[LEVER] ResPlus: " + this.leverResPlus);
		CruiseControl.log(5, "[LEVER] SetMinus: " + this.leverSetMinus);
		
	}
	
	/**
	 * translates the analoginput signal into the following booleans:
	 * + leverCruise
	 * + leverCancel
	 * + leverResPlus
	 * + leverSetMinus
	 * + error  is set if the Voltage is not in the given parameters
	 */
	private void translate_Analoginput() {
		this.resetLever();
		if(IdleMin < this.leverVoltage && IdleMax > this.leverVoltage) {
			this.leverIdle = true;
		} else if( TempomatMin < this.leverVoltage && TempomatMax > this.leverVoltage) {
			this.leverCruise = true;
			controller.cruisePressed();
		} else if(CancelMin < this.leverVoltage && CancelMax > this.leverVoltage) {
			this.leverCancel = true;
		} else if(ResPlusMin < this.leverVoltage && ResPlusMax > this.leverVoltage) {
			this.leverResPlus = true;
		} else if(SetMinusMin < this.leverVoltage && SetMinusMax > this.leverVoltage) {
			this.leverSetMinus = true;
		} else {
			this.error = true;
			CruiseControl.log(3, "[LEVER] Error Spannung nicht definiert");
		}
	}
	
	/**
	 * resets all Lever booleans
	 */
	private void resetLever() {
		this.leverCruise = false;
		this.leverCancel = false;
		this.leverResPlus = false;
		this.leverSetMinus = false;
		this.leverIdle = false;
	}
	
	/**
	 * @return
	 * boolean leverCruise
	 */
	public boolean getTempomat() {
		return this.leverCruise;
	}
	
	/**
	 * @return
	 * boolean leverCancel
	 */
	public boolean getCancel() {
		return this.leverCancel;
	}
	
	/**
	 * @return
	 * boolean leverResPlus
	 */
	public boolean getRESplus() {
		return this.leverResPlus;
	}
	
	/**
	 * @return
	 * boolean leverSetMinus
	 */
	public boolean getSETminus() {
		return this.leverSetMinus;
	}
	
	/**
	 * @return
	 * boolean leverIdle
	 */
	public boolean getIdle() {
		return this.leverIdle;
	}
}

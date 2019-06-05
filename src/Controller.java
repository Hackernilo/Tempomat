import cruiseControlSimulator.*;

public class Controller implements Executable {

	State currentState = new OffState();
	EngineControl engineControl;
	VehicleSpeed vehicleSpeed;
	
	
	Controller( VehicleSpeed v, EngineControl e ) {
		vehicleSpeed = v;
		engineControl = e;
	}
	
	
	public void cruisePressed() {
			/* cruise is presssed */
		currentState = currentState.cruisePressed();
		CruiseControl.log(1, "[Controller] CruisePressed");
		
	}
	public void cancelPressed() {
		currentState = currentState.cancelPressed();
		CruiseControl.log(1, "[Controller] cancelPressed");
	}



	@Override
	public void every100ms() {
		// TODO Auto-generated method stub
		if( currentState.governorActive() ) {
			
		}
			
	}



	@Override
	public void everyKeypress() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

package code;

import code.common.enumerate.WYSPACE;
import code.common.WYSpaceI;
import code.service.GetWYSpaceFactory;

public class main {

	// name of the file pass schedule
	public static String FILE_NAME = "input/2458843pass-schedule.txt";
	
	// Maximum BandWidth supports by the ground station
	public static Integer MAX_BANDWIDTH_GS = 40;

	public static void main(String[] args) {
		
		// create the factory WYSpace class 
		GetWYSpaceFactory spaceFactory = new GetWYSpaceFactory();
		
		// Select the approach
		WYSpaceI space = spaceFactory.getSpace(WYSPACE.APPROACH1_ALMOST_CUADRATIC);
		
		// find the 30 minute period where the total downlink will be at its maximum
		space.findPeriod(FILE_NAME, MAX_BANDWIDTH_GS);
		
	}

}

package code;

import code.common.enumerate.WYSPACE;

import java.time.LocalTime;
import java.util.List;

import code.common.WYSpaceI;
import code.service.GetWYSpaceFactory;

public class main {

	// name of the file pass schedule
	public static String FILE_NAME = "input/2458843pass-schedule.txt";
	
	// Maximum BandWidth supports by the ground station
	public static Integer MAX_BANDWIDTH_GS = 30;

	public static void main(String[] args) {
		
		try {
			FILE_NAME = args[0];
			MAX_BANDWIDTH_GS = Integer.parseInt(args[1]);
			

			// create the factory WYSpace class 
			GetWYSpaceFactory spaceFactory = new GetWYSpaceFactory();
			
			// Select the approach
			WYSpaceI space = spaceFactory.getSpace(WYSPACE.APPROACH1_ALMOST_CUADRATIC);
			
			// find the 30 minute period where the total downlink will be at its maximum
			List<LocalTime> periods = space.findPeriod(FILE_NAME, MAX_BANDWIDTH_GS);
			
			System.out.println("The periods where the total downlink will be at its maximum are: ");
			for (LocalTime p : periods)
				System.out.println(p);
			
			if (space.supportBandwidth())
				System.out.println("The space ground supports the total bandwidth");
			else
				System.out.println("The space ground does not support the total bandwidth");
			
	    }
	    catch (ArrayIndexOutOfBoundsException e){

			System.out.println("Please, specific the input parameters as follows:\n");
			System.out.println("java -jar wySpace.jar PASS_SCHEDULE_FILE [MAX_BANDWIDTH]\n");
	    }
	    finally {

	    }
		
	}

}

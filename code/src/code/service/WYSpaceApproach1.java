package code.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import code.common.Interval;
import code.common.Satellite;
import code.common.Station;

/**
 * @author Cesar Augusto Guzman Alvarez
 * @date Sep 26, 2020
 *
 */
public class WYSpaceApproach1 extends WYSpaceAbstract {

	/**
	 * List of satellites
	 */
	private List<Station> satellites = new ArrayList<Station>();

	
	@Override
	protected int findTotalBandwidth(LocalTime start) {
		
		int totalBandwidth = 0;
		
		// for each satellite in pass schedule:
	    for (Station satellite : satellites) {
			
	    	// if satellite.overlap(time) :
	    	if (((Satellite)satellite).overlap(start)) {
	    		
	            // totalBandwidth+= satellite.getBandwidth()
	    		totalBandwidth+=satellite.getBandwidth();
	    		
	    	}
	    }
		
	    return totalBandwidth;
	    
	}

	@Override
	protected void store(String[] temp) {
		
		// create the object Satellite
		Station satellite = new Satellite(temp[0], Integer.parseInt(temp[1]));
		
		// store the satellite in the list of satellites
		int index = satellites.indexOf(satellite);
		if(index == -1) {
			satellites.add(satellite);
			index = satellites.size()-1;
		}
		
		satellite = satellites.get(index);				
		
		// keep the satellite information in the list
		((Satellite)satellite).add(new Interval(LocalTime.parse(temp[2]), LocalTime.parse(temp[3])));
				
	}

}

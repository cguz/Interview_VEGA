package code.service;

import java.time.LocalTime;

import code.common.Interval;
import code.common.Satellite;
import code.common.Station;

/**
 * @author Cesar Augusto Guzman Alvarez
 * @date Sep 26, 2020
 *
 */
public class WYSpaceApproach2 extends WYSpaceAbstract {
	
	/**
	 * Interval Tree implementation
	 */
	private IntervalTree intervalTree = new IntervalTree();
	
	@Override
	protected int findTotalBandwidth(LocalTime start) {
		
	    // calculate the total bandwidth occupied by the satellites in the given time
	    return intervalTree.findTotalBandwidth(start);
	    
	}


	@Override
	protected void store(String[] temp) {

		// create the object Satellite
		Station satellite = new Satellite(temp[0], Integer.parseInt(temp[1]));
		
		// keep the satellite information in the list
		((Satellite)satellite).add(new Interval(LocalTime.parse(temp[2]), LocalTime.parse(temp[3])));
		
		// store the satellite (period of time) in the interval tree data structure
		intervalTree.insert((Satellite)satellite);
		
	}
	
}

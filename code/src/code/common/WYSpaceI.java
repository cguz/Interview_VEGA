package code.common;

import java.time.LocalTime;
import java.util.List;

/**
 * @author Cesar Augusto Guzman Alvarez
 * @date Sep 26, 2020
 *
 */
public interface WYSpaceI {
	
	/**
	 * 
	 * Function that finds the 30 minute period where the 
	 * total downlink will be at its maximum
	 * 
	 * In addition it will print whether the ground station 
	 * has the bandwidth to support this 
	 * 
	 * @param file 
	 * @param maxBandwidth
	 * @return
	 */
	public  List<LocalTime> findPeriod(String file, Integer maxBandwidth);
	
	/**
	 * Function to check if the ground station has the bandwidth
	 * to support communication
	 * 
	 * @return true has the bandwidth to support the communication, false otherwise
	 */
	public boolean supportBandwidth();

}

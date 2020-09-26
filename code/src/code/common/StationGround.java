package code.common;

/**
 * @author Cesar Augusto Guzman Alvarez
 * @date Sep 26, 2020
 *
 */
public class StationGround extends Station {

	
	/**
	 * Indicate if the ground station support the bandwidth
	 */
	private boolean supportBandwidth;

	/**
	 * Constructor 
	 * 
	 * @param bandwidth Integer maximum bandwidth support by the ground station
	 */
	public StationGround(Integer bandwidth) {
		super("Station Ground", bandwidth);
		
		supportBandwidth = true;
	}

	/**
	 * Function that returns if the satellite support the total bandwidth of the pass schedule
	 * @return true if it supports the total bandwidth, false otherwise
	 */
	public boolean getSupportBandwidth() {
		return supportBandwidth;
	}
	
	/**
	 * Function to check if the ground station has the bandwidth
	 * to support communication
	 * 
	 * @return true has the bandwidth to support the communication, false otherwise
	 */
	public void setSupportBandwidth(boolean support) {
		supportBandwidth = support;
	}
}

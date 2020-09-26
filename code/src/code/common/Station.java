package code.common;

/**
 * @author Cesar Augusto Guzman Alvarez
 * @date Sep 25, 2020
 *
 */
public class Station {
	
	/**
	 * Name of the satellite or the station ground
	 */
	private String name;
	
	/**
	 * for a satellite it is the bandwidth it consumes when it is communicating
	 * 
	 * for a station ground it is the maximum bandwidth it can deals
	 */
	private Integer bandwidth;
	
	
	/**
	 * @param name String name of the satellite or ground station
	 * @param bandwidth Integer bandwidth of the satellite or station
	 */
	public Station(String name, Integer bandwidth) {
		this.name = name;
		this.bandwidth = bandwidth;
	}
	
	/**
	 * @return the name of the station
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the bandwidth of the station
	 */
	public Integer getBandwidth() {
		return bandwidth;
	}

}

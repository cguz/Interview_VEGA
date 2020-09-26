package code.common;

/**
 * @author Cesar Augusto Guzman Alvarez
 * @date Sep 26, 2020
 *
 */
public class StationGround extends Station {

	/**
	 * Constructor 
	 * 
	 * @param bandwidth Integer maximum bandwidth support by the ground station
	 */
	public StationGround(Integer bandwidth) {
		super("Station Ground", bandwidth);
	}

}

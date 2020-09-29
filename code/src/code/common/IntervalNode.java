package code.common;

import java.time.LocalTime;

/**
 * @author Cesar Augusto Guzman Alvarez
 * @date Sep 28, 2020
 *
 */
public class IntervalNode {
	
	/**
	 * Information of the period of time
	 */
	public Satellite satellite;
	
	/**
	 * Maximum local time by the right
	 */
	public LocalTime max;
	
	/**
	 * left interval node
	 */
	public IntervalNode left;
	
	/**
	 * right interval node
	 */
	public IntervalNode right;

	@Override
	public String toString() {
		return "[" + satellite.getName() + ", intervals="+satellite.getFirstTimeInterval()+", max=" + max + ", left=" + left + ", right=" + right + "]";
	}
	
}

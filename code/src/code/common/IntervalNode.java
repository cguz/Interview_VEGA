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
	private Satellite satellite;
	
	/**
	 * Maximum local time by the right
	 */
	private LocalTime max;
	
	/**
	 * left interval node
	 */
	private IntervalNode left;
	
	/**
	 * right interval node
	 */
	private IntervalNode right;
	
}

package code.common.enumerate;

/**
 * @author Cesar Augusto Guzman Alvarez
 * @date Sep 26, 2020
 *
 */
public enum WYSPACE {
	
	/**
	 * Visit each time and test the satellites that intersect 
	 * the given time within its interval of communication, 
	 * which requires O(n*m). Where n is the number of 
	 * time intervals during a day, and m is the number of satellites. 
	 */
	APPROACH1_ALMOST_CUADRATIC, 
	
	/**
	 * Interval tree
	 */
	APPROACH2_INTERVAL_TREE
}

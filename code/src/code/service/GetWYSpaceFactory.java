package code.service;

import code.common.enumerate.WYSPACE;
import code.common.WYSpaceI;

/**
 * 
 * @author Cesar Augusto Guzman Alvarez
 * @date Sep 26, 2020
 *
 */
public class GetWYSpaceFactory {

	/**
	 * Function to retrieve the approach used to solve the Space
	 * 
	 * @param approach Enumerate of the approach to select
	 * @return WYSpaceI that solve the problem
	 */
	public WYSpaceI getSpace(WYSPACE approach) {
		
		switch(approach) {
			/**
			 * Visit each time and test the satellites that intersect 
			 * the given time within its interval of communication, 
			 * which requires O(n*m). Where n is the number of 
			 * time intervals during a day, and m is the number of satellites. 
			 */
			case APPROACH1_ALMOST_CUADRATIC:
				return new WYSpaceApproach1();
			/**
			 * Interval tree
			 */
			case APPROACH2_INTERVAL_TREE:
				return new WYSpaceApproach2();
				
		}
		
		return null;
	}

}

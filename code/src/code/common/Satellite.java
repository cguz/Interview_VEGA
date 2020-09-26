package code.common;
import java.util.List;
import java.util.ArrayList;

import java.time.LocalTime;

/**
 * @author Cesar Augusto Guzman Alvarez
 * @date Sep 26, 2020
 *
 */
public class Satellite extends Station {

	/**
	 * List of time intervals of a satellites
	 */
	private List<Interval> timeIntervals; 
	
	
	/**
	 * Constructor 
	 * 
	 * @param name String name of the satellite
	 * @param bandwidth Integer bandwidth per 30 minute period
	 */
	public Satellite(String name, Integer bandwidth) {
		super(name, bandwidth);
		timeIntervals = new ArrayList<Interval>();
	}
	
	/**
	 * 
	 * Function to add an interval in the satellite
	 * 
	 * @param start Integer start time
	 * @param end Integer end time
	 */
	public void add(LocalTime start, LocalTime end) {
		add(new Interval(start, end));
	}
	
	/**
	 * 
	 * Function to add an Interval in the satellite
	 * 
	 * @param interval Interval object 
	 */
	public void add(Interval interval) {
		timeIntervals.add(interval);
	}
	

}

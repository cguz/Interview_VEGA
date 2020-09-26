package code.common;

import java.time.LocalTime;

/**
 * @author Cesar Augusto Guzman Alvarez
 * @date Sep 25, 2020
 *
 */
public class Interval {
	
	/**
	 * start time of the interval
	 */
	private LocalTime start;
	
	
	/**
	 * end time of the interval
	 */
	private LocalTime end;
	
	
	
	/**
	 * Constructor to initialize 
	 * 
	 * @param start Integer start time of the transmission
	 * @param end Integer end time of the transmission
	 */
	public Interval(LocalTime start, LocalTime end) {
		this.start = start;
		this.end = end;
	}
	
	/**
	 * Function that retrieves the start time
	 * 
	 * @return the start time of the transmission
	 */
	public LocalTime getStart() {
		return start;
	}
	
	/**
	 * Function that retrieves the end time
	 * 
	 * @return the end time of the transmission
	 */
	public LocalTime getEnd() {
		return end;
	}

	/**
	 * Function that detects if the time overlaps
	 * 
	 * @param time LocaTime 
	 * @return True if the time overlaps. Otherwise false.
	 */
	public boolean overlap(LocalTime time) {
		return (start.isBefore(time) || start.equals(time)) && (time.isBefore(end) || time.equals(end));
	}
}

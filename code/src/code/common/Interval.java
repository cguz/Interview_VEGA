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
	 * @return the end time of the transmission
	 */
	public LocalTime getEnd() {
		return end;
	}
	
	/**
	 * @return the start time of the transmission
	 */
	public LocalTime getStart() {
		return start;
	}
}

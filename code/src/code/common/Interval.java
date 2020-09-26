package code.common;

/**
 * @author Cesar Augusto Guzman Alvarez
 * @date Sep 25, 2020
 *
 */
public class Interval {
	
	/**
	 * start time of the interval
	 */
	private int start;
	
	
	/**
	 * end time of the interval
	 */
	private int end;
	
	
	
	/**
	 * Constructor to initialize 
	 * 
	 * @param start
	 * @param end
	 */
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	
	public int getEnd() {
		return end;
	}
	
	public int getStart() {
		return start;
	}
}

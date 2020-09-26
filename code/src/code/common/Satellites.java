package code.common;
import java.util.List;
import java.util.ArrayList;

public class Satellites extends Station {

	private List<Interval> timeIntervals; 
	
	public Satellites(String name, Integer bandwidth) {
		super(name, bandwidth);
		timeIntervals = new ArrayList<Interval>();
	}
	
	

}

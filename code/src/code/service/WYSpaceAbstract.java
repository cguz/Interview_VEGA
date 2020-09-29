package code.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import java.time.LocalTime;

import code.common.Interval;
import code.common.Satellite;
import code.common.Station;
import code.common.StationGround;
import code.common.WYSpaceI;

/**
 * @author Cesar Augusto Guzman Alvarez
 * @date Sep 26, 2020
 *
 */
public abstract class WYSpaceAbstract implements WYSpaceI {
	
	// delimiter of the file
	protected final String DELIMITER = ",";
	
	
	/**
	 * Pass schedule configuration file
	 */
	protected String fileName;
	
	/**
	 * Station ground 
	 */
	protected Station stationGround; 
	
	/**
	 * List of satellites
	 */
	protected List<Station> satellites = new ArrayList<Station>();

	
	@Override
	public List<LocalTime> findPeriod(String file, Integer maxBandwidth) {

		fileName = file; 
		
		stationGround = new StationGround(maxBandwidth);
		
		// read the file pass schedule
		readFile(fileName);
		
		// declare a list of intervals as empty
		List<LocalTime> periodTotalDownlinkMaximum = new ArrayList<LocalTime>();

		// maximum total bandwidth
		int maxTotalBandwidth = 0;

		// for each possible time in the interval
		// for time 00:00 to 00:00 (24:00) increased by 30:
		LocalTime end = LocalTime.parse("23:30");
		for (LocalTime start = LocalTime.parse("00:00");
			start.isBefore(end); 
			start = start.plusMinutes(30)) {
		    
		    // calculate the total bandwidth occupied by the satellites in the given time
		    int totalBandwidth = 0;
			
			// for each satellite in pass schedule:
		    for (Station satellite : satellites) {
				
		    	// if satellite.overlap(time) :
		    	if (((Satellite)satellite).overlap(start)) {
		    		
		            // totalBandwidth+= satellite.getBandwidth()
		    		totalBandwidth+=satellite.getBandwidth();
		    		
		    	}
		    }
		    
		    // whether the total bandwidth is higher than the support by the ground station
		    if (totalBandwidth <= stationGround.getBandwidth()) {

		        // keep the maximum total bandwidth 
		    	if (totalBandwidth > maxTotalBandwidth)
		    		periodTotalDownlinkMaximum.clear();
		        
		    	// if totalBandwidth >= maxBand :
		    	if (totalBandwidth >= maxTotalBandwidth) {
		            
		    		// maxBand = totalBandwidth
		    		maxTotalBandwidth = totalBandwidth;
		    		
		            // periodTotalDownlinkMaximum.add(time);
		    		periodTotalDownlinkMaximum.add(start);
		    		
		    	}
		    }else {
		    	((StationGround)stationGround).setSupportBandwidth(false);
		    }
		}
		
		return periodTotalDownlinkMaximum;
		
	}
	
	/**
	 * Function to check if the ground station has the bandwidth
	 * to support communication
	 * 
	 * @return true has the bandwidth to support the communication, false otherwise
	 */
	public boolean supportBandwidth() {
		return ((StationGround)stationGround).getSupportBandwidth();
	}


	/**
	 * Function to read the file pass schedule
	 * 
	 * @param fileName String name of the file pass schedule
	 */
	protected void readFile(String fileName) {

		try {
			// read the file
			File input = new File(fileName);
			Scanner scanner = new Scanner(input);
			
			// whether there is more line in the file
			while(scanner.hasNextLine()) {
				
				// read the next line of the file
				String line = scanner.nextLine();
				
				// separate the string 
				String[] temp = line.split(DELIMITER);
				
				// create the object Satellite
				Station satellite = new Satellite(temp[0], Integer.parseInt(temp[1]));
				
				// store the satellite in the list of satellites
				int index = satellites.indexOf(satellite);
				if(index == -1) {
					satellites.add(satellite);
					index = satellites.size()-1;
				}
				
				satellite = satellites.get(index);				
				
				// keep the satellite information in the list
				((Satellite)satellite).add(new Interval(LocalTime.parse(temp[2]), LocalTime.parse(temp[3])));
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}

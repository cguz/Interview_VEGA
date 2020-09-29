package code.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import java.time.LocalTime;

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
	private final String DELIMITER = ",";
	
	
	/**
	 * Pass schedule configuration file
	 */
	protected String fileName;
	
	/**
	 * Station ground 
	 */
	protected Station stationGround; 

	
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
		for (LocalTime time = LocalTime.parse("00:00");
			time.isBefore(end); 
			time = time.plusMinutes(30)) {
		    
		    // calculate the total bandwidth occupied by the satellites in the given time
		    int totalBandwidth = findTotalBandwidth(time);
		    
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
		    		periodTotalDownlinkMaximum.add(time);
		    		
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
	private void readFile(String fileName) {

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
				
				// store the object Satellite
				store(temp);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Abstract function to find the total bandwidth occupied by the satellites at the given time
	 * 
	 * @param time LocalTime to search
	 * @return total bandwidth occupied by the satellites 
	 */
	protected abstract int findTotalBandwidth(LocalTime time);

	/**
	 * Function abstract to store the object satellite in the list of satellites
	 * 
	 * @param temp
	 */
	protected abstract void store(String[] temp);
	
}

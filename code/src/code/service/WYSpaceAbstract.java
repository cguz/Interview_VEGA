package code.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import java.time.LocalTime;

import code.common.Interval;
import code.common.Station;
import code.common.StationGround;
import code.common.WYSpaceI;

/**
 * @author Cesar Augusto Guzman Alvarez
 * @date Sep 26, 2020
 *
 */
public abstract class WYSpaceAbstract implements WYSpaceI {
	
	/**
	 * Pass schedule configuration file
	 */
	private String fileName;
	
	/**
	 * Station ground 
	 */
	private Station stationGround; 
	
	/**
	 * List of satellites
	 */
	private List<Station> satellites;
	

	@Override
	public LocalTime findPeriod(String file, Integer maxBandwidth) {

		fileName = file; 
		
		stationGround = new StationGround(maxBandwidth);
		
		LocalTime periodTotalDownlinkMaximum = null;
		// LocalTime.parse("00:00");
        // System.out.println(periodTotalDownlinkMaximum);
		
		try {
			File input = new File(fileName);
			
			Scanner scanner = new Scanner(input);
			
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				System.out.println(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return periodTotalDownlinkMaximum;
	}
	
}

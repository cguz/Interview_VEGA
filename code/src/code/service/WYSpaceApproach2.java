package code.service;

import java.time.LocalTime;
import java.util.List;

/**
 * @author Cesar Augusto Guzman Alvarez
 * @date Sep 26, 2020
 *
 */
public class WYSpaceApproach2 extends WYSpaceAbstract {

	@Override
	public  List<LocalTime> findPeriod(String file, Integer maxBandwidth) {
		return null;
	}

	@Override
	public boolean supportBandwidth() {
		return false;
	}

}

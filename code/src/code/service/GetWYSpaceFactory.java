package code.service;

import code.common.enumerate.WYSPACE;
import code.common.WYSpaceI;

public class GetWYSpaceFactory {

	public WYSpaceI getSpace(WYSPACE approach) {
		
		switch(approach) {
		
			case APPROACH1_ALMOST_CUADRATIC:
				return new WYSpaceApproach1();
			case APPROACH2_INTERVAL_TREE:
				return new WYSpaceApproach2();
		}
		
		return null;
	}

}

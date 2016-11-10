package ca.mcgill.ecse539.btms.persistence;

import ca.mcgill.ecse539.btms.persistence.PersistenceXStream;
import ca.mcgill.ecse539.btms.model.BTMS;

public class PersistenceBTMS {
	
	private static void initializeXStream() {
		PersistenceXStream.setFilename("busTransportationManagementSystem.xml");
		PersistenceXStream.setAlias("btms", BTMS.class);
	}
	
	public static void loadEventRegistrationModel() {
		BTMS btms = BTMS.getInstance();
		PersistenceBTMS.initializeXStream();
		BTMS btms2 = (BTMS) PersistenceXStream.loadFromXMLwithXStream();
	}

}

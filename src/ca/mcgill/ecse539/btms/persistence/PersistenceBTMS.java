package ca.mcgill.ecse539.btms.persistence;

import ca.mcgill.ecse539.btms.persistence.PersistenceXStream;

import java.util.Iterator;


import ca.mcgill.ecse539.btms.model.BTMS;
import ca.mcgill.ecse539.btms.model.Bus;
import ca.mcgill.ecse539.btms.model.Driver;

public class PersistenceBTMS {
	
	private static void initializeXStream() {
		PersistenceXStream.setFilename("busTransportationManagementSystem.xml");
		PersistenceXStream.setAlias("btms", BTMS.class);
	}
	
	public static void loadBtmsModel() {
		BTMS btms = BTMS.getInstance();
		PersistenceBTMS.initializeXStream();
		BTMS btms2 = (BTMS) PersistenceXStream.loadFromXMLwithXStream();
	}
	

}

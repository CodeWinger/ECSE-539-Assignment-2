package ca.mcgill.ecse539.btms.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ca.mcgill.ecse539.btms.model.BTMS;

public class PersistenceObjectStream {

	private static final String FILENAME = "output";
	
	public static void serialize(BTMS object)  {
         FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(FILENAME);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
	        out.writeObject(object);
	        out.close();
	        fileOut.close();
		} catch (Exception e) {
			System.out.println(e);
		}
         
	}
	
	public static BTMS deserialize() {
		BTMS btms = null;
        
        ObjectInputStream in;
		try {
			FileInputStream fileIn = new FileInputStream(FILENAME);
			in = new ObjectInputStream(fileIn);
			btms = (BTMS) in.readObject();
		    in.close();
		    fileIn.close();
		} catch (Exception e) {
		}
		
		return btms;
    	}
	 
}

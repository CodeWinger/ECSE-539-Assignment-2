package ca.mcgill.ecse539.btms.application;

import ca.mcgill.ecse539.btms.view.BtmsPage;

public class Btms {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// load model
		// TODO
		
		// start UI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BtmsPage().setVisible(true);
            }
        });
        
	}
}

package ca.mcgill.ecse539.btms.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import ca.mcgill.ecse539.btms.model.AfternoonRouteWorkShift;
import ca.mcgill.ecse539.btms.model.BTMS;
import ca.mcgill.ecse539.btms.model.Bus;
import ca.mcgill.ecse539.btms.model.Driver;
import ca.mcgill.ecse539.btms.model.DriverBusRouteTuple;
import ca.mcgill.ecse539.btms.model.MorningRouteWorkShift;
import ca.mcgill.ecse539.btms.model.NightRouteWorkShift;
import ca.mcgill.ecse539.btms.model.Route;
import ca.mcgill.ecse539.btms.model.RouteWorkShift;
import ca.mcgill.ecse539.btms.persistence.PersistenceObjectStream;
import ca.mcgill.ecse539.btms.persistence.PersistenceXStream;


public class BtmsPage extends JFrame {

	private static final long serialVersionUID = -4426310869335015542L;
	
	// UI elements
	private JLabel errorMessage;
	// driver
	private JTextField driverNameTextField;
	private JLabel driverNameLabel;
	private JButton addDriverButton;
	private JComboBox<String> driverList;
	private JLabel driverLabel;
	private JButton sickButton;
	private JComboBox<String> driverNotSickList;
	private JLabel driverNotSickLabel;
	// route
	private JTextField routeNumberTextField;
	private JLabel routeNumberLabel;
	private JButton addRouteButton;
	// bus
	private JTextField busLicencePlateTextField;
	private JLabel busLicencePlateLabel;
	private JButton addBusButton;
	private JComboBox<String> busRepairList;
	private JLabel busRepairLabel;
	private JButton repairButton;
	// bus assignment
	private JComboBox<String> busList;
	private JLabel busLabel;
	private JComboBox<String> routeList;
	private JLabel routeLabel;
	private JDatePickerImpl assignmentDatePicker;
	private JLabel assignmentDateLabel;
	private JButton assignButton;
	// shift assignment
	private JComboBox<String> shiftList;
	private JLabel shiftLabel;

	private JTable outputTable;
	private JPanel panel_1 = new JPanel();
	private DefaultTableModel dtm;
	// temporary elements
	private JLabel hint1;
	private JLabel hint2;
    private JTextArea sickDriverDisplay = new JTextArea();
    private JTextArea repairDisplay = new JTextArea();
	// data elements
	private String error = null;
	private Integer selectedBus = -1;
	//private HashMap<Integer, Bus> buses;
	private Integer selectedRoute = -1;
	//private HashMap<Integer, Route> routes;
	private Integer selectedDriver = -1;
	private Integer selectedSickDriver = -1;
	//private Integer UniqueDriverID = 1;
	//private HashMap<Integer, Driver> drivers;
	private Integer selectedRepairBus= -1;
	//private HashMap<Integer, Bus> drivers;
	private Integer selectedShift= 0;
	private JLabel sickLabel;
	private JLabel repairLabel;
	public BTMS btms; // = BTMS.getInstance();


	/** Creates new form EventRegistrationPage */
	public BtmsPage() {
		btms = PersistenceObjectStream.deserialize();
		if ( btms == null) {
			btms = BTMS.getInstance();
		}
		initComponents();
		refreshData();
	}

	/** This method is called from within the constructor to initialize the form.
	 */
	private void initComponents() {
		PersistenceXStream.saveToXMLwithXStream(btms);
		// elements for error message
		errorMessage = new JLabel();
		errorMessage.setForeground(Color.RED);
		
		// elements for driver
		driverNameTextField = new JTextField();
		driverNameLabel = new JLabel();
		addDriverButton = new JButton();
		String[] test = (String[]) btms.getDrivers().stream().map(d -> d.getName()).collect(Collectors.toList()).toArray(new String[0]);
		driverList = new JComboBox<String>(test);
		driverList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
		        JComboBox<String> cb = (JComboBox<String>) evt.getSource();
		        selectedDriver = cb.getSelectedIndex();
			}
		});
		ArrayList<String> temp = new ArrayList<String>();
		test = (String[]) btms.getDrivers().stream().map(d -> d.getName()).collect(Collectors.toList()).toArray(new String[0]);
		driverNotSickList = new JComboBox<String>(test);
		driverNotSickList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
		        JComboBox<String> cb = (JComboBox<String>) evt.getSource();
		        selectedSickDriver = cb.getSelectedIndex();
			}
		});
		driverLabel = new JLabel();
		sickButton = new JButton();
		
		// elements for route
		routeNumberTextField = new JTextField();
		routeNumberLabel = new JLabel();
		addRouteButton = new JButton();
		
		// elements for bus
		busLicencePlateTextField = new JTextField();
		busLicencePlateLabel = new JLabel();
		addBusButton = new JButton();
		test = (String[]) btms.getBuses().stream().map(d -> d.getLicensePlate()).collect(Collectors.toList()).toArray(new String[0]);
		busRepairList = new JComboBox<String>(test);
		busRepairList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
		        JComboBox<String> cb = (JComboBox<String>) evt.getSource();
		        selectedRepairBus = cb.getSelectedIndex();
			}
		});
		busRepairLabel = new JLabel();
		repairButton = new JButton();
		
		// elements for bus assignment
		test = (String[]) btms.getBuses().stream().map(d -> d.getLicensePlate()).collect(Collectors.toList()).toArray(new String[0]);
		busList = new JComboBox<String>(test);
		busList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
		        JComboBox<String> cb = (JComboBox<String>) evt.getSource();
		        selectedBus = cb.getSelectedIndex();
			}
		});
		busLabel = new JLabel();
		test = (String[]) btms.getRoutes().stream().map(d -> new Integer(d.getRouteNumber()).toString()).collect(Collectors.toList()).toArray(new String[0]);
		routeList = new JComboBox<String>(test);
		routeList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
		        JComboBox<String> cb = (JComboBox<String>) evt.getSource();
		        selectedRoute = cb.getSelectedIndex();
			}
		});
		
		shiftLabel = new JLabel();
		String[] shift = {"Morning", "Afternoon", "Night" };
		shiftList = new JComboBox<String>(shift);
		shiftList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
		        JComboBox<String> cb = (JComboBox<String>) evt.getSource();
		        selectedShift = cb.getSelectedIndex();
			}
		});
		routeLabel = new JLabel();
		
		SqlDateModel model = new SqlDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		assignmentDatePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		assignmentDateLabel = new JLabel();

		assignButton = new JButton();
		
		// temporary elements
		hint1 = new JLabel();
		hint2 = new JLabel();
		driverNotSickLabel = new JLabel();
		sickLabel = new JLabel();
		repairLabel = new JLabel();
		// global settings and listeners
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Bus Transportation Management System");

		driverNameLabel.setText("Name:");
		addDriverButton.setText("Add Driver");
		addDriverButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addDriverButtonActionPerformed(evt);
			}
		});
		sickButton.setText("Toggle Sick");
		sickButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sickButtonActionPerformed(evt);
			}
		});
		
		driverNotSickLabel.setText("Assign Sick Driver:");
		
		routeNumberLabel.setText("Number:");
		addRouteButton.setText("Add Route");
		addRouteButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addRouteButtonActionPerformed(evt);
			}
		});

		busLicencePlateLabel.setText("Licence Plate:");
		addBusButton.setText("Add Bus");
		addBusButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addBusButtonActionPerformed(evt);
			}
		});
		busRepairLabel.setText("Select Bus:");
		repairButton.setText("Toggle Repair");
		repairButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				repairButtonActionPerformed(evt);
			}
		});
		
		busLabel.setText("Select Bus:");
		shiftLabel.setText("Select Shift:");
		routeLabel.setText("Select Route:");
		driverLabel.setText("Select Driver:");
		driverNotSickLabel.setText("Select Driver:");
		assignmentDateLabel.setText("Date:");
		assignButton.setText("Assign");
		assignButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				assignButtonActionPerformed(evt);
			}
		});
		
		

		hint2.setText("Daily Overview for the next Three Days");
		sickLabel.setText("Drivers Sick");
		repairLabel.setText("Buses in Repair");
		outputTable = new JTable();
		dtm = new DefaultTableModel(0, 0);
		// add header of the table
		String header[] = new String[] { "Route", "Date", "Shift", "Bus License Number", "Driver Name", "Driver ID"};

		
		JScrollPane js=new JScrollPane(outputTable);
		js.setVisible(true);
		add(js);
		// add header in table model     
		dtm.setColumnIdentifiers(header);
		//set model into the table object
	    outputTable.setDefaultRenderer(String.class, new MyRenderer());
		outputTable.setModel(dtm);
	    panel_1.setLayout(new BorderLayout());
	    panel_1.add(outputTable.getTableHeader(), BorderLayout.NORTH);
	    panel_1.add(outputTable, BorderLayout.CENTER);


		// horizontal line elements
		JSeparator horizontalLineTop = new JSeparator();
		JSeparator horizontalLineMiddle1 = new JSeparator();
		JSeparator horizontalLineMiddle2 = new JSeparator();
		JSeparator horizontalLineBottom = new JSeparator();

		// layout
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(
				layout.createParallelGroup()
				.addComponent(errorMessage)
				.addComponent(horizontalLineTop)
				.addComponent(horizontalLineMiddle1)
				.addComponent(horizontalLineBottom)
				.addComponent(hint2)
				.addComponent(panel_1)
				.addComponent(sickLabel)
				.addComponent(sickDriverDisplay)
				.addComponent(repairLabel)
				.addComponent(repairDisplay)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup()
								.addComponent(driverNameLabel)
								.addComponent(driverLabel)
								.addComponent(busLabel)
								.addComponent(driverNotSickLabel)
						        )
						.addGroup(layout.createParallelGroup()
								.addComponent(driverNameTextField, 200, 200, 400)
								.addComponent(addDriverButton)
								.addComponent(driverList)
								.addComponent(sickButton)
								.addComponent(busList)
								.addComponent(driverNotSickList)
						        )
						.addGroup(layout.createParallelGroup()
								.addComponent(routeNumberLabel)
								.addComponent(busRepairLabel)
								.addComponent(routeLabel)
								.addComponent(shiftLabel))
						.addGroup(layout.createParallelGroup()
								.addComponent(routeNumberTextField, 200, 200, 400)
								.addComponent(addRouteButton)
								.addComponent(busRepairList)
								.addComponent(repairButton)
								.addComponent(routeList)
								.addComponent(shiftList))
						.addGroup(layout.createParallelGroup()
								.addComponent(busLicencePlateLabel)
								.addComponent(assignmentDateLabel)
								)
						.addGroup(layout.createParallelGroup()
								.addComponent(busLicencePlateTextField, 200, 200, 400)
								.addComponent(addBusButton)
								.addComponent(assignmentDatePicker)
								.addComponent(assignButton)))
				);

		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {assignButton, assignmentDatePicker});
		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {sickButton, driverNameTextField});
		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {repairButton, routeNumberTextField});
		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {addDriverButton, driverNameTextField});
		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {addRouteButton, routeNumberTextField});
		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {addBusButton, busLicencePlateTextField});
		
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addComponent(errorMessage)
				.addGroup(layout.createParallelGroup()
						.addComponent(driverNameLabel)
						.addComponent(driverNameTextField)
						.addComponent(routeNumberLabel)
						.addComponent(routeNumberTextField)
						.addComponent(busLicencePlateLabel)
						.addComponent(busLicencePlateTextField))		
				.addGroup(layout.createParallelGroup()
						.addComponent(addDriverButton)
						.addComponent(addRouteButton)
						.addComponent(addBusButton))
				.addGroup(layout.createParallelGroup()
						.addComponent(horizontalLineTop))
				.addGroup(layout.createParallelGroup()
						.addComponent(driverLabel)
						.addComponent(driverList)
						.addComponent(busRepairLabel)
						.addComponent(busRepairList))
				.addGroup(layout.createParallelGroup()
						.addComponent(sickButton)
						.addComponent(repairButton))
				.addGroup(layout.createParallelGroup()
						.addComponent(horizontalLineMiddle1))
				.addGroup(layout.createParallelGroup()
						.addComponent(busLabel)
						.addComponent(busList)
						.addComponent(routeLabel)
						.addComponent(routeList)
						.addComponent(assignmentDateLabel)
						.addComponent(assignmentDatePicker))
				.addGroup(layout.createParallelGroup()
						.addComponent(driverNotSickLabel)
						.addComponent(driverNotSickList)
				        .addComponent(shiftLabel)
				        .addComponent(shiftList)
				    	.addComponent(assignButton))
				.addGroup(layout.createParallelGroup()
						.addComponent(horizontalLineBottom))
				.addGroup(layout.createParallelGroup()
						.addComponent(hint2))
				.addGroup(layout.createParallelGroup()
						.addComponent(panel_1))
				.addGroup(layout.createParallelGroup()
						.addComponent(sickLabel))
				.addGroup(layout.createParallelGroup()
						.addComponent(sickDriverDisplay))
				.addGroup(layout.createParallelGroup()
						.addComponent(repairLabel))
				.addGroup(layout.createParallelGroup()
						.addComponent(repairDisplay)));
		
		pack();

	}

	private void refreshData() {
		// TODO: complete this method
		// error
		errorMessage.setText(error);
		if (error == null || error.length() == 0) {
			sickDriversHighlight();
			busInRepairHighlight();
			displayData();
		}
		// this is needed because the size of the window changes depending on whether an error message is shown or not
		pack();
	}

	private void addDriverButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// call the controller
		error = "";
		// TODO
		if(!driverNameTextField.getText().equals("") && (((DefaultComboBoxModel) driverList.getModel()).getIndexOf(driverNameTextField.getText()) == -1))
		{
	        driverList.addItem(driverNameTextField.getText()); 
	        driverNotSickList.addItem(driverNameTextField.getText()); 
	        btms.addDriver(driverNameTextField.getText());
	        PersistenceObjectStream.serialize(btms);
			//PersistenceXStream.saveToXMLwithXStream(btms); 
		}
		else{
			error += "Driver already in the Database! ";
		}

		// update visuals
		refreshData();
	}
	
	private void sickButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// call the controller
		String name = driverList.getItemAt(selectedDriver);
		error = "";
		if (selectedDriver < 0)
			error += error + " Driver needs to be selected to toggle sick status! ";
		error = error.trim();
		if (error.length() == 0) {
			// call the controller
			for(Driver i: btms.getDrivers()){
				if(i.getName().equals(name)&& i.getWorkStatusFullName().contentEquals("CAN_WORK")){
			        if(!i.driverStrickenWithIllness()){
			        	error += "Error adding a sick driver!"; 
			        }
				}
				else if(i.getName().equals(name)&& i.getWorkStatusFullName().contentEquals("SICK")){
			        if(!i.driverFeelsBetter()){
			        	error += "Error adding a sick driver!"; 
			        }
				}
			}
			//driverList.removeItemAt(selectedDriver);
			// TODO
			PersistenceObjectStream.serialize(btms);
		}
		refreshData();
	}

	private void addRouteButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// call the controller
		error = "";
		// TODO
		if((((DefaultComboBoxModel) routeList.getModel()).getIndexOf(routeNumberTextField.getText()) == -1)&&(!routeNumberTextField.getText().equals("")))
		{
		  routeList.addItem(routeNumberTextField.getText());
		  btms.addRoute(Integer.parseInt(routeNumberTextField.getText()));
		  PersistenceObjectStream.serialize(btms);
		}
		else
		{
			error += "Route already in the Database! ";
		}
		// update visuals
		refreshData();
	}
	
	private void addBusButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// call the controller
		error = null;
		// TODO
		if((((DefaultComboBoxModel) busList.getModel()).getIndexOf(busLicencePlateTextField.getText()) == -1)&&(!busLicencePlateTextField.getText().equals("")))
		{
			busList.addItem(busLicencePlateTextField.getText());
			busRepairList.addItem(busLicencePlateTextField.getText());
			btms.addBus(busLicencePlateTextField.getText());
			PersistenceObjectStream.serialize(btms);
		}
		else
		{
			error = "Bus already in the Database! ";
		}
		// update visuals
		refreshData();
	}
	
	private void repairButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// call the controller
		String license = busList.getItemAt(selectedRepairBus);
		error = "";
		if (selectedRepairBus < 0)
			error = error + "Bus needs to be selected to toggle repair status! ";
		error = error.trim();
		if (error.length() == 0) {
			// call the controller
			for(Bus i: btms.getBuses()){
				if(i.getLicensePlate().equals(license) && i.getBusStatusFullName().equals("FUNCTIONNAL")){
			        if(!i.busBreaksDown()){
			        	error += "Error in adding a bus to sick list!"; 
			        }
				}
				else if(i.getLicensePlate().equals(license) && i.getBusStatusFullName().equals("IN_REPAIR")){
					if(!i.busRepaired()){
			        	error += "Error in adding a bus to sick list!"; 
			        }
				}
			}
			PersistenceObjectStream.serialize(btms);
			//busList.removeItemAt(selectedRepairBus);
			// TOOD
		}
		refreshData();
	}

	private void assignButtonActionPerformed(java.awt.event.ActionEvent evt) {
		error = "";
		boolean rwsAlreadyAssigned = false; 
		Date selectedDate = (Date) assignmentDatePicker.getModel().getValue();
		Date todaysDate = new Date();
		long diff = selectedDate.getTime() - todaysDate.getTime();
		//error += diff;
        if(((diff/ 1000 / 60 / 60 / 24) > 2) )
        {
        	error += "Date more than 3 days away! ";
        }
        else if(diff < 0)
        {
        	error += "Date cannot be before or todays date! ";
        }
//		if (selectedBus < 0)
//			error = error + "Bus needs to be selected for assignment! ";
//		if (selectedRoute < 0)
//			error = error + "Route needs to be selected for assignment!";
		if(!btms.hasDrivers()) error += "Need to have drivers to assign!";
		java.sql.Date dateSelected = (java.sql.Date) selectedDate;
		//Check if rws exists already
		error = error.trim();
		
		//Find route from route list
		Route routeToBeAssigned = null;
		int routeNumToBeAssigned = Integer.parseInt(routeList.getSelectedItem().toString());
		for( Route i : btms.getRoutes()){
			if (i.getRouteNumber() == routeNumToBeAssigned){
				routeToBeAssigned = i;
			}
		}
		//Find bus from bus list
		Bus temp = null;
		String licensePlate = busList.getSelectedItem().toString();
		for( Bus i : btms.getBuses()){
			if (i.getLicensePlate().equals(licensePlate)){
				temp = i;
			}
		}
		final Bus busToBeAssigned = temp;
		
		//Find bus from bus list
		Driver driverToBeAssigned = null;
		String driverId = driverNotSickList.getSelectedItem().toString();
		for( Driver i : btms.getDrivers()){
			if (i.getName().equals(driverId)){
				driverToBeAssigned = i;
			}
		}
		//System.out.println("" + routeToBeAssigned + "/n" + busToBeAssigned + "/n" + driverToBeAssigned );

		//All inputs good to go so far
		if (error.length() == 0) {	
			// call the controller
			//Check what type of Route Work Shift to create
			String shiftType = shiftList.getItemAt(selectedShift);
			
			if(shiftType.equals("Morning")){
				MorningRouteWorkShift rws = null;
				try{
					rws = new MorningRouteWorkShift(dateSelected, btms);
					btms.addMorningRouteWorkShift(rws);
				}
				catch(Exception e){
                    //Item already exists.
					for(MorningRouteWorkShift i : btms.getMorningRouteWorkShifts()){
						if(i.getWorkDate().equals(selectedDate)){
							rws = i;
						}
					}
				}  
						
				if(!rws.getDriverBusRouteTuples().stream().map(t -> t.getBus()).anyMatch(b -> b.equals(busToBeAssigned)) && !busToBeAssigned.getBusStatusFullName().equals("IN_REPAIR")){
					if(!driverToBeAssigned.getWorkStatusFullName().contentEquals("SICK")){
						try{
							rws.addDriverBusRouteTuple(driverToBeAssigned, busToBeAssigned, routeToBeAssigned, btms);
						}
						catch(Exception e){
							error += "Cannot assign one bus to more than one route on the same day! ";
						}
						
					}
					else{
						error += "Cannot Assign a sick driver!";
					}
				    
				}
				else if(!rws.getDriverBusRouteTuples().stream().map(t -> t.getBus()).anyMatch(b -> b.equals(busToBeAssigned)) && busToBeAssigned.getBusStatusFullName().equals("IN_REPAIR")){
					error += "Cannot Assign a broken bus!";
				}
				else{
					error += "Shift and bus for this date already assigned!";
				}
				/* At this point a route has a bus and a shift for a day */
				//Time to add drivers
			}
			else if(shiftType.equals("Afternoon")){
				AfternoonRouteWorkShift rws = null;
				try{
					rws = new AfternoonRouteWorkShift(dateSelected, btms);
					btms.addAfternoonRouteWorkShift(rws);
				}
				catch(Exception e){
                    //Item already exists.
					for(AfternoonRouteWorkShift i : btms.getAfternoonRouteWorkShifts()){
						if(i.getWorkDate().equals(selectedDate)){
							rws = i;
						}
					}
				}  
						
				if(!rws.getDriverBusRouteTuples().stream().map(t -> t.getBus()).anyMatch(b -> b.equals(busToBeAssigned))&& !busToBeAssigned.getBusStatusFullName().equals("IN_REPAIR")){
					if(!driverToBeAssigned.getWorkStatusFullName().contentEquals("SICK")){
						try{
							rws.addDriverBusRouteTuple(driverToBeAssigned, busToBeAssigned, routeToBeAssigned, btms);
						}
						catch(Exception e){
							error += "Cannot assign one bus to more than one route on the same day! ";
						}
					}
					else{
						error += "Cannot Assign a sick driver!";
					}
				    
				}
				else if(!rws.getDriverBusRouteTuples().stream().map(t -> t.getBus()).anyMatch(b -> b.equals(busToBeAssigned)) && busToBeAssigned.getBusStatusFullName().equals("IN_REPAIR")){
					error += "Cannot Assign a broken bus!";
				}
				else{
					error += "Shift and bus for this date already assigned!";
				}
			}
			else{
				
				NightRouteWorkShift rws = null;
				try{
					rws = new NightRouteWorkShift(dateSelected, btms);
					btms.addNightRouteWorkShift(rws);
				}
				catch(Exception e){
                    //Item already exists.
					for(NightRouteWorkShift i : btms.getNightRouteWorkShifts()){
						if(i.getWorkDate().equals(selectedDate)){
							rws = i;
						}
					}
				}  
				if(!rws.getDriverBusRouteTuples().stream().map(t -> t.getBus()).anyMatch(b -> b.equals(busToBeAssigned)) && !busToBeAssigned.getBusStatusFullName().equals("IN_REPAIR")){
					if(!driverToBeAssigned.getWorkStatusFullName().contentEquals("SICK")){
						try{
							rws.addDriverBusRouteTuple(driverToBeAssigned, busToBeAssigned, routeToBeAssigned, btms);
						}
						catch(Exception e){
							error += "Cannot assign one bus to more than one route on the same day! ";
						}
					}
					else{
						error += "Cannot Assign a sick driver!";
					}
				    
				}
				else if(!rws.getDriverBusRouteTuples().stream().map(t -> t.getBus()).anyMatch(b -> b.equals(busToBeAssigned)) && busToBeAssigned.getBusStatusFullName().equals("IN_REPAIR")){
					error += "Cannot Assign a broken bus!";
				}
				else{
					error += "Shift and bus for this date already assigned!";
				}
			}
			
			
			
			//Ready To display
			if(error.length()== 0)
			{
				PersistenceObjectStream.serialize(btms);
				refreshData();
			}			
			
		}		
			// TOOD	
		// update visuals
		
		refreshData();			
	}
	
	private void displayData(){
		
		    dtm = new DefaultTableModel(0, 0);
			// add header of the table
			String header[] = new String[] { "Route", "Date", "Shift", "Bus License Number", "Driver Name", "Driver ID"};
			dtm.setColumnIdentifiers(header);
			//set model into the table object
			
			outputTable.setModel(dtm);

			
			for(MorningRouteWorkShift i : btms.getMorningRouteWorkShifts()){
				for(DriverBusRouteTuple j : i.getDriverBusRouteTuples()){
						String routeNumber = "" + j.getRoute().getRouteNumber();
						String date = "" + i.getWorkDate();
						String shift = "" + i.getShiftName();
						String busLicense = "" + j.getBus().getLicensePlate();
						String driverName = "" + j.getDriver().getName();
						String driverIdNum = "" + j.getDriver().getId();
						dtm.addRow(new Object[] {routeNumber, date, shift,busLicense, driverName, driverIdNum});
				}
			}		
			for(AfternoonRouteWorkShift i : btms.getAfternoonRouteWorkShifts()){
				for(DriverBusRouteTuple j : i.getDriverBusRouteTuples()){
						String routeNumber = "" + j.getRoute().getRouteNumber();
						String date = "" + i.getWorkDate();
						String shift = "" + i.getShiftName();
						String busLicense = "" + j.getBus().getLicensePlate();
						String driverName = "" + j.getDriver().getName();
						String driverIdNum = "" + j.getDriver().getId();
						dtm.addRow(new Object[] {routeNumber, date, shift,busLicense, driverName, driverIdNum});
				}
			}
			for(NightRouteWorkShift i : btms.getNightRouteWorkShifts()){
				for(DriverBusRouteTuple j : i.getDriverBusRouteTuples()){
						String routeNumber = "" + j.getRoute().getRouteNumber();
						String date = "" + i.getWorkDate();
						String shift = "" + i.getShiftName();
						String busLicense = "" + j.getBus().getLicensePlate();
						String driverName = "" + j.getDriver().getName();
						String driverIdNum = "" + j.getDriver().getId();
						dtm.addRow(new Object[] {routeNumber, date, shift,busLicense, driverName, driverIdNum});
				}
			}
					

			
			//outputTable.setModel(dtm);
			pack();
	}
	
	private void sickDriversHighlight(){
		String sickList = "Name:\t" + "ID Number:";
		for(Driver i : btms.getDrivers()){
			if(i.getWorkStatusFullName().equals("SICK")){
				sickList += "\n"+i.getName() + "\t" + i.getId();
			}
		}
		sickDriverDisplay.setText(sickList);

	}
	
	private void busInRepairHighlight(){
		String repairList = "License Number:";
		for(Bus i : btms.getBuses()){
			if(i.getBusStatusFullName().equals("IN_REPAIR")){
				repairList += "\n"+ i.getLicensePlate();
			}
		}
		repairDisplay.setText(repairList);

	}
	
	
	
//	private boolean isInAnotherRouteOnSameDay(java.sql.Date Date, Bus bus, String shift, Route route ){
//		if(shift.equals("Morning")){
//			for (NightRouteWorkShift rws : btms.getNightRouteWorkShifts()){
//				if(rws.getWorkDate().equals(Date) && (rws.getBuses().contains(bus))){
//					 return true;
//				}	
//			}
//			for (AfternoonRouteWorkShift rws : btms.getAfternoonRouteWorkShifts()){
//				if(rws.getWorkDate().equals(Date) && (rws.getBuses().contains(bus))){
//					 return true;
//				}
//			}
//		}
//		else if(shift.equals("Afternoon")){
//			for (NightRouteWorkShift rws : btms.getNightRouteWorkShifts()){
//				if(rws.getWorkDate().equals(Date) && (rws.getBuses().contains(bus))){
//					 return true;
//				}	
//			}
//			for (MorningRouteWorkShift rws : btms.getMorningRouteWorkShifts()){
//				if(rws.getWorkDate().equals(Date) && (rws.getBuses().contains(bus))){
//					 return true;
//				}
//			}
//		}
//		else{
//			for (AfternoonRouteWorkShift rws : btms.getAfternoonRouteWorkShifts()){
//				if(rws.getWorkDate().equals(Date) && (rws.getBuses().contains(bus))){
//					 return true;
//				}	
//			}
//			for (MorningRouteWorkShift rws : btms.getMorningRouteWorkShifts()){
//				if(rws.getWorkDate().equals(Date) && (rws.getBuses().contains(bus))){
//					 return true;
//				}
//			}
//		}
//
//		return false;
//	}
	

	private void debugPrint(){

		
		System.out.println("***********************NEW ASSIGNMENT*******************************");
		
		System.out.println();
		System.out.println("Buses in repair - ");
		for(Bus i : btms.getBuses()){
			if(i.getBusStatusFullName().equals("IN_REPAIR"))
			System.out.println(i.getLicensePlate());
		}
		System.out.println();
		System.out.println("Sick Drivers - ");
		for(Driver i : btms.getDrivers()){
			if(i.getWorkStatusFullName().equals("SICK"))
			System.out.println(i.getId());
		}
		
		for(MorningRouteWorkShift i : btms.getMorningRouteWorkShifts()){

			System.out.println(i);
			
		}
		for(AfternoonRouteWorkShift i : btms.getAfternoonRouteWorkShifts()){
			System.out.println(i);
			
		}
		for(NightRouteWorkShift i : btms.getNightRouteWorkShifts()){
			System.out.println(i);	
		}

	}
}

package ca.mcgill.ecse539.btms.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import ca.mcgill.ecse539.btms.model.BTMS;
import ca.mcgill.ecse539.btms.model.Bus;
import ca.mcgill.ecse539.btms.model.Driver;


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

	// data elements
	private String error = null;
	private Integer selectedBus = -1;
	//private HashMap<Integer, Bus> buses;
	private Integer selectedRoute = -1;
	//private HashMap<Integer, Route> routes;
	private Integer selectedDriver = -1;
	//private Integer UniqueDriverID = 1;
	//private HashMap<Integer, Driver> drivers;
	private Integer selectedRepairBus= -1;
	//private HashMap<Integer, Bus> drivers;
	private Integer selectedShift= -1;
	public BTMS btms = BTMS.getInstance();
	/** Creates new form EventRegistrationPage */
	public BtmsPage() {
		initComponents();
		refreshData();
	}

	/** This method is called from within the constructor to initialize the form.
	 */
	private void initComponents() {
		// elements for error message
		errorMessage = new JLabel();
		errorMessage.setForeground(Color.RED);
		
		// elements for driver
		driverNameTextField = new JTextField();
		driverNameLabel = new JLabel();
		addDriverButton = new JButton();
		driverList = new JComboBox<String>(new String[0]);
		driverList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
		        JComboBox<String> cb = (JComboBox<String>) evt.getSource();
		        selectedDriver = cb.getSelectedIndex();
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
		busRepairList = new JComboBox<String>(new String[0]);
		busRepairList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
		        JComboBox<String> cb = (JComboBox<String>) evt.getSource();
		        selectedRepairBus = cb.getSelectedIndex();
			}
		});
		busRepairLabel = new JLabel();
		repairButton = new JButton();
		
		// elements for bus assignment
		busList = new JComboBox<String>(new String[0]);
		busList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
		        JComboBox<String> cb = (JComboBox<String>) evt.getSource();
		        selectedBus = cb.getSelectedIndex();
			}
		});
		busLabel = new JLabel();
		routeList = new JComboBox<String>(new String[0]);
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
		driverLabel.setText("Select Driver:");
		sickButton.setText("Toggle Sick");
		sickButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sickButtonActionPerformed(evt);
			}
		});
		
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
		assignmentDateLabel.setText("Date:");
		assignButton.setText("Assign");
		assignButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				assignButtonActionPerformed(evt);
			}
		});
		
		

		hint1.setText("Hint: add scheduling of drivers here...");
		hint2.setText("Hint: add daily overview here...");
		
		//Added output table 
		outputTable = new JTable();
		dtm = new DefaultTableModel(0, 0);
		// add header of the table
		String header[] = new String[] { "Driver", "Date", "Shift", "Bus", "Route"};

		
		JScrollPane js=new JScrollPane(outputTable);
		js.setVisible(true);
		add(js);
		// add header in table model     
		 dtm.setColumnIdentifiers(header);
		 dtm.addRow(new Object[] { "Driver", "Date", "Shift", "Bus", "Route"});
		//set model into the table object
		 outputTable.setModel(dtm);
	     panel_1.setLayout(new BorderLayout());
	     panel_1.add(js, BorderLayout.CENTER);
		
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
				.addComponent(horizontalLineMiddle2)
				.addComponent(horizontalLineBottom)
				.addComponent(hint1)
				.addComponent(hint2)
				.addComponent(outputTable)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup()
								.addComponent(driverNameLabel)
								.addComponent(driverLabel)
								.addComponent(busLabel)
						        )
						.addGroup(layout.createParallelGroup()
								.addComponent(driverNameTextField, 200, 200, 400)
								.addComponent(addDriverButton)
								.addComponent(driverList)
								.addComponent(sickButton)
								.addComponent(busList)
						        )
						.addGroup(layout.createParallelGroup()
								.addComponent(routeNumberLabel)
								.addComponent(busRepairLabel)
								.addComponent(routeLabel))
						.addGroup(layout.createParallelGroup()
								.addComponent(routeNumberTextField, 200, 200, 400)
								.addComponent(addRouteButton)
								.addComponent(busRepairList)
								.addComponent(repairButton)
								.addComponent(routeList))
						.addGroup(layout.createParallelGroup()
								.addComponent(busLicencePlateLabel)
								.addComponent(assignmentDateLabel)
								.addComponent(shiftLabel))
						.addGroup(layout.createParallelGroup()
								.addComponent(busLicencePlateTextField, 200, 200, 400)
								.addComponent(addBusButton)
								.addComponent(shiftList)
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
						.addComponent(busRepairList)
						.addComponent(shiftLabel)
						.addComponent(shiftList))
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
				.addComponent(assignButton)
				.addGroup(layout.createParallelGroup())
				.addGroup(layout.createParallelGroup()
						.addComponent(horizontalLineMiddle2))
				.addGroup(layout.createParallelGroup()
						.addComponent(hint1))
				.addGroup(layout.createParallelGroup()
						.addComponent(horizontalLineBottom))
				.addGroup(layout.createParallelGroup()
						.addComponent(hint2))
				.addGroup(layout.createParallelGroup()
						.addComponent(outputTable))
				);
		
		pack();
		
	}

	private void refreshData() {
		// TODO: complete this method
		// error
		errorMessage.setText(error);
		if (error == null || error.length() == 0) {
			// TODO
		}
		// this is needed because the size of the window changes depending on whether an error message is shown or not
		pack();
	}

	private void addDriverButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// call the controller
		error = "";
		// TODO
		if(((DefaultComboBoxModel) driverList.getModel()).getIndexOf(driverNameTextField.getText()) == -1)
		{
          driverList.addItem(driverNameTextField.getText()); 
          btms.addDriver(driverNameTextField.getText());
		}
		else
		{
			error += " Driver already in the Database!";
		}
		// update visuals
		refreshData();
	}
	
	private void sickButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// call the controller
		error = "";
		if (selectedDriver < 0)
			error += error + " Driver needs to be selected to toggle sick status! ";
		error = error.trim();
		if (error.length() == 0) {
			// call the controller
			driverList.removeItemAt(selectedDriver);
			// TODO
		}
		refreshData();
	}

	private void addRouteButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// call the controller
		error = "";
		// TODO
		if(((DefaultComboBoxModel) routeList.getModel()).getIndexOf(routeNumberTextField.getText()) == -1)
		{
		  routeList.addItem(routeNumberTextField.getText());
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
		if(((DefaultComboBoxModel) busList.getModel()).getIndexOf(busLicencePlateTextField.getText()) == -1)
		{
			busList.addItem(busLicencePlateTextField.getText());
			busRepairList.addItem(busLicencePlateTextField.getText());
			btms.addBus(busLicencePlateTextField.getText());
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
		error = "";
		if (selectedRepairBus < 0)
			error = error + "Bus needs to be selected to toggle repair status! ";
		error = error.trim();
		if (error.length() == 0) {
			// call the controller
			busList.removeItemAt(selectedRepairBus);
			// TOOD
		}
		refreshData();
	}

	private void assignButtonActionPerformed(java.awt.event.ActionEvent evt) {
		error = "";
		Date selectedDate = (Date) assignmentDatePicker.getModel().getValue();
		Date todaysDate = new Date();
		long diff = selectedDate.getTime() - todaysDate.getTime();
		error += diff;
        if(((diff/ 1000 / 60 / 60 / 24) > 2) )
        {
        	error += "Date more than 3 days away! ";
        }
        else if(diff < 0)
        {
        	error += "Date cannot be before todays date! ";
        }
		if (selectedBus < 0)
			error = error + "Bus needs to be selected for assignment! ";
		if (selectedRoute < 0)
			error = error + "Route needs to be selected for assignment!";
		error = error.trim();
		
		if (error.length() == 0) {
			// call the controller
			//JUST A TEST
			for (int count = 1; count <= 30; count++) {
			       dtm.addRow(new Object[] { "data", "data", "data",
			                "data", "data"});
			} 
			// TOOD
		}
		// update visuals
		
		refreshData();			
	}

}

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.util.*;

// line 69 "../../../../../model.ump"
public class Driver
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextId = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Driver Attributes
  private String name;

  //Autounique Attributes
  private int id;

  //Driver State Machines
  enum WorkStatus { CAN_WORK, SICK }
  private WorkStatus workStatus;

  //Driver Associations
  private BTMS bTMS;
  private List<DriverBusRouteTuple> driverBusRouteTuples;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Driver(String aName, BTMS aBTMS)
  {
    name = aName;
    id = nextId++;
    boolean didAddBTMS = setBTMS(aBTMS);
    if (!didAddBTMS)
    {
      throw new RuntimeException("Unable to create driver due to bTMS");
    }
    driverBusRouteTuples = new ArrayList<DriverBusRouteTuple>();
    setWorkStatus(WorkStatus.CAN_WORK);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getName()
  {
    return name;
  }

  public int getId()
  {
    return id;
  }

  public String getWorkStatusFullName()
  {
    String answer = workStatus.toString();
    return answer;
  }

  public WorkStatus getWorkStatus()
  {
    return workStatus;
  }

  public boolean driverStrickenWithIllness()
  {
    boolean wasEventProcessed = false;
    
    WorkStatus aWorkStatus = workStatus;
    switch (aWorkStatus)
    {
      case CAN_WORK:
        setWorkStatus(WorkStatus.SICK);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean driverFeelsBetter()
  {
    boolean wasEventProcessed = false;
    
    WorkStatus aWorkStatus = workStatus;
    switch (aWorkStatus)
    {
      case SICK:
        setWorkStatus(WorkStatus.CAN_WORK);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setWorkStatus(WorkStatus aWorkStatus)
  {
    workStatus = aWorkStatus;
  }

  public BTMS getBTMS()
  {
    return bTMS;
  }

  public DriverBusRouteTuple getDriverBusRouteTuple(int index)
  {
    DriverBusRouteTuple aDriverBusRouteTuple = driverBusRouteTuples.get(index);
    return aDriverBusRouteTuple;
  }

  public List<DriverBusRouteTuple> getDriverBusRouteTuples()
  {
    List<DriverBusRouteTuple> newDriverBusRouteTuples = Collections.unmodifiableList(driverBusRouteTuples);
    return newDriverBusRouteTuples;
  }

  public int numberOfDriverBusRouteTuples()
  {
    int number = driverBusRouteTuples.size();
    return number;
  }

  public boolean hasDriverBusRouteTuples()
  {
    boolean has = driverBusRouteTuples.size() > 0;
    return has;
  }

  public int indexOfDriverBusRouteTuple(DriverBusRouteTuple aDriverBusRouteTuple)
  {
    int index = driverBusRouteTuples.indexOf(aDriverBusRouteTuple);
    return index;
  }

  public boolean setBTMS(BTMS aBTMS)
  {
    boolean wasSet = false;
    if (aBTMS == null)
    {
      return wasSet;
    }

    BTMS existingBTMS = bTMS;
    bTMS = aBTMS;
    if (existingBTMS != null && !existingBTMS.equals(aBTMS))
    {
      existingBTMS.removeDriver(this);
    }
    bTMS.addDriver(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfDriverBusRouteTuples()
  {
    return 0;
  }

  public DriverBusRouteTuple addDriverBusRouteTuple(Bus aBus, Route aRoute, RouteWorkShift aRouteWorkShift)
  {
    return new DriverBusRouteTuple(this, aBus, aRoute, aRouteWorkShift);
  }

  public boolean addDriverBusRouteTuple(DriverBusRouteTuple aDriverBusRouteTuple)
  {
    boolean wasAdded = false;
    if (driverBusRouteTuples.contains(aDriverBusRouteTuple)) { return false; }
    Driver existingDriver = aDriverBusRouteTuple.getDriver();
    boolean isNewDriver = existingDriver != null && !this.equals(existingDriver);
    if (isNewDriver)
    {
      aDriverBusRouteTuple.setDriver(this);
    }
    else
    {
      driverBusRouteTuples.add(aDriverBusRouteTuple);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDriverBusRouteTuple(DriverBusRouteTuple aDriverBusRouteTuple)
  {
    boolean wasRemoved = false;
    //Unable to remove aDriverBusRouteTuple, as it must always have a driver
    if (!this.equals(aDriverBusRouteTuple.getDriver()))
    {
      driverBusRouteTuples.remove(aDriverBusRouteTuple);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addDriverBusRouteTupleAt(DriverBusRouteTuple aDriverBusRouteTuple, int index)
  {  
    boolean wasAdded = false;
    if(addDriverBusRouteTuple(aDriverBusRouteTuple))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDriverBusRouteTuples()) { index = numberOfDriverBusRouteTuples() - 1; }
      driverBusRouteTuples.remove(aDriverBusRouteTuple);
      driverBusRouteTuples.add(index, aDriverBusRouteTuple);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDriverBusRouteTupleAt(DriverBusRouteTuple aDriverBusRouteTuple, int index)
  {
    boolean wasAdded = false;
    if(driverBusRouteTuples.contains(aDriverBusRouteTuple))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDriverBusRouteTuples()) { index = numberOfDriverBusRouteTuples() - 1; }
      driverBusRouteTuples.remove(aDriverBusRouteTuple);
      driverBusRouteTuples.add(index, aDriverBusRouteTuple);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDriverBusRouteTupleAt(aDriverBusRouteTuple, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    BTMS placeholderBTMS = bTMS;
    this.bTMS = null;
    placeholderBTMS.removeDriver(this);
    for(int i=driverBusRouteTuples.size(); i > 0; i--)
    {
      DriverBusRouteTuple aDriverBusRouteTuple = driverBusRouteTuples.get(i - 1);
      aDriverBusRouteTuple.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "bTMS = "+(getBTMS()!=null?Integer.toHexString(System.identityHashCode(getBTMS())):"null")
     + outputString;
  }
}
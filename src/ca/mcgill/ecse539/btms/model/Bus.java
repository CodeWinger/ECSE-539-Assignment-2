/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.io.Serializable;
import java.util.*;

// line 56 "../../../../../model.ump"
public class Bus implements Serializable
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, Bus> bussByLicensePlate = new HashMap<String, Bus>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Bus Attributes
  private String licensePlate;

  //Bus State Machines
  enum BusStatus { FUNCTIONNAL, IN_REPAIR }
  private BusStatus busStatus;

  //Bus Associations
  private BTMS bTMS;
  private List<DriverBusRouteTuple> driverBusRouteTuples;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Bus(String aLicensePlate, BTMS aBTMS)
  {
    if (!setLicensePlate(aLicensePlate))
    {
      throw new RuntimeException("Cannot create due to duplicate licensePlate");
    }
    boolean didAddBTMS = setBTMS(aBTMS);
    if (!didAddBTMS)
    {
      throw new RuntimeException("Unable to create bus due to bTMS");
    }
    driverBusRouteTuples = new ArrayList<DriverBusRouteTuple>();
    setBusStatus(BusStatus.FUNCTIONNAL);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLicensePlate(String aLicensePlate)
  {
    boolean wasSet = false;
    String anOldLicensePlate = getLicensePlate();
    if (hasWithLicensePlate(aLicensePlate)) {
      return wasSet;
    }
    licensePlate = aLicensePlate;
    wasSet = true;
    if (anOldLicensePlate != null) {
      bussByLicensePlate.remove(anOldLicensePlate);
    }
    bussByLicensePlate.put(aLicensePlate, this);
    return wasSet;
  }

  public String getLicensePlate()
  {
    return licensePlate;
  }

  public static Bus getWithLicensePlate(String aLicensePlate)
  {
    return bussByLicensePlate.get(aLicensePlate);
  }

  public static boolean hasWithLicensePlate(String aLicensePlate)
  {
    return getWithLicensePlate(aLicensePlate) != null;
  }

  public String getBusStatusFullName()
  {
    String answer = busStatus.toString();
    return answer;
  }

  public BusStatus getBusStatus()
  {
    return busStatus;
  }

  public boolean busBreaksDown()
  {
    boolean wasEventProcessed = false;
    
    BusStatus aBusStatus = busStatus;
    switch (aBusStatus)
    {
      case FUNCTIONNAL:
        setBusStatus(BusStatus.IN_REPAIR);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean busRepaired()
  {
    boolean wasEventProcessed = false;
    
    BusStatus aBusStatus = busStatus;
    switch (aBusStatus)
    {
      case IN_REPAIR:
        setBusStatus(BusStatus.FUNCTIONNAL);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setBusStatus(BusStatus aBusStatus)
  {
    busStatus = aBusStatus;
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
      existingBTMS.removeBus(this);
    }
    bTMS.addBus(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfDriverBusRouteTuples()
  {
    return 0;
  }

  public DriverBusRouteTuple addDriverBusRouteTuple(Driver aDriver, Route aRoute, BTMS aBTMS, RouteWorkShift aRouteWorkShift)
  {
    return new DriverBusRouteTuple(aDriver, this, aRoute, aBTMS, aRouteWorkShift);
  }

  public boolean addDriverBusRouteTuple(DriverBusRouteTuple aDriverBusRouteTuple)
  {
    boolean wasAdded = false;
    if (driverBusRouteTuples.contains(aDriverBusRouteTuple)) { return false; }
    Bus existingBus = aDriverBusRouteTuple.getBus();
    boolean isNewBus = existingBus != null && !this.equals(existingBus);
    if (isNewBus)
    {
      aDriverBusRouteTuple.setBus(this);
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
    //Unable to remove aDriverBusRouteTuple, as it must always have a bus
    if (!this.equals(aDriverBusRouteTuple.getBus()))
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
    bussByLicensePlate.remove(getLicensePlate());
    BTMS placeholderBTMS = bTMS;
    this.bTMS = null;
    placeholderBTMS.removeBus(this);
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
            "licensePlate" + ":" + getLicensePlate()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "bTMS = "+(getBTMS()!=null?Integer.toHexString(System.identityHashCode(getBTMS())):"null")
     + outputString;
  }
}
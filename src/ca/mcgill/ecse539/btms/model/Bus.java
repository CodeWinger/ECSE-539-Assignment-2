/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.util.*;

// line 50 "../../../../../model.ump"
public class Bus
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
  private List<RouteWorkShift> routeWorkShifts;

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
    routeWorkShifts = new ArrayList<RouteWorkShift>();
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

  /**
   * 1 -- * RouteShift;
   */
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

  private void setBusStatus(BusStatus aBusStatus)
  {
    busStatus = aBusStatus;
  }

  public BTMS getBTMS()
  {
    return bTMS;
  }

  public RouteWorkShift getRouteWorkShift(int index)
  {
    RouteWorkShift aRouteWorkShift = routeWorkShifts.get(index);
    return aRouteWorkShift;
  }

  public List<RouteWorkShift> getRouteWorkShifts()
  {
    List<RouteWorkShift> newRouteWorkShifts = Collections.unmodifiableList(routeWorkShifts);
    return newRouteWorkShifts;
  }

  public int numberOfRouteWorkShifts()
  {
    int number = routeWorkShifts.size();
    return number;
  }

  public boolean hasRouteWorkShifts()
  {
    boolean has = routeWorkShifts.size() > 0;
    return has;
  }

  public int indexOfRouteWorkShift(RouteWorkShift aRouteWorkShift)
  {
    int index = routeWorkShifts.indexOf(aRouteWorkShift);
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

  public static int minimumNumberOfRouteWorkShifts()
  {
    return 0;
  }

  public boolean addRouteWorkShift(RouteWorkShift aRouteWorkShift)
  {
    boolean wasAdded = false;
    if (routeWorkShifts.contains(aRouteWorkShift)) { return false; }
    routeWorkShifts.add(aRouteWorkShift);
    if (aRouteWorkShift.indexOfBus(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aRouteWorkShift.addBus(this);
      if (!wasAdded)
      {
        routeWorkShifts.remove(aRouteWorkShift);
      }
    }
    return wasAdded;
  }

  public boolean removeRouteWorkShift(RouteWorkShift aRouteWorkShift)
  {
    boolean wasRemoved = false;
    if (!routeWorkShifts.contains(aRouteWorkShift))
    {
      return wasRemoved;
    }

    int oldIndex = routeWorkShifts.indexOf(aRouteWorkShift);
    routeWorkShifts.remove(oldIndex);
    if (aRouteWorkShift.indexOfBus(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aRouteWorkShift.removeBus(this);
      if (!wasRemoved)
      {
        routeWorkShifts.add(oldIndex,aRouteWorkShift);
      }
    }
    return wasRemoved;
  }

  public boolean addRouteWorkShiftAt(RouteWorkShift aRouteWorkShift, int index)
  {  
    boolean wasAdded = false;
    if(addRouteWorkShift(aRouteWorkShift))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRouteWorkShifts()) { index = numberOfRouteWorkShifts() - 1; }
      routeWorkShifts.remove(aRouteWorkShift);
      routeWorkShifts.add(index, aRouteWorkShift);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRouteWorkShiftAt(RouteWorkShift aRouteWorkShift, int index)
  {
    boolean wasAdded = false;
    if(routeWorkShifts.contains(aRouteWorkShift))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRouteWorkShifts()) { index = numberOfRouteWorkShifts() - 1; }
      routeWorkShifts.remove(aRouteWorkShift);
      routeWorkShifts.add(index, aRouteWorkShift);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRouteWorkShiftAt(aRouteWorkShift, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    bussByLicensePlate.remove(getLicensePlate());
    BTMS placeholderBTMS = bTMS;
    this.bTMS = null;
    placeholderBTMS.removeBus(this);
    ArrayList<RouteWorkShift> copyOfRouteWorkShifts = new ArrayList<RouteWorkShift>(routeWorkShifts);
    routeWorkShifts.clear();
    for(RouteWorkShift aRouteWorkShift : copyOfRouteWorkShifts)
    {
      aRouteWorkShift.removeBus(this);
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
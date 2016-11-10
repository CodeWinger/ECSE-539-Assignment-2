/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.io.Serializable;
import java.util.*;

// line 88 "../../../../../model.ump"
public class Route implements Serializable
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<Integer, Route> routesByRouteNumber = new HashMap<Integer, Route>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Route Attributes
  private int routeNumber;

  //Route Associations
  private BTMS bTMS;
  private List<DriverBusRouteTuple> driverBusRouteTuples;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Route(int aRouteNumber, BTMS aBTMS)
  {
    if (!setRouteNumber(aRouteNumber))
    {
      throw new RuntimeException("Cannot create due to duplicate routeNumber");
    }
    boolean didAddBTMS = setBTMS(aBTMS);
    if (!didAddBTMS)
    {
      throw new RuntimeException("Unable to create route due to bTMS");
    }
    driverBusRouteTuples = new ArrayList<DriverBusRouteTuple>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRouteNumber(int aRouteNumber)
  {
    boolean wasSet = false;
    Integer anOldRouteNumber = getRouteNumber();
    if (hasWithRouteNumber(aRouteNumber)) {
      return wasSet;
    }
    routeNumber = aRouteNumber;
    wasSet = true;
    if (anOldRouteNumber != null) {
      routesByRouteNumber.remove(anOldRouteNumber);
    }
    routesByRouteNumber.put(aRouteNumber, this);
    return wasSet;
  }

  public int getRouteNumber()
  {
    return routeNumber;
  }

  public static Route getWithRouteNumber(int aRouteNumber)
  {
    return routesByRouteNumber.get(aRouteNumber);
  }

  public static boolean hasWithRouteNumber(int aRouteNumber)
  {
    return getWithRouteNumber(aRouteNumber) != null;
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
      existingBTMS.removeRoute(this);
    }
    bTMS.addRoute(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfDriverBusRouteTuples()
  {
    return 0;
  }

  public DriverBusRouteTuple addDriverBusRouteTuple(Driver aDriver, Bus aBus, BTMS aBTMS, RouteWorkShift aRouteWorkShift)
  {
    return new DriverBusRouteTuple(aDriver, aBus, this, aBTMS, aRouteWorkShift);
  }

  public boolean addDriverBusRouteTuple(DriverBusRouteTuple aDriverBusRouteTuple)
  {
    boolean wasAdded = false;
    if (driverBusRouteTuples.contains(aDriverBusRouteTuple)) { return false; }
    Route existingRoute = aDriverBusRouteTuple.getRoute();
    boolean isNewRoute = existingRoute != null && !this.equals(existingRoute);
    if (isNewRoute)
    {
      aDriverBusRouteTuple.setRoute(this);
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
    //Unable to remove aDriverBusRouteTuple, as it must always have a route
    if (!this.equals(aDriverBusRouteTuple.getRoute()))
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
    routesByRouteNumber.remove(getRouteNumber());
    BTMS placeholderBTMS = bTMS;
    this.bTMS = null;
    placeholderBTMS.removeRoute(this);
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
            "routeNumber" + ":" + getRouteNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "bTMS = "+(getBTMS()!=null?Integer.toHexString(System.identityHashCode(getBTMS())):"null")
     + outputString;
  }
}
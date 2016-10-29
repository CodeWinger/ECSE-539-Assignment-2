/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.util.*;

// line 71 "../../../../../model.ump"
public class Route
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Route Attributes
  private int routeNumber;

  //Route Associations
  private BTMS bTMS;
  private List<Bus> buses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Route(int aRouteNumber, BTMS aBTMS)
  {
    routeNumber = aRouteNumber;
    boolean didAddBTMS = setBTMS(aBTMS);
    if (!didAddBTMS)
    {
      throw new RuntimeException("Unable to create route due to bTMS");
    }
    buses = new ArrayList<Bus>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public int getRouteNumber()
  {
    return routeNumber;
  }

  public BTMS getBTMS()
  {
    return bTMS;
  }

  public Bus getBus(int index)
  {
    Bus aBus = buses.get(index);
    return aBus;
  }

  public List<Bus> getBuses()
  {
    List<Bus> newBuses = Collections.unmodifiableList(buses);
    return newBuses;
  }

  public int numberOfBuses()
  {
    int number = buses.size();
    return number;
  }

  public boolean hasBuses()
  {
    boolean has = buses.size() > 0;
    return has;
  }

  public int indexOfBus(Bus aBus)
  {
    int index = buses.indexOf(aBus);
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

  public static int minimumNumberOfBuses()
  {
    return 0;
  }

  public Bus addBus(String aLicensePlate, BTMS aBTMS, Driver aDriver)
  {
    return new Bus(aLicensePlate, this, aBTMS, aDriver);
  }

  public boolean addBus(Bus aBus)
  {
    boolean wasAdded = false;
    if (buses.contains(aBus)) { return false; }
    Route existingRoute = aBus.getRoute();
    boolean isNewRoute = existingRoute != null && !this.equals(existingRoute);
    if (isNewRoute)
    {
      aBus.setRoute(this);
    }
    else
    {
      buses.add(aBus);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBus(Bus aBus)
  {
    boolean wasRemoved = false;
    //Unable to remove aBus, as it must always have a route
    if (!this.equals(aBus.getRoute()))
    {
      buses.remove(aBus);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addBusAt(Bus aBus, int index)
  {  
    boolean wasAdded = false;
    if(addBus(aBus))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBuses()) { index = numberOfBuses() - 1; }
      buses.remove(aBus);
      buses.add(index, aBus);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBusAt(Bus aBus, int index)
  {
    boolean wasAdded = false;
    if(buses.contains(aBus))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBuses()) { index = numberOfBuses() - 1; }
      buses.remove(aBus);
      buses.add(index, aBus);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBusAt(aBus, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    BTMS placeholderBTMS = bTMS;
    this.bTMS = null;
    placeholderBTMS.removeRoute(this);
    for(int i=buses.size(); i > 0; i--)
    {
      Bus aBus = buses.get(i - 1);
      aBus.delete();
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
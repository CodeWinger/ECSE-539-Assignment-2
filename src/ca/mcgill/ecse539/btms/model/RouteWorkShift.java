/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.util.*;

// line 86 "../../../../../model.ump"
public abstract class RouteWorkShift
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RouteWorkShift Associations
  private List<Bus> buses;
  private List<Driver> drivers;
  private Route route;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RouteWorkShift(Route aRoute)
  {
    buses = new ArrayList<Bus>();
    drivers = new ArrayList<Driver>();
    if (!setRoute(aRoute))
    {
      throw new RuntimeException("Unable to create RouteWorkShift due to aRoute");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

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

  public Driver getDriver(int index)
  {
    Driver aDriver = drivers.get(index);
    return aDriver;
  }

  public List<Driver> getDrivers()
  {
    List<Driver> newDrivers = Collections.unmodifiableList(drivers);
    return newDrivers;
  }

  public int numberOfDrivers()
  {
    int number = drivers.size();
    return number;
  }

  public boolean hasDrivers()
  {
    boolean has = drivers.size() > 0;
    return has;
  }

  public int indexOfDriver(Driver aDriver)
  {
    int index = drivers.indexOf(aDriver);
    return index;
  }

  public Route getRoute()
  {
    return route;
  }

  public static int minimumNumberOfBuses()
  {
    return 0;
  }

  public boolean addBus(Bus aBus)
  {
    boolean wasAdded = false;
    // line 92 "../../../../../model.ump"
    if(aBus.getBusStatus() ==  ca.mcgill.ecse539.btms.model.Bus.BusStatus.IN_REPAIR)
        			return false;
    if (buses.contains(aBus)) { return false; }
    if (buses.contains(aBus)) { return false; }
    if (buses.contains(aBus)) { return false; }
    if (buses.contains(aBus)) { return false; }
    buses.add(aBus);
    if (aBus.indexOfRouteWorkShift(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aBus.addRouteWorkShift(this);
      if (!wasAdded)
      {
        buses.remove(aBus);
      }
    }
    return wasAdded;
  }

  public boolean removeBus(Bus aBus)
  {
    boolean wasRemoved = false;
    if (!buses.contains(aBus))
    {
      return wasRemoved;
    }

    int oldIndex = buses.indexOf(aBus);
    buses.remove(oldIndex);
    if (aBus.indexOfRouteWorkShift(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aBus.removeRouteWorkShift(this);
      if (!wasRemoved)
      {
        buses.add(oldIndex,aBus);
      }
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

  public static int minimumNumberOfDrivers()
  {
    return 0;
  }

  public boolean addDriver(Driver aDriver)
  {
    boolean wasAdded = false;
    // line 97 "../../../../../model.ump"
    if(aDriver.getWorkStatus() == ca.mcgill.ecse539.btms.model.Driver.WorkStatus.SICK)
        			return false;
    if (drivers.contains(aDriver)) { return false; }
    if (drivers.contains(aDriver)) { return false; }
    if (drivers.contains(aDriver)) { return false; }
    if (drivers.contains(aDriver)) { return false; }
    drivers.add(aDriver);
    if (aDriver.indexOfRouteWorkShift(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDriver.addRouteWorkShift(this);
      if (!wasAdded)
      {
        drivers.remove(aDriver);
      }
    }
    return wasAdded;
  }

  public boolean removeDriver(Driver aDriver)
  {
    boolean wasRemoved = false;
    if (!drivers.contains(aDriver))
    {
      return wasRemoved;
    }

    int oldIndex = drivers.indexOf(aDriver);
    drivers.remove(oldIndex);
    if (aDriver.indexOfRouteWorkShift(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDriver.removeRouteWorkShift(this);
      if (!wasRemoved)
      {
        drivers.add(oldIndex,aDriver);
      }
    }
    return wasRemoved;
  }

  public boolean addDriverAt(Driver aDriver, int index)
  {  
    boolean wasAdded = false;
    if(addDriver(aDriver))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDrivers()) { index = numberOfDrivers() - 1; }
      drivers.remove(aDriver);
      drivers.add(index, aDriver);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDriverAt(Driver aDriver, int index)
  {
    boolean wasAdded = false;
    if(drivers.contains(aDriver))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDrivers()) { index = numberOfDrivers() - 1; }
      drivers.remove(aDriver);
      drivers.add(index, aDriver);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDriverAt(aDriver, index);
    }
    return wasAdded;
  }

  public boolean setRoute(Route aNewRoute)
  {
    boolean wasSet = false;
    if (aNewRoute != null)
    {
      route = aNewRoute;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Bus> copyOfBuses = new ArrayList<Bus>(buses);
    buses.clear();
    for(Bus aBus : copyOfBuses)
    {
      aBus.removeRouteWorkShift(this);
    }
    ArrayList<Driver> copyOfDrivers = new ArrayList<Driver>(drivers);
    drivers.clear();
    for(Driver aDriver : copyOfDrivers)
    {
      aDriver.removeRouteWorkShift(this);
    }
    route = null;
  }

}
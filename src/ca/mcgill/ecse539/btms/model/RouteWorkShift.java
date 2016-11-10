/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.io.Serializable;
import java.util.*;

// line 93 "../../../../../model.ump"
public abstract class RouteWorkShift implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RouteWorkShift Associations
  private List<DriverBusRouteTuple> driverBusRouteTuples;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RouteWorkShift()
  {
    driverBusRouteTuples = new ArrayList<DriverBusRouteTuple>();
  }

  //------------------------
  // INTERFACE
  //------------------------

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

  public static int minimumNumberOfDriverBusRouteTuples()
  {
    return 0;
  }

  public DriverBusRouteTuple addDriverBusRouteTuple(Driver aDriver, Bus aBus, Route aRoute, BTMS aBTMS)
  {
    return new DriverBusRouteTuple(aDriver, aBus, aRoute, aBTMS, this);
  }

  public boolean addDriverBusRouteTuple(DriverBusRouteTuple aDriverBusRouteTuple)
  {
    boolean wasAdded = false;
    if (driverBusRouteTuples.contains(aDriverBusRouteTuple)) { return false; }
    if (driverBusRouteTuples.contains(aDriverBusRouteTuple)) { return false; }
    if (driverBusRouteTuples.contains(aDriverBusRouteTuple)) { return false; }
    if (driverBusRouteTuples.contains(aDriverBusRouteTuple)) { return false; }
    RouteWorkShift existingRouteWorkShift = aDriverBusRouteTuple.getRouteWorkShift();
    boolean isNewRouteWorkShift = existingRouteWorkShift != null && !this.equals(existingRouteWorkShift);
    if (isNewRouteWorkShift)
    {
      aDriverBusRouteTuple.setRouteWorkShift(this);
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
    //Unable to remove aDriverBusRouteTuple, as it must always have a routeWorkShift
    if (!this.equals(aDriverBusRouteTuple.getRouteWorkShift()))
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
    for(int i=driverBusRouteTuples.size(); i > 0; i--)
    {
      DriverBusRouteTuple aDriverBusRouteTuple = driverBusRouteTuples.get(i - 1);
      aDriverBusRouteTuple.delete();
    }
  }

}
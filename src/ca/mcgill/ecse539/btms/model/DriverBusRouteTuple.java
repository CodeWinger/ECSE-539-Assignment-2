/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

// line 104 "../../../../../model.ump"
public class DriverBusRouteTuple
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DriverBusRouteTuple Associations
  private Driver driver;
  private Bus bus;
  private Route route;
  private RouteWorkShift routeWorkShift;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DriverBusRouteTuple(Driver aDriver, Bus aBus, Route aRoute, RouteWorkShift aRouteWorkShift)
  {
	  //warning manually added code
	  final Date date;
	    if (aRouteWorkShift instanceof MorningRouteWorkShift) {
	    	date = ((MorningRouteWorkShift) aRouteWorkShift).getWorkDate();
	    } else if ( aRouteWorkShift instanceof AfternoonRouteWorkShift) {
	    	date = ((AfternoonRouteWorkShift) aRouteWorkShift).getWorkDate();
	    } else if ( aRouteWorkShift instanceof NightRouteWorkShift){
	    	date = ((NightRouteWorkShift) aRouteWorkShift).getWorkDate();
	    } else {
	    	date = null;
	    }
	    
	    List<DriverBusRouteTuple> all = new ArrayList<DriverBusRouteTuple>();
	    aBus.getBTMS().getMorningRouteWorkShifts().stream().filter(s -> s.getWorkDate().equals(date)).map(s -> s.getDriverBusRouteTuples()).map(all::addAll);
	    aBus.getBTMS().getAfternoonRouteWorkShifts().stream().filter(s -> s.getWorkDate().equals(date)).map(s -> s.getDriverBusRouteTuples()).map(all::addAll);
	    aBus.getBTMS().getNightRouteWorkShifts().stream().filter(s -> s.getWorkDate().equals(date)).map(s -> s.getDriverBusRouteTuples()).map(all::addAll);
	    
	    if ( all.stream().anyMatch(s -> s.route.equals(aRoute)))
	    	throw new RuntimeException("cannot assign a bus to different route for the same day!");
    boolean didAddDriver = setDriver(aDriver);
    if (!didAddDriver)
    {
      throw new RuntimeException("Unable to create driverBusRouteTuple due to driver");
    }
    boolean didAddBus = setBus(aBus);
    if (!didAddBus)
    {
      throw new RuntimeException("Unable to create driverBusRouteTuple due to bus");
    }
    boolean didAddRoute = setRoute(aRoute);
    if (!didAddRoute)
    {
      throw new RuntimeException("Unable to create driverBusRouteTuple due to route");
    }
    boolean didAddRouteWorkShift = setRouteWorkShift(aRouteWorkShift);
    if (!didAddRouteWorkShift)
    {
      throw new RuntimeException("Unable to create driverBusRouteTuple due to routeWorkShift");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Driver getDriver()
  {
    return driver;
  }

  public Bus getBus()
  {
    return bus;
  }

  public Route getRoute()
  {
    return route;
  }

  public RouteWorkShift getRouteWorkShift()
  {
    return routeWorkShift;
  }

  public boolean setDriver(Driver aDriver)
  {
	  if(aDriver.getWorkStatus() == ca.mcgill.ecse539.btms.model.Driver.WorkStatus.SICK)
			return false;
    boolean wasSet = false;
    if (aDriver == null)
    {
      return wasSet;
    }

    Driver existingDriver = driver;
    driver = aDriver;
    if (existingDriver != null && !existingDriver.equals(aDriver))
    {
      existingDriver.removeDriverBusRouteTuple(this);
    }
    driver.addDriverBusRouteTuple(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setBus(Bus aBus)
  {
	  if(aBus.getBusStatus() ==  ca.mcgill.ecse539.btms.model.Bus.BusStatus.IN_REPAIR)
			return false;
	  
    boolean wasSet = false;
    if (aBus == null)
    {
      return wasSet;
    }

    Bus existingBus = bus;
    bus = aBus;
    if (existingBus != null && !existingBus.equals(aBus))
    {
      existingBus.removeDriverBusRouteTuple(this);
    }
    bus.addDriverBusRouteTuple(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setRoute(Route aRoute)
  {
    boolean wasSet = false;
    if (aRoute == null)
    {
      return wasSet;
    }

    Route existingRoute = route;
    route = aRoute;
    if (existingRoute != null && !existingRoute.equals(aRoute))
    {
      existingRoute.removeDriverBusRouteTuple(this);
    }
    route.addDriverBusRouteTuple(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setRouteWorkShift(RouteWorkShift aRouteWorkShift)
  {
    boolean wasSet = false;
    if (aRouteWorkShift == null)
    {
      return wasSet;
    }

    RouteWorkShift existingRouteWorkShift = routeWorkShift;
    routeWorkShift = aRouteWorkShift;
    if (existingRouteWorkShift != null && !existingRouteWorkShift.equals(aRouteWorkShift))
    {
      existingRouteWorkShift.removeDriverBusRouteTuple(this);
    }
    routeWorkShift.addDriverBusRouteTuple(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Driver placeholderDriver = driver;
    this.driver = null;
    placeholderDriver.removeDriverBusRouteTuple(this);
    Bus placeholderBus = bus;
    this.bus = null;
    placeholderBus.removeDriverBusRouteTuple(this);
    Route placeholderRoute = route;
    this.route = null;
    placeholderRoute.removeDriverBusRouteTuple(this);
    RouteWorkShift placeholderRouteWorkShift = routeWorkShift;
    this.routeWorkShift = null;
    placeholderRouteWorkShift.removeDriverBusRouteTuple(this);
  }

}
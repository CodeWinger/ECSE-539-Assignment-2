/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;

// line 94 "../../../../../model.ump"
public class DriverBusRouteTuple
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DriverBusRouteTuple Associations
  private Driver driver;
  private Bus bus;
  private Route route;
  private BTMS bTMS;
  private RouteWorkShift routeWorkShift;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DriverBusRouteTuple(Driver aDriver, Bus aBus, Route aRoute, BTMS aBTMS, RouteWorkShift aRouteWorkShift)
  {
    // line 109 "../../../../../model.ump"
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
    	    
    	    List<DriverBusRouteTuple> assignmentsForGivenDay = new ArrayList<DriverBusRouteTuple>();
    	    aBTMS.getAfternoonRouteWorkShifts().stream().filter(s -> s.getWorkDate().equals(date)).map(s -> s.getDriverBusRouteTuples()).forEach(assignmentsForGivenDay::addAll);
    	    aBTMS.getMorningRouteWorkShifts().stream().filter(s -> s.getWorkDate().equals(date)).map(s -> s.getDriverBusRouteTuples()).forEach(assignmentsForGivenDay::addAll);
    	    aBTMS.getNightRouteWorkShifts().stream().filter(s -> s.getWorkDate().equals(date)).map(s -> s.getDriverBusRouteTuples()).forEach(assignmentsForGivenDay::addAll);
    	    
    	    if ( assignmentsForGivenDay.stream().anyMatch(a -> a.getRoute().getRouteNumber() != aRoute.getRouteNumber())) {
    	    	throw new RuntimeException("cannot assign a bus to different route for the same day!");
    	    }
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
    boolean didAddBTMS = setBTMS(aBTMS);
    if (!didAddBTMS)
    {
      throw new RuntimeException("Unable to create driverBusRouteTuple due to bTMS");
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

  public BTMS getBTMS()
  {
    return bTMS;
  }

  public RouteWorkShift getRouteWorkShift()
  {
    return routeWorkShift;
  }

  public boolean setDriver(Driver aDriver)
  {
    boolean wasSet = false;
    // line 104 "../../../../../model.ump"
    if(aDriver.getWorkStatus() == ca.mcgill.ecse539.btms.model.Driver.WorkStatus.SICK)
        			return false;
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
    boolean wasSet = false;
    // line 99 "../../../../../model.ump"
    if(aBus.getBusStatus() ==  ca.mcgill.ecse539.btms.model.Bus.BusStatus.IN_REPAIR)
        			return false;
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
      existingBTMS.removeDriverBusRouteTuple(this);
    }
    bTMS.addDriverBusRouteTuple(this);
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
    BTMS placeholderBTMS = bTMS;
    this.bTMS = null;
    placeholderBTMS.removeDriverBusRouteTuple(this);
    RouteWorkShift placeholderRouteWorkShift = routeWorkShift;
    this.routeWorkShift = null;
    placeholderRouteWorkShift.removeDriverBusRouteTuple(this);
  }

}
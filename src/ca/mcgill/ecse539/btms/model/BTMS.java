/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.sql.Date;
import java.util.*;

// line 3 "../../../../../model.ump"
public class BTMS
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static BTMS theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BTMS Attributes
  private Date currentDate;
  private Date threeDaysAhead;

  //BTMS Associations
  private List<Bus> buses;
  private List<Route> routes;
  private List<Driver> drivers;
  private List<MorningRouteWorkShift> morningRouteWorkShifts;
  private List<AfternoonRouteWorkShift> afternoonRouteWorkShifts;
  private List<NightRouteWorkShift> nightRouteWorkShifts;
  private List<DriverBusRouteTuple> driverBusRouteTuples;

  //Helper Variables
  private boolean canSetCurrentDate;
  private boolean canSetThreeDaysAhead;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private BTMS()
  {
	  Calendar calendar = Calendar.getInstance();
		setCurrentDate(new java.sql.Date(calendar.getTime().getTime()));
		calendar.add(Calendar.DATE, 3);
		setThreeDaysAhead(new java.sql.Date(calendar.getTime().getTime()));
    canSetCurrentDate = true;
    canSetThreeDaysAhead = true;
    buses = new ArrayList<Bus>();
    routes = new ArrayList<Route>();
    drivers = new ArrayList<Driver>();
    morningRouteWorkShifts = new ArrayList<MorningRouteWorkShift>();
    afternoonRouteWorkShifts = new ArrayList<AfternoonRouteWorkShift>();
    nightRouteWorkShifts = new ArrayList<NightRouteWorkShift>();
    driverBusRouteTuples = new ArrayList<DriverBusRouteTuple>();
  }

  public static BTMS getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new BTMS();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCurrentDate(Date aCurrentDate)
  {
    boolean wasSet = false;
    if (!canSetCurrentDate) { return false; }
    canSetCurrentDate = false;
    currentDate = aCurrentDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setThreeDaysAhead(Date aThreeDaysAhead)
  {
    boolean wasSet = false;
    if (!canSetThreeDaysAhead) { return false; }
    canSetThreeDaysAhead = false;
    threeDaysAhead = aThreeDaysAhead;
    wasSet = true;
    return wasSet;
  }

  public Date getCurrentDate()
  {
    return currentDate;
  }

  public Date getThreeDaysAhead()
  {
    return threeDaysAhead;
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

  public Route getRoute(int index)
  {
    Route aRoute = routes.get(index);
    return aRoute;
  }

  public List<Route> getRoutes()
  {
    List<Route> newRoutes = Collections.unmodifiableList(routes);
    return newRoutes;
  }

  public int numberOfRoutes()
  {
    int number = routes.size();
    return number;
  }

  public boolean hasRoutes()
  {
    boolean has = routes.size() > 0;
    return has;
  }

  public int indexOfRoute(Route aRoute)
  {
    int index = routes.indexOf(aRoute);
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

  public MorningRouteWorkShift getMorningRouteWorkShift(int index)
  {
    MorningRouteWorkShift aMorningRouteWorkShift = morningRouteWorkShifts.get(index);
    return aMorningRouteWorkShift;
  }

  public List<MorningRouteWorkShift> getMorningRouteWorkShifts()
  {
    List<MorningRouteWorkShift> newMorningRouteWorkShifts = Collections.unmodifiableList(morningRouteWorkShifts);
    return newMorningRouteWorkShifts;
  }

  public int numberOfMorningRouteWorkShifts()
  {
    int number = morningRouteWorkShifts.size();
    return number;
  }

  public boolean hasMorningRouteWorkShifts()
  {
    boolean has = morningRouteWorkShifts.size() > 0;
    return has;
  }

  public int indexOfMorningRouteWorkShift(MorningRouteWorkShift aMorningRouteWorkShift)
  {
    int index = morningRouteWorkShifts.indexOf(aMorningRouteWorkShift);
    return index;
  }

  public AfternoonRouteWorkShift getAfternoonRouteWorkShift(int index)
  {
    AfternoonRouteWorkShift aAfternoonRouteWorkShift = afternoonRouteWorkShifts.get(index);
    return aAfternoonRouteWorkShift;
  }

  public List<AfternoonRouteWorkShift> getAfternoonRouteWorkShifts()
  {
    List<AfternoonRouteWorkShift> newAfternoonRouteWorkShifts = Collections.unmodifiableList(afternoonRouteWorkShifts);
    return newAfternoonRouteWorkShifts;
  }

  public int numberOfAfternoonRouteWorkShifts()
  {
    int number = afternoonRouteWorkShifts.size();
    return number;
  }

  public boolean hasAfternoonRouteWorkShifts()
  {
    boolean has = afternoonRouteWorkShifts.size() > 0;
    return has;
  }

  public int indexOfAfternoonRouteWorkShift(AfternoonRouteWorkShift aAfternoonRouteWorkShift)
  {
    int index = afternoonRouteWorkShifts.indexOf(aAfternoonRouteWorkShift);
    return index;
  }

  public NightRouteWorkShift getNightRouteWorkShift(int index)
  {
    NightRouteWorkShift aNightRouteWorkShift = nightRouteWorkShifts.get(index);
    return aNightRouteWorkShift;
  }

  public List<NightRouteWorkShift> getNightRouteWorkShifts()
  {
    List<NightRouteWorkShift> newNightRouteWorkShifts = Collections.unmodifiableList(nightRouteWorkShifts);
    return newNightRouteWorkShifts;
  }

  public int numberOfNightRouteWorkShifts()
  {
    int number = nightRouteWorkShifts.size();
    return number;
  }

  public boolean hasNightRouteWorkShifts()
  {
    boolean has = nightRouteWorkShifts.size() > 0;
    return has;
  }

  public int indexOfNightRouteWorkShift(NightRouteWorkShift aNightRouteWorkShift)
  {
    int index = nightRouteWorkShifts.indexOf(aNightRouteWorkShift);
    return index;
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

  public static int minimumNumberOfBuses()
  {
    return 0;
  }

  public Bus addBus(String aLicensePlate)
  {
    return new Bus(aLicensePlate, this);
  }

  public boolean addBus(Bus aBus)
  {
    boolean wasAdded = false;
    if (buses.contains(aBus)) { return false; }
    BTMS existingBTMS = aBus.getBTMS();
    boolean isNewBTMS = existingBTMS != null && !this.equals(existingBTMS);
    if (isNewBTMS)
    {
      aBus.setBTMS(this);
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
    //Unable to remove aBus, as it must always have a bTMS
    if (!this.equals(aBus.getBTMS()))
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

  public static int minimumNumberOfRoutes()
  {
    return 0;
  }

  public Route addRoute(int aRouteNumber)
  {
    return new Route(aRouteNumber, this);
  }

  public boolean addRoute(Route aRoute)
  {
    boolean wasAdded = false;
    if (routes.contains(aRoute)) { return false; }
    BTMS existingBTMS = aRoute.getBTMS();
    boolean isNewBTMS = existingBTMS != null && !this.equals(existingBTMS);
    if (isNewBTMS)
    {
      aRoute.setBTMS(this);
    }
    else
    {
      routes.add(aRoute);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRoute(Route aRoute)
  {
    boolean wasRemoved = false;
    //Unable to remove aRoute, as it must always have a bTMS
    if (!this.equals(aRoute.getBTMS()))
    {
      routes.remove(aRoute);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addRouteAt(Route aRoute, int index)
  {  
    boolean wasAdded = false;
    if(addRoute(aRoute))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoutes()) { index = numberOfRoutes() - 1; }
      routes.remove(aRoute);
      routes.add(index, aRoute);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRouteAt(Route aRoute, int index)
  {
    boolean wasAdded = false;
    if(routes.contains(aRoute))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoutes()) { index = numberOfRoutes() - 1; }
      routes.remove(aRoute);
      routes.add(index, aRoute);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRouteAt(aRoute, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfDrivers()
  {
    return 0;
  }

  public Driver addDriver(String aName)
  {
    return new Driver(aName, this);
  }

  public boolean addDriver(Driver aDriver)
  {
    boolean wasAdded = false;
    if (drivers.contains(aDriver)) { return false; }
    BTMS existingBTMS = aDriver.getBTMS();
    boolean isNewBTMS = existingBTMS != null && !this.equals(existingBTMS);
    if (isNewBTMS)
    {
      aDriver.setBTMS(this);
    }
    else
    {
      drivers.add(aDriver);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDriver(Driver aDriver)
  {
    boolean wasRemoved = false;
    //Unable to remove aDriver, as it must always have a bTMS
    if (!this.equals(aDriver.getBTMS()))
    {
      drivers.remove(aDriver);
      wasRemoved = true;
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

  public static int minimumNumberOfMorningRouteWorkShifts()
  {
    return 0;
  }

  public MorningRouteWorkShift addMorningRouteWorkShift(Date aWorkDate)
  {
	  if( !(aWorkDate.after(getCurrentDate()) && aWorkDate.before(getThreeDaysAhead())))
	 		return null;
    return new MorningRouteWorkShift(aWorkDate, this);
  }

  public boolean addMorningRouteWorkShift(MorningRouteWorkShift aMorningRouteWorkShift)
  {
    boolean wasAdded = false;
    if (morningRouteWorkShifts.contains(aMorningRouteWorkShift)) { return false; }
    BTMS existingBTMS = aMorningRouteWorkShift.getBTMS();
    boolean isNewBTMS = existingBTMS != null && !this.equals(existingBTMS);
    if (isNewBTMS)
    {
      aMorningRouteWorkShift.setBTMS(this);
    }
    else
    {
      morningRouteWorkShifts.add(aMorningRouteWorkShift);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMorningRouteWorkShift(MorningRouteWorkShift aMorningRouteWorkShift)
  {
    boolean wasRemoved = false;
    //Unable to remove aMorningRouteWorkShift, as it must always have a bTMS
    if (!this.equals(aMorningRouteWorkShift.getBTMS()))
    {
      morningRouteWorkShifts.remove(aMorningRouteWorkShift);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addMorningRouteWorkShiftAt(MorningRouteWorkShift aMorningRouteWorkShift, int index)
  {  
    boolean wasAdded = false;
    if(addMorningRouteWorkShift(aMorningRouteWorkShift))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMorningRouteWorkShifts()) { index = numberOfMorningRouteWorkShifts() - 1; }
      morningRouteWorkShifts.remove(aMorningRouteWorkShift);
      morningRouteWorkShifts.add(index, aMorningRouteWorkShift);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMorningRouteWorkShiftAt(MorningRouteWorkShift aMorningRouteWorkShift, int index)
  {
    boolean wasAdded = false;
    if(morningRouteWorkShifts.contains(aMorningRouteWorkShift))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMorningRouteWorkShifts()) { index = numberOfMorningRouteWorkShifts() - 1; }
      morningRouteWorkShifts.remove(aMorningRouteWorkShift);
      morningRouteWorkShifts.add(index, aMorningRouteWorkShift);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMorningRouteWorkShiftAt(aMorningRouteWorkShift, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfAfternoonRouteWorkShifts()
  {
    return 0;
  }

  public AfternoonRouteWorkShift addAfternoonRouteWorkShift(Date aWorkDate)
  {
	  if( !(aWorkDate.after(getCurrentDate()) && aWorkDate.before(getThreeDaysAhead())))
	 		return null;
    return new AfternoonRouteWorkShift(aWorkDate, this);
  }

  public boolean addAfternoonRouteWorkShift(AfternoonRouteWorkShift aAfternoonRouteWorkShift)
  {
    boolean wasAdded = false;
    if (afternoonRouteWorkShifts.contains(aAfternoonRouteWorkShift)) { return false; }
    BTMS existingBTMS = aAfternoonRouteWorkShift.getBTMS();
    boolean isNewBTMS = existingBTMS != null && !this.equals(existingBTMS);
    if (isNewBTMS)
    {
      aAfternoonRouteWorkShift.setBTMS(this);
    }
    else
    {
      afternoonRouteWorkShifts.add(aAfternoonRouteWorkShift);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAfternoonRouteWorkShift(AfternoonRouteWorkShift aAfternoonRouteWorkShift)
  {
    boolean wasRemoved = false;
    //Unable to remove aAfternoonRouteWorkShift, as it must always have a bTMS
    if (!this.equals(aAfternoonRouteWorkShift.getBTMS()))
    {
      afternoonRouteWorkShifts.remove(aAfternoonRouteWorkShift);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAfternoonRouteWorkShiftAt(AfternoonRouteWorkShift aAfternoonRouteWorkShift, int index)
  {  
    boolean wasAdded = false;
    if(addAfternoonRouteWorkShift(aAfternoonRouteWorkShift))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAfternoonRouteWorkShifts()) { index = numberOfAfternoonRouteWorkShifts() - 1; }
      afternoonRouteWorkShifts.remove(aAfternoonRouteWorkShift);
      afternoonRouteWorkShifts.add(index, aAfternoonRouteWorkShift);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAfternoonRouteWorkShiftAt(AfternoonRouteWorkShift aAfternoonRouteWorkShift, int index)
  {
    boolean wasAdded = false;
    if(afternoonRouteWorkShifts.contains(aAfternoonRouteWorkShift))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAfternoonRouteWorkShifts()) { index = numberOfAfternoonRouteWorkShifts() - 1; }
      afternoonRouteWorkShifts.remove(aAfternoonRouteWorkShift);
      afternoonRouteWorkShifts.add(index, aAfternoonRouteWorkShift);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAfternoonRouteWorkShiftAt(aAfternoonRouteWorkShift, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfNightRouteWorkShifts()
  {
    return 0;
  }

  public NightRouteWorkShift addNightRouteWorkShift(Date aWorkDate)
  {
	  if( !(aWorkDate.after(getCurrentDate()) && aWorkDate.before(getThreeDaysAhead())))
	 		return null;
    return new NightRouteWorkShift(aWorkDate, this);
  }

  public boolean addNightRouteWorkShift(NightRouteWorkShift aNightRouteWorkShift)
  {
    boolean wasAdded = false;
    if (nightRouteWorkShifts.contains(aNightRouteWorkShift)) { return false; }
    BTMS existingBTMS = aNightRouteWorkShift.getBTMS();
    boolean isNewBTMS = existingBTMS != null && !this.equals(existingBTMS);
    if (isNewBTMS)
    {
      aNightRouteWorkShift.setBTMS(this);
    }
    else
    {
      nightRouteWorkShifts.add(aNightRouteWorkShift);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeNightRouteWorkShift(NightRouteWorkShift aNightRouteWorkShift)
  {
    boolean wasRemoved = false;
    //Unable to remove aNightRouteWorkShift, as it must always have a bTMS
    if (!this.equals(aNightRouteWorkShift.getBTMS()))
    {
      nightRouteWorkShifts.remove(aNightRouteWorkShift);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addNightRouteWorkShiftAt(NightRouteWorkShift aNightRouteWorkShift, int index)
  {  
    boolean wasAdded = false;
    if(addNightRouteWorkShift(aNightRouteWorkShift))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfNightRouteWorkShifts()) { index = numberOfNightRouteWorkShifts() - 1; }
      nightRouteWorkShifts.remove(aNightRouteWorkShift);
      nightRouteWorkShifts.add(index, aNightRouteWorkShift);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveNightRouteWorkShiftAt(NightRouteWorkShift aNightRouteWorkShift, int index)
  {
    boolean wasAdded = false;
    if(nightRouteWorkShifts.contains(aNightRouteWorkShift))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfNightRouteWorkShifts()) { index = numberOfNightRouteWorkShifts() - 1; }
      nightRouteWorkShifts.remove(aNightRouteWorkShift);
      nightRouteWorkShifts.add(index, aNightRouteWorkShift);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addNightRouteWorkShiftAt(aNightRouteWorkShift, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfDriverBusRouteTuples()
  {
    return 0;
  }

  public DriverBusRouteTuple addDriverBusRouteTuple(Driver aDriver, Bus aBus, Route aRoute, RouteWorkShift aRouteWorkShift)
  {
    return new DriverBusRouteTuple(aDriver, aBus, aRoute, this, aRouteWorkShift);
  }

  public boolean addDriverBusRouteTuple(DriverBusRouteTuple aDriverBusRouteTuple)
  {
    boolean wasAdded = false;
    if (driverBusRouteTuples.contains(aDriverBusRouteTuple)) { return false; }
    BTMS existingBTMS = aDriverBusRouteTuple.getBTMS();
    boolean isNewBTMS = existingBTMS != null && !this.equals(existingBTMS);
    if (isNewBTMS)
    {
      aDriverBusRouteTuple.setBTMS(this);
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
    //Unable to remove aDriverBusRouteTuple, as it must always have a bTMS
    if (!this.equals(aDriverBusRouteTuple.getBTMS()))
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
    while (buses.size() > 0)
    {
      Bus aBus = buses.get(buses.size() - 1);
      aBus.delete();
      buses.remove(aBus);
    }
    
      
    while (routes.size() > 0)
    {
      Route aRoute = routes.get(routes.size() - 1);
      aRoute.delete();
      routes.remove(aRoute);
    }
    
      
    while (drivers.size() > 0)
    {
      Driver aDriver = drivers.get(drivers.size() - 1);
      aDriver.delete();
      drivers.remove(aDriver);
    }
    
      
    while (morningRouteWorkShifts.size() > 0)
    {
      MorningRouteWorkShift aMorningRouteWorkShift = morningRouteWorkShifts.get(morningRouteWorkShifts.size() - 1);
      aMorningRouteWorkShift.delete();
      morningRouteWorkShifts.remove(aMorningRouteWorkShift);
    }
    
      
    while (afternoonRouteWorkShifts.size() > 0)
    {
      AfternoonRouteWorkShift aAfternoonRouteWorkShift = afternoonRouteWorkShifts.get(afternoonRouteWorkShifts.size() - 1);
      aAfternoonRouteWorkShift.delete();
      afternoonRouteWorkShifts.remove(aAfternoonRouteWorkShift);
    }
    
      
    while (nightRouteWorkShifts.size() > 0)
    {
      NightRouteWorkShift aNightRouteWorkShift = nightRouteWorkShifts.get(nightRouteWorkShifts.size() - 1);
      aNightRouteWorkShift.delete();
      nightRouteWorkShifts.remove(aNightRouteWorkShift);
    }
    
      
    while (driverBusRouteTuples.size() > 0)
    {
      DriverBusRouteTuple aDriverBusRouteTuple = driverBusRouteTuples.get(driverBusRouteTuples.size() - 1);
      aDriverBusRouteTuple.delete();
      driverBusRouteTuples.remove(aDriverBusRouteTuple);
    }
    
      
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "currentDate" + "=" + (getCurrentDate() != null ? !getCurrentDate().equals(this)  ? getCurrentDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "threeDaysAhead" + "=" + (getThreeDaysAhead() != null ? !getThreeDaysAhead().equals(this)  ? getThreeDaysAhead().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}
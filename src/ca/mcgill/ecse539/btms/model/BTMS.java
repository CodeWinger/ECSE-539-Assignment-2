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

  //BTMS Associations
  private List<Bus> buses;
  private List<Driver> drivers;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private BTMS()
  {
    currentDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    buses = new ArrayList<Bus>();
    drivers = new ArrayList<Driver>();
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
    currentDate = aCurrentDate;
    wasSet = true;
    return wasSet;
  }

  public Date getCurrentDate()
  {
    return currentDate;
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

  public Driver getDriver(int index)
  {
    Driver aDriver = drivers.get(index);
    return aDriver;
  }

  /**
   * 1 <@>- * RouteWorkShift;
   * 1 <@>- * Shift;
   */
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

  public void delete()
  {
    while (buses.size() > 0)
    {
      Bus aBus = buses.get(buses.size() - 1);
      aBus.delete();
      buses.remove(aBus);
    }
    
      
    while (drivers.size() > 0)
    {
      Driver aDriver = drivers.get(drivers.size() - 1);
      aDriver.delete();
      drivers.remove(aDriver);
    }
    
      
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "currentDate" + "=" + (getCurrentDate() != null ? !getCurrentDate().equals(this)  ? getCurrentDate().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}
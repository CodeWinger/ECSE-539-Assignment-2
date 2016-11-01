/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-dab6b48 modeling language!*/

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
  private List<MorningRouteWorkShift> morningRouteWorkShifts;
  private List<AfternoonRouteWorkShift> afternoonRouteWorkShifts;
  private List<NightRouteWorkShift> nightRouteWorkShifts;
  private List<Driver> drivers;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private BTMS()
  {
    currentDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    buses = new ArrayList<Bus>();
    morningRouteWorkShifts = new ArrayList<MorningRouteWorkShift>();
    afternoonRouteWorkShifts = new ArrayList<AfternoonRouteWorkShift>();
    nightRouteWorkShifts = new ArrayList<NightRouteWorkShift>();
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

  public static int minimumNumberOfMorningRouteWorkShifts()
  {
    return 0;
  }

  public MorningRouteWorkShift addMorningRouteWorkShift(int aRouteNumber, Date aWorkDate)
  {
    return new MorningRouteWorkShift(aRouteNumber, aWorkDate, this);
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

  public AfternoonRouteWorkShift addAfternoonRouteWorkShift(int aRouteNumber, Date aWorkDate)
  {
    return new AfternoonRouteWorkShift(aRouteNumber, aWorkDate, this);
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

  public NightRouteWorkShift addNightRouteWorkShift(int aRouteNumber, Date aWorkDate)
  {
    return new NightRouteWorkShift(aRouteNumber, aWorkDate, this);
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
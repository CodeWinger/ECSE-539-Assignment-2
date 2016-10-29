/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.util.*;

// line 87 "../../../../../model.ump"
public abstract class Shift
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Shift Associations
  private List<Driver> drivers;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Shift()
  {
    drivers = new ArrayList<Driver>();
  }

  //------------------------
  // INTERFACE
  //------------------------

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

  public boolean isNumberOfDriversValid()
  {
    boolean isValid = numberOfDrivers() >= minimumNumberOfDrivers() && numberOfDrivers() <= maximumNumberOfDrivers();
    return isValid;
  }

  public static int minimumNumberOfDrivers()
  {
    return 1;
  }

  public static int maximumNumberOfDrivers()
  {
    return 3;
  }

  public Driver addDriver(String aName, BTMS aBTMS, Bus aBus)
  {
    if (numberOfDrivers() >= maximumNumberOfDrivers())
    {
      return null;
    }
    else
    {
      return new Driver(aName, aBTMS, aBus, this);
    }
  }

  public boolean addDriver(Driver aDriver)
  {
    boolean wasAdded = false;
    if (drivers.contains(aDriver)) { return false; }
    if (drivers.contains(aDriver)) { return false; }
    if (drivers.contains(aDriver)) { return false; }
    if (drivers.contains(aDriver)) { return false; }
    if (numberOfDrivers() >= maximumNumberOfDrivers())
    {
      return wasAdded;
    }

    Shift existingShift = aDriver.getShift();
    boolean isNewShift = existingShift != null && !this.equals(existingShift);

    if (isNewShift && existingShift.numberOfDrivers() <= minimumNumberOfDrivers())
    {
      return wasAdded;
    }

    if (isNewShift)
    {
      aDriver.setShift(this);
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
    //Unable to remove aDriver, as it must always have a shift
    if (this.equals(aDriver.getShift()))
    {
      return wasRemoved;
    }

    //shift already at minimum (1)
    if (numberOfDrivers() <= minimumNumberOfDrivers())
    {
      return wasRemoved;
    }
    drivers.remove(aDriver);
    wasRemoved = true;
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
    for(int i=drivers.size(); i > 0; i--)
    {
      Driver aDriver = drivers.get(i - 1);
      aDriver.delete();
    }
  }

}
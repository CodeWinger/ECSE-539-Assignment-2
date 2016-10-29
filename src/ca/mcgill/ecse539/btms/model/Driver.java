/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.util.*;

// line 78 "../../../../../model.ump"
public class Driver
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextId = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Driver Attributes
  private String name;
  private boolean isSick;

  //Autounique Attributes
  private int id;

  //Driver Associations
  private BTMS bTMS;
  private Bus bus;
  private Shift shift;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetBus;
  private boolean canSetShift;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Driver(String aName, BTMS aBTMS, Bus aBus, Shift aShift)
  {
    cachedHashCode = -1;
    canSetBus = true;
    canSetShift = true;
    name = aName;
    isSick = false;
    id = nextId++;
    boolean didAddBTMS = setBTMS(aBTMS);
    if (!didAddBTMS)
    {
      throw new RuntimeException("Unable to create driver due to bTMS");
    }
    if (aBus == null || aBus.getDriver() != null)
    {
      throw new RuntimeException("Unable to create Driver due to aBus");
    }
    bus = aBus;
    boolean didAddShift = setShift(aShift);
    if (!didAddShift)
    {
      throw new RuntimeException("Unable to create driver due to shift");
    }
  }

  public Driver(String aName, BTMS aBTMS, String aLicensePlateForBus, Route aRouteForBus, BTMS aBTMSForBus, Shift aShift)
  {
    name = aName;
    isSick = false;
    id = nextId++;
    boolean didAddBTMS = setBTMS(aBTMS);
    if (!didAddBTMS)
    {
      throw new RuntimeException("Unable to create driver due to bTMS");
    }
    bus = new Bus(aLicensePlateForBus, aRouteForBus, aBTMSForBus, this);
    boolean didAddShift = setShift(aShift);
    if (!didAddShift)
    {
      throw new RuntimeException("Unable to create driver due to shift");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsSick(boolean aIsSick)
  {
    boolean wasSet = false;
    isSick = aIsSick;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public boolean getIsSick()
  {
    return isSick;
  }

  public int getId()
  {
    return id;
  }

  public boolean isIsSick()
  {
    return isSick;
  }

  public BTMS getBTMS()
  {
    return bTMS;
  }

  public Bus getBus()
  {
    return bus;
  }

  public Shift getShift()
  {
    return shift;
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
      existingBTMS.removeDriver(this);
    }
    if (!bTMS.addDriver(this))
    {
      bTMS = existingBTMS;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setShift(Shift aShift)
  {
    boolean wasSet = false;
    if (!canSetShift) { return false; }
    //Must provide shift to driver
    if (aShift == null)
    {
      return wasSet;
    }

    //shift already at maximum (3)
    if (aShift.numberOfDrivers() >= Shift.maximumNumberOfDrivers())
    {
      return wasSet;
    }
    
    Shift existingShift = shift;
    shift = aShift;
    if (existingShift != null && !existingShift.equals(aShift))
    {
      boolean didRemove = existingShift.removeDriver(this);
      if (!didRemove)
      {
        shift = existingShift;
        return wasSet;
      }
    }
    shift.addDriver(this);
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Driver compareTo = (Driver)obj;
  
    if (bus == null && compareTo.bus != null)
    {
      return false;
    }
    else if (bus != null && !bus.equals(compareTo.bus))
    {
      return false;
    }

    if (shift == null && compareTo.shift != null)
    {
      return false;
    }
    else if (shift != null && !shift.equals(compareTo.shift))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (bus != null)
    {
      cachedHashCode = cachedHashCode * 23 + bus.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }
    if (shift != null)
    {
      cachedHashCode = cachedHashCode * 23 + shift.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetBus = false;
    canSetShift = false;
    return cachedHashCode;
  }

  public void delete()
  {
    BTMS placeholderBTMS = bTMS;
    this.bTMS = null;
    placeholderBTMS.removeDriver(this);
    Bus existingBus = bus;
    bus = null;
    if (existingBus != null)
    {
      existingBus.delete();
    }
    Shift placeholderShift = shift;
    this.shift = null;
    placeholderShift.removeDriver(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "name" + ":" + getName()+ "," +
            "isSick" + ":" + getIsSick()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "bTMS = "+(getBTMS()!=null?Integer.toHexString(System.identityHashCode(getBTMS())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "bus = "+(getBus()!=null?Integer.toHexString(System.identityHashCode(getBus())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "shift = "+(getShift()!=null?Integer.toHexString(System.identityHashCode(getShift())):"null")
     + outputString;
  }
}
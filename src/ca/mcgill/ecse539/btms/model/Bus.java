/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.util.*;

// line 15 "../../../../../model.ump"
public class Bus
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, Bus> bussByLicensePlate = new HashMap<String, Bus>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Bus Attributes
  private String licensePlate;

  //Bus State Machines
  enum Sm { notBroken, broken }
  enum SmNotBroken { Null, day000, day001, day010, day011, day100, day101, day110, day111 }
  private Sm sm;
  private SmNotBroken smNotBroken;

  //Bus Associations
  private Route route;
  private BTMS bTMS;
  private Driver driver;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Bus(String aLicensePlate, Route aRoute, BTMS aBTMS, Driver aDriver)
  {
    if (!setLicensePlate(aLicensePlate))
    {
      throw new RuntimeException("Cannot create due to duplicate licensePlate");
    }
    boolean didAddRoute = setRoute(aRoute);
    if (!didAddRoute)
    {
      throw new RuntimeException("Unable to create bus due to route");
    }
    boolean didAddBTMS = setBTMS(aBTMS);
    if (!didAddBTMS)
    {
      throw new RuntimeException("Unable to create bus due to bTMS");
    }
    if (aDriver == null || aDriver.getBus() != null)
    {
      throw new RuntimeException("Unable to create Bus due to aDriver");
    }
    driver = aDriver;
    setSmNotBroken(SmNotBroken.Null);
    setSm(Sm.notBroken);
  }

  public Bus(String aLicensePlate, Route aRoute, BTMS aBTMS, String aNameForDriver, BTMS aBTMSForDriver, Shift aShiftForDriver)
  {
    licensePlate = aLicensePlate;
    boolean didAddRoute = setRoute(aRoute);
    if (!didAddRoute)
    {
      throw new RuntimeException("Unable to create bus due to route");
    }
    boolean didAddBTMS = setBTMS(aBTMS);
    if (!didAddBTMS)
    {
      throw new RuntimeException("Unable to create bus due to bTMS");
    }
    driver = new Driver(aNameForDriver, aBTMSForDriver, this, aShiftForDriver);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLicensePlate(String aLicensePlate)
  {
    boolean wasSet = false;
    String anOldLicensePlate = getLicensePlate();
    if (hasWithLicensePlate(aLicensePlate)) {
      return wasSet;
    }
    licensePlate = aLicensePlate;
    wasSet = true;
    if (anOldLicensePlate != null) {
      bussByLicensePlate.remove(anOldLicensePlate);
    }
    bussByLicensePlate.put(aLicensePlate, this);
    return wasSet;
  }

  public String getLicensePlate()
  {
    return licensePlate;
  }

  public static Bus getWithLicensePlate(String aLicensePlate)
  {
    return bussByLicensePlate.get(aLicensePlate);
  }

  public static boolean hasWithLicensePlate(String aLicensePlate)
  {
    return getWithLicensePlate(aLicensePlate) != null;
  }

  public String getSmFullName()
  {
    String answer = sm.toString();
    if (smNotBroken != SmNotBroken.Null) { answer += "." + smNotBroken.toString(); }
    return answer;
  }

  public Sm getSm()
  {
    return sm;
  }

  public SmNotBroken getSmNotBroken()
  {
    return smNotBroken;
  }

  public boolean breakDown()
  {
    boolean wasEventProcessed = false;
    
    Sm aSm = sm;
    switch (aSm)
    {
      case notBroken:
        exitSm();
        setSm(Sm.broken);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean enterNotBroken()
  {
    boolean wasEventProcessed = false;
    
    SmNotBroken aSmNotBroken = smNotBroken;
    switch (aSmNotBroken)
    {
      case Null:
        setSmNotBroken(SmNotBroken.day000);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean exitNotBroken()
  {
    boolean wasEventProcessed = false;
    
    SmNotBroken aSmNotBroken = smNotBroken;
    switch (aSmNotBroken)
    {
      case day000:
        setSmNotBroken(SmNotBroken.Null);
        wasEventProcessed = true;
        break;
      case day001:
        setSmNotBroken(SmNotBroken.Null);
        wasEventProcessed = true;
        break;
      case day010:
        setSmNotBroken(SmNotBroken.Null);
        wasEventProcessed = true;
        break;
      case day011:
        setSmNotBroken(SmNotBroken.Null);
        wasEventProcessed = true;
        break;
      case day100:
        setSmNotBroken(SmNotBroken.Null);
        wasEventProcessed = true;
        break;
      case day101:
        setSmNotBroken(SmNotBroken.Null);
        wasEventProcessed = true;
        break;
      case day110:
        setSmNotBroken(SmNotBroken.Null);
        wasEventProcessed = true;
        break;
      case day111:
        setSmNotBroken(SmNotBroken.Null);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean assignDay0()
  {
    boolean wasEventProcessed = false;
    
    SmNotBroken aSmNotBroken = smNotBroken;
    switch (aSmNotBroken)
    {
      case day000:
        setSmNotBroken(SmNotBroken.day100);
        wasEventProcessed = true;
        break;
      case day001:
        setSmNotBroken(SmNotBroken.day101);
        wasEventProcessed = true;
        break;
      case day010:
        setSmNotBroken(SmNotBroken.day110);
        wasEventProcessed = true;
        break;
      case day011:
        setSmNotBroken(SmNotBroken.day111);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean assignDay1()
  {
    boolean wasEventProcessed = false;
    
    SmNotBroken aSmNotBroken = smNotBroken;
    switch (aSmNotBroken)
    {
      case day000:
        setSmNotBroken(SmNotBroken.day010);
        wasEventProcessed = true;
        break;
      case day001:
        setSmNotBroken(SmNotBroken.day011);
        wasEventProcessed = true;
        break;
      case day100:
        setSmNotBroken(SmNotBroken.day110);
        wasEventProcessed = true;
        break;
      case day101:
        setSmNotBroken(SmNotBroken.day111);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean assignDay2()
  {
    boolean wasEventProcessed = false;
    
    SmNotBroken aSmNotBroken = smNotBroken;
    switch (aSmNotBroken)
    {
      case day000:
        setSmNotBroken(SmNotBroken.day001);
        wasEventProcessed = true;
        break;
      case day010:
        setSmNotBroken(SmNotBroken.day011);
        wasEventProcessed = true;
        break;
      case day100:
        setSmNotBroken(SmNotBroken.day101);
        wasEventProcessed = true;
        break;
      case day110:
        setSmNotBroken(SmNotBroken.day111);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitSm()
  {
    switch(sm)
    {
      case notBroken:
        exitNotBroken();
        break;
    }
  }

  private void setSm(Sm aSm)
  {
    sm = aSm;

    // entry actions and do activities
    switch(sm)
    {
      case notBroken:
        if (smNotBroken == SmNotBroken.Null) { setSmNotBroken(SmNotBroken.day000); }
        break;
    }
  }

  private void setSmNotBroken(SmNotBroken aSmNotBroken)
  {
    smNotBroken = aSmNotBroken;
    if (sm != Sm.notBroken && aSmNotBroken != SmNotBroken.Null) { setSm(Sm.notBroken); }
  }

  public Route getRoute()
  {
    return route;
  }

  public BTMS getBTMS()
  {
    return bTMS;
  }

  public Driver getDriver()
  {
    return driver;
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
      existingRoute.removeBus(this);
    }
    route.addBus(this);
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
      existingBTMS.removeBus(this);
    }
    bTMS.addBus(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    bussByLicensePlate.remove(getLicensePlate());
    Route placeholderRoute = route;
    this.route = null;
    placeholderRoute.removeBus(this);
    BTMS placeholderBTMS = bTMS;
    this.bTMS = null;
    placeholderBTMS.removeBus(this);
    Driver existingDriver = driver;
    driver = null;
    if (existingDriver != null)
    {
      existingDriver.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "licensePlate" + ":" + getLicensePlate()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "route = "+(getRoute()!=null?Integer.toHexString(System.identityHashCode(getRoute())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "bTMS = "+(getBTMS()!=null?Integer.toHexString(System.identityHashCode(getBTMS())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "driver = "+(getDriver()!=null?Integer.toHexString(System.identityHashCode(getDriver())):"null")
     + outputString;
  }
}
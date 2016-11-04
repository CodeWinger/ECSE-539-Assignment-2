/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.util.*;

// line 82 "../../../../../model.ump"
public class Route
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<Integer, Route> routesByRouteNumber = new HashMap<Integer, Route>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Route Attributes
  private int routeNumber;

  //Route Associations
  private BTMS bTMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Route(int aRouteNumber, BTMS aBTMS)
  {
    if (!setRouteNumber(aRouteNumber))
    {
      throw new RuntimeException("Cannot create due to duplicate routeNumber");
    }
    boolean didAddBTMS = setBTMS(aBTMS);
    if (!didAddBTMS)
    {
      throw new RuntimeException("Unable to create route due to bTMS");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRouteNumber(int aRouteNumber)
  {
    boolean wasSet = false;
    Integer anOldRouteNumber = getRouteNumber();
    if (hasWithRouteNumber(aRouteNumber)) {
      return wasSet;
    }
    routeNumber = aRouteNumber;
    wasSet = true;
    if (anOldRouteNumber != null) {
      routesByRouteNumber.remove(anOldRouteNumber);
    }
    routesByRouteNumber.put(aRouteNumber, this);
    return wasSet;
  }

  public int getRouteNumber()
  {
    return routeNumber;
  }

  public static Route getWithRouteNumber(int aRouteNumber)
  {
    return routesByRouteNumber.get(aRouteNumber);
  }

  public static boolean hasWithRouteNumber(int aRouteNumber)
  {
    return getWithRouteNumber(aRouteNumber) != null;
  }

  public BTMS getBTMS()
  {
    return bTMS;
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
      existingBTMS.removeRoute(this);
    }
    bTMS.addRoute(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    routesByRouteNumber.remove(getRouteNumber());
    BTMS placeholderBTMS = bTMS;
    this.bTMS = null;
    placeholderBTMS.removeRoute(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "routeNumber" + ":" + getRouteNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "bTMS = "+(getBTMS()!=null?Integer.toHexString(System.identityHashCode(getBTMS())):"null")
     + outputString;
  }
}
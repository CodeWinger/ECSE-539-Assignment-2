/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.sql.Date;
import java.util.*;

// line 112 "../../../../../model.ump"
public class NightRouteWorkShift extends RouteWorkShift
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<Date, NightRouteWorkShift> nightrouteworkshiftsByWorkDate = new HashMap<Date, NightRouteWorkShift>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //NightRouteWorkShift Attributes
  private Date workDate;
  private String shiftName;

  //NightRouteWorkShift Associations
  private BTMS bTMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public NightRouteWorkShift(Date aWorkDate, BTMS aBTMS)
  {
    super();
    shiftName = "Night";
    if (!setWorkDate(aWorkDate))
    {
      throw new RuntimeException("Cannot create due to duplicate workDate");
    }
    boolean didAddBTMS = setBTMS(aBTMS);
    if (!didAddBTMS)
    {
      throw new RuntimeException("Unable to create nightRouteWorkShift due to bTMS");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setWorkDate(Date aWorkDate)
  {
    boolean wasSet = false;
    Date anOldWorkDate = getWorkDate();
    if (hasWithWorkDate(aWorkDate)) {
      return wasSet;
    }
    workDate = aWorkDate;
    wasSet = true;
    if (anOldWorkDate != null) {
      nightrouteworkshiftsByWorkDate.remove(anOldWorkDate);
    }
    nightrouteworkshiftsByWorkDate.put(aWorkDate, this);
    return wasSet;
  }

  public Date getWorkDate()
  {
    return workDate;
  }

  public static NightRouteWorkShift getWithWorkDate(Date aWorkDate)
  {
    return nightrouteworkshiftsByWorkDate.get(aWorkDate);
  }

  public static boolean hasWithWorkDate(Date aWorkDate)
  {
    return getWithWorkDate(aWorkDate) != null;
  }

  public String getShiftName()
  {
    return shiftName;
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
      existingBTMS.removeNightRouteWorkShift(this);
    }
    bTMS.addNightRouteWorkShift(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    nightrouteworkshiftsByWorkDate.remove(getWorkDate());
    BTMS placeholderBTMS = bTMS;
    this.bTMS = null;
    placeholderBTMS.removeNightRouteWorkShift(this);
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "shiftName" + ":" + getShiftName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "workDate" + "=" + (getWorkDate() != null ? !getWorkDate().equals(this)  ? getWorkDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "bTMS = "+(getBTMS()!=null?Integer.toHexString(System.identityHashCode(getBTMS())):"null")
     + outputString;
  }
}
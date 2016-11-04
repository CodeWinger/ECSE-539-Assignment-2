/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.sql.Date;
import java.util.*;

// line 114 "../../../../../model.ump"
public class AfternoonRouteWorkShift extends RouteWorkShift
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<Date, AfternoonRouteWorkShift> afternoonrouteworkshiftsByWorkDate = new HashMap<Date, AfternoonRouteWorkShift>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AfternoonRouteWorkShift Attributes
  private Date workDate;
  private String shiftName;

  //AfternoonRouteWorkShift Associations
  private BTMS bTMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AfternoonRouteWorkShift(Route aRoute, Date aWorkDate, BTMS aBTMS)
  {
    super(aRoute);
    shiftName = "Afternoon";
    if (!setWorkDate(aWorkDate))
    {
      throw new RuntimeException("Cannot create due to duplicate workDate");
    }
    boolean didAddBTMS = setBTMS(aBTMS);
    if (!didAddBTMS)
    {
      throw new RuntimeException("Unable to create afternoonRouteWorkShift due to bTMS");
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
      afternoonrouteworkshiftsByWorkDate.remove(anOldWorkDate);
    }
    afternoonrouteworkshiftsByWorkDate.put(aWorkDate, this);
    return wasSet;
  }

  public Date getWorkDate()
  {
    return workDate;
  }

  public static AfternoonRouteWorkShift getWithWorkDate(Date aWorkDate)
  {
    return afternoonrouteworkshiftsByWorkDate.get(aWorkDate);
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
      existingBTMS.removeAfternoonRouteWorkShift(this);
    }
    bTMS.addAfternoonRouteWorkShift(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    afternoonrouteworkshiftsByWorkDate.remove(getWorkDate());
    BTMS placeholderBTMS = bTMS;
    this.bTMS = null;
    placeholderBTMS.removeAfternoonRouteWorkShift(this);
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
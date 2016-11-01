/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.sql.Date;
import java.util.*;

// line 57 "../../../../../model.ump"
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

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public NightRouteWorkShift(int aRouteNumber, Date aWorkDate)
  {
    super(aRouteNumber);
    shiftName = "Night";
    if (!setWorkDate(aWorkDate))
    {
      throw new RuntimeException("Cannot create due to duplicate workDate");
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

  public void delete()
  {
    nightrouteworkshiftsByWorkDate.remove(getWorkDate());
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "shiftName" + ":" + getShiftName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "workDate" + "=" + (getWorkDate() != null ? !getWorkDate().equals(this)  ? getWorkDate().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.sql.Date;
import java.util.*;

// line 50 "../../../../../model.ump"
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

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AfternoonRouteWorkShift(int aRouteNumber, Date aWorkDate)
  {
    super(aRouteNumber);
    shiftName = "Afternoon";
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

  public void delete()
  {
    afternoonrouteworkshiftsByWorkDate.remove(getWorkDate());
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
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.sql.Date;
import java.util.*;

// line 43 "../../../../../model.ump"
public class MorningRouteWorkShift extends RouteWorkShift
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<Date, MorningRouteWorkShift> morningrouteworkshiftsByWorkDate = new HashMap<Date, MorningRouteWorkShift>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MorningRouteWorkShift Attributes
  private Date workDate;
  private String shiftName;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MorningRouteWorkShift(int aRouteNumber, Date aWorkDate)
  {
    super(aRouteNumber);
    shiftName = "Morning";
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
      morningrouteworkshiftsByWorkDate.remove(anOldWorkDate);
    }
    morningrouteworkshiftsByWorkDate.put(aWorkDate, this);
    return wasSet;
  }

  public Date getWorkDate()
  {
    return workDate;
  }

  public static MorningRouteWorkShift getWithWorkDate(Date aWorkDate)
  {
    return morningrouteworkshiftsByWorkDate.get(aWorkDate);
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
    morningrouteworkshiftsByWorkDate.remove(getWorkDate());
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
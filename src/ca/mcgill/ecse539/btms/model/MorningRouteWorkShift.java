/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-dab6b48 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.sql.Date;
import java.util.*;

// line 44 "../../../../../model.ump"
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

  //MorningRouteWorkShift Associations
  private BTMS bTMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MorningRouteWorkShift(int aRouteNumber, Date aWorkDate, BTMS aBTMS)
  {
    super(aRouteNumber);
    shiftName = "Morning";
    if (!setWorkDate(aWorkDate))
    {
      throw new RuntimeException("Cannot create due to duplicate workDate");
    }
    boolean didAddBTMS = setBTMS(aBTMS);
    if (!didAddBTMS)
    {
      throw new RuntimeException("Unable to create morningRouteWorkShift due to bTMS");
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
      existingBTMS.removeMorningRouteWorkShift(this);
    }
    bTMS.addMorningRouteWorkShift(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    morningrouteworkshiftsByWorkDate.remove(getWorkDate());
    BTMS placeholderBTMS = bTMS;
    this.bTMS = null;
    placeholderBTMS.removeMorningRouteWorkShift(this);
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
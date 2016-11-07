/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.util.*;

// line 63 "../../../../../model.ump"
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

  //Autounique Attributes
  private int id;

  //Driver State Machines
  enum WorkStatus { CAN_WORK, SICK }
  private WorkStatus workStatus;

  //Driver Associations
  private BTMS bTMS;
  private List<RouteWorkShift> routeWorkShifts;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Driver(String aName, BTMS aBTMS)
  {
    name = aName;
    id = nextId++;
    boolean didAddBTMS = setBTMS(aBTMS);
    if (!didAddBTMS)
    {
      throw new RuntimeException("Unable to create driver due to bTMS");
    }
    routeWorkShifts = new ArrayList<RouteWorkShift>();
    setWorkStatus(WorkStatus.CAN_WORK);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getName()
  {
    return name;
  }

  public int getId()
  {
    return id;
  }

  public String getWorkStatusFullName()
  {
    String answer = workStatus.toString();
    return answer;
  }

  public WorkStatus getWorkStatus()
  {
    return workStatus;
  }

  public boolean driverStrickenWithIllness()
  {
    boolean wasEventProcessed = false;
    
    WorkStatus aWorkStatus = workStatus;
    switch (aWorkStatus)
    {
      case CAN_WORK:
        setWorkStatus(WorkStatus.SICK);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean driverFeelsBetter()
  {
    boolean wasEventProcessed = false;
    
    WorkStatus aWorkStatus = workStatus;
    switch (aWorkStatus)
    {
      case SICK:
        setWorkStatus(WorkStatus.CAN_WORK);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setWorkStatus(WorkStatus aWorkStatus)
  {
    workStatus = aWorkStatus;
  }

  public BTMS getBTMS()
  {
    return bTMS;
  }

  public RouteWorkShift getRouteWorkShift(int index)
  {
    RouteWorkShift aRouteWorkShift = routeWorkShifts.get(index);
    return aRouteWorkShift;
  }

  public List<RouteWorkShift> getRouteWorkShifts()
  {
    List<RouteWorkShift> newRouteWorkShifts = Collections.unmodifiableList(routeWorkShifts);
    return newRouteWorkShifts;
  }

  public int numberOfRouteWorkShifts()
  {
    int number = routeWorkShifts.size();
    return number;
  }

  public boolean hasRouteWorkShifts()
  {
    boolean has = routeWorkShifts.size() > 0;
    return has;
  }

  public int indexOfRouteWorkShift(RouteWorkShift aRouteWorkShift)
  {
    int index = routeWorkShifts.indexOf(aRouteWorkShift);
    return index;
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
    bTMS.addDriver(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfRouteWorkShifts()
  {
    return 0;
  }

  public boolean addRouteWorkShift(RouteWorkShift aRouteWorkShift)
  {
    boolean wasAdded = false;
    if (routeWorkShifts.contains(aRouteWorkShift)) { return false; }
    routeWorkShifts.add(aRouteWorkShift);
    if (aRouteWorkShift.indexOfDriver(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aRouteWorkShift.addDriver(this);
      if (!wasAdded)
      {
        routeWorkShifts.remove(aRouteWorkShift);
      }
    }
    return wasAdded;
  }

  public boolean removeRouteWorkShift(RouteWorkShift aRouteWorkShift)
  {
    boolean wasRemoved = false;
    if (!routeWorkShifts.contains(aRouteWorkShift))
    {
      return wasRemoved;
    }

    int oldIndex = routeWorkShifts.indexOf(aRouteWorkShift);
    routeWorkShifts.remove(oldIndex);
    if (aRouteWorkShift.indexOfDriver(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aRouteWorkShift.removeDriver(this);
      if (!wasRemoved)
      {
        routeWorkShifts.add(oldIndex,aRouteWorkShift);
      }
    }
    return wasRemoved;
  }

  public boolean addRouteWorkShiftAt(RouteWorkShift aRouteWorkShift, int index)
  {  
    boolean wasAdded = false;
    if(addRouteWorkShift(aRouteWorkShift))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRouteWorkShifts()) { index = numberOfRouteWorkShifts() - 1; }
      routeWorkShifts.remove(aRouteWorkShift);
      routeWorkShifts.add(index, aRouteWorkShift);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRouteWorkShiftAt(RouteWorkShift aRouteWorkShift, int index)
  {
    boolean wasAdded = false;
    if(routeWorkShifts.contains(aRouteWorkShift))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRouteWorkShifts()) { index = numberOfRouteWorkShifts() - 1; }
      routeWorkShifts.remove(aRouteWorkShift);
      routeWorkShifts.add(index, aRouteWorkShift);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRouteWorkShiftAt(aRouteWorkShift, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    BTMS placeholderBTMS = bTMS;
    this.bTMS = null;
    placeholderBTMS.removeDriver(this);
    ArrayList<RouteWorkShift> copyOfRouteWorkShifts = new ArrayList<RouteWorkShift>(routeWorkShifts);
    routeWorkShifts.clear();
    for(RouteWorkShift aRouteWorkShift : copyOfRouteWorkShifts)
    {
      aRouteWorkShift.removeDriver(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "bTMS = "+(getBTMS()!=null?Integer.toHexString(System.identityHashCode(getBTMS())):"null")
     + outputString;
  }
}
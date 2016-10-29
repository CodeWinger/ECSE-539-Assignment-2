/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.util.*;

/**
 * find way to make Shift contain name attribute
 */
// line 93 "../../../../../model.ump"
public class Morning extends Shift
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Morning theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Morning Attributes
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private Morning()
  {
    super();
    name = "Morning";
  }

  public static Morning getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new Morning();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getName()
  {
    return name;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.util.*;

// line 107 "../../../../../model.ump"
public class Night extends Shift
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Night theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Night Attributes
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private Night()
  {
    super();
    name = "Night";
  }

  public static Night getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new Night();
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
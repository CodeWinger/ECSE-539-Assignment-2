/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse539.btms.model;
import java.util.*;

// line 100 "../../../../../model.ump"
public class Afternoon extends Shift
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Afternoon theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Afternoon Attributes
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private Afternoon()
  {
    super();
    name = "Afternoon";
  }

  public static Afternoon getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new Afternoon();
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
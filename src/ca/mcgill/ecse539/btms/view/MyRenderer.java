package ca.mcgill.ecse539.btms.view;

import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;

public class MyRenderer
       extends DefaultTableCellRenderer {
  /**
	 * 
	 */
	private static final long serialVersionUID = -7630711650070684146L;

public Component getTableCellRendererComponent(JTable table,
                                                 Object value,
                                                 boolean isSelected,
                                                 boolean hasFocus,
                                                 int row,
                                                 int column) {
    Component c = 
      super.getTableCellRendererComponent(table, value,
                                          isSelected, hasFocus,
                                          row, column);

    // Only for specific cell
    if (row == 0 && column == 0) {
       //c.setFont(/* special font*/);
       // you may want to address isSelected here too
    	System.out.println("Here!!!!");
       c.setForeground(new Color(236, 236, 236));
       c.setBackground(Color.RED);
    }
    return c;
  }
}
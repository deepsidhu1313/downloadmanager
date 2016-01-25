import java.awt.Checkbox;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.text.*;
// This class manages the download table's data.
class sdtm extends AbstractTableModel
implements Observer {
// These are the names for the table's columns.
private static final String[] columnNames = {"File Name","Status","Size","Downloaded"};
// These are the classes for each column's values.
private static final Class[] columnClasses = {String.class,String.class,String.class,String.class,};
// The table's list of downloads.
private ArrayList  queList = new ArrayList  ();
// Add a new download to the table.






public void addDownload(graph download) {
// Register to be notified when the download changes.
download.addObserver(this);
queList.add(download);
// Fire table row insertion notification to table.
fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
}
/*public void setValueAt(String value, int row, int col) {  
                System.out.println("Setting value at " + row + "," + col  
                                   + " to " + value  
                                   + " (an instance of "   
                                   + value.getClass() + ")");  
            if(col==1)
            downloadList.add(col, (String)value);
            fireTableCellUpdated(row, col);  
                System.out.println("New value of data:");  
              
        }*/

/*public void addDownload(graphmain2 readfile){
 
    
    
    downloadList.add(readfile);
  fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);  
}
/*public void addDow?load(String str, int col) {
// Register to be notified when the download changes.
//v.addObserver(this);
    String temp[] = str.split("&&@", 6);
    for(int i=0;i<temp.length;i++)
    {
        if(i==2){
            JProgressBar jp1 = new JProgressBar(0, 100);
            jp1.setValue(Integer.parseInt(temp[i]));
        graphmain2.tableModel.setValueAt(jp1, i, col);
                }
        else 
        graphmain2.tableModel.setValueAt(temp[i].toString(), i, col);
    }
    
    
    
// Fire table row insertion notification to table.
fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
}*/

// Get a download for the specified row.
public graph getDownload(int row) {
return (graph) queList.get(row);
}
// Remove a download from the list.
public void clearDownload(int row) {
queList.remove(row);
// Fire table row deletion notification to table.
fireTableRowsDeleted(row, row);
}
// Get table's column count.
public int getColumnCount() {
return columnNames.length;
}
// Get a column's name.
public String getColumnName(int col) {
return columnNames[col];
}
// Get a column's class.
public Class getColumnClass(int col) {
return columnClasses[col];
}
// Get table's row count.
public int getRowCount() {
return queList.size();
}
// Get value for a specific row and column combination.
public Object getValueAt(int row, int col) {
graph download = (graph) queList.get(row);

switch (col) {

    
    
case 0://File NAme
return download.getFileName();
case 1: // Status
return graph.STATUSES[download.getStatus()];
case 2:
    return download.getSize();
//return (size == -1) ? "" : Integer.toString(size);
case 3: // Size
//float size = download.getSize();
    return download.getdownloaded();
//return (size == -1) ? "" : Integer.toString(size);

}
return "";
}

public void update(Observable o, Object arg) {
int index = queList.indexOf(o);
// Fire table row update notification to table.
fireTableRowsUpdated(index, index);
}
}

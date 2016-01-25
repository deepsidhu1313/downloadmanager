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
class DownloadsTableModel extends AbstractTableModel
implements Observer {
// These are the names for the table's columns.
private static final String[] columnNames = {"File Name","Status","Q","Progress","Size","Downloaded","Url","Save To","Added On","Thread Name","CMD string","Frame Status","Times","Button Count","File Path","Last Try On"};
// These are the classes for each column's values.
private static final Class[] columnClasses = {String.class,String.class,JCheckBox.class,JProgressBar.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,
    Integer.class,Integer.class,Integer.class,
String.class,String.class};
// The table's list of downloads.
private ArrayList  downloadList = new ArrayList  ();
// Add a new download to the table.






public void addDownload(graph download) {
// Register to be notified when the download changes.
download.addObserver(this);
downloadList.add(download);
// Fire table row insertion notification to table.
fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
}


// Get a download for the specified row.
public graph getDownload(int row) {
return (graph) downloadList.get(row);
}
// Remove a download from the list.
public void clearDownload(int row) {
downloadList.remove(row);
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
return downloadList.size();
}



public boolean isCellEditable(int row, int col)
{
return false;
}



// Get value for a specific row and column combination.
public Object getValueAt(int row, int col) {
graph download = (graph) downloadList.get(row);

switch (col) {

    
    
case 0://File NAme
return download.getFileName();
case 1: // Status
return graph.STATUSES[download.getStatus()];
case 2:
return download.getquestatus();
case 3: // Progress
return new Float(download.getProgress());
case 4: // Size
//float size = download.getSize();
    return download.getSize();
//return (size == -1) ? "" : Integer.toString(size);
case 5: // Size
//float size = download.getSize();
    return download.getdownloaded();
//return (size == -1) ? "" : Integer.toString(size);


case 6: // URL
return download.getUrl();
case 7:
    return download.getdirloc();
case 8:
return download.getAddtime();
case 9:
return download.getthreadname();
case 10:
return download.getcmdstring();
case 11:
return download.getframestatus();
case 12:
    return download.gettimes();
case 13:
    return download.getbuttoncount();
case 14:
    return download.getfilepath();
case 15:
return download.gettrytime();
     
}
return "";
}

public void update(Observable o, Object arg) {
int index = downloadList.indexOf(o);
// Fire table row update notification to table.
fireTableRowsUpdated(index, index);
}
}



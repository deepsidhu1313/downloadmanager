import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

public class TableSelectionTest extends JFrame implements
ListSelectionListener {
private final int COLUMN_COUNT = 5;
private TblModel model;
public TableSelectionTest() {
initialize();
setDefaultCloseOperation(EXIT_ON_CLOSE);
pack();
}
private void initialize() {
List data = new ArrayList();
for (int i = 0; i < 10; i++) {
Object record[] = new Object[COLUMN_COUNT];
record[0] = Boolean.FALSE;
for (int j = 1; j < COLUMN_COUNT; j++) {
record[j] = new Integer(j);
}
data.add(record);
}
model = new TblModel(data);
JTable table = new JTable(model);
table.getSelectionModel().setSelectionMode(
ListSelectionModel.SINGLE_SELECTION);
table.getSelectionModel().addListSelectionListener (this);
JScrollPane scroll = new JScrollPane(table);
getContentPane().add(scroll, BorderLayout.CENTER);
}
public static void main(String[] args) {
TableSelectionTest f = new TableSelectionTest();
f.show();
}
class TblModel extends AbstractTableModel {

private List data;
public TblModel(List data) {
this.data = data;
}
public int getColumnCount() {
return COLUMN_COUNT;
}
public int getRowCount() {
return data == null ? 0 : data.size();
}
public void setValueAt(Object value, int rowIndex, int columnIndex) {
getRecord(rowIndex)[columnIndex] = value;
super.fireTableCellUpdated(rowIndex, columnIndex);
}
public Object getValueAt(int rowIndex, int columnIndex) {
return getRecord(rowIndex)[columnIndex];
}
public boolean isCellEditable(int rowIndex, int columnIndex) {
return true;
}
public Class getColumnClass(int columnIndex) {
if (data == null || data.size() == 0) {
return Object.class;
}
Object o = getValueAt(0, columnIndex);
return o == null ? Object.class : o.getClass();
}
private Object[] getRecord(int rowIndex) {
return (Object[]) data.get(rowIndex);
}
}
public void valueChanged(ListSelectionEvent e) {
if (e.getValueIsAdjusting()) {
int index = e.getFirstIndex();
model.setValueAt(Boolean.TRUE, index, 0);
}
}}
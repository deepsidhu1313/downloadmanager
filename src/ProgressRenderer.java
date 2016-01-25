import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
// This class renders a JProgressBar in a table cell.
class ProgressRenderer extends JProgressBar
implements TableCellRenderer {
// Constructor for ProgressRenderer.
public ProgressRenderer(int min, int max) {
super(min, max);
}
/* Returns this JProgressBar as the renderer
for the given table cell. */
public Component getTableCellRendererComponent(
JTable table, Object value, boolean isSelected,
boolean hasFocus, int row, int column) {
// Set JProgressBar's percent complete value.
setValue((int) ((Float) value).floatValue());
return this;
}
}
class CheckboxRenderer extends JCheckBox 
implements TableCellRenderer {
// Constructor for ProgressRenderer.
public CheckboxRenderer(boolean value) {
super("", value);
}
/* Returns this JProgressBar as the renderer
for the given table cell. */
public Component getTableCellRendererComponent(
JTable table, Object value, boolean isSelected,
boolean hasFocus, int row, int columnI) {
// Set JProgressBar's percent complete value.
    if(super.isSelected()==true)
    {
        super.setSelected(false);
    }
    else //if (super.isSelected()==false)
    {super.setSelected(true);}
return this;
}
}
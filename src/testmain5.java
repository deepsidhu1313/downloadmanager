
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.io.BufferedReader;
import java.io.*;
import java.util.Observer;
import java.io.InputStreamReader;
import javax.swing.border.*;
import java.awt.List;
import java.awt.peer.SystemTrayPeer;
import java.awt.peer.TrayIconPeer;
import java.util.Vector;
import java.awt.peer.*;
import java.net.URL;
import java.util.Observable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.StyledEditorKit;

class PopupListener extends MouseAdapter {

    public void mousePressed(MouseEvent e) {
        showPopup(e);
    }

    public void mouseReleased(MouseEvent e) {
        showPopup(e);
    }

    private void showPopup(MouseEvent e) {
        if (e.isPopupTrigger()) {
            checkmain.jpop1.show(e.getComponent(), e.getX(), e.getY());
        }
    }
}

class checkmain {

    static JPopupMenu dpopup;
    static JPopupMenu jpop1;
    static String temp = "";
    static Process p, p2;
    static String str2;
    static Thread t1main, t2main, t3main, t4main;
    static int count = 0;
    static int buttoncount = 0;
    static JButton stopall = new JButton("Stop All");
    static JButton[] pausebutton = new JButton[400];
    static JButton[] resumebutton = new JButton[400];
    static JButton[] cancelbutton = new JButton[400];
    static int i;
    static JTable table1;
    static Boolean dtray;
    //static TrayIcon  trayIcon2;
    checkmain() {
    }
//static JTable table1= new JTable(new rw().createtable());
}

class graphmain2 extends JFrame implements ActionListener, Observer {

    
    JPopupMenu popup;
    private graph selectedDownload;
    TrayIcon trayIcon;
    static DownloadsTableModel tableModel;
    static JTable table;
    // Currently selected download.
// Flag for whether or not table selection is being cleared.
    private boolean clearing;
    JMenuBar mbar;
    JMenu file;
    JMenuItem n, e, c, r;
    Container con;
    JLabel l1;
    JMenuItem popi0, popi1, popi2, popi3, popi4, popi5, popi6;
    static float rprogress;
    static String str7, rfilename, rstatus, rfilesize, rurl, rsaveto, raddtime, rthreadname, rcmdstring, rframestatus, rtimes, rbuttoncount, rlasttrytime;
    JButton mainb1, resumeb, mainb3, bt, pauseb, mainb5, stopb, deleteb, deletecompleted, grabber;
    static ThreadGroup tdg;
    JButton stopall = new JButton("Stop All");

    graphmain2() {
        //super("Module main (Download Manager) Property OF TLC");
        l1 = new JLabel();
        mbar = new JMenuBar();
        file = new JMenu("File");


        tdg = new ThreadGroup("Downloads Thread Group");
        n = new JMenuItem("Add New");
        c = new JMenuItem("Resume");
        e = new JMenuItem("Exit");
        r = new JMenuItem("Pause");



        mainb1 = new JButton("Add");
        resumeb = new JButton("Resume");
        mainb3 = new JButton("Exit");
        pauseb = new JButton("Pause");
        stopb = new JButton("Stop");
        bt = new JButton("");
        mainb5 = new JButton("show");
        deleteb = new JButton("Delete");
        deletecompleted = new JButton("Delete Completed");
        grabber = new JButton("Grabber");

        checkmain.dtray = false;
        add(mainb1);
        add(resumeb);
        add(mainb3);
        add(pauseb);
        add(mainb5);
        add(stopall);
        add(deleteb);
        add(deletecompleted);
        add(grabber);

        file.add(n);
        file.addSeparator();
        file.add(c);
        file.addSeparator();
        file.add(r);
        file.addSeparator();
        add(l1);
        file.add(e);
        mbar.add(file);

        l1.setText(str7);


        pauseb.setEnabled(false);

        resumeb.setEnabled(false);
        l1.setBounds(380, 550, 300, 30);

        //jsp.setBounds(10,110,641,420);

        mainb1.setBounds(20, 30, 100, 30);
        resumeb.setBounds(190, 30, 100, 30);
        pauseb.setBounds(360, 30, 100, 30);
        mainb3.setBounds(530, 30, 100, 30);
        mainb5.setBounds(10, 550, 100, 30);
        stopall.setBounds(680, 30, 100, 30);
        deleteb.setBounds(800, 30, 100, 30);
        deletecompleted.setBounds(920, 30, 80, 30);
        grabber.setBounds(190, 65, 100, 30);
        setJMenuBar(mbar);
        setLayout(null);




        mainb1.addActionListener(this);
        resumeb.addActionListener(this);
        mainb3.addActionListener(this);
        pauseb.addActionListener(this);
        mainb5.addActionListener(this);
        stopall.addActionListener(this);
        deleteb.addActionListener(this);
        deletecompleted.addActionListener(this);
        grabber.addActionListener(this);



        e.addActionListener(this);
        n.addActionListener(this);
        c.addActionListener(this);
        r.addActionListener(this);




        tableModel = new DownloadsTableModel();
        table = new JTable(tableModel);
        table.setFont(new Font("BitStream Charter", Font.PLAIN, 16));
        table.setGridColor(Color.LIGHT_GRAY);
        readfile();



// Allow only one row at a time to be selected.
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
// Set up ProgressBar as renderer for progress column.
        final ProgressRenderer renderer = new ProgressRenderer(0, 100);
        renderer.setStringPainted(true); // show progress text
        table.setDefaultRenderer(JProgressBar.class, renderer);


        final CheckboxRenderer crenderer = new CheckboxRenderer(true);
        table.setDefaultRenderer(JCheckBox.class, crenderer);

        table.getColumnModel().getColumn(0).setPreferredWidth(250);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(300);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);
        table.getColumnModel().getColumn(5).setPreferredWidth(400);
        table.getColumnModel().getColumn(6).setPreferredWidth(400);
        table.getColumnModel().getColumn(7).setPreferredWidth(300);
        table.getColumnModel().getColumn(8).setPreferredWidth(300);
        table.getColumnModel().getColumn(15).setPreferredWidth(300);
        //table.getColumnModel().getColumn(5).setPreferredWidth(100);

        // table.getColumnModel().getColumn(8).setMaxWidth(0);
        //table.getColumnModel().getColumn(8).setMinWidth(0);
        //table.getColumnModel().getColumn(8).setPreferredWidth(0);

        table.getColumnModel().getColumn(9).setMaxWidth(0);
        table.getColumnModel().getColumn(9).setMinWidth(0);
        table.getColumnModel().getColumn(9).setPreferredWidth(0);

        table.getColumnModel().getColumn(10).setMaxWidth(0);
        table.getColumnModel().getColumn(10).setMinWidth(0);
        table.getColumnModel().getColumn(10).setPreferredWidth(0);

        table.getColumnModel().getColumn(11).setMaxWidth(0);
        table.getColumnModel().getColumn(11).setMinWidth(0);
        table.getColumnModel().getColumn(11).setPreferredWidth(0);

        table.getColumnModel().getColumn(12).setMaxWidth(0);
        table.getColumnModel().getColumn(12).setMinWidth(0);
        table.getColumnModel().getColumn(12).setPreferredWidth(0);

        table.getColumnModel().getColumn(13).setMaxWidth(0);
        table.getColumnModel().getColumn(13).setMinWidth(0);
        table.getColumnModel().getColumn(13).setPreferredWidth(0);

        table.getColumnModel().getColumn(14).setMaxWidth(0);
        table.getColumnModel().getColumn(14).setMinWidth(0);
        table.getColumnModel().getColumn(14).setPreferredWidth(0);



        //  tableModel.;

// Set table's row height large enough to fit JProgressBar.
        table.setRowHeight(
                (int) renderer.getPreferredSize().getHeight());


        int v1 = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h1 = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                tableSelectionChanged();
                //table.repaint();
                //renderer.repaint();
                int index= table.getSelectedRow();
                int index2=table.getSelectedColumn();
try{            table.getCellEditor().stopCellEditing();
}catch(Exception cee){}            //tableModel.fireTableCellUpdated(index,index2);
            }
        });



        JScrollPane jsp = new JScrollPane(table, v1, h1);
        add(jsp);

        jsp.setBounds(10, 110, 1000, 420);





        try {
            if (SystemTray.isSupported()) {
                SystemTray tray = SystemTray.getSystemTray();
                Image image = Toolkit.getDefaultToolkit().getImage("256_001.png");
        
                ActionListener exitListener = new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Exiting...");
                        System.exit(0);
                    }
                };
                
                
                popup = new JPopupMenu();
                JMenuItem exit = new JMenuItem("Exit");
                exit.addActionListener(exitListener);
                popup.add(exit);
                //popup.setSize(100, 100);
                
                trayIcon = new TrayIcon(image, "S13 Download Manager");
                ActionListener actionListener = new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        trayIcon.displayMessage("Action Event",
                                "An Action Event Has Been Performed!",
                                TrayIcon.MessageType.INFO);
                    }
                };
                MouseListener mouseListener = new MouseListener() {

                    public void mouseClicked(MouseEvent e) {
                        System.out.println("Tray Icon - Mouse clicked!");
                    }

                    public void mouseEntered(MouseEvent e) {
                        System.out.println("Tray Icon - Mouse entered!");
                    }

                    public void mouseExited(MouseEvent e) {
                        System.out.println("Tray Icon - Mouse exited!");
                    }

                    public void mousePressed(MouseEvent e) {
                        System.out.println("Tray Icon - Mouse pressed!");
                    }

                    public void mouseReleased(MouseEvent e) {
                        System.out.println("Tray Icon - Mouse released!");
                    //if (e.isPopupTrigger()) {
                popup.setLocation(e.getX(), e.getY());
                popup.setInvoker(popup);
                popup.setVisible(true);
            //}
                    
                    }
                };


                



                
                
                /*trayIcon.addMouseListener(new MouseAdapter() {
        public void mouseReleased(MouseEvent e) {
            if (e.isPopupTrigger()) {
                popup.setLocation(e.getX(), e.getY());
                popup.setInvoker(popup);
                popup.setVisible(true);
            }
        }
    });*/
                trayIcon.setImageAutoSize(true);
                trayIcon.addActionListener(actionListener);
                trayIcon.addMouseListener(mouseListener);


                try {
                    tray.add(trayIcon);
                } catch (AWTException e) {
                    System.err.println("TrayIcon could not be added.");
                }
            } else {
//System Tray is not supported
            }


        } catch (Exception te) {
        }










        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent we) {
                System.exit(-1);
            }
        });


        setSize(1080, 650);
        setVisible(true);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);
//tableModel.addDownload( new graphmain2());
    }

    public void actionPerformed(ActionEvent ae) {
        final Object o = ae.getSource();



        if (o == deleteb) {
            try {
                int rowcount = table.getSelectedRow();
                String cmplete = "Downloading";
                String sall = "" + tableModel.getValueAt(rowcount, 1);
                if (!sall.equals(cmplete)) {
                    tableModel.clearDownload(rowcount);

                } else {
                }

            } catch (Exception e) {
                System.out.println("" + e);
            }
        }
        if (o == deletecompleted) {
            try {
                String cmplete = "Downloading";
                int rowcount = table.getRowCount();
                for (int x = 0; x <= rowcount; x++) {
                    String sall = "" + tableModel.getValueAt(x, 1);
                    if (sall.equals(cmplete)) {
                        tableModel.clearDownload(x);

                    } else {
                    }


                }
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }



        if (o == grabber) {

            Thread grbr = new Thread(new grbbr());
            grbr.start();

        }

        if (o == stopall) {
            try {
                int rowcount = table.getRowCount();
                for (int x = 0; x <= rowcount; x++) {
                    String sall = "" + tableModel.getValueAt(x, 13);
                    int bcount = Integer.parseInt(sall);
                    checkmain.cancelbutton[bcount].doClick();
                }
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }

        if (o == c || o == resumeb) {
            int slrw = table.getSelectedRow();
            String fstatus = "" + tableModel.getValueAt(slrw, 11);
            String status2 = "" + tableModel.getValueAt(slrw, 1);
            String errors= "Error";
            int fs = Integer.parseInt(fstatus);
            
            if (fs == 0 && status2.equals(errors)) 
            {

                String rthrd = "" + tableModel.getValueAt(slrw, 12);
                int times = Integer.parseInt(rthrd);
                times = times++;
                String cmdurl = "" + tableModel.getValueAt(slrw, 10);
                String qs = "" + tableModel.getValueAt(slrw, 2);

                String saveto = "" + tableModel.getValueAt(slrw, 7);

                Boolean qb = Boolean.parseBoolean(qs);
                graphmain2.tableModel.addDownload(new graph(cmdurl, times, qb, saveto));
                tableModel.clearDownload(slrw);
                //new graph(cmdurl,times);
            } 
            
            else 
            
            {
                String sall = "" + tableModel.getValueAt(slrw, 13);
                int bcount = Integer.parseInt(sall);
                checkmain.resumebutton[bcount].doClick();

            }
        }


        if (o == mainb1 || o == n) {

            Thread t1pnl = new Thread(new graphpnl2());
            t1pnl.setName("graphic panel");
            t1pnl.start();
            try {
                Thread.sleep(50);
            } catch (Exception e) {
            }
            updateButtons();
            writefile();
        }//t2main.suspend();

        if (o == pauseb || o == r) {
            int slrw = table.getSelectedRow();
            String pthrd = "" + tableModel.getValueAt(slrw, 13);
            int bcount = Integer.parseInt(pthrd);
            checkmain.pausebutton[bcount].doClick();

            updateButtons();
        }
        if (o == mainb5) {

            //setState(JFrame.NORMAL);
            new Scheduler2();

            updateButtons();
        }

        if (o == e || o == mainb3) {

            System.exit(0);
            //p.destroy();
            //p2.destroy();
        }
    }

    private void actionClear() {
        clearing = true;
        tableModel.clearDownload(table.getSelectedRow());
        clearing = false;
        selectedDownload = null;
        updateButtons();
    }

    private void tableSelectionChanged() {
        /*
         * Unregister from receiving notifications from the last selected
         * download.
         */
        if (selectedDownload != null) {
            selectedDownload.deleteObserver(tableModel);
            selectedDownload.deleteObserver(graphmain2.this);
            table.repaint();
         
try{            table.getCellEditor().stopCellEditing();
}catch(Exception cee){}}
        /*
         * If not in the middle of clearing a download, set the selected
         * download and register to receive notifications from it.
         */
        if (!clearing) {
            selectedDownload =
                    tableModel.getDownload(table.getSelectedRow());
            selectedDownload.addObserver(graphmain2.this);
            table.repaint();

            updateButtons();
                   try{     table.getCellEditor().stopCellEditing();}
                   catch(Exception cee){}
        }
    }

    private void updateButtons() {
        if (selectedDownload != null) {
            int status = selectedDownload.getStatus();
            switch (status) {
                case graph.DOWNLOADING:
                    pauseb.setEnabled(true);
                    resumeb.setEnabled(false);
////cancelb.setEnabled(true);
//clearButton.setEnabled(false);
                    break;
                case graph.PAUSED:
                    pauseb.setEnabled(false);
                    resumeb.setEnabled(true);
////cancelb.setEnabled(true);
//clearButton.setEnabled(false);
                    break;
                case graph.ERROR:
                    pauseb.setEnabled(false);
                    resumeb.setEnabled(true);
////cancelb.setEnabled(false);
//clearButton.setEnabled(true);
                    break;
                default: // COMPLETE or CANCELLED
                    pauseb.setEnabled(false);
                    resumeb.setEnabled(false);
//cancelb.setEnabled(false);
//clearButton.setEnabled(true);
            }
        } else {
// No download is selected in table.
            pauseb.setEnabled(false);
            resumeb.setEnabled(false);
////cancelb.setEnabled(false);
//clearButton.setEnabled(false);
        }
    }

    public void update(Observable o, Object arg) {
// Update buttons if the selected download has changed.
        if (selectedDownload != null && selectedDownload.equals(o)) {
            updateButtons();
//renderer.repaint();
        }
    }

    public static void writefile() {
        try {

            PrintStream out = new PrintStream(("dwndata.txt")); //new AppendFileStream
            int rows = tableModel.getRowCount();
            int columns = tableModel.getColumnCount();
            for (int i = 0; i <= rows; i++) {

                for (int j = 0; j <= columns; j++) {
                    System.out.println("Value is" + tableModel.getValueAt(i, j) + " AT Row=" + i + " Column=" + j);
                    out.print("" + tableModel.getValueAt(i, j));
                    if (j < columns && j != columns) {
                        out.print(" &&@ ");
                    } else if (j >= columns) {
                        out.print("\n");
                    }

                }



            }

        } catch (Exception we) {
        }

    }

    public static void readfile() {
        try {
            FileReader fReader = new FileReader("dwndata.txt");
            BufferedReader inFile = new BufferedReader(fReader);
            String input;
            while ((input = inFile.readLine()) != null) {
                System.out.println("" + input);
                graphmain2.tableModel.addDownload(new graph(input));

            }

            System.out.println("---------End of Line");
        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }

    }
}

class testmain5 {
    //Thread rw= new rwthread();

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception err) {
            System.out.println("Error loading Linux Theme:" + err.toString());
        }
        new graphmain2();
    }
}
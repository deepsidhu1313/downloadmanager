
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
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
import java.util.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
     


class Scheduler2 //extends AbstractTableModel //implements ActionListener {
{
JFrame sf;
 static sdtm tableModel;
JPanel jp1,jp2,jp3,jp4;
JButton next1,next2,back1,back2,start1,cancel1,cancel2,exit,schedule;
JLabel jl1,jl2,jl3,jl4,jl5,jl6;
static JLabel systemdate;
JTextField Date,Month,Year;
JSpinner hrs, mins,secs,downloads;
static JTable stable;
//TableModel stablemodel;
int dwnldno;
JScrollPane jsp;
String sdate;
static String cTime;
static Vector<Vector<String>> myVector = new Vector<Vector<String>>();
        Vector<String> columnNames = new Vector<String>();

static  int colcount, rowcount, mrowcount,mcolcount;
public static void readtable(){

    try{
    
    }catch(Exception ne){}
}


public static void getsystemtime(){
Date d2= new Date();
       cTime  = d2.toString();
  systemdate.setText("System Time :"+cTime);
//  getsystemtime();
        
        //lasttryon= ""+d1.getHours()+":"+d1.getMinutes()+":"+d1.getSeconds()+" `"+d1.getDay() + "/" + d1.getMonth()+ "/" + d1.getYear()+"`";
//System.out.println("Date is"+ );


}
public static void setsystemtime(){
getsystemtime();
try{
    //Thread.currentThread().wait(1000);
}catch(Exception te){}
//setsystemtime();
}
Scheduler2(){

sf= new JFrame("Scheduler");


jp1= new JPanel();
jp2= new JPanel();
jp3= new JPanel();

next1= new JButton("Next");
start1= new JButton("Start Now");
back1= new JButton("Back");
cancel1= new JButton("Cancel");
cancel2= new JButton("Cancel");
exit= new JButton("Exit");
schedule= new JButton("Schedule");


jl1= new JLabel("Scheduler Settings");
systemdate= new JLabel("System Time ");
jl2= new JLabel("Start On");
jl3= new JLabel("Max. Parallel Downloads");
jl4= new JLabel("Scheduled Downloads");
jl5= new JLabel("HH    MM    SS");


Date= new JTextField("DD");
Month= new JTextField("MM");
Year= new JTextField("YY");
//Date= new JTextField("");
hrs=new JSpinner();
mins=new JSpinner();
secs=new JSpinner();


        tableModel = new sdtm();
        stable = new JTable(tableModel);
        stable.setFont(new Font("BitStream Charter", Font.PLAIN, 16));
        stable.setGridColor(Color.LIGHT_GRAY);



SpinnerNumberModel hsm= new SpinnerNumberModel(0, 0, 24, 1);
SpinnerNumberModel msm= new SpinnerNumberModel(0, 0, 60, 1);
SpinnerNumberModel ssm= new SpinnerNumberModel(0, 0, 60, 1);
SpinnerNumberModel dsm= new SpinnerNumberModel(0, 0, 99, 1);

hrs=new JSpinner(hsm);
mins=new JSpinner(msm);
secs=new JSpinner(ssm);
downloads = new JSpinner(dsm);


         int v1 = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h1 = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        
        
     jsp = new JScrollPane(stable,v1,h1);
    
    
    jp1.add(jl1);
    jp1.add(jl2);
    jp1.add(jl3);
    jp1.add(systemdate);
    jp1.add(start1);
    jp1.add(schedule);
    jp1.add(cancel1);
    jp1.add(hrs);
    jp1.add(mins);
    jp1.add(secs);
    jp1.add(Date);
    jp1.add(Month);
    jp1.add(Year);
    jp1.add(downloads);
    jp1.add(jl3);
    jp1.add(jl4);
    jp1.add(jsp);
    jp1.add(exit);
    
    
    jl1.setBounds(10, 10, 300, 30);
    systemdate.setBounds(50, 60, 300, 30);
    jl2.setBounds(50, 100, 300, 30);
    Date.setBounds(70, 140, 40, 30);
    Month.setBounds(120, 140, 40, 30);
    Year.setBounds(170, 140, 40, 30);
    hrs.setBounds(70, 180, 50, 30);
    mins.setBounds(130, 180, 50, 30);
    secs.setBounds(190, 180, 50, 30);
    jl5.setBounds(10, 180, 300, 30);
    jl3.setBounds(30, 220, 200, 30);
    jl4.setBounds(30, 260, 200, 30);
    downloads.setBounds(260, 220, 50, 30);
    start1.setBounds(240, 640, 100, 30);
    cancel1.setBounds(360, 640, 100, 30);
    exit.setBounds(10, 640, 100, 30);
    schedule.setBounds(120, 640, 100, 30);
    
    
    jsp.setBounds(30, 300, 500, 300);
    
    Date d3= new Date();
      //sdate  = ;//toString();
    
    
   Thread time = new Thread(new systemdatetime());
     time.start();
 Thread readt = new Thread(new readTable());
     readt.start();

     jp1.setBounds(0, 0, 800, 800);
     jp1.setLayout(null);
     sf.add(jp1);
    
     
     sf.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
                //sf.setState(JFrame.EXIT_ON_CLOSE);
                System.exit(0);//framestatus=0;
            }
        });

     sf.setLayout(null);
     sf.setVisible(true);
                sf.setSize(800, 800);
        sf.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - sf.getWidth()) / 2,
                ((Toolkit.getDefaultToolkit().getScreenSize().height - sf.getHeight()) / 2)-100);


}




















class systemdatetime implements Runnable{
    
int lnumber= 2;
public void run(){
    for(int k=0;k<=lnumber; k++){
            Scheduler2.setsystemtime();
            if(k==1){
            k=0;
            }
}}
}

class readTable implements Runnable{
    
int lnumber= 2;
public void run(){
    for(int k=0;k<=lnumber; k++){
            Scheduler2.readtable();
            if(k==1){
            k=0;
            }
}}
}}

class Scheduler{
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception err) {
            System.out.println("Error loading Linux Theme:" + err.toString());
        }
        //Class v1[] = testadd2.class.getClasses();
        new Scheduler2();
        
}}


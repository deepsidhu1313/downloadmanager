
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.UIManager;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DecimalFormat;
import java.io.*;
import javax.swing.plaf.FileChooserUI;


class grbbr extends JFrame implements Runnable, ActionListener,ItemListener {

    private String localuname;
    JFrame jf1,jf2,jf3,jf4;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b16,browse,terminal;
    List lst1;
    Checkbox jcb1,jcb2,jcb3,jcb4,jcb5,jcb6;
    JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7;
    JPanel jp1,jp2,jp3,jp4;
    JProgressBar jpb;
    Container con1;
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8, dwnname,dwnloaded,cfilesize,fdownloaded,gicon;
    Process pgrbbr;
    int l=1;
    int t=5, fsaved=0,tp=0,rcount=0;
    String fnl,filename,filesize, str1p;
    float fsize,downloaded,perc;
    ImageIcon t1,t2,t3,gt,g1,n1,bck1,c1,f1,resume1;
    JSpinner js1,js2;
    SpinnerNumberModel snm1,snm2;
    
     public String getuname(){
        
            try {
        Process uname;
            Thread.currentThread().setName("Thread "+checkmain.count);
            checkmain.count++;
           // graphmain2.tdg.
            
            
          
            String com =  "whoami"  ;
            //System.out.println("Combined string: " + com);     
            uname = Runtime.getRuntime().exec("" + com);
            
            //System.out.println("Process executed");
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(uname.getInputStream()));
            String response = "";
            String temp = "";
            //System.out.println("2");
            while ((temp = stdInput.readLine()) != null) {
                response = temp;
                //temp1++;
                
                System.out.println(temp);  
               
                //Thread.sleep(500);
               
                        localuname=temp;
               // System.out.println("Unmae is"+localuname); 
                   
                }
              

            
            
           
           
            
          
            } catch (Exception e1) {
        }
return localuname;          
        }

    
grbbr(){

//jf1.super("Site Grabber");

    
    jf1= new JFrame("Site Grabber");
   
    getuname();
    jl1= new JLabel("URL");
    jl2=new JLabel("User-name");
    jl3= new JLabel("Password");
    jl4= new JLabel("Number Of Levels Upto Grabber Search For Data" );
    jl5= new JLabel("File Type(.extension) Or Use ',' to seperate multiple extensions");
    jl6= new JLabel("Add Site Url To Grab");
    jl7= new JLabel("Advanced Settings:");
    cfilesize= new JLabel("File size: ");
    dwnname= new JLabel("Current File: ");
    dwnloaded= new JLabel("Downloaded: ");
    fdownloaded= new JLabel("Total Files Downloaded: "+fsaved);
    
    jl7.setFont(new Font("Aharoni CLM Book", Font.PLAIN, 18));
    
    
    t1= new ImageIcon("terminal1.png");
    t2= new ImageIcon("terminal2.png");
    t3= new ImageIcon("terminal3.png");
    g1= new ImageIcon("grabber.png");
    n1= new ImageIcon("next 32.png");
    bck1= new ImageIcon("back32.png");
    c1= new ImageIcon("cancel 32.png");
    f1= new ImageIcon("finish 32.png");
    resume1= new ImageIcon("resume 32.png");        
            
    
    
    gicon= new JLabel(g1);
    
    b1= new JButton("Next ",n1);
    b2= new JButton("Cancel ",c1);
    b3= new JButton(" Back", bck1);
    b4= new JButton("Start ");
    b5= new JButton("Cancel ",c1);
    b6= new JButton("Finish ",f1);
    b7= new JButton("Cancel ",c1);
    b8= new JButton(" Back",bck1);
    b9= new JButton("resume ",resume1);
    b10= new JButton("Cancel ");
    b11= new JButton("Exit");
    browse= new JButton("Browse");
    terminal= new JButton(t1);
    jpb= new JProgressBar(0, 100);
    jpb.setStringPainted(true);
    
    
    jf1.setIconImage(Toolkit.getDefaultToolkit().getImage("grabbertitle.png"));

    //jf1.add(Toolkit.getDefaultToolkit().getImage("grabbertitle.png"));
// Place text to the left of icon, vertically centered
b1.setVerticalTextPosition(SwingConstants.CENTER);
b1.setHorizontalTextPosition(SwingConstants.LEFT);

b2.setVerticalTextPosition(SwingConstants.CENTER);
b2.setHorizontalTextPosition(SwingConstants.LEFT);

b3.setVerticalTextPosition(SwingConstants.CENTER);
b3.setHorizontalTextPosition(SwingConstants.RIGHT);

b4.setVerticalTextPosition(SwingConstants.CENTER);
b4.setHorizontalTextPosition(SwingConstants.LEFT);

b5.setVerticalTextPosition(SwingConstants.CENTER);
b5.setHorizontalTextPosition(SwingConstants.LEFT);

b6.setVerticalTextPosition(SwingConstants.CENTER);
b6.setHorizontalTextPosition(SwingConstants.LEFT);

b7.setVerticalTextPosition(SwingConstants.CENTER);
b7.setHorizontalTextPosition(SwingConstants.LEFT);

b8.setVerticalTextPosition(SwingConstants.CENTER);
b8.setHorizontalTextPosition(SwingConstants.RIGHT);


b9.setVerticalTextPosition(SwingConstants.CENTER);
b9.setHorizontalTextPosition(SwingConstants.LEFT);

    
    
    snm1= new SpinnerNumberModel(1, 1, 25, 1);
    snm2= new SpinnerNumberModel(5, 5, 100, 5);
    b6.setEnabled(false);
    
    js1= new JSpinner(snm1);
    js2= new JSpinner(snm2);
    
    
    jp1= new JPanel();
    jp2= new JPanel();
    jp3= new JPanel();
    
    jt1=new JTextField();
    jt2=new JTextField();
    jt3=new JTextField();
    jt4=new JTextField();
    jt5=new JTextField();
    jt6=new JTextField();
    jt7=new JTextField("/home/"+localuname+"/JWGET/grabber/Project"+checkmain.count+"/");
    
    jcb1= new Checkbox("No Parent Directory");
    jcb2= new Checkbox("Don't create Subdirectories");
    jcb3= new Checkbox("Enable Login");
    jcb4= new Checkbox("Enable Wait Between Request (in secnds.)");
    jcb5= new Checkbox("Save to directory");
    jcb6= new Checkbox("Download New Files Only");
    
    
    lst1= new List();
    
   // con1 = getContentPane();
    
    jp1.setSize(800, 700);
    jp2.setSize(800, 700);
    jp3.setSize(800, 700);
    //jp1.setBounds(10, 10, 500, 600);
    jl6.setFont(new Font("BitStream Charter", Font.PLAIN, 22));
    jl6.setBounds(105, 25, 300, 50);
    jl1.setBounds(35, 90, 50, 30);
    jt1.setBounds(70, 90, 500, 30);
    jcb5.setFont(new Font("Aharoni CLM Book", Font.PLAIN, 16));
    jcb5.setBounds(90,155,200,30);
    jt7.setBounds(140, 220, 300, 30);
    browse.setBounds(470, 220, 100, 30);
    jcb3.setBounds(90, 290, 150, 35);
    jl2.setBounds(115, 345, 100, 30);
    jt2.setBounds(210, 345, 350, 30);
    jl3.setBounds(115, 385, 100, 30);
    jt3.setBounds(210, 385, 350, 30);
    b1.setBounds(270,520,120,30);
    b2.setBounds(520,520,120,30);
    gicon.setBounds(600,10,200,200);
    jt7.setEnabled(jcb5.getState());
    jt2.setEnabled(false);
    jt3.setEnabled(false);
    browse.setEnabled(jcb5.getState());
    
    jl6.setVisible(true);
    
    jl7.setBounds(45, 15, 300, 30);
    jl4.setBounds(105, 70, 400, 30);
    js1.setBounds(505,70,50,30);
    jl5.setBounds(105,120,500,30);
    jt6.setBounds(115,160,450,30);
    jcb1.setBounds(170,230,300,30);
    jcb2.setBounds(170,270,300,30);
    //jcb3.setBounds(20,260,300,30);
    jcb4.setBounds(170,310,350,30);
    js2.setBounds(525,310,50,30);
    
    
    jcb6.setBounds(170,355,300,30);
    b3.setBounds(50,520,120,30);
    b4.setBounds(270,520,120,30);
    b5.setBounds(520,520,120,30);
    b9.setBounds(270, 520, 120, 30);
    js2.setEnabled(false);
    
    fdownloaded.setBounds(40, 30, 500, 30);
    dwnname.setBounds(40, 65, 500, 30);
    cfilesize.setBounds(40, 100, 500, 30);
    dwnloaded.setBounds(40, 135, 500, 30);
    //fdownloaded.setBounds(40, 190, 300, 30);
    terminal.setBounds(25, 260, 40, 40);
    lst1.setBounds(30,310,650,300);
    jpb.setBounds(100, 170, 550, 20);
    b6.setBounds(270,210,120,30);
    b7.setBounds(520,210,120,30);
    b8.setBounds(70,210,120,30);
    terminal.setRolloverIcon(t2);
    terminal.setToolTipText("Show/Hide Terminal");
    lst1.setVisible(false);
    b8.setEnabled(false);
    
    jp1.add(jl6);
    jp1.add(jl1);
    jp1.add(jl2);
    jp1.add(jl3);
    jp1.add(jcb3);
    jp1.add(jt1);
    jp1.add(jt2);
    jp1.add(jt3);
    jp1.add(b1);
    jp1.add(b2);
    jp1.add(jcb5);
    jp1.add(jt7);
    jp1.add(browse);
    jp1.add(gicon);
    //jp2.add(jl6);
    jp2.add(jl4);
    jp2.add(jl5);
    jp2.add(jl7);
    jp2.add(jt4);
    jp2.add(jt5);
    jp2.add(jt6);
    jp2.add(b3);
    jp2.add(b4);
    jp2.add(b5);
    jp2.add(jcb1);
    jp2.add(jcb2);
    //jp2.add(jcb3);
    jp2.add(jcb4);
    jp2.add(b9);
    jp2.add(jcb6);
    jp2.add(js1);
    jp2.add(js2);
    b9.setVisible(false);
    
    
    //lst1.set
    jp3.add(lst1);
    jp3.add(b6);
    jp3.add(b7);
    jp3.add(jpb);
    jp3.add(fdownloaded); 
    jp3.add(dwnname);
    jp3.add(cfilesize);
    jp3.add(dwnloaded);
        
    jp3.add(terminal);
    jp3.add(b8);
    
    
    
    
            addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent we) {
                jf1.setState(JFrame.EXIT_ON_CLOSE);
                }
        });
        
            
    try{
        jcb1.addItemListener(this);
        jcb2.addItemListener(this);
        jcb3.addItemListener(this);
        jcb4.addItemListener(this);
        jcb5.addItemListener(this);
        jcb6.addItemListener(this);
       }
        catch (Exception err) 
        {}

    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    b6.addActionListener(this);
    b7.addActionListener(this);
    b8.addActionListener(this);
    b9.addActionListener(this);
    terminal.addActionListener(this);
    browse.addActionListener(this);
    
    
    jp1.setLayout(null);
    jp2.setLayout(null);
    jp3.setLayout(null);
    
    
    
    
    jp2.setVisible(false);
    jp3.setVisible(false);
    jp1.setVisible(true);
    
    jf1.add(jp1);
    jf1.add(jp2);
    jf1.add(jp3);


    jf1.setSize(840, 700);
    jf1.setLayout(null);
    jf1.setVisible(true);
    jf1.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2)-200,
                ((Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2)-400);

/*jf2.setSize(600, 700);
    jf2.setLayout(null);
    jf2.setVisible(false);
    jf2.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);
jf3.setSize(600, 700);
    jf3.setLayout(null);
    jf3.setVisible(false);
    jf3.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);


*/


}


    public void itemStateChanged(ItemEvent e) {
        int index = 0;
        char c = '-';
        Object source = e.getItemSelectable();

        if (source == jcb3) {
                   
        jt2.setEnabled(jcb3.getState());
        jt3.setEnabled(jcb3.getState());
            //setState(JFrame.DISPOSE_ON_CLOSE);
        }
        if (source == jcb4 ) {
                   
        
        js2.setEnabled(jcb4.getState());
            //setState(JFrame.DISPOSE_ON_CLOSE);
        }if (source == jcb5 ) {
                   
        
        jt7.setEnabled(jcb5.getState());
        browse.setEnabled(jcb5.getState());
        //b14.setEnabled(jcb4.getState());
        //b15.setEnabled(jcb4.getState());
            //setState(JFrame.DISPOSE_ON_CLOSE);
        } 
    }

    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        String str;
        str= "";
    
        String URL= jt1.getText();
        String pth= jt7.getText();
        String lvl= ""+js1.getValue();
        String ext= jt6.getText();
        String dly= ""+js2.getValue();
        
        
        if (o == b1) {
           if((jcb3.getState()==false) && (jcb5.getState()==false) && (str.equals(URL)))
           {
               jt1.setForeground(Color.red);
               javax.swing.JOptionPane.showMessageDialog(null, "Some Fields Are Empty!", "Error !", 0);
           }
           else if((jcb3.getState()==true ) && (jcb5.getState()==false) && (str.equals(URL)|| str.equals(jt1.getText())||str.equals(jt2.getText())||str.equals(jt3.getText())))
           {
               jt1.setForeground(Color.red);
               jt2.setForeground(Color.red);
               jt3.setForeground(Color.red);
               javax.swing.JOptionPane.showMessageDialog(null, "Some Fields Are Empty!", "Error !", 0);
           }
           else if((jcb3.getState()==false ) && (jcb5.getState()==true) && (str.equals(URL)|| str.equals(jt7.getText()) ))
           {
               jt1.setForeground(Color.red);
               jt7.setForeground(Color.red);
               //jt3.setForeground(Color.red);
               javax.swing.JOptionPane.showMessageDialog(null, "Some Fields Are Empty!", "Error !", 0);
           }else if((jcb3.getState()==true ) && (jcb5.getState()==true) && (str.equals(URL)|| str.equals(jt1.getText())||str.equals(jt2.getText())||str.equals(jt7.getText()) || str.equals(jt3.getText())))
           {
               jt1.setForeground(Color.red);
               jt2.setForeground(Color.red);
               jt3.setForeground(Color.red);
               javax.swing.JOptionPane.showMessageDialog(null, "Some Fields Are Empty!", "Error !", 0);
           }
           
           
           
           else 
           {
              
              jp1.setVisible(false);
              jp2.setVisible(true);
              
           }}
    
            if(o==terminal)
        {
        tp=tp+1;
        if(tp%2==0){
            jf1.setSize(800, 340);
        lst1.setVisible(false);
        terminal.setIcon(t1);
        }else{
            jf1.setSize(800, 700);
            lst1.setVisible(true);
        terminal.setIcon(t3);
        }}
    
            if(o== b7){
            rcount= rcount+1;
            pgrbbr.destroy();
            b6.setEnabled(true);
            b8.setEnabled(true);
            
    b9.setVisible(true);
    b4.setVisible(false);
            }
            
            if(o==b8){
            jp3.setVisible(false);
            jp2.setVisible(true);
            jf1.setSize(800, 700);
            }
            
            if(o==b9){
            jp2.setVisible(false);
            jp3.setVisible(true);
            rcount= rcount+1;
            b8.setEnabled(false);            
            b6.setEnabled(false);
            b7.setEnabled(true);
            
            jf1.setSize(800, 340);
        Thread gr=new Thread(this);
        gr.start();
            }
            
        if(o==b2 ||o==b5 || o==b6)

        {
        System.exit(0);
        }
        if (o==b3)
        {
         jp2.setVisible(false);
         jp1.setVisible(true);
        }
        
        if(o==browse){
        
JFileChooser chooser = new JFileChooser();
chooser.setDialogTitle("Select target directory");
chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//FileChooserUI fd = new FileChooserUI(jf2, "Save", FileDialog.SAVE);
   int returnVal=     chooser.showDialog(jf2, "Select");//show();
        
//int returnVal = chooser.showOpenDialog(parentFrame);
if(returnVal == JFileChooser.APPROVE_OPTION) {
File path = chooser.getSelectedFile();
jt7.setText(""+path.getPath()+"/");//AbsolutePath());
//System.out.println(beanFile.getAbsolutePath() + beanFile.isDirectory());
}
if(returnVal == JFileChooser.CANCEL_OPTION) {

jt7.setText("/home/"+localuname+"/JWGET/grabber/Project"+checkmain.count+"/");//AbsolutePath());
//System.out.println(beanFile.getAbsolutePath() + beanFile.isDirectory());
}
         //jt7.setText(""+);
        }
        if(o==b4)
        {
        if(((str.equals(lvl)) || (str.equals(ext))) && ((jcb4.getState()== false)))
           {
               jt4.setForeground(Color.red);
               jt6.setForeground(Color.red);
               //jt4.setForeground(Color.red);
               
               javax.swing.JOptionPane.showMessageDialog(null, "Some Fields Are Empty!", "Error !", 0);
           }
        else if(((str.equals(lvl)) || (str.equals(ext) || (str.equals(dly)))) && (jcb4.getState()== true))
           {
               jt4.setForeground(Color.red);
               jt6.setForeground(Color.red);
               jt5.setForeground(Color.red);
               
               javax.swing.JOptionPane.showMessageDialog(null, "Some Fields Are Empty!", "Error !", 0);
           }
        else
        {
        if ((jcb3.getState()== false)&& (jcb1.getState()== false) && (jcb2.getState()== false)&& (jcb4.getState()== false) && (jcb6.getState()== false))
        {
         fnl= " -r -l"+lvl + " -P "+pth+" -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }
        else if ((jcb3.getState()== true)&& (jcb1.getState()== false) && (jcb2.getState()== false)&& (jcb4.getState()== false) && (jcb6.getState()== false))
        {
         fnl= "--user="+jt2.getText()+" --password="+jt3.getText()+" -r -l"+lvl + " -P "+pth+" -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== false)&& (jcb1.getState()== true) && (jcb2.getState()== false)&& (jcb4.getState()== false) && (jcb6.getState()== false))
        {
         fnl= " -r -l"+lvl + " -P "+pth+" -np -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== false)&& (jcb1.getState()== false) && (jcb2.getState()== true)&& (jcb4.getState()== false) && (jcb6.getState()== false))
        {
         fnl= " -r -l"+lvl + " -P "+pth+" -nd -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }
        else if ((jcb3.getState()== false)&& (jcb1.getState()== false) && (jcb2.getState()== false)&& (jcb4.getState()== true) && (jcb6.getState()== false))
        {
         fnl= " -r -l"+lvl + " -P "+pth+" -w"+dly+" -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== false)&& (jcb1.getState()== false) && (jcb2.getState()== false)&& (jcb4.getState()== false) && (jcb6.getState()== true))
        {
         fnl= " -r -l"+lvl + " -P "+pth+" -N -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== true)&& (jcb1.getState()== true) && (jcb2.getState()== false)&& (jcb4.getState()== false) && (jcb6.getState()== false))
        {
         fnl= "--user="+jt2.getText()+" --password="+jt3.getText()+" -r -l"+lvl + " -P "+pth+" -np -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== true)&& (jcb1.getState()== false) && (jcb2.getState()== true)&& (jcb4.getState()== false) && (jcb6.getState()== false))
        {
         fnl= "--user="+jt2.getText()+" --password="+jt3.getText()+" -r -l"+lvl + " -P "+pth+" -nd -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }
        else if ((jcb3.getState()== true)&& (jcb1.getState()== false) && (jcb2.getState()== false)&& (jcb4.getState()== true) && (jcb6.getState()== false))
        {
         fnl= "--user="+jt2.getText()+" --password="+jt3.getText()+" -r -l"+lvl + " -P "+pth+" -w"+dly+" -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== true)&& (jcb1.getState()== false) && (jcb2.getState()== false)&& (jcb4.getState()== false) && (jcb6.getState()== true))
        {
         fnl= "--user="+jt2.getText()+" --password="+jt3.getText()+" -r -l"+lvl + " -P "+pth+" -N -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== false)&& (jcb1.getState()== true) && (jcb2.getState()== true)&& (jcb4.getState()== false) && (jcb6.getState()== false))
        {
         fnl= " -r -l"+lvl + " -P "+pth+" -np -nd -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== false)&& (jcb1.getState()== true) && (jcb2.getState()== false)&& (jcb4.getState()== true) && (jcb6.getState()== false))
        {
         fnl= " -r -l"+lvl + " -P "+pth+" -w"+dly+" -np -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== false)&& (jcb1.getState()== true) && (jcb2.getState()== false)&& (jcb4.getState()== false) && (jcb6.getState()== true))
        {
         fnl= " -r -l"+lvl + " -P "+pth+" -np -N -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== false)&& (jcb1.getState()== false) && (jcb2.getState()== true)&& (jcb4.getState()== true) && (jcb6.getState()== false))
        {
         fnl= " -r -l"+lvl + " -P "+pth+" -w"+dly+" -nd -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== false)&& (jcb1.getState()== false) && (jcb2.getState()== true)&& (jcb4.getState()== false) && (jcb6.getState()== true))
        {
         fnl= " -r -l"+lvl + " -P "+pth+" -nd -N -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== false)&& (jcb1.getState()== false) && (jcb2.getState()== false)&& (jcb4.getState()== true) && (jcb6.getState()== true))
        {
         fnl= " -r -l"+lvl + " -P "+pth+" -w"+dly+" -N -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== true)&& (jcb1.getState()== true) && (jcb2.getState()== true)&& (jcb4.getState()== false) && (jcb6.getState()== false))
        {
         fnl= "--user="+jt2.getText()+" --password="+jt3.getText()+" -r -l"+lvl + " -P "+pth+" -np -nd -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== true)&& (jcb1.getState()== true) && (jcb2.getState()== false)&& (jcb4.getState()== true) && (jcb6.getState()== false))
        {
         fnl= "--user="+jt2.getText()+" --password="+jt3.getText()+" -r -l"+lvl + " -P "+pth+" -w"+dly+" -np -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== true)&& (jcb1.getState()== true) && (jcb2.getState()== false)&& (jcb4.getState()== false) && (jcb6.getState()== true))
        {
         fnl= "--user="+jt2.getText()+" --password="+jt3.getText()+" -r -l"+lvl + " -P "+pth+" -np -N -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== false)&& (jcb1.getState()== true) && (jcb2.getState()== true)&& (jcb4.getState()== true) && (jcb6.getState()== false))
        {
         fnl= " -r -l"+lvl + " -P "+pth+" -w"+dly+" -np -nd -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== false)&& (jcb1.getState()== true) && (jcb2.getState()== true)&& (jcb4.getState()== false) && (jcb6.getState()== true))
        {
         fnl= " -r -l"+lvl + " -P "+pth+" -np -nd -N -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== false)&& (jcb1.getState()== false) && (jcb2.getState()== true)&& (jcb4.getState()== true) && (jcb6.getState()== true))
        {
         fnl= " -r -l"+lvl + " -P "+pth+" -w"+dly+" -nd -N -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== true)&& (jcb1.getState()== true) && (jcb2.getState()== true)&& (jcb4.getState()== true) && (jcb6.getState()== false))
        {
         fnl= "--user="+jt2.getText()+" --password="+jt3.getText()+" -r -l"+lvl + " -P "+pth+" -w"+dly+" -np -nd -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== true)&& (jcb1.getState()== true) && (jcb2.getState()== true)&& (jcb4.getState()== false) && (jcb6.getState()== true))
        {
         fnl= "--user="+jt2.getText()+" --password="+jt3.getText()+" -r -l"+lvl + " -P "+pth+" -np -nd -N -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== false)&& (jcb1.getState()== true) && (jcb2.getState()== true)&& (jcb4.getState()== true) && (jcb6.getState()== true))
        {
         fnl= " -r -l"+lvl + " -P "+pth+" -w"+dly+" -np -nd -N -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== true)&& (jcb1.getState()== false) && (jcb2.getState()== true)&& (jcb4.getState()== true) && (jcb6.getState()== true))
        {
         fnl= "--user="+jt2.getText()+" --password="+jt3.getText()+" -r -l"+lvl + " -P "+pth+" -w"+dly+"  -nd -N -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== true)&& (jcb1.getState()== true) && (jcb2.getState()== false)&& (jcb4.getState()== true) && (jcb6.getState()== true))
        {
         fnl= "--user="+jt2.getText()+" --password="+jt3.getText()+" -r -l"+lvl + " -P "+pth+" -w"+dly+" -np -N -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== true)&& (jcb1.getState()== true) && (jcb2.getState()== true)&& (jcb4.getState()== true) && (jcb6.getState()== true))
        {
         fnl= "--user="+jt2.getText()+" --password="+jt3.getText()+" -r -l"+lvl + " -P "+pth+" -w"+dly+" -np -nd -N -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== true)&& (jcb1.getState()== false) && (jcb2.getState()== true)&& (jcb4.getState()== true) && (jcb6.getState()== false))
        {
         fnl= "--user="+jt2.getText()+" --password="+jt3.getText()+" -r -l"+lvl + " -P "+pth+" -w"+dly+" -nd -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== true)&& (jcb1.getState()== false) && (jcb2.getState()== true)&& (jcb4.getState()== false) && (jcb6.getState()== true))
        {
         fnl= "--user="+jt2.getText()+" --password="+jt3.getText()+" -r -l"+lvl + " -P "+pth+" -nd -N -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else if ((jcb3.getState()== true)&& (jcb1.getState()== false) && (jcb2.getState()== false)&& (jcb4.getState()== true) && (jcb6.getState()== true))
        {
         fnl= "--user="+jt2.getText()+" --password="+jt3.getText()+" -r -l"+lvl + " -P "+pth+" -w"+dly+" -N -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }else /*((jcb3.getState()== false)&& (jcb1.getState()== false) && (jcb2.getState()== false)&& (jcb4.getState()== false) && (jcb6.getState()== false))*/
        {
         fnl= " -r -l"+lvl + " -P "+pth+" -w"+dly+" -np -N -A"+ext+" "+URL;
          System.out.println("Link is:"+fnl);
        
        }
        jp2.setVisible(false);
        jp3.setVisible(true);
        jf1.setSize(800, 340);
        Thread gr=new Thread(this);
        gr.start();
        }   }  }   
        
/*
        private void grabber() {
        Thread thread = new Thread(this);
        thread.start();
        }*/
              
    //@Override
        public void run() {
        int b, s;
            try {
            if(rcount == 0) 
            {
                str1p = "wget ";
            
            }else {//if(rcount >=1) {
            
            str1p = "wget -c ";
            }
            System.out.println("str1 string: " + str1p);
            System.out.println("Combine string example!");
            String com =  "" +str1p+""+ fnl ;
            System.out.println("Combined string: " + com);     
            pgrbbr = Runtime.getRuntime().exec("" + com);
            
            System.out.println("Process executed");
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(pgrbbr.getErrorStream()));
            String response = "";
            String temp = "";
            //int temp1=0;
            while ((temp = stdInput.readLine()) != null) {
                temp = temp;
                        System.out.println("1");
                System.out.println(temp);  
                Thread.sleep(500);
                
                        System.out.println("2");
                lst1.add(temp, 0);
                
                        System.out.println("3");
                    String lenth= "Length: ";
                    String nme="Saving to: ";
                    String uspecified= "Length: unspecified";
                    
                        System.out.println("4");
                    { if( (temp.contains(nme)==true) ){
                   
                        System.out.println("5");
                    String fna=temp.substring(temp.lastIndexOf("/") + 1, temp.indexOf("'")-0);
               System.out.println("String get is:"+ fna);
               
                        System.out.println("6");
                   filename= fna;
                   dwnname.setText("Current File: "+filename);
               System.out.println("File Name is:"+ filename);
               }
        else{
               //System.out.println("didn't get size");
                        System.out.println("7");
               } }
                    { if((temp.contains(uspecified)==false) &&(temp.contains(lenth)==true) ){
                   
                        System.out.println("8");
               String fname2=temp.substring(temp.lastIndexOf(": ") + 2, temp.indexOf(" (")-0);
               //System.out.println("String get is:"+ fname2);
                    fsize = Integer.parseInt(fname2);
                    DecimalFormat df= new DecimalFormat("0.##");
    
                    { if(fsize>= 1024 && !(fsize>= (1024*1024)) ){
                    
                        System.out.println("9");
                        float floatsize= fsize/1024;
        
                    System.out.println("\n  Size "+fsize+" KB");
        
                    filesize=(df.format(floatsize) +" KB");
        }
        else if(fsize>= (1024*1024)&& !(fsize>= (1024*1024*1024))){
                    float floatsize= (fsize)/(1024*1024);
                    
                        System.out.println("10");
                    System.out.println(" Size  "+fsize+" MB");
                    filesize=(df.format(floatsize)+" MB");
        }
        else if(fsize>= (1024*1024*1024)&& !(fsize>= (1024*1024*1024*1024))){
                    float floatsize= (fsize)/(1024*1024*1024);
                    System.out.println("  Size "+fsize+" GB");
        
                        System.out.println("11");
                    filesize=(df.format(floatsize)+" GB");
        }
        else if(fsize>= (1024*1024*1024*1024)&& !(fsize>= (1024*1024*1024*1024*1024))){
                    float floatsize= (fsize)/(1024*1024*1024);
                    System.out.println("  Size  "+fsize+" TB");
                    filesize=(df.format(floatsize)+" TB");
                    
                        System.out.println("12");
 }
        else if(fsize< 1024) {
                    float floatsize= fsize;
                    System.out.println(" Size  "+fsize+" Bytes");
                    filesize=(df.format(floatsize)+" Bytes");
                    
                        System.out.println("13");
 }  else{}

        
                    }
                    cfilesize.setText("File size: "+filesize);
                    
                        System.out.println("14");
               //System.out.println("Size is:"+ fsize);
               }
        else{
                        
                        System.out.println("15");
               //System.out.println("didn't get size");
               } }
                    {if (temp.indexOf("% ") >= 0) {
                
                        System.out.println("16");
                        s = temp.indexOf("% ");
                        {if (Character.isDigit(temp.charAt(s - 3))) {
                        
                        System.out.println("17");
                        b = s - 3;
                    } else if (Character.isDigit(temp.charAt(s - 2))) {
                        
                        System.out.println("18");
                        b = s - 2;
                    } else if (Character.isDigit(temp.charAt(s - 1))) {
                        
                        System.out.println("19");
                        b = s - 1;
                    } else {
                        
                        System.out.println("20");
                        b = 0;
                        
                    }}
                    System.out.println("21");
                    jpb.setValue(Integer.parseInt(temp.substring(b, s)));
                    
                        
                    }}
                    perc= jpb.getValue();
                    
        
                    
                        System.out.println("22");
                    downloaded= (perc*fsize)/100;
                    DecimalFormat df= new DecimalFormat("0.##");
                    {                  
        if(downloaded>= 1024 && !(downloaded>= (1024*1024)) ){
                    downloaded= downloaded/1024;
                    
                        System.out.println("23");
       // System.out.println("  Size "+downloaded+" KB");
                    dwnloaded.setText("Downloaded: "+df.format(downloaded)+" KB");}
        else if(downloaded>= (1024*1024)&& !(downloaded>= (1024*1024*1024))){
                    downloaded= (downloaded)/(1024*1024);
                    
                        System.out.println("24");
                    // System.out.println("                Size  "+downloaded+" MB");
                    dwnloaded.setText("Downloaded: "+df.format(downloaded)+" MB");}
        else if(downloaded>= (1024*1024*1024)&& !(downloaded>= (1024*1024*1024*1024))){
                    downloaded= (downloaded)/(1024*1024*1024);
                    // System.out.println("  Size "+downloaded+" GB");
        
                        System.out.println("25");
                    dwnloaded.setText("Downloaded: "+df.format(downloaded)+" GB");}
        else if(downloaded>= (1024*1024*1024*1024)&& !(downloaded>= (1024*1024*1024*1024*1024))){
                    downloaded= (downloaded)/(1024*1024*1024);
 
                        System.out.println("26");
                    //System.out.println("  Size  "+downloaded+" TB");
                    dwnloaded.setText("Downloaded: "+df.format(downloaded)+" TB");}
        else if(downloaded< 1024) {
            
                        System.out.println("27");
                    //System.out.println("  Size  "+downloaded+" Bytes");
                    dwnloaded.setText("Downloaded: "+df.format(downloaded)+" Bytes");}
                    }
                    
                        System.out.println("28");
                   //graphmain2.writefile();
                    //System.out.println(""+downloaded); 
                    { if (jpb.getValue() == 100) {
                       // javax.swing.JOptionPane.showMessageDialog(null, "Download Successfully Completed !", "Complete", 1);
                    fsaved=fsaved+1;
                    fdownloaded.setText("Total Files Downloaded: "+fsaved);
                        jpb.setValue(0);
                        System.out.println("29");
                    }}
                   
                        System.out.println("30");
                }
              

            }
           
           //stdInput.close();
            
         catch (Exception e1) {
        System.out.println("Exception"+e1);

         }
        System.out.println("Process Completed!");
        lst1.add("Process Completed!", 0);
        b6.setEnabled(true);
        b7.setEnabled(false);
        } 
        
        
       
}


class grabber
{
        public static void main(String args[])
    {
        try{
	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
}

catch (Exception err) {
        		System.out.println("Error loading System Theme:" + err.toString());
   		 	}
  //Class v1[] = testadd2.class.getClasses();
    new grbbr();
    } 




}
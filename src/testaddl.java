
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.border.*;
import java.awt.List;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.lang.String;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileSystemView;
import sun.awt.shell.ShellFolder; 
import java.util.Observable;
import java.util.Date;
import java.awt.FileDialog;
import java.text.DecimalFormat;


import java.util.Observable;
class check {

  static JButton stopall2= new JButton("Stop All");
    
}
class graphpnl2 extends Observable implements Runnable, ActionListener, ItemListener {

    
    

    JFrame jf2;
    String URL,str1, str2, str3, str4, str7, bv,com;
     Container con2;
    JLabel l11, l12, l13, l14, l15, l16, l17,jln2,jln3;
    ImageIcon i1;
    JButton b12, b13, b14, b15,b16,browse2;
    int hght = 210;
     String temp1 = "";
     float fsize;
        Thread g1;
        JButton bt1, b11;
        JTextField jtf11, jtf12, jtf13, jtf14, jtf15, jtf16, jtf17;
        JLabel jln1 = new JLabel("");
        Thread t12, t1pnl;
        Checkbox cb11, cb12,que, dir;
        CheckboxGroup cbg;
        JComboBox c11;
    File file;
    ShellFolder shellFolder;
    String written, localuname;
    Boolean aq;
 
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
    graphpnl2() {
        //super(str);
       jf2= new JFrame();
       
       
            l11 = new JLabel("Url");
        l12 = new JLabel("File Name");
        l13 = new JLabel("Save As");
        l14 = new JLabel("User Name");
        l15 = new JLabel("Password");
        l16 = new JLabel("                     **********************Advanced Settings**************************");
        jln2= new JLabel();
        jln3= new JLabel("");
        
        
        
        //check.bv = "true";
        str7 = "© 2011-12 All Rights Reserved.";
       cbg= new CheckboxGroup();
        
          b11 = new JButton("Start Download");
        b12 = new JButton("Download Later");
        b13 = new JButton("Cancel");
        b14 = new JButton("Advanced >>");
        b15 = new JButton("<< Advanced");
        b16= new JButton("Browse");
        browse2= new JButton("Browse");
        cb11 = new Checkbox("Enable",cbg,false);
        cb12 = new Checkbox("Login");
        que= new Checkbox("Add Download To Que");
        dir= new Checkbox("Set Location",cbg,true);
        
       
        jtf11 = new JTextField("");
        
        jtf12 = new JTextField("");
        jtf13 = new JTextField("");
        jtf14 = new JTextField("");
        jtf15 = new JTextField("");
        jtf16 = new JTextField("");
        jtf17 = new JTextField("");
         
        //cb11.setBackground(Color.red);
        c11 = new JComboBox();
        c11.addItem("ftp");
        c11.addItem("http");
        //c1.addItem("https");

        jf2.add(c11);
        jf2.add(b11);
        jf2.add(cb11);
        jf2.add(cb12);
        jf2.add(b12);
        jf2.add(b13);
        jf2.add(b14);
        jf2.add(b15);
        jf2.add(l11);
        jf2.add(b16);
        jf2.add(l13);
        jf2.add(l14);
        jf2.add(l15);
        jf2.add(l16);
        jf2.add(que);
       jf2.add(dir);
        jf2.add(jtf11);
        //jf2.add(jtf12);
        jf2.add(jtf13);
        jf2.add(jtf14);
        jf2.add(jtf15);
        jf2.add(jtf16);
        jf2.add(jtf17);
        jf2.add(jln3);
        jf2.add(browse2);
        
        

   
        b15.setVisible(false);
        

        l11.setBounds(50, 50, 300, 30);
        l16.setBounds(50, 230, 800, 30);
        //l12.setBounds(50, 300, 300, 30);
        l13.setBounds(50, 300, 300, 30);
        l14.setBounds(50, 450, 300, 30);
        l15.setBounds(50, 500, 300, 30);
        dir.setBounds(30, 340, 150, 30);
        que.setBounds(250, 150, 200, 30);
        cb11.setBounds(30, 260, 100, 30);
        cb12.setBounds(30, 400, 100, 30);
        jtf11.setBounds(130, 50, 500, 30);
        //jtf2.setBounds(330,200,300,30);
        //jtf12.setBounds(330, 300, 300, 30);
        jtf13.setBounds(330, 300, 300, 30);
        jtf14.setBounds(330, 450, 300, 30);
        jtf15.setBounds(330, 500, 300, 30);
        jtf16.setBounds(330,340,300,30);
        b11.setBounds(50, 100, 150, 30);
        b12.setBounds(270, 100, 150, 30);
        b13.setBounds(470, 100, 150, 30);
        b14.setBounds(50, 150, 150, 30);
        b15.setBounds(50, 150, 150, 30);
        b16.setBounds(700, 300, 80, 30);           
        browse2.setBounds(700, 340, 80, 30);           
        jtf12.setEnabled(false);
        jtf13.setEnabled(false);           
        jtf14.setEnabled(false);
        jtf15.setEnabled(false);
        jtf16.setEnabled(dir.getState());
        browse2.setEnabled(dir.getState());
       
        jln1.setBounds(60, 10, 500, 20);
        
        
        jf2.add(jln1);
//        jf2.add(jln2);
                
        jln1.setText("File Name :");
        jf2.setLayout(null);

        //jf2.setSize(880, 220);
        //jf2.setVisible(true);
    
    
              
                
     
        
      JCheckBox jcb23= new JCheckBox();
      
        jf2.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent we) {
                jf2.setState(JFrame.DISPOSE_ON_CLOSE);
            }
        });


        try{
            cb11.addItemListener(this);
        cb12.addItemListener(this);
        que.addItemListener(this);
        dir.addItemListener(this);
       }
        catch (Exception err) 
        {}
        try{
            //jtf11.addKeyListener(this);
       jtf11.addCaretListener(
               new CaretListener() {

                @Override
                public void caretUpdate(CaretEvent e) {
                  get();
                  jf2.repaint();
                //g1.start();
                }
            }
               );
        }
        catch (Exception errp) 
        {}

        jtf11.addActionListener(this);
        
         
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);
        browse2.addActionListener(this);
        b16.setEnabled(cb11.getState());
        //cb11.setForeground(Color.red);
         
        con2 = jf2.getContentPane();
        jf2.setSize(880, 220);
        jf2.setVisible(true);
        jf2.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width - jf2.getWidth()) / 2)-100,
                ((Toolkit.getDefaultToolkit().getScreenSize().height - jf2.getHeight()) / 2)-250);
       getuname(); 
    jtf16.setText("/home/"+localuname+"/JWGET/");
    }

    public void get(){
        
    //Thread g1= new Thread(this);
        g1= new Thread(this);
        g1.start();
    }
       public void run (){
           try{
               String url= jtf11.getText();
             URL u1= new URL(url);
        //File f1= 
       //      getuname();
             String contyp= ""+u1.openConnection().getContentType();
               System.out.println("content type"+u1.openConnection().getContentType());
                String fname= ""+u1.getFile();
                fname = fname.substring(fname.lastIndexOf('/') + 1);
                //jln2.setIcon(null);
               // jln2.repaint();
                
               //System.out.println("2");
                if(fname.contains("."))
                {
                    String extension= fname.substring(fname.lastIndexOf(".")+1);
                  
               //System.out.println("3");
                    if(extension.contains("pdf")||extension.contains("PDF")||contyp.contains("pdf")||contyp.contains("PDF"))
                  {
                      
               //System.out.println("4");
                     ImageIcon  icon= new ImageIcon("pdf.png");
                 // jln2= new JLabel(icon);
                   jln2.setIcon(icon);
                  jln2.setBounds(670, 40, 68, 68);
                  jf2.add(jln2);
                  jf2.repaint();
                  jtf16.setText("/home/"+localuname+"/JWGET/Documents/");
                  }
                    else if(extension.contains("3gp")||
                            extension.contains("avi")||extension.contains("m4v")||extension.contains("mkv")||
                            extension.contains("mov")||extension.contains("mp4")||extension.contains("mpeg")||
                            extension.contains("mpg")||extension.contains("ogg")||extension.contains("ogv")||
                            extension.contains("flv")||extension.contains("wmv")||contyp.contains("mpeg")||
                            contyp.contains("video")||contyp.contains("VIDEO"))
                  {
                      
               //System.out.println("4");
                     ImageIcon  icon= new ImageIcon("movie 68.png");
                  //jln2= new JLabel(icon);
                     jln2.setIcon(icon);
                  jln2.setBounds(670, 40, 68, 68);
                  jf2.add(jln2);
                  jf2.repaint();
                  jtf16.setText("/home/"+localuname+"/JWGET/Videos/");
                  }
                    else if(extension.contains("rar")||
                            extension.contains("RAR")||extension.contains("r0")||extension.contains("r1")||
                            extension.contains("r2")||extension.contains("R1")||extension.contains("R2")||
                            extension.contains("R3"))
                  {
                      
               //System.out.println("4");
                     ImageIcon  icon= new ImageIcon("rar 68.png");
                  //jln2= new JLabel(icon);
                     jln2.setIcon(icon);
                  jln2.setBounds(670, 40, 68, 68);
                  jf2.add(jln2);
                  jf2.repaint();
                  jtf16.setText("/home/"+localuname+"/JWGET/Compressed/");
                  }
                    else if(extension.contains("jar")||
                            extension.contains("JAR"))
                  {
                      
               //System.out.println("4");
                     ImageIcon  icon= new ImageIcon("jar 68.png");
                  //jln2= new JLabel(icon);
                     jln2.setIcon(icon);
                  jln2.setBounds(670, 40, 68, 68);
                  jf2.add(jln2);
                  jf2.repaint();
                  jtf16.setText("/home/"+localuname+"/JWGET/Applications/");
                  }
                    else if(extension.contains("tar")||
                            extension.contains("TAR"))
                  {
                      
               //System.out.println("4");
                     ImageIcon  icon= new ImageIcon("tar 68.png");
                  //jln2= new JLabel(icon);
                     jln2.setIcon(icon);
                  jln2.setBounds(670, 40, 68, 68);
                  jf2.add(jln2);
                  jf2.repaint();
                  jtf16.setText("/home/"+localuname+"/JWGET/Compressed/");
                  }
                    else if(extension.contains("ISO")||
                            extension.contains("iso")||extension.contains("img")||extension.contains("IMG")||
                            extension.contains("NRG")||extension.contains("nrg")||extension.contains("cue")||
                            extension.contains("CUE")||extension.contains("bin")||extension.contains("BIN"))
                  {
                      
               System.out.println("iso");
                     ImageIcon  icon= new ImageIcon("iso 68.png");
                  //jln2= new JLabel(icon);
                     jln2.setIcon(icon);
                  jln2.setBounds(670, 40, 68, 68);
                  jf2.add(jln2);
                  jf2.repaint();
                  
                  jtf16.setText("/home/"+localuname+"/JWGET/CD_DVD Images/");
                  }
                    else if(extension.contains("GZIP")||
                            extension.contains("gzip"))
                  {
                      
               //System.out.println("4");
                     ImageIcon  icon= new ImageIcon("targzip 68.png");
                  //jln2= new JLabel(icon);
                    jln2.setIcon(icon);
                  jln2.setBounds(670, 40, 68, 68);
                  jf2.add(jln2);
                  jf2.repaint();
                  jtf16.setText("/home/"+localuname+"/JWGET/Compressed/");
                  }
                    else if(extension.contains("GZ")||
                            extension.contains("gz")||
                            extension.contains("bz")||
                            extension.contains("BZ"))
                  {
                      
               //System.out.println("4");
                     ImageIcon  icon= new ImageIcon("tar 68.png");
                  //jln2= new JLabel(icon);
                     jln2.setIcon(icon);
                  jln2.setBounds(670, 40, 68, 68);
                  jf2.add(jln2);
                  jf2.repaint();
                  
                  jtf16.setText("/home/"+localuname+"/JWGET/Compressed/");
                  }
                    else if(extension.contains("bz2")||
                            extension.contains("BZ2"))
                  {
                      
               //System.out.println("4");
                     ImageIcon  icon= new ImageIcon("tarbz2 68.png");
                  jln2= new JLabel(icon);
                     jln2.setIcon(icon);
                  jln2.setBounds(670, 40, 68, 68);
                  jf2.add(jln2);
                  jf2.repaint();
                  jtf16.setText("/home/"+localuname+"/JWGET/Compressed/");
                  } else if(extension.contains("mp3")||
                            extension.contains("MP3")||extension.contains("wav")||extension.contains("WAV")||
                            extension.contains("amr")||extension.contains("AMR")||extension.contains("ACC")||
                            extension.contains("ACC")||extension.contains("flac")||extension.contains("FLAC"))
                  {
                      
               //System.out.println("4");
                     ImageIcon  icon= new ImageIcon("music2 68.png");
                  //jln2= new JLabel(icon);
                     jln2.setIcon(icon);
                  jln2.setBounds(670, 40, 68, 68);
                  jf2.add(jln2);
                  jf2.repaint();
                  
                  jtf16.setText("/home/"+localuname+"/JWGET/Music/");
                  } else if(extension.contains("odt")||
                            extension.contains("ott")||extension.contains("sxw")||extension.contains("stw")||
                            extension.contains("doc")||extension.contains("rtf")||extension.contains("xml")||
                            extension.contains("docx")||extension.contains("fodt")||extension.contains("uot")||extension.contains("ODT")||
                            extension.contains("OTT")||extension.contains("SXW")||extension.contains("STW")||
                            extension.contains("DOC")||extension.contains("RTF")||extension.contains("XML")||
                            extension.contains("DOCX")||extension.contains("FODT")||extension.contains("UOT"))
                  {
                      
               //System.out.println("4");
                     ImageIcon  icon= new ImageIcon("doc 68.png");
                  //jln2= new JLabel(icon);
                     jln2.setIcon(icon);
                  jln2.setBounds(670, 40, 68, 68);
                  jf2.add(jln2);
                  jf2.repaint();
                  jtf16.setText("/home/"+localuname+"/JWGET/Documents/");
                  }else if(extension.contains("ods")||
                            extension.contains("ots")||extension.contains("sxc")||extension.contains("stc")||
                            extension.contains("dif")||extension.contains("dbf")||extension.contains("xls")||
                            extension.contains("xlt")||extension.contains("slk")||extension.contains("csv")||extension.contains("xlsx")||
                            extension.contains("fods")||extension.contains("uos")||extension.contains("ODS")||
                            extension.contains("OTS")||extension.contains("SXC")||extension.contains("STC")||
                            extension.contains("DIF")||extension.contains("DBF")||extension.contains("XLS")||
                            extension.contains("XLT")||extension.contains("SLK")||extension.contains("CSV")||extension.contains("XLSX")||
                            extension.contains("FODS")||extension.contains("UOS"))
                  {
                      
               //System.out.println("4");
                     ImageIcon  icon= new ImageIcon("xlsheet 68.png");
                  //jln2= new JLabel(icon);
                     jln2.setIcon(icon);
                  jln2.setBounds(670, 40, 68, 68);
                  jf2.add(jln2);
                  jf2.repaint();
                  jtf16.setText("/home/"+localuname+"/JWGET/Documents/");
                  }else if(extension.contains("odp")||
                            extension.contains("otp")||extension.contains("sxl")||extension.contains("sti")||
                            extension.contains("ppt")||extension.contains("pot")||extension.contains("sxd")||
                            extension.contains("pptx")||extension.contains("ppsx")||extension.contains("potm")||extension.contains("pps")||
                            extension.contains("fodp")||extension.contains("uop")||extension.contains("odg")||extension.contains("ODP")||
                            extension.contains("OTP")||extension.contains("SXL")||extension.contains("STI")||
                            extension.contains("PPT")||extension.contains("POT")||extension.contains("SXD")||
                            extension.contains("PPTX")||extension.contains("PPSX")||extension.contains("POTM")||extension.contains("PPS")||
                            extension.contains("FODP")||extension.contains("UOP")||extension.contains("ODG")
                            )
                  {
                      
               //System.out.println("4");
                     ImageIcon  icon= new ImageIcon("pwrpnt 68.png");
                  //jln2= new JLabel(icon);
                     jln2.setIcon(icon);
                  jln2.setBounds(670, 40, 68, 68);
                  jf2.add(jln2);
                  jf2.repaint();
                  jtf16.setText("/home/"+localuname+"/JWGET/Documents/");
                  }else if(extension.contains("otg")||
                            extension.contains("sxd")||extension.contains("std")||extension.contains("fodg")||extension.contains("OTG")||
                            extension.contains("SXD")||extension.contains("STD")||extension.contains("FODG")
                            )
                  {
                      
               //System.out.println("4");
                     ImageIcon  icon= new ImageIcon("drw 68.png");
                 // jln2= new JLabel(icon);
                   jln2.setIcon(icon);
                  jln2.setBounds(670, 40, 68, 68);
                  jf2.add(jln2);
                  jf2.repaint();
                  jtf16.setText("/home/"+localuname+"/JWGET/Images/");
                  }else if(extension.contains("accdb")||
                            extension.contains("mdb")||extension.contains("mdx")||extension.contains("ACCDB")||
                            extension.contains("MDB")||extension.contains("MDX")
                            )
                  {
                      
               //System.out.println("4");
                     ImageIcon  icon= new ImageIcon("db 68.png");
                 // jln2= new JLabel(icon);
                     jln2.setIcon(icon);
                  jln2.setBounds(670, 40, 68, 68);
                  jf2.add(jln2);
                  jf2.repaint();
                  jtf16.setText("/home/"+localuname+"/JWGET/Databases/");
                  }else if(extension.contains("deb")||
                            extension.contains("DEB"))
                  {
                      
               //System.out.println("4");
                     ImageIcon  icon= new ImageIcon("deb 68.png");
                  //jln2= new JLabel(icon);
                     jln2.setIcon(icon);
                  jln2.setBounds(670, 40, 68, 68);
                  jf2.add(jln2);
                  jf2.repaint();
                  jtf16.setText("/home/"+localuname+"/JWGET/Applications/");
                  }else if(extension.contains("rpm")||
                            extension.contains("RPM"))
                  {
                      
               //System.out.println("4");
                     ImageIcon  icon= new ImageIcon("rpm 68.png");
                  //jln2= new JLabel(icon);
                     jln2.setIcon(icon);
                  jln2.setBounds(670, 40, 68, 68);
                  jf2.add(jln2);
                  jf2.repaint();
                  jtf16.setText("/home/"+localuname+"/JWGET/Applications/");
                  }else if(extension.contains("ZIP")||
                            extension.contains("zip")||extension.contains("7Z")||
                            extension.contains("7z"))
                  {
                      
               //System.out.println("4");
                     ImageIcon  icon= new ImageIcon("zip 68.png");
                  //jln2= new JLabel(icon);
                     jln2.setIcon(icon);
                  jln2.setBounds(670, 40, 68, 68);
                  jf2.add(jln2);
                  jf2.repaint();
                  jtf16.setText("/home/"+localuname+"/JWGET/Compressed/");
                  }
                    else
                  {
                  ImageIcon  icon= new ImageIcon("unknown 68.png");
                  //jln2= new JLabel(icon);
                     jln2.setIcon(icon);
                  jln2.setBounds(670, 40, 68, 68);
                  jf2.add(jln2);
                  jf2.repaint();
                  jtf16.setText("/home/"+localuname+"/JWGET/");
                  }
                }
                else{
                
                }
                jtf13.setText(fname);
         fsize= u1.openConnection().getContentLength();

        DecimalFormat df= new DecimalFormat("0.##");
           jln3.setBounds(680, 105, 100, 30);
                                    
        if(fsize>= 1024 && !(fsize>= (1024*1024)) ){
        fsize= fsize/1024;
        //System.out.println("File Name : "+fname+"\n  Size "+df.format(fsize)+" KB");
        jln1.setText("File Name : "+fname );
        jln3.setText(""+df.format(fsize)+" KB");}
        else if(fsize>= (1024*1024)&& !(fsize>= (1024*1024*1024))){
        fsize= (fsize)/(1024*1024);
        //System.out.println("File Name : "+fname+"\n                     Size  "+df.format(fsize)+" MB");
        jln1.setText("File Name : "+fname);
        jln3.setText(""+df.format(fsize)+" MB");}
        else if(fsize>= (1024*1024*1024)&& !(fsize>= (1024*1024*1024*1024))){
        fsize= (fsize)/(1024*1024*1024);
        //System.out.println("File Name : "+fname+"\n  Size "+df.format(fsize)+" GB");
        
        jln1.setText("File Name : "+fname);
        jln3.setText(""+df.format(fsize)+" GB");}
        else if(fsize>= (1024*1024*1024*1024)&& !(fsize>= (1024*1024*1024*1024*1024))){
        fsize= (fsize)/(1024*1024*1024);
        //System.out.println("File Name : "+fname+"\n  Size  "+df.format(fsize)+" TB");
        jln1.setText("File Name : "+fname);
        jln3.setText(""+df.format(fsize)+" TB");}
        else if(fsize< 1024) {
        //System.out.println("File Name : "+fname+"\n  Size  "+df.format(fsize)+" Bytes");
        jln1.setText("File Name : "+fname);
        jln3.setText(""+df.format(fsize)+" Bytes");}
        
        
       // //System.out.println(""+fname+"     "+fsize);
        
        
        jln1.setBounds(10, 10, 500, 20);
        jf2.add(jln1);
        ////System.out.println(""+fname+"     "+fsize);
        }
        catch(Exception ue){
        //System.out.println(""+ue);
        }
        /*ClassLoader cl = getClass().getClassLoader();
        URL iconURL = cl.getResource("icon.gif");
        if(iconURL != null)
        {
            ImageIcon icon = new ImageIcon(iconURL);
            setIconImage(icon.getImage());
            
         }
        try
        {
            URLConnection connection = (new URL(url)).openConnection();
            String f[] = url.split("/");
            int length = 
            
        }
        catch(Exception e)
        {
            System.err.println((new StringBuilder()).append("Error connecting to ").append(url).toString());
        
        }*/
    //return showoff;
    }

    
    
    
    
//    Action actions[] = jtf1.getActions();

//    Action pasteAction = get(jtf1.getText());
    public void itemStateChanged(ItemEvent e) {
        int index = 0;
        char c = '-';
        Object source = e.getItemSelectable();

        if (source == cb11) {
        //dir.setState(!cb11.getState());
        b16.setEnabled(cb11.getState());           
        jtf12.setEnabled(cb11.getState());
        jtf13.setEnabled(cb11.getState());
        jtf16.setEnabled(!cb11.getState());
        browse2.setEnabled(dir.getState());//setState(JFrame.DISPOSE_ON_CLOSE);
        }
        if (source == cb12 ) {
                   
        jtf14.setEnabled(cb12.getState());
        jtf15.setEnabled(cb12.getState());
            //setState(JFrame.DISPOSE_ON_CLOSE);
        }
        if (source == dir ) {
                   
        //cb11.setState(!dir.getState());
        jtf16.setEnabled(dir.getState());
        b16.setEnabled(cb11.getState());           
        jtf12.setEnabled(cb11.getState());
        jtf13.setEnabled(cb11.getState());
        browse2.setEnabled(dir.getState());    //setState(JFrame.DISPOSE_ON_CLOSE);
        } 
    }
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        String str;
        str= "";
        URL= jtf11.getText();
        if (o== browse2){
        
        JFileChooser chooser = new JFileChooser();
chooser.setDialogTitle("Select target directory");
chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//FileChooserUI fd = new FileChooserUI(jf2, "Save", FileDialog.SAVE);
   int returnVal=     chooser.showDialog(jf2, "Select");//show();
        
//int returnVal = chooser.showOpenDialog(parentFrame);
if(returnVal == JFileChooser.APPROVE_OPTION) {
File path = chooser.getSelectedFile();
jtf16.setText(""+path.getPath()+"/");//AbsolutePath());
//System.out.println(beanFile.getAbsolutePath() + beanFile.isDirectory());
}
if(returnVal == JFileChooser.CANCEL_OPTION) {

//jtf16.setText("/home/"+localuname+"/JWGET/grabber/Project"+checkmain.count+"/");//AbsolutePath());
//System.out.println(beanFile.getAbsolutePath() + beanFile.isDirectory());
}

        
        }
        
        
        if (o == b11) {
           if((cb11.getState()==false && cb12.getState()==false) && (str.equals(URL)))
           {
               jtf11.setForeground(Color.red);
               javax.swing.JOptionPane.showMessageDialog(null, "Some Fields Are Empty!", "Error !", 0);
           }
           else if((cb11.getState()==true && cb12.getState()==true) && (str.equals(URL)|| str.equals(jtf12.getText())||str.equals(jtf13.getText())||str.equals(jtf14.getText())||str.equals(jtf15.getText())))
           {
               jtf11.setForeground(Color.red);
               javax.swing.JOptionPane.showMessageDialog(null, "Some Fields Are Empty!", "Error !", 0);
           }
           else if((cb11.getState()==false && cb12.getState()==true) && (str.equals(URL)||str.equals(jtf14.getText())||str.equals(jtf15.getText())))
            {
               jtf11.setForeground(Color.red);
               javax.swing.JOptionPane.showMessageDialog(null, "Some Fields Are Empty!", "Error !", 0);
           }
           else if ((cb11.getState()==true && cb12.getState()==false) && (str.equals(URL)|| str.equals(jtf12.getText())||str.equals(jtf13.getText()))) 
           {
               jtf11.setForeground(Color.red);
               javax.swing.JOptionPane.showMessageDialog(null, "Some Fields Are Empty!", "Error !", 0);
           }
           else
           {
            if(cb11.getState()==true && cb12.getState()==false)
            {
            str2 = " -O "+jtf12.getText()+""+jtf13.getText()+" "+URL;
            //System.out.println(""+str2); //str3 = ;
            }
            else if(cb11.getState()==false && cb12.getState()==true)
            {
            str2 = " -P "+jtf16.getText()+" --user="+jtf14.getText()+" --password="+jtf15.getText()+" "+URL;
            //System.out.println(""+str2); //str3 = ;
            }
            else if(cb11.getState()==true && cb12.getState()==true)
            {
            str2 = " -P "+jtf16.getText()+" --user="+jtf14.getText()+" --password="+jtf15.getText()+" -O "+jtf12.getText()+""+jtf13.getText()+" "+URL;
            //System.out.println(""+str2); //str3 = ;
            }
            else
            {
            str2 = " -P "+jtf16.getText()+" "+jtf11.getText();
            System.out.println("link is"+str2); //str3 = ;
            }
            
            String dloc= new String();
            dloc= ""+jtf16.getText();
             String str3 = new String() ;
             str3 = str2;
            //System.out.println("Str2" + str2);
            System.out.println("Str3" + str3);
            
            if(que.getState()==true){
             aq= Boolean.TRUE;
            
            }else{
            aq= Boolean.FALSE;
            
            }
             // checkmain.table1.;
          //  checkmain.myVector.add(jtf11.getText());
           /* try{
                URL u1 = new URL(str3);
            }
            catch(MalformedURLException ls)
            {
                //System.out.println("Address not valid");
                 javax.swing.JOptionPane.showMessageDialog(null, "Couldn't Start Download", "Error", 0);
                       //jf1.setState(DISPOSE_ON_CLOSE);//dispose();
                
            }*/
            jf2.dispose();
            
            graphmain2.tableModel.addDownload(new graph(str3,0,aq,dloc));
            //Scheduler2.tableModel.addDownload(graphmain2.tableModel.addDownload(new graph(str3,0)));
            jf2.dispose();
          
            
            //new graph(str3);
            //Thread g1= new Thread (new graph(str3));
            //g1.start();
            
          // checkmain.v.add("4 &&@ nika &&@ m &&@ gndu &&@ jki &&@ "+URL);
           }
        }
        //if (o == b1) {

          //  try {
          //      Thread.sleep(50);
            //} catch (Exception e) {
            //}
        //}

        
        if (o == b13) {
            System.exit(0);
            //setState(JFrame.DISPOSE_ON_CLOSE);
        }
        if (o == b14) {
            b14.setVisible(false);
            b15.setVisible(true);
            //for (; hght <= 580; hght++) {
                jf2.setSize(880, 600);
           // }
        }
        if (o == b15) {
            b15.setVisible(false);
            b14.setVisible(true);
            //for (; hght >= 200; hght--) {
                jf2.setSize(880, 220);
            //}
        }
        if (o == b16) {
        FileDialog fd = new FileDialog(jf2, "Save", FileDialog.SAVE);
        fd.show();
         jtf13.setText(fd.getDirectory() + fd.getFile());
        }
    }
    
    
}



class graph extends Observable implements Runnable, ActionListener {

// Max size of download buffer.
private static final int MAX_BUFFER_SIZE = 1024;
// These are the status names.
public static final String STATUSES[] = {"Downloading",
"Paused", "Complete", "Cancelled", "Error"};
// These are the status
public static final int DOWNLOADING = 0;
public static final int PAUSED = 1;
public static final int COMPLETE = 2;
public static final int CANCELLED = 3;
public static final int ERROR = 4;
private float fsize,fsize2;
private int  framestatus;

float downloaded;
private int status, times,bcount;
private int perc;
private boolean que,rtable;
Process p, p2;
private String filename, lasttryon, folderloc,filepath;
URL u1;
TrayIcon trayIcon2;
           private String addedon, threadname, filesize="",dwnsize="";
   
    
       
//,addedon;
// Constructor for Download.
public String getthreadname(){
return threadname;
}
           
public int getframestatus(){
return framestatus;
}
// Get this download's URL.
public URL getUrl() {
return u1;
}


public String getcmdstring() {
return gurl;
}
// Get this file name
public String getFileName() {
return filename;
}
 public String getAddtime() {
return addedon;
}
public String gettrytime() {
return lasttryon;
}

// Get this download's size.
public String getSize() {
     if (rtable== false){ 
    try{
    DecimalFormat df= new DecimalFormat("0.##");

        if(fsize>= 1024 && !(fsize>= (1024*1024)) ){
        float floatsize= fsize/1024;
        
        //System.out.println("\n  Size "+fsize+" KB");
        
        filesize=(df.format(floatsize) +" KB");
        }
        else if(fsize>= (1024*1024)&& !(fsize>= (1024*1024*1024))){
        float floatsize= (fsize)/(1024*1024);
        //System.out.println(" Size  "+fsize+" MB");
        filesize=(df.format(floatsize)+" MB");
        }
        else if(fsize>= (1024*1024*1024)&& !(fsize>= (1024*1024*1024*1024))){
        float floatsize= (fsize)/(1024*1024*1024);
        //System.out.println("  Size "+fsize+" GB");
        
        filesize=(df.format(floatsize)+" GB");
        }
        else if(fsize>= (1024*1024*1024*1024)&& !(fsize>= (1024*1024*1024*1024*1024))){
        float floatsize= (fsize)/(1024*1024*1024);
        //System.out.println("  Size  "+fsize+" TB");
  filesize=(df.format(floatsize)+" TB");
 }
        else if(fsize< 1024) {
        float floatsize= fsize;
            //System.out.println(" Size  "+fsize+" Bytes");
  filesize=(df.format(floatsize)+" Bytes");
 }else{}

    }catch(Exception fs){}
return filesize;
     }else{
return filesize;
     }
    
    
}

public String getdirloc(){
return folderloc;
}

public String getfilepath(){
return filepath;
}
public String getdownloaded() {
     if (rtable== false){
    try{
    DecimalFormat df= new DecimalFormat("0.##");
   
        if(downloaded>= 1024 && !(downloaded>= (1024*1024)) ){
        float floatsize= downloaded/1024;
        
        //System.out.println("\n  Size "+downloaded+" KB");
        
        dwnsize=(df.format(floatsize) +" KB");
        }
        else if(downloaded>= (1024*1024)&& !(downloaded>= (1024*1024*1024))){
        float floatsize= (downloaded)/(1024*1024);
        //System.out.println(" Size  "+downloaded+" MB");
        dwnsize=(df.format(floatsize)+" MB");
        }
        else if(downloaded>= (1024*1024*1024)&& !(downloaded>= (1024*1024*1024*1024))){
        float floatsize= (downloaded)/(1024*1024*1024);
        //System.out.println("  Size "+downloaded+" GB");
        
        dwnsize=(df.format(floatsize)+" GB");
        }
        else if(downloaded>= (1024*1024*1024*1024)&& !(downloaded>= (1024*1024*1024*1024*1024))){
        float floatsize= (downloaded)/(1024*1024*1024);
        //System.out.println("  Size  "+downloaded+" TB");
  dwnsize=(df.format(floatsize)+" TB");
        }
        else if((downloaded< 1024) && (!(downloaded>= 1024))) {
        float floatsize= downloaded;
            //System.out.println(" Size  "+downloaded+" Bytes");
  dwnsize=(df.format(floatsize)+" Bytes");
        }else{
        
        }
}catch(Exception ne){}

return dwnsize;
 
     }else{return dwnsize;}
    
}

// Get this download's progress.
public int getProgress() {
return perc;//jp1.getValue();//((float) downloaded2 / fsize) * 100;
}
// Get this download's status.
public int getStatus() {
return status;
}
public int getbuttoncount() {
return bcount;
}
public boolean getquestatus() {
return que;
}

public boolean getrtablestat() {
return rtable;
}
// Pause this download.
public void pause() {
status = PAUSED;
p.destroy();

stateChanged();
}
// Resume this download.
public int gettimes(){
return times;
}
public void resume() {
times= times+1;
    status = DOWNLOADING;
stateChanged();
//Thread resume= new Thread(this);

//resume.start();
download();
}
// Cancel this download.
public void cancel() {
p.destroy();
jf1.dispose();
status = CANCELLED;
stateChanged();
}
// Mark this download as having an error.
private void error() {
status = ERROR;
stateChanged();
}
// Start or resume downloading.
private void download() {
//times= 0;
    Thread thread = new Thread(graphmain2.tdg, this);
thread.start();
}

public void setTrayicon(){
try{      
                if (SystemTray.isSupported()) {
                SystemTray tray2 = SystemTray.getSystemTray();
                Image image = Toolkit.getDefaultToolkit().getImage("256_001.png");
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
                checkmain.dpopup.setLocation(e.getX(), e.getY());
                checkmain.dpopup.setInvoker(checkmain.dpopup);
                checkmain.dpopup.setVisible(true);
                }
                };
                
                
                ActionListener exitListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                System.out.println("Exiting...");
                System.exit(0);
                }
                };

                
                
                checkmain.dpopup = new JPopupMenu();
                JMenuItem exit = new JMenuItem("Exit");
                exit.addActionListener(exitListener);
                checkmain.dpopup.add(exit);
                
                trayIcon2 = new TrayIcon(image, "Downloads");
                ActionListener actionListener = new ActionListener() {


                    
                    public void actionPerformed(ActionEvent e) {
                trayIcon2.displayMessage("Action Event",
                "An Action Event Has Been Performed!",
                TrayIcon.MessageType.INFO);
                }
                };

                trayIcon2.setImageAutoSize(true);
                trayIcon2.addActionListener(actionListener);
                trayIcon2.addMouseListener(mouseListener);

                
                try {
                tray2.add(trayIcon2);
                } catch (AWTException e) {
                System.err.println("TrayIcon could not be added.");
                }
                } else {
//System Tray is not supported
                }


  }catch(Exception te){}
  


}
// Get file name portion of URL.
//private String getFileName(URL url) {
//String fileName = url.getFile();
//return fileName.substring(fileName.lastIndexOf('/') + 1);
//}
// Notify observers that this download's status has changed.
private void stateChanged() {
setChanged();
notifyObservers();
}
    
    JMenuItem d1;
        
    JProgressBar jp1;
    String str1;
    JPanel gui2;
    String temp2 = "";
    Container con;
    JTextField jtf1;
    String  bv;
    Thread t2;
    JMenuBar mbar;
    JMenu file;
    JMenuItem n, e, c, r,pause;
    List jl1;
    JLabel l1;
    JLabel pbstatus;
    ImageIcon i;
    String str7;
    //JProgressBar jp1;
    LineBorder line;
    JButton  b5, b6;
    JFrame jf1;
    JLabel pbstatus2;
    List jl2;
    String str1p;
    
    String gurl,readline;
    String[] temp;
    
    
    public graph(String line) {
         readline= line;
    temp = readline.split("&&@", 16);
    rtable= Boolean.TRUE;
    for(int i=0;i<temp.length;i++){
        
             //System.out.println(""+temp.length);
             //System.out.println("Value of i"+i);
    //System.out.println("Value of temp"+temp[i]);
    
             // v.add(readline[i]);
        switch(i){
        case 0://File NAme
       
            try{
            filename= ""+temp[0];
       }catch(Exception ne){}
             //System.out.println("Value of filename "+filename);
    
        case 1://status
        String stus= temp[1].trim();
        String dnl= "Downloading";
        String pus="Paused";
        String cmplt="Complete";
        String cancl="Cancelled";
        String err= "Error";
// These are the status
        if(stus.equals(dnl))
    {
        status=ERROR;
    }
        else if(stus.equals(pus)){
        status=ERROR;
    }
        else if(stus.equals(cmplt)){
        status=COMPLETE;
    }
        else if(stus.equals(cancl)){
        status=CANCELLED;
    }
        else if(stus.equals(err)){
        status=ERROR;
    }
        else{
        status=ERROR;
        }
        //System.out.println("Value of status "+status);
        case 2://File NAme
        que= Boolean.parseBoolean(temp[2].trim());
        if(que== true){
//Scheduler2.tableModel.addDownload(this);
      }else{}
//      //System.out.println("Value of lasttryon"+que);
        case 3://progress
       // perc = Integer.parseInt(temp[i]);
            //System.out.println("Value of percentage "+perc);
        case 4://filesize
        filesize= temp[4].trim();
            //System.out.println("Value of filesize"+filesize);
        case 5://filesize
        dwnsize= temp[5].trim();
            //System.out.println("Value of downloaded"+dwnsize);
        case 6://url
       try{ u1= new URL(temp[6].trim());}
            catch(Exception urle){        }
            //System.out.println("Value of url "+u1);
        case 7://Add time
        folderloc= temp[7].trim();
        case 8://File NAme
        addedon= temp[8].trim();
            //System.out.println("Value of addedon "+addedon);
        case 9://File NAme
        threadname= temp[9].trim();
            //System.out.println("Value of threadname "+threadname);
        case 10://File NAme
        gurl= temp[10].trim();
            //System.out.println("Value of gurl "+gurl);
        case 11://File NAme
        try{
            framestatus= Integer.parseInt(temp[11].trim());
        if(framestatus==1){
        framestatus=0;
        }
        }catch(Exception ne){}
            //System.out.println("Value of framestatus "+framestatus);
        case 12://File NAme
        try{
            times= Integer.parseInt(temp[12].trim());
        }catch(Exception ne){}
            //System.out.println("Value of times "+times);
        case 13://File NAme
        try{
            bcount= Integer.parseInt(temp[13].trim());
        }catch (Exception ne){}
            //System.out.println("Value of buttoncount "+bcount);
       case 14:
           filepath= temp[14].trim();
        case 15://File NAme
        lasttryon= temp[15].trim();
            //System.out.println("Value of lasttryon"+lasttryon);
        
        }}}
    
    
    
    public graph(String url, int tmes, Boolean bl1, String floc) {
        checkmain.buttoncount++;
        gurl = url;
        bcount= checkmain.buttoncount;
        times= tmes;
        framestatus=1;
        que= bl1;
        folderloc= floc;
        rtable= Boolean.FALSE;
        //fsize = -1;
//        downloaded2 = 0;
        status = DOWNLOADING;
      if(que== true){
//        Scheduler2.tableModel.addDownload(this);
      }else{}
//    jf1.setTitle("Module 1 (Download Manager GArgi) Property OF TLC");
    
        //str1p = "wget ";
        jf1= new JFrame();
        jf1.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent we) {
                jf1.setState(JFrame.DISPOSE_ON_CLOSE);
                framestatus=0;
            }
        });
       jf1.setLayout(null);
           l1 = new JLabel();
        //i=new ImageIcon("welcome.jpg");
        jp1 = new JProgressBar(0, 100);
        mbar = new JMenuBar();
        pbstatus = new JLabel("");
        
        file = new JMenu("File");
        //outbox= new JTextArea();
        jl1 = new List();
        l1 = new JLabel(i);
          //  check.stopall2 = new JButton("Stop All");
        //bv= "true";
        str7 = "© 2011-12 All Rights Reserved.";
        
        n = new JMenuItem("Start");
        c = new JMenuItem("Cancel");
        pause = new JMenuItem("pause");
        r = new JMenuItem("Resume");

jp1.setStringPainted(true);
//        b1 = new JButton("Add");
        checkmain.pausebutton[checkmain.buttoncount] = new JButton("Pause");
        checkmain.cancelbutton[checkmain.buttoncount] = new JButton("Exit");
        checkmain.resumebutton[checkmain.buttoncount] = new JButton("Resume");
        b5 = new JButton("Show Details>>");
        b6 = new JButton("Hide Details<<");       //b1.setRolloverIcon(ror1);
           //check.stopall2.setVisible(false);
        checkmain.pausebutton[checkmain.buttoncount].setEnabled(true);
        
        
     //   jf1.add(b1);
        jf1.add(checkmain.pausebutton[checkmain.buttoncount]);
        jf1.add(checkmain.cancelbutton[checkmain.buttoncount]);
        jf1.add(checkmain.resumebutton[checkmain.buttoncount]);
        jf1.add(b5);
        jf1.add(b6);
        jf1.add(pbstatus);
        jf1.add(jl1);
        //jf1.add(check.stopall2);
        
        mbar.add(file);


        file.add(n);
        file.addSeparator();
        file.add(c);
        file.addSeparator();
        file.add(r);
        file.addSeparator();
        jf1.add(l1);
        file.add(pause);

        l1.setText(str7);

       
        checkmain.resumebutton[checkmain.buttoncount].setEnabled(false);
        checkmain.pausebutton[checkmain.buttoncount].setEnabled(true);
        b6.setVisible(false);
        
            
        jp1.setBounds(10, 80, 641, 20);
        pbstatus.setBounds(10, 120, 641, 40);
        l1.setBounds(380, 850, 300, 30);
        jl1.setBounds(10, 250, 641, 420);
    //    b1.setBounds(20, 180, 100, 30);
        checkmain.pausebutton[checkmain.buttoncount].setBounds(190, 180, 100, 30);
        checkmain.resumebutton[checkmain.buttoncount].setBounds(360, 180, 100, 30);
        checkmain.cancelbutton[checkmain.buttoncount].setBounds(530, 180, 100, 30);
        b5.setBounds(20, 210, 150, 30);
        b6.setBounds(20, 210, 150, 30);
        
            

     
       
        jf1.add(jp1);
        jf1.add(pbstatus);
        
        stateChanged();
        
        jf1.setJMenuBar(mbar);
        jf1.setVisible(true);
                jf1.setSize(880, 300);
        jf1.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - jf1.getWidth()) / 2,
                ((Toolkit.getDefaultToolkit().getScreenSize().height - jf1.getHeight()) / 2)-100);

// Begin the download.
 if(times == 0)
     {
        addedon = new Date().toString();
        download();
        //addedon= ""+d1.getHours()+":"+d1.getMinutes()+":"+d1.getSeconds()+" `"+d1.getDay() + "/" + d1.getMonth()+ "/" + d1.getYear()+"`";
//System.out.println("Date is"+ addedon);

     }
     else{
     resume();
     }
                     ActionListener show = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                System.out.println("Showing");
                jf1.show();
                jf1.setVisible(true);
                //jf1.show();
                jf1.toFront();
                jf1.setState(JFrame.MAXIMIZED_BOTH);
                }
                };
 
 
     if (checkmain.dtray==false){
     checkmain.dtray=true;
         setTrayicon();

         d1 = new JMenuItem("");

     d1.addActionListener(show);
                checkmain.dpopup.add(d1);
                
     }else{
     d1 = new JMenuItem("");
                d1.addActionListener(show);
                checkmain.dpopup.add(d1);
     
     }
 
      pause.addActionListener(this);
        n.addActionListener(this);
        c.addActionListener(this);
        r.addActionListener(this);
     //   b1.addActionListener(this);
        checkmain.pausebutton[checkmain.buttoncount].addActionListener(this);
        checkmain.cancelbutton[checkmain.buttoncount].addActionListener(this);
        checkmain.resumebutton[checkmain.buttoncount].addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        //check.stopall2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();

        if (o == c || o == checkmain.pausebutton[checkmain.buttoncount]) {
            checkmain.resumebutton[checkmain.buttoncount].setEnabled(true);
            checkmain.pausebutton[checkmain.buttoncount].setEnabled(false);
            status = PAUSED;
            p.destroy();
            
            //p2.destroy();

        }
       
       
        if (o == checkmain.resumebutton[checkmain.buttoncount] || o == r) {
            checkmain.pausebutton[checkmain.buttoncount].setEnabled(true);
            checkmain.resumebutton[checkmain.buttoncount].setEnabled(false);
            //str1p = "wget -c ";
            resume();
            try {
                Thread.sleep(50);
            } catch (Exception e) {
            }
        }
//if ( o == check.stopall2) {
    //        p.destroy();
      //      jf1.dispose();
  //      }
        if (o == e || o == checkmain.cancelbutton[checkmain.buttoncount]) {
            p.destroy();
            jf1.dispose();
            framestatus=0;
        }
        if ( o == b5) {

            jf1.setSize(880, 800);
            b5.setVisible(false);
            b6.setVisible(true);
        }
        if ( o == b6) {

            jf1.setSize(880, 310);
            b5.setVisible(true);
            b6.setVisible(false);
        }
    }
    public void run() {
        //Process p;
        int b, s;
      String furl= new String();
          Date d2= new Date();
        lasttryon = d2.toString();
        
        
        //lasttryon= ""+d1.getHours()+":"+d1.getMinutes()+":"+d1.getSeconds()+" `"+d1.getDay() + "/" + d1.getMonth()+ "/" + d1.getYear()+"`";
System.out.println("Date is"+ lasttryon);
        try {
             if(times == 0)
     {
     str1p = "wget ";
     
     }
     else{
     str1p = "wget -c ";
     
     }
             times++;
            Thread.currentThread().setName("Thread "+checkmain.count);
            checkmain.count++;
            threadname= ""+Thread.currentThread().getName();
           // graphmain2.tdg.
            
            int perc2;
System.out.println("1");
                    if (gurl.contains("http://")){
                     furl= ""+gurl.substring(gurl.indexOf("http://"));
                    }
                    else if (gurl.contains("ftp://")){
                     furl= ""+gurl.substring(gurl.indexOf("ftp://"));
                    }
                    else if (gurl.contains("https://")){
                     furl= ""+gurl.substring(gurl.indexOf("ftp://"));
                    }
               u1= new URL(furl);      
            
System.out.println("2");
            //fsize= u1.openConnection().getContentLength();
               
            
            
            ////System.out.println("str2 is" + fsize);
            //System.out.println("str1 string: " + str1p);
            //System.out.println("Combine string example!");
            String com =  "" +str1p+" "+ gurl ;
            System.out.println("Combined string: " + com);     
            p = Runtime.getRuntime().exec("" + com);
            
            ////System.out.println("Process executed");
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String response = "";
            String temp = "";
            int temp1=0;
            while ((temp = stdInput.readLine()) != null) {{
                temp = temp;
                //temp1++;
                
                System.out.println(temp);  
                Thread.sleep(500);
                jl1.add(temp, 0);
                String lenth= "Length: ";
                String nme="Saving to: ";
               if( (temp.contains(nme)) ){
                   
               String fna=temp.substring(temp.lastIndexOf(": `") + 3, temp.indexOf("'")-0);
               ////System.out.println("String get is:"+ fname2);
               if(fna.contains("/")==true){
               String fna2= temp.substring(temp.lastIndexOf("/")+1, temp.indexOf("'")-0);
               filename= fna2;
               filepath= fna;
               }else{
               filename= fna;}
               filepath= "na";//System.out.println("File Name is:"+ filename);
               }
               else{
               ////System.out.println("didn't get size");
               } 
               if( (temp.contains(lenth)) ){
                   
               String fname2=temp.substring(temp.lastIndexOf(": ") + 2, temp.indexOf(" (")-0);
               ////System.out.println("String get is:"+ fname2);
               fsize = Integer.parseInt(fname2);
               fsize2= fsize;
               //System.out.println("Size is:"+ fsize);
               }
               else{
               ////System.out.println("didn't get size");
               } 
                if (temp.indexOf("% ") >= 0) {
                    s = temp.indexOf("% ");
                    if (Character.isDigit(temp.charAt(s - 3))) {
                        b = s - 3;
                    } else if (Character.isDigit(temp.charAt(s - 2))) {
                        b = s - 2;
                    } else if (Character.isDigit(temp.charAt(s - 1))) {
                        b = s - 1;
                    } else {
                        b = 0;
                        
                    }
                    jp1.setValue(Integer.parseInt(temp.substring(b, s)));
                    
                    perc= jp1.getValue();
                    
                    d1.setLabel(""+perc+" %  "+filename);
                    
        DecimalFormat df= new DecimalFormat("0.##");
        
                    
        downloaded= (perc*fsize)/100;
                     if(downloaded>= 1024 && !(downloaded>= (1024*1024)) ){
        downloaded= downloaded/1024;
       // //System.out.println("  Size "+downloaded+" KB");
        pbstatus.setText(jp1.getValue() + "% Completed.     Downloaded= "+df.format(downloaded)+" KB");}
        else if(downloaded>= (1024*1024)&& !(downloaded>= (1024*1024*1024))){
        downloaded= (downloaded)/(1024*1024);
       // //System.out.println("                Size  "+downloaded+" MB");
        pbstatus.setText(jp1.getValue() + "% Completed.     Downloaded= "+df.format(downloaded)+" MB");}
        else if(downloaded>= (1024*1024*1024)&& !(downloaded>= (1024*1024*1024*1024))){
        downloaded= (downloaded)/(1024*1024*1024);
       // //System.out.println("  Size "+downloaded+" GB");
        
        pbstatus.setText(jp1.getValue() + "% Completed.     Downloaded= "+df.format(downloaded)+" GB");}
        else if(downloaded>= (1024*1024*1024*1024)&& !(downloaded>= (1024*1024*1024*1024*1024))){
        downloaded= (downloaded)/(1024*1024*1024);
        ////System.out.println("  Size  "+downloaded+" TB");
        pbstatus.setText(jp1.getValue() + "% Completed.     Downloaded= "+df.format(downloaded)+" TB");}
        else if(downloaded< 1024) {
        ////System.out.println("  Size  "+downloaded+" Bytes");
        pbstatus.setText(jp1.getValue() + "% Completed.     Downloaded= "+df.format(downloaded)+" Bytes");}
        
                   stateChanged();
                   graphmain2.writefile();
                    //System.out.println(""+downloaded); 
                    if (jp1.getValue() == 100) {
                      status = COMPLETE;
                    javax.swing.JOptionPane.showMessageDialog(null, "Download Successfully Completed !", "Complete", 1);
                  graphmain2.writefile();
                  framestatus=0;    
                    jf1.dispose();
              Thread.currentThread().stop();
                    }
                   
                }
              

            }}
            stdInput.close();
           
           
            
            
        } catch (Exception e1) {
        }
//        p.exitValue();
        //System.out.println("You are watching this msg because you got error or process completed!");
        status = ERROR;
        //javax.swing.JOptionPane.showMessageDialog(null, "You are watching this msg because you got error or process completed withot downloading! Or File is already downloaded", "Message", 1);
          framestatus=0;
    }
}




class testaddl {
    Process p,p2;
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception err) {
            //System.out.println("Error loading Linux Theme:" + err.toString());
        }
        //Class v1[] = testadd2.class.getClasses();
        new graphpnl2();
        
}}

import javax.swing.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.*;

class Yframe extends JFrame implements ActionListener
{
    Container con;
    JSplitPane splitPane;
    JMenuBar mb; 
    JScrollPane sp1,sp2;
    ImageIcon ico;
    FileDialog fd1,fd2;
    SPanel p1,p2;
    JTabbedPane t;
    JMenu file,edit,view,tools,help;
    JMenuItem f1,f2,f3,f4,f5,f6,f7,f8,fopen;
    JMenuItem e1,e2,e3,e4,e5,e6,e7; 
    JMenuItem t1,t2,t3;
    String epath,path,url,fn,dn,tfn,tdn,ipath,sipath,sepath,tpath,ext;
    Process pd,pe,ps;
    FilenameFilter filefilter;
	
       
    public Yframe()
    {
	setTitle("Steganography");
	setIconImage(new ImageIcon("images/author.gif").getImage()); 
    //Menubar
	    mb = new JMenuBar();
	    setJMenuBar(mb);
	    file = new JMenu("File");
	    file.add(fopen=new JMenu("Open..."));
	    fopen.add(f1=new JMenuItem("Cover Image",new ImageIcon("images/open2.gif"))); 
	f1.setMnemonic(KeyEvent.VK_O);          		
	f1.addActionListener(this);
	        f1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));    
	        fopen.add(f2=new JMenuItem("Text",new ImageIcon("images/txticon3.gif")));   
	f2.setMnemonic(KeyEvent.VK_T);  	
	f2.addActionListener(this); 
        fopen.add(f7=new JMenuItem("Image",new ImageIcon("images/video.gif")));  
	f7.setMnemonic(KeyEvent.VK_I);  	
	f7.addActionListener(this); 
        file.add(f8=new JMenuItem("Close",new ImageIcon("images/stop.gif")));   
	f8.setMnemonic(KeyEvent.VK_C);  	
	f8.addActionListener(this); 
	file.addSeparator(); 
        file.add(f3=new JMenuItem("Save",new ImageIcon("images/save.gif")));     
	f3.setMnemonic(KeyEvent.VK_S); 	f3.addActionListener(this);
	f3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
	file.add(f4=new JMenuItem("Save As...",new ImageIcon("images/saveas.gif")));
	f4.setMnemonic(KeyEvent.VK_A);
	f4.addActionListener(this);
        file.addSeparator();
        file.add(f6=new JMenuItem("Exit",new ImageIcon("images/close.gif")));     
	f6.setMnemonic(KeyEvent.VK_X); 	
	f6.addActionListener(this);
        file.setMnemonic(KeyEvent.VK_F);
        mb.add(file);
	edit = new JMenu("Edit");
	edit.setMnemonic(KeyEvent.VK_E);
	edit.add(e1=new JMenuItem("Cut",new ImageIcon("images/cut.gif")));   
	e1.setMnemonic(KeyEvent.VK_T);  	
	e1.addActionListener(this);
	e1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));    
        edit.add(e2=new JMenuItem("Copy",new ImageIcon("images/copy.gif")));  
	e2.setMnemonic(KeyEvent.VK_C);  	
	e2.addActionListener(this); 
	e2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));       
	edit.add(e3=new JMenuItem("Paste",new ImageIcon("images/paste.gif"))); 
	e3.setMnemonic(KeyEvent.VK_P);  	
	e3.addActionListener(this);
	e3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
	edit.addSeparator();
	edit.add(e4=new JMenuItem("Delete",new ImageIcon("images/close.gif")));
	e4.setMnemonic(KeyEvent.VK_L);  	
	e4.addActionListener(this);
        e4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));
        edit.add(e5=new JMenuItem("Select All",new ImageIcon("images/txticon1.gif")));
	e5.setMnemonic(KeyEvent.VK_A);  	
	e5.addActionListener(this);
        e5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
	mb.add(edit);
	tools = new JMenu("Tools");
	tools.add(t1=new JMenuItem("Make Stegano Image",new ImageIcon("images/wheel.gif")));
	t1.setMnemonic(KeyEvent.VK_M); 	
	t1.addActionListener(this);
	t1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
	tools.add(t2=new JMenuItem("Read Stegano Data",new ImageIcon("images/wheel.gif")));
	t2.setMnemonic(KeyEvent.VK_R); 	
	t2.addActionListener(this);
	t2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
	tools.addSeparator();
	tools.add(t3=new JMenuItem("Properties",new ImageIcon("images/display.gif")));
	t3.setMnemonic(KeyEvent.VK_P); 	
	t3.addActionListener(this);
    	t3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
	ButtonGroup group2 = new ButtonGroup();    
	tools.setMnemonic(KeyEvent.VK_O);
	mb.add(tools);
	JMenuItem h1,h2;
	help=new JMenu("Help");
	help.setMnemonic(KeyEvent.VK_H);
	help.add(h1=new JMenuItem("Steganography Help",new ImageIcon("images/help.gif")));
	h1.setMnemonic(KeyEvent.VK_S);
	h1.addActionListener(this);
	help.add(h2=new JMenuItem("About...",new ImageIcon("images/information.gif")));
	h2.setMnemonic(KeyEvent.VK_A);
	h2.addActionListener(this);
	mb.add(help);
     	f2.setEnabled(false);
	f3.setEnabled(false);
	f4.setEnabled(false);
	f7.setEnabled(false);
	t1.setEnabled(false);
	t2.setEnabled(false);
	t3.setEnabled(false);
        p1=new SPanel(new BorderLayout());
        p2=new SPanel(new BorderLayout());
        ico=new ImageIcon("images/wheel.gif");
        p2.removePanel();
        t=new JTabbedPane();
        t.addTab("Encrypt",ico,p1);
        t.addTab("Decrypt",ico,p2);
	con=getContentPane();
        con.add(t);
  }
   
public void actionPerformed(ActionEvent e)
  {
  
   try
   {
     String s;
     s = e.getActionCommand();
      
   if(s.equals("Cover Image")||s.equals("Image"))
     {       
	fd1=new FileDialog(this,"open",FileDialog.LOAD);
	fd1.setDirectory(dn); 	
	fd1.show();
	    dn=fd1.getDirectory();
	    fn=fd1.getFile();
				 	
			
         
		  if (fn!=null)
		 { 
        	 path=dn+fn;
		 url="file:///"+path;
	     ico=new ImageIcon(new URL(url));
		 
		 t3.setEnabled(true);
		 
		
         if (s.equals("Cover Image")  )
		 {  
		    if(t.getSelectedIndex()==0)
		 	{
			epath=path;
			this.setTitle(fn+" - Steganography");
            p1.setCoverImage(ico);
			t1.setEnabled(true); 
			f2.setEnabled(true);
            f7.setEnabled(true); 
			}
			else
		 	{
			
		 	this.setTitle(fn+" - Steganography");
		 	p2.setCoverImage(ico);  
			t2.setEnabled(true); 
		 	} 	
		 } 
		 else
		 {  
		 	if (t.getSelectedIndex()==0)
			{
			ipath=path;
		    p1.showImage(); 
		    p1.setImage(ico);
			}
		 }	  
       
		 }
		 
	       
	}
       
		
		
         if(s.equals("Text") && t.getSelectedIndex()==0)
        {
	 fd1=new FileDialog(this,"open",FileDialog.LOAD);       
         fd1.setDirectory(tdn); 
         fd1.show();
                
		 
		 tdn=fd1.getDirectory();
		 tfn=fd1.getFile();
		 tpath=tdn+tfn;
		 if (tfn!=null)
		 {
	         p1.setPage(tpath);
		 p1.showText();
		 }
		
       
		}
 
	    if(s.equals("Close"))
        {
         
         this.setTitle("Steganography");
         if(t.getSelectedIndex()==0)
            p1.close();	
        else
            p2.close();
		f2.setEnabled(false);
		f3.setEnabled(false);
    		f4.setEnabled(false);
        	f7.setEnabled(false);
	    t1.setEnabled(false);
	    t2.setEnabled(false);
	    t3.setEnabled(false);
	   
		ipath=null;	
        }	
	  
		if(s.equals("Save") || s.equals("Save As..."))
        {
		
         	fd2=new FileDialog(this,"Save",FileDialog.SAVE);
		 	fd2.show();
		 	dn=fd2.getDirectory();
		 	fn=fd2.getFile();  
		 	path=dn+fn; 
			
			if (fn!=null)
			{

		 	if(t.getSelectedIndex()==0)
		 	{
 		     	ico=p1.getSteganoImage();
				ps=new Process(ico);
		    	ps.saveImage(ico,path,new Utils().getExtension(new File(epath)),"png");
			//t2.setEnabled(true);
			}
	     	else
			{
			 	ico=p2.getImage();
				ps=new Process(ico);
		    	ps.saveImage(ico,path,ext,ext);
			//t2.setEnabled(true);
			}
			}
		
		 
          }
		 
		if(s.equals("Make Stegano Image"))
        {	
           pe=new Process(p1.getCoverImage());		   
		   boolean success=pe.setTextBuffer(p1.getBuffer());
		   if (success)
		   {
		    f3.setEnabled(true);
   		    f4.setEnabled(true);
		   	if (ipath!=null)
			{
             pe.setImage(p1.getImage(),new Utils().getExtension(new File(ipath)));
			}
		

		   p1.setSteganoImage(pe.mergeData());
			
		   System.out.println("Message merged successfully....");
		   p2.setCoverImage(ico);
		   }	
        }
		
		if(s.equals("Read Stegano Data"))
        {
		   
		    f3.setEnabled(true);
   		    f4.setEnabled(true);
			
		    path=null;
		    ico=p2.getCoverImage();		
            	pd=new Process(ico);		   
		    int cbuf[] =pd.getBuffer();
			p2.setText(cbuf);
			if (pd.getImage()!=null)
			{
			ico=pd.getImage();
			ext=pd.getExtension();
			p2.setImage(ico);
			}
				
        }
		 
		  
	 if(s.equals("Cut"))
	    {
        if(t.getSelectedIndex()==0)
            p1.cut();
		else	
       	    p2.cut();
	    }	
         
     if (s.equals("Copy"))
	   {
        if(t.getSelectedIndex()==0)
            p1.copy();
        else
            p2.copy();
       }  
	   
     if(s.equals("Paste"))
       {
         if(t.getSelectedIndex()==0)
            p1.paste();
        else
            p2.paste();
       }  
     if(s.equals("Delete"))
       {
         if(t.getSelectedIndex()==0)
            p1.clearText();
        else
            p2.clearText();
       }  
     if(s.equals("Select All"))
       {
        if(t.getSelectedIndex()==0)
            p1.selectAllText();
        else
            p2.selectAllText();
       } 
	   
       if(s.equals("Undo"))
         {
          if(t.getSelectedIndex()==0)
              p1.undo();
          else
              p2.undo();
         } 
      
         if(s.equals("Redo"))
           {
            if(t.getSelectedIndex()==0)
                p1.redo();
            else
                p2.redo();
           } 
	  
	   


		
		
	    if(s.equals("Properties"))
        {
		 final JDialog d;
		 d=new JDialog(this,"Properties");	
		 t=new JTabbedPane();
		 ico=new ImageIcon("images/wheel.gif");
		 
		 Properties pr1=new Properties(d,epath);
		 JPanel p1=pr1.getPanel();
		 t.addTab("Cover Image",ico,p1);
		 
		if (ipath!=null)
		{
		 Properties pr2=new Properties(d,ipath);
		 JPanel p2=pr2.getPanel();
		 t.addTab("Image",ico,p2);
		}
		
		d.getContentPane().add(t);
  		d.show();      
        }

         if (s.equals("About..."))
	 {  
	    
	 JOptionPane.showMessageDialog(new Yframe(),"Steganography 1.0","About Steganography...",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("images/butterfly48.png"));
	 }
     
     if(s.equals("Exit"))
          System.exit(0);

     }
    catch(Exception er)
        {
        System.out.println("Stegano ERROR::"+er.getMessage());
        }
   }       
}


class Welcome
{
Timer timer;
final Window w;

 
 public Welcome(JFrame yf)
 {
 w=new Window(yf);
 w.setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-280,(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-80);
 JButton closeButton = new JButton(new ImageIcon("images/Stegano3.jpg"));

             closeButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
             w.dispose();   } });
 
 closeButton.setBorder(BorderFactory.createEmptyBorder());
 closeButton.setOpaque(false);		
 w.add(new JLabel(new ImageIcon("images/pid1.jpg")),BorderLayout.WEST);
 w.add(closeButton,BorderLayout.CENTER);
 JLabel label=new JLabel(new ImageIcon("images/welcome3.gif"));
 label.setOpaque(true);
 w.add(label,BorderLayout.NORTH);
 w.pack();
 w.show();
 	
 	   
 	
 timer = new Timer(2000, new ActionListener()
 			{
				//int l=50,t=50;
            public void actionPerformed(ActionEvent evt) 
	  		{
		    w.dispose();
		    timer.stop();
		        }
	                });	   
		timer.start(); 
	  }
	   	
		   
}


class Stegano 
{
 
  public static void main(String arg[])
  {
	server6 sb=new server6();
	sb.ServerGui();   

	new server6();
	
	Yframe yf = new Yframe();
	new Welcome(yf);	 
        yf.setSize(Toolkit.getDefaultToolkit().getScreenSize()); //640,480);
        yf.setVisible(true);
	yf.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
              System.exit(0);
            }
        });
  }
 
}
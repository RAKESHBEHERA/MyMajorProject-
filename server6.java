import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.lang.*;
import java.sql.*;

public class server6
{
 public JFrame f;
 public List topl,downl;
 
 public JFrame f1;
 public JMenuBar m;
 public JMenu New,menu,file,edit,help;
 public JMenuItem open,save,saveAs,exit,Agenda;
 public JLabel label;
 public JTextField t;
 public JButton b,connect;
 public String input="";
 public String input1="Developed By: Rakesh Behera";
 public String input2="Salkhan Majhi";

public void AgendaGui()
{
try{

 f1=new JFrame("Agenda Window");
 f1.setSize(300,300);
 f1.setResizable(false);
 f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
 
 Container content=f1.getContentPane();
 content.setLayout(null);

 m=new JMenuBar();
 file=new JMenu("File");
 m.add(file);
   
 New=new JMenu("New");
 open=new JMenuItem("Open");
 save=new JMenuItem("Save",'S');
 saveAs=new JMenuItem("SaveAs");
 save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK,false));
 exit=new JMenuItem("Exit");

 Agenda=new JMenuItem("Agenda");

 file.add(New);
 file.add(open);
 file.addSeparator();
 file.add(save);
 file.add(saveAs);
 file.add(exit);

 New.add(Agenda);

 f1.setJMenuBar(m);
 
 label=new JLabel("Agenda");
 f1.getContentPane().add(label);
 label.setBounds(90,100,70,25);

 t=new JTextField(30);
 f1.getContentPane().add(t);
 t.setBounds(90,130,170,25);

 b=new JButton("OK");
 f1.getContentPane().add(b);
 b.setBounds(170,160,55,25);

 content.setBackground(Color.orange);
 f1.setVisible(true);	
 
      b.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
	{	        		                     
		input=t.getText(); 
		input1=t.getText();
		input2=t.getText();
		System.out.println(input);				
		System.out.println(input1);
		System.out.println(input2);								
		
			topl.add(input);
			topl.add(input1);
			topl.add(input2);
         }});
}catch(Exception e){}
}

public void ServerGui()
 {
  f=new JFrame("Server");
  f.setSize(450,450);
  f.setResizable(false);
  f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

 connect=new JButton("Connect");
  f.getContentPane().add(connect);
  connect.setBounds(200,200,90,35);
  
  Container content=f.getContentPane();
  content.setLayout(null);
 
   topl=new List();
  f.getContentPane().add(topl);
  
 topl.add(input);
 topl.add(input1);
 topl.add(input2);
 topl.setBounds(20,20,300,170);

  Color c=new Color(184,7,184);
  content.setBackground(c);//  f.setVisible(true);

    f.setVisible(true);  	 
     connect.addActionListener(new ActionListener(){
    
    public void actionPerformed(ActionEvent e)
     { 
	new Stegano();
  }
 });



 }

public void downl(String str)
{
	downl.add(str);
}


public static void main(String args[])
 {
	server6 sb=new server6();
	sb.ServerGui();	
	new Stegano();

}
}



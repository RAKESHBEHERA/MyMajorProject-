import javax.swing.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Properties
{
   JPanel jp;
   JLabel l1,l2,l3,l4,l5,l6,l7;
   ImageIcon mico;
   File file;
   
	public Properties(final JDialog d,String path)
	{
		file=new File(path);
	    	mico=new ImageIcon(path);
		jp=new JPanel(new BorderLayout(20,20));
		jp.setLayout(new GridLayout(0,2,5,15));
  		jp.add(new JLabel("Name     :     ",JLabel.RIGHT));
  		l1=new JLabel(new ImageFileView().getName(file));
		jp.add(l1);
		jp.add(new JLabel("Extension     :     ",JLabel.RIGHT));
  		l6=new JLabel(new Utils().getExtension(file));
 	    	jp.add(l6);
  		jp.add(new JLabel("Type     :     ",JLabel.RIGHT));
  		l2=new JLabel(new ImageFileView().getTypeDescription(file));
  		jp.add(l2);
  		jp.add(new JLabel("Width     :     ",JLabel.RIGHT));
  		l3=new JLabel(""+mico.getIconWidth());
  		jp.add(l3);
  		jp.add(new JLabel("Height     :     ",JLabel.RIGHT));
  		l4=new JLabel(""+mico.getIconHeight());
  		jp.add(l4); 
  		jp.add(new JLabel("Directory     :     ",JLabel.RIGHT));
  		l5=new JLabel(new ImageFileView().getDirectory(file));
  		jp.add(l5); 
  		l7=new JLabel("");
  		jp.add(l7);
	
		     JButton closeButton = new JButton("Close");
             closeButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
             d.dispose();
                        }
                    });
		jp.add(closeButton); 
		
		d.setDefaultCloseOperation(new JDialog().DISPOSE_ON_CLOSE);
		d.setSize(260,300);
	}
	public JPanel getPanel()
	{
		return jp;
	}
		
}

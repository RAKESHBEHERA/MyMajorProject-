	import javax.swing.*;
	import java.awt.*;
	import java.io.*;

public class SPanel extends JPanel
{
    Container con;
    JLabel label1,label2,label3;
    JSplitPane jsp1,jsp2;
    JTextArea tp;
    JTabbedPane tab; 
    JScrollPane sp1,sp2,sp3,sp4;
    ImageIcon ico;
    double width;

    int buf[];
    int size=0;
public SPanel(LayoutManager lf)
    {
      super(lf);
     
      ico=new ImageIcon("");
      label1=new JLabel(ico) ;
      label2=new JLabel(ico) ;
      label3=new JLabel(ico) ;
     
      tp=new JTextArea();
      tp.setCaretPosition(0);
      tp.setMargin(new Insets(5,5,5,5));

      Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
      width=dim.getWidth();

      //FOR SCROLLBAR
      sp1=new JScrollPane(label1);
      sp2=new JScrollPane(tp); 
      sp3=new JScrollPane(label2);
      sp4=new JScrollPane(label3);


      tab=new JTabbedPane();
      tab.addTab("Text",sp2);
      tab.addTab("Image",sp3);


     
     jsp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,sp1,tab);
     
     jsp1.setOneTouchExpandable(true);
     jsp1.setDividerLocation((int)width/3);//200);
	 
     jsp2=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jsp1,sp4);
     jsp2.setOneTouchExpandable(true);
     jsp2.setDividerLocation((int)width*2/3);//400);

     //Provide minimum sizes for the two components in the split pane.
     Dimension minimumSize = new Dimension(100, 50);
     label1.setMinimumSize(minimumSize);
     tp.setMinimumSize(minimumSize);  
	 sp1.setMinimumSize(minimumSize);  
	 sp2.setMinimumSize(minimumSize);
	 sp3.setMinimumSize(minimumSize); 
	 sp4.setMinimumSize(minimumSize);     

     //Provide a preferred size for the split pane.
     jsp1.setPreferredSize(new Dimension(400, 200));
     jsp2.setPreferredSize(new Dimension(400, 200));      

     add(jsp2);
   }
public void removePanel()
   {
   jsp2.remove(sp4);
   jsp1.setDividerLocation(((int)width/2)-20);//300);
   }
   
public void setCoverImage(ImageIcon ico)
   {
     label1.setIcon(ico);
   }
   
public void setImage(ImageIcon ico)
   {
    label2.setIcon(ico);
   }
   
public void setSteganoImage(ImageIcon ico)
   {
    label3.setIcon(ico);
   } 
   
public void setSteganoImage(Icon ico)
   {
    label3.setIcon(ico);
   } 
   
   
public ImageIcon getCoverImage()
   {
   return (ImageIcon)label1.getIcon(); 
   }
   
public ImageIcon getImage()
   {
    return (ImageIcon)label2.getIcon();
   }
   
public ImageIcon getSteganoImage()
   {
   return (ImageIcon)label3.getIcon();
   } 
   
public void showText()
   {  
   tab.setSelectedIndex(0);
     
   }
public void showImage()
   {  tab.setSelectedIndex(1);
     
   }
  
public int[] getBuffer()
   {
	String text= tp.getText();
	int  len=text.length()+16;
	
	int  x,y,z;

         x=len/10000;
         y=len/100- x*100;
         z=len-(x*10000+y*100);
	 
   	buf=new int[len+16];
	buf[0]=x;
	buf[1]=y;
	buf[2]=z;
	
        char str[]=new char[len];
	for (int i=0;i< text.length();i++)
	{
		buf[i+16]=text.charAt(i);
	}
	return buf;    
   }
   
public void setText(String str)
   {
   	tp.setText(str);
	
   }
public String getText()
   {
   	return tp.getText();
   }
public void setText(int cbuf[])
   {
        tp.setText("");
   	for (int i=0;i<cbuf.length;i++)
	{
	 tp.append(String.valueOf((char)cbuf[i]));		
	}
   }	
   	
public void setPage(String url)
   {
   
    try
    {
	  
	
	tp.selectAll();
	tp.replaceSelection("");
      	FileInputStream fn=new FileInputStream(url);
      	int ch;
      	while((ch=fn.read())!=-1)
      	{
       	tp.append(String.valueOf((char)ch));
      	}
      	fn.close();
                   
     }
      catch(Exception er)
      {
      System.out.println("SPanel ERROR::"+er.getMessage());
     }

   }
public void close()
{
 	 label1.setIcon(new ImageIcon(""));
	 label2.setIcon(new ImageIcon(""));
	 label3.setIcon(new ImageIcon(""));
	 tp.selectAll();
	 tp.replaceSelection("");
	}
public void cut()
   {
      tp.cut();
   }
public void copy()
   {
     tp.copy();
   }
public void paste()
   {
      tp.paste();
   }
public void selectAllText()
   {
      tp.selectAll();
   }
public void clearText()
   {						 
      tp.replaceSelection("");
   }
public void undo()
   {						 
      
   }
 public void redo()
   {						 
      
   }
   
   
 } 
 

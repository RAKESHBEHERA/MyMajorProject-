	import java.io.File;
	import javax.swing.*;
	import javax.swing.filechooser.*;

public class ImageFileView extends FileView 
{
    	ImageIcon jpgIcon = new ImageIcon("images/jpgIcon.gif");
    	ImageIcon gifIcon = new ImageIcon("images/gifIcon.gif");
	ImageIcon tiffIcon= new ImageIcon("images/tiffIcon.gif");
	ImageIcon txtIcon = new ImageIcon("images/txtIcon.gif");
	ImageIcon pngIcon = new ImageIcon("images/pngIcon.gif");
	ImageIcon bmpIcon = new ImageIcon("images/bmpIcon.gif");
	String sep="\\",s=sep.substring(0);
    
public String getName(File f) 
{ 
	  String name=""+f;
	  int n=name.lastIndexOf(s);
	  if (n<0)
	  	{
	  	return null;
		  }
	  else
	  	{
  	  
	  return name.substring(n+1); 
	  	}
         // let the L&F FileView figure this out
}
	 
public String getDirectory(File f) 
{
	  String dir=""+f;
	  int n=dir.lastIndexOf(s);
	  if (n<0)
	  	{
	  	return null;
		}
	  else
	  	{
	  return dir.substring(0,n);
	  	}
         // let the L&F FileView figure this out
}

    
public String getDescription(File f) 
{
        return null; // let the L&F FileView figure this out
}

  
public Boolean isTraversable(File f) 
{
      return null; // let the L&F FileView figure this out
}
    
public String getTypeDescription(File f) 
{
        String extension = Utils.getExtension(f);
        String type = null;

        if (extension != null) {
            if (extension.equals(Utils.jpeg) ||
                extension.equals(Utils.jpg)) {
                type = "JPEG Image";
            } else if (extension.equals(Utils.gif)){
                type = "GIF Image";
            } else if (extension.equals(Utils.bmp)){
                type = "Bitmap Image";
            } else if (extension.equals(Utils.tiff) ||
                       extension.equals(Utils.tif)) {
                type = "TIFF Image";
            } else if (extension.equals(Utils.txt)){
                type = "Text Document";
		    } else if (extension.equals(Utils.png)){
                type = "PNG Image";
			}else type = "Unknown File";
        }							
        return type;
		
    }
   
public Icon getIcon(File f) 
{
        String extension = Utils.getExtension(f);
        Icon icon = null;

        if (extension != null) {
            if (extension.equals(Utils.jpeg) ||
                extension.equals(Utils.jpg)) {
                icon = jpgIcon;
            } else if (extension.equals(Utils.gif)) {
                icon = gifIcon;
            } else if (extension.equals(Utils.tiff) ||
                       extension.equals(Utils.tif)) {
                icon = tiffIcon;
            } else if (extension.equals(Utils.png)) {
                icon = pngIcon;
			} else if (extension.equals(Utils.txt)) {
                icon = txtIcon;	
		    } else if (extension.equals(Utils.bmp)) {
                icon = bmpIcon;	
            } 
		
        }
        return icon;
    }
}

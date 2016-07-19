import java.io.File;

import javax.swing.filechooser.*;



class TextFilter extends FileFilter 
{
    
    
    
public boolean accept(File f) 
{
        
if (f.isDirectory()) 
{
            
return true;
        
}

        

String extension = Utils.getExtension(f);
	
if (extension != null) 
{
            
if (extension.equals(Utils.txt))
                 
{
                    
return true;
                 
}
			 
else 
			     
{
                
return false;
                 
}
    	
}

        
return false;
    
}
    
    
// The description of this filter
    
public String getDescription() 
{
        
return "Text Files";
    
}

}

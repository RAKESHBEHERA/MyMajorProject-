import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PasswordDialog extends JDialog implements ActionListener
    {
    Label l,l1;
    TextField tf;
    Button bt[];
    String p;
    Panel p1,p2,p3;
    public PasswordDialog(JFrame f)
        {
        super(f,true);
        setSize(250,100);
        setLocation(250,250);

        p1 = new Panel(new GridLayout(1,3));
        getContentPane().add(p1,"North");
        l = new Label("    Enter Password");
        p1.add(l);
        l1 = new Label("    Min Length Of Password 8 Characters");
        getContentPane().add(l1,"Center");
        tf = new TextField(8);
	tf.addActionListener(this);
        p1.add(tf);
        tf.setEchoChar('*');
        p2 = new Panel(new GridLayout(1,2));
	getContentPane().add(p2,"South");
        bt = new Button[2];
        String s[] = {"Accept","Cancel"};
        for(int i=0;i<=1;i++)
            {
            bt[i] = new Button(s[i]);
            bt[i].addActionListener(this);
            p2.add(bt[i]);
            }
        }

    public void actionPerformed(ActionEvent e)
        {
        String cmd = e.getActionCommand();

            if(cmd.equals("Cancel"))
            {
            p = null;
            this.setVisible(false);
            }
		else
            {
            p = tf.getText();
            if(p.length()<8)
               JOptionPane.showMessageDialog(this,"Min Length Of Password Must Be 8 Characters","Error",JOptionPane.ERROR_MESSAGE);
            else
               this.setVisible(false);
            }
        }
     public String getPassword()
        {
        return p;
        }
    }

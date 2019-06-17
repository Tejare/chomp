package swingdemo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Tejas
 */
public class fiveuser implements ActionListener{
    JButton ja[][]=new JButton[40][40];
    String name[]=new String[3];
	int player=0;
    fiveuser()
    {
        JFrame jfr=new JFrame("HUNGRY FOR COOKIES!!!");
        jfr.setLayout(new GridLayout(40,40)); 
        jfr.setSize(700, 700);
	
        name[0]=JOptionPane.showInputDialog(null, "Enter the name of Player 1", "Hello", 0);
	name[1]=JOptionPane.showInputDialog(null, "Enter the name of Player 2", "Hello", 0);
        
	Icon poison_image=new ImageIcon("F:\\Html's\\cookiesmall.png");
	int t=0;
        for(int i=0;i<40;i++)
        {
        	for(int j=0;j<40;j++)
        	{
        		ja[i][j]=new JButton(poison_image);
        		t++;
        	    ja[i][j].setActionCommand(String.valueOf(t));
        	    ja[i][j].addActionListener(this);
        	    jfr.add(ja[i][j]);
        	}
        }
	jfr.getContentPane().setBackground( Color.MAGENTA);
        jfr.setVisible(true);
	
    }
    
    
    public void actionPerformed(ActionEvent ae)
    	{
        int t=Integer.parseInt(ae.getActionCommand());
        int c=(t-1)%40+1;
        int r=(t-1)/40+1;
        c--;r--;
	player++;
        for(int i=0;i<40;i++)
                {
                    for(int j=0;j<40;j++)
                    {
                        if(r==0&&c==0)
                        {
                            JOptionPane.showMessageDialog(null,name[player%2]+" wins!!");
                            return;
                        }
                        if(r<=i&&c<=j)
                           {
                                ja[i][j].setVisible(false);
                           }
					
                    }
        	}
   	}
   
}

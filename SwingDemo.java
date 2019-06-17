package swingdemo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Tejas
 */
public class SwingDemo implements ActionListener{
    JButton ja[][]=new JButton[3][3];//Creating JButtons
    String name[]=new String[3];//Creating a string array to store the player names
	int player=0;
    SwingDemo()
    {
	    //Taking the name input
    	name[0]=JOptionPane.showInputDialog(null, "Enter the name of Player 1", "Hello", 0);
	name[1]=JOptionPane.showInputDialog(null, "Enter the name of Player 2", "Hello", 0);
        JFrame jfr=new JFrame("3 by 3");
	//Creating a new jframe
        jfr.setLayout(new GridLayout(3,3)); 
        jfr.setSize(700, 700);
        Icon poison_image=new ImageIcon("F:\\Html's\\oreo.png");
	int t=0;
        for(int i=0;i<3;i++)//The buttons are initialised
        {
        	for(int j=0;j<3;j++)
        	{
        		ja[i][j]=new JButton(poison_image);
        		t++;
			ja[i][j].setActionCommand(String.valueOf(t));
			ja[i][j].addActionListener(this);
			jfr.add(ja[i][j]);
        	}
        }
	jfr.getContentPane().setBackground( Color.MAGENTA );
        jfr.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)//When a cookie gets pressed
    	{
        int t=Integer.parseInt(ae.getActionCommand());
        int c=(t-1)%3+1;
        int r=(t-1)/3+1;
        c--;r--;
	player++;
        for(int i=0;i<3;i++)//To delete the cookies to the right and the bottom of the eaten cookie
                {
                    for(int j=0;j<3;j++)
                    {
                        if(r==0&&c==0)
                        {//If the poisoned cookie is eaten
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

package swingdemo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Tejas
 */
public class fouruser implements ActionListener{
    JButton ja[][]=new JButton[4][4];//The jbuttons
    	String name[]=new String[3];//String to store player names
	int player=0; 
    fouruser()
    {
	//For taking the player name input
	name[0]=JOptionPane.showInputDialog(null, "Enter the name of Player 1", "Hello", 0);
	name[1]=JOptionPane.showInputDialog(null, "Enter the name of Player 2", "Hello", 0);
        JFrame jfr=new JFrame("Four by four");
	//Creating a new jframe
        jfr.setLayout(new GridLayout(4,4)); 
        jfr.setSize(700, 700);
        
        Icon poison_image=new ImageIcon("F:\\Html's\\oreo4x4.png");
	int t=0;
        for(int i=0;i<4;i++)//For creating the buttons
        {
        	for(int j=0;j<4;j++)
        	{
        		ja[i][j]=new JButton(poison_image);
        		t++;
        	    ja[i][j].setActionCommand(String.valueOf(t));
        	    ja[i][j].addActionListener(this);
        	    jfr.add(ja[i][j]);
        	}
        }
        jfr.getContentPane().setBackground( Color.GREEN);
        jfr.setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae)//When a cookie is eaten
    	{
        int t=Integer.parseInt(ae.getActionCommand());
        int c=(t-1)%4+1;
        int r=(t-1)/4+1;
        c--;r--;
	player++;
        for(int i=0;i<4;i++)
                {
                    for(int j=0;j<4;j++)
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

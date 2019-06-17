package swingdemo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Tejas
 */
public class awesomeness implements ActionListener{
    JLabel jlab;
    JButton ja[][]=new JButton[5][5];
    
    public int find(int r,int c)
	{
		System.out.println("Inside find");
            int a=0;int b=0;
            boolean arr[][]=new boolean[5][5];
            for(int i=0;i<5;i++)
            {
                for(int j=0;j<5;j++)
		{
			arr[i][j]=ja[i][j].isVisible();
		}
            }
            destroy(r,c,arr);
            for(int k=0;k<5;k++)
            {
                for(int l=0;l<5;l++)
                {
                    if(ja[k][l].isVisible()!=arr[k][l])
                    {
                        a++;
                    }
                }
            }
            
            if(a==2)
            {
             return(1);
            }
            else
            {
                return(0);
            }
	}
	
    
    void destroy(int r,int c,JButton jc[][])
    {
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(r<=i&&c<=j)
                {
                    jc[i][j].setVisible(false);
		    System.out.println("deleted "+i+", "+j);
                }					
            }
        }
    }
    
    void destroy(int r,int c, boolean jc[][])
    {
	    System.out.println("Inside arr del");
	for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(r<=i&&c<=j)
                {
                    jc[i][j]=false;
		    //System.out.println("deleted "+i+", "+j);
                }					
            }
        }  
    }
    
    public void computer()
	{
	int ctr=0;
        int a=0;
        int b=0;
        int d=0;
        System.out.println("Entered computer");
	for(int i=0;i<5;i++)
        {
           for(int j=0;j<5;j++)
           {
               if(ja[i][j].isVisible()!=false)
			{
			ctr++;
		}
               if(ja[i][j].isVisible()!=false)
               {
                   a++;
               }
               if(j!=0&&ja[i][j].isVisible()!=false)
               {
                   b++;
               }
               if(i!=0&&ja[i][j].isVisible()!=false)
               {
                   d++;
               }
           }
        }
        System.out.println(String.valueOf(ctr));
        if(a==1)
        {
            JOptionPane.showMessageDialog(null,"YOU WIN!!");
            return;
        }
        
        if(b==0)
        {
            destroy(1,0,ja);
            return;
        }
        
        if(d==0)
        {
            destroy(0,1,ja);
            return;
        }
        
        if(ctr%2!=0)
	{
		System.out.println("Odd number of cookies are left");
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				int eat=find(i,j);
				if(eat==1)
					{
						System.out.println("Found "+i+", "+j);
					destroy(i,j,ja);
                                        int z=(i)*5+j+1;
                                        System.out.println("\nThe computer ate the cookie number : "+z);
					return;
				}
			}
		}
	}
	else
		{
			System.out.println("The number is even");
		int r=0;int c=0;
		for(int i=0;i<5;i++)
           	{
                	for(int j=0;j<5;j++)
                	{
                            if(ja[i][j].isVisible()!=false)
                            {
                                if(i>=r)
                                {
                                    r=i;
                                    c=j;
                                }
                            }
                        }
        	}
		destroy(r,c,ja);
                int z=(r+1)*5+c+1;
                System.out.println("\nThe computer ate the cookie number : "+z);
		}
            return;
}
    
    awesomeness()
    {
        JFrame jfr=new JFrame("Artificial Intelligence");
        jfr.setLayout(new GridLayout(5,5));
        jfr.setSize(700, 700);
	
        Icon poison_image=new ImageIcon("F:\\Html's\\oreo5x5.png");
	    int t=0;
        for(int i=0;i<5;i++)
        {
        	for(int j=0;j<5;j++)
        	{
        		ja[i][j]=new JButton(poison_image);
        		t++;
        	    ja[i][j].setActionCommand(String.valueOf(t));
        	    ja[i][j].addActionListener(this);
        	    jfr.add(ja[i][j]);
        	}
        }
       
        jfr.getContentPane().setBackground( Color.blue);
        jfr.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    	{
        int t=Integer.parseInt(ae.getActionCommand());
        int c=(t-1)%5+1;
        int r=(t-1)/5+1;
        c--;r--;
	
	if(r==0&&c==0)
	{
		JOptionPane.showMessageDialog(null,"You lose...Please try again!!");
                return;
	}
	
	destroy(r,c,ja);
        System.out.println("computer");
        computer();  
	System.out.println("Out of computer");
   	}
   
}
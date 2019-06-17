/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingdemo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 *
 * @author Tejas
 */
public class menu //creating JMenu
{
JMenu menu,submenu,about,sub_menu1,sub_menu2;
	JMenuItem item1,item2,item3,item4,item5,c_item1,c_item2,c_item3,ab_chomp;	
	
	
	public menu()
	{
	JFrame f=new JFrame("CHOMP");
	
	JMenuBar mb=new JMenuBar();
	menu=new JMenu("File");
	submenu=new JMenu("New");
	sub_menu1=new JMenu("1 vs 1");
	item5=new JMenuItem("Computer");
	item1=new JMenuItem("3 x 3");
	item2=new JMenuItem("4 x 4");
	item3=new JMenuItem("HUNGRYYYYY");
	item4=new JMenuItem("Quit");

	
	//adding all items to Jmenu
	
	sub_menu1.add(item1);	//adding in human vs human 
	sub_menu1.add(item2);
	sub_menu1.add(item3);				
	

	
	submenu.add(sub_menu1);
	submenu.add(item5);
	menu.add(submenu);

	menu.add(item4);
	mb.add(menu);

	
	

	
	f.getContentPane().setBackground( Color.orange );
	JLabel t = new JLabel( "Chomp", SwingConstants.CENTER );
        f.add( t, BorderLayout.CENTER );
	f.setJMenuBar(mb);
	f.setSize(500,500);
	f.setVisible(true); 
	
	about=new JMenu("Help");
	ab_chomp=new JMenuItem("About CHOMP");
	about.add(ab_chomp);

	mb.add(about);

	t.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
	
	


		
    item1.addActionListener(new ActionListener(){  		// 3 x 3 chomp game
        public void actionPerformed(ActionEvent e){	
		new SwingDemo();
	}
    });
    
    item2.addActionListener(new ActionListener(){			//4 x 4 chomp game
	public void actionPerformed(ActionEvent x)
	{
            new fouruser();
	}
    });
    
    item3.addActionListener(new ActionListener(){  		// 5 x 5 chomp game
            public void actionPerformed(ActionEvent e){	
		new fiveuser();
	}
    });
	
    item5.addActionListener(new ActionListener(){  		// 5 x 5 chomp game against  computer
        public void actionPerformed(ActionEvent e){	
		awesomeness obj=new awesomeness();
	}
    });	
	


    item4.addActionListener(new ActionListener(){ 			//quit option from menu
	public void actionPerformed(ActionEvent a)
	{
	System.exit(0);
	}
    });

ab_chomp.addActionListener(new ActionListener(){			//about chomp will get direct you to page of wikipedia
	public void actionPerformed(ActionEvent b)
	{
	 try {
        Desktop.getDesktop().browse(new URL("https://en.wikipedia.org/wiki/Chomp").toURI());
  	       } catch (Exception e) {
        e.printStackTrace();
			    }
	}
	});
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
	
	
        public static void main(String args[])
        {
            new menu();
        }
}

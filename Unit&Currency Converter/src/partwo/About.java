package partwo;


/* Developer:
 	Nabin Atreya Sunar
 	C7202333
 	The British College
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class About extends JFrame {
	private JPanel mainpanel;																												
	//Creating main Jpanel Variable
	
		public About() {																													
			//Starting About constructor
				setTitle("About Us");										
				setLocationRelativeTo(null);
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 601, 343);
				mainpanel = new JPanel();
				mainpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
				mainpanel.setLayout(new BorderLayout(0, 0));
				setContentPane(mainpanel);
		
				JPanel panel = new JPanel();																								
				//Creating  next Panel			
				panel.setBackground(Color.GRAY);
				mainpanel.add(panel, BorderLayout.CENTER);
				panel.setBackground(Color.decode("#1b7fbd"));
				panel.setLayout(null);
																																				
				JLabel developer_pic = new JLabel("");																						
				//creating JLabel 
				developer_pic.setIcon(new ImageIcon("../c7202333/images/logo.png"));
				developer_pic.setBounds(20, 20, 200, 200);
				panel.add(developer_pic);
		
				JLabel developer_name = new JLabel("<html><font color=black>Developed By:</font> Conversion Tool</html>");
				developer_name.setToolTipText("AUTHOR ");
				developer_name.setFont(new Font("arial black",Font.BOLD,20));
				developer_name.setForeground(Color.WHITE);
				developer_name.setBounds(20, 300, 400, 20);
				panel.add(developer_name);
		
				JLabel copyright = new JLabel("@ Copyright 2019");
				copyright .setToolTipText("Copy Right Information");
				copyright.setForeground(Color.black);
				copyright.setBackground(Color.decode("#6ba8a9"));
				copyright.setFont(new Font("arial black",Font.BOLD,16));
				copyright.setBounds(20, 270, 206, 28);
				panel.add(copyright);
		
				JButton btn_exit = new JButton("Exit");
				btn_exit.setToolTipText("Click Here To Exit This Window");
				//btnExit.setBackground(UIManager.getColor("RadioButtonMenuItem.selectionBackground"));
				btn_exit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {																			//adding action listener
							//System.exit(0);
							dispose();																											//dispose window
								}
					});
				btn_exit.setBounds(480, 300, 100, 40);
				btn_exit.setFont(new Font("arial black",Font.BOLD,20));
				btn_exit.setMnemonic(KeyEvent.VK_E);
				btn_exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_exit.setBackground(Color.decode("#ff0000"));
				btn_exit.setForeground(Color.white);
				panel.add(btn_exit);
		

				JTextArea description=new JTextArea("Welcome to the conversion tool to convert various units\n in categories such as inches to centimeter,\n degree to farherneit and much more. A converter is \nsoftware code that is designed to convert one units\n into respective"		
						//JtextField
						+ " order to check its corresponding value.\nThis tool also include various currencies conversion.\n Shortcut key (alt + (mnenomics)."
						+ "\n For More Details\n https://www.conversiontool.com"); 
				description.setBounds(260, 30, 550, 200);
				description.setForeground(Color.darkGray);
				description.setBackground(Color.white);
				description.setEditable(false);
				description.setFont(new Font("arial black",Font.PLAIN,17));
				panel.add(description);
				
				JLabel update=new JLabel("<html><u>Check Your Updates</u><html>");
				update.setBounds(400, 135, 400,100);
				update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				update.setForeground(Color.white);
				update.setFont(new Font("arial black",Font.PLAIN,17));
				panel.add(update);
				
				String version="<html><font color=white>Version:  <br>v.2.0.0_2019</font></html>";																		
				//adding description
				JLabel version_description=new JLabel(version);
				version_description.setBounds(260, 150, 550, 100);
				version_description.setBackground(Color.decode("#6ba8a9"));
				version_description.setFont(new Font("arial black",Font.BOLD,19));
				panel.add(version_description);
				JFrame.setDefaultLookAndFeelDecorated(true);
				//setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				setLocationRelativeTo(null);
				setResizable(true);
				setSize(750,550);																																	
				//frame size 
				setVisible(true);
		}																																							
		//End of constructor.
	}																																								
//End of class.

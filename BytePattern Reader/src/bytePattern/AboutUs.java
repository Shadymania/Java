package bytePattern;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * 
 * @author Nabin Atreya Sunar
 *			
 * 			
 * @version 1.0
 */


	public class AboutUs extends JFrame {
		/**
		 * Details out about the program and its uses.
		 * Give information about copy right and version of the program.
		 */
		
		/**
		 *  mainpanel Object of JPanel which adds the other panels in the class.
		 */
		private JPanel mainpanel;																												
		

			/**
			 * -----------------------------------------------------------------
			 *  Constructor: Setting up the AboutUs Class Graphical User Interface (GUI).
			 *             	 Default Constructor.
			 *-----------------------------------------------------------------			  
			 */
			public AboutUs() {																													
					
					/**
					 * Setting title, location, image icon and setBounds inside frame 
					 */
					setTitle("About Us");										
					setLocationRelativeTo(null);
					ImageIcon image=new ImageIcon("../Assignment_1/logo.png");
					setIconImage(image.getImage());
					/**
					 * Disable the close (x) in window of AboutUs class.
					 */
					setDefaultCloseOperation(0);
					setBounds(100, 100, 601, 343);
					mainpanel = new JPanel();
					
					/**
					 * Setting Border to the mainpanel Object.
					 */
					mainpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
					mainpanel.setLayout(new BorderLayout(0, 0));
					setContentPane(mainpanel);
					
					/**
					 *  Creating panel Object of JPanel 
					 *  Adding panel into the mainpanel at border layout center
					 */
					JPanel panel = new JPanel();																										
					mainpanel.add(panel, BorderLayout.CENTER);
					panel.setBackground(Color.decode("#035aa6"));
					panel.setLayout(null);
													
					/**
					 * Creating JLabel and passing image icon on it.
					 */
					JLabel developer_pic = new JLabel("");																						
					developer_pic.setIcon(new ImageIcon("../Assignment_1/images/logo.png"));
					developer_pic.setBounds(20, 20, 200, 200);
					panel.add(developer_pic);
					
					/**
					 * Declaring String to pass text on it.
					 */
			      	String version="<html><font color=white>Byte Pattern (File Scanner) \n"
			      			+ "\nVersion: V.1.0</font></html>";
			      	
							/**
							 * Creating JLabel for version description 
							 * Adding into the panel Object
							 */
							JLabel version_description=new JLabel(version);
							version_description.setBounds(20, 100, 200, 250);
							version_description.setBackground(Color.decode("#6ba8a9"));
							version_description.setFont(new Font("arial black",Font.ITALIC,12));
							panel.add(version_description);
							
							/**
							 * Creating JLabel for update
							 * Adding into panel Object
							 */
							JLabel update=new JLabel("<html><u>Check Your Updates</u><html>");
							update.setBounds(20, 230, 200,100);
							update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							update.setForeground(Color.white);
							update.setFont(new Font("arial black",Font.PLAIN,12));
							panel.add(update);
							
							/**
							 * Creating JLabel for developer name
							 * Adding into panel Object
							 * Setting tool tip, setBounds and Color.
							 */
							JLabel developer_name = new JLabel("<html><font color=#ffcd3c>Developed By: Byte Pattern Corporation</font></html>");
							developer_name.setToolTipText("AUTHOR ");
							developer_name.setFont(new Font("",Font.BOLD,12));
							developer_name.setForeground(Color.decode("#ffcd3c"));
							developer_name.setBounds(20, 270, 200, 100);
							panel.add(developer_name);
							
							/**
							 * Creating JLabel for copyright
							 * Adding into panel Object
							 */
							JLabel copyright = new JLabel("@ Copyright 2020");
							copyright .setToolTipText("Copy Right Information");
							copyright.setForeground(Color.white);
							copyright.setBackground(Color.decode("#6ba8a9"));
							copyright.setFont(new Font("arial black",Font.PLAIN,12));
							copyright.setBounds(20, 310, 200, 100);
							panel.add(copyright);
		
							
							/**
							 * Declaring String and passing whole description information on it.
							 * Details out the whole program how it works.
							 * Has Shortcut key (or hotkey) description.
							 * Has Rule of Usage protocols.
							 */
					String description="A Byte Pattern is a file scanner program that allows to scan\n"
							+ "a specific file or give access to choose directory and comp-\n"
							+ "-aring them to the specific byte format.\n"
							+ " \n"
							+ "It identify known byte-patterns (signatures) within file \n"
							+ "contents. It reads the contents of files, scan these contents\n"
							+ "for certain byte-patterns. \n"
							+ "A 'User' or 'You' can select from Menu Items. There are\n"
							+ "some pre-defined patterns in the program which compares \n"
							+ "its pattern according to the nature of files.\n\n"
							+ "Using shortcut key (or hotkey) to speed up the \n"
							+ "access to frequently used actions. For example:\n\n"
							+ " alt + F = Select File Menu\n"
							+ " alt + H = Help Menu\n"
							+ " alt + S = Select A File\n"
							+ " alt + D = Select A Directory/Folder\n"
							+ " alt + L = Load A Pattern File\n"
							+ " alt + N = New Window\n"
							+ " alt + E = Exit\n"
							+ " alt + C = Clear\n"
							+ " alt + A = About Us\n"
							
							
							
							+ "\n\t*** Rules of Usage ***\n\n"
							
							+ "1. You have the right to use the Product and its services.\n"
							+ "However, you may not get involved in any of the following\nactivities:\n\n"
							+ "1.1: The ownership and operation of the Product and its\n"
							+ " services belongs to Byte Pattern Corporation.\n\n"
							
							+ "1.2: The user can install, use, or run the software for non-\n"
							+ "commercia purpose. However, if it uses for commericial \n"
							+ " purposes and cannot copy the data during the operation of \n"
							+ "the Product. \n\n"
							
							+ "1.3: Remove copyright information from the Product and its\n"
							+ "copies, modify and remove will be taken as guilty or \n"
							+ "can consider a certain fines. \n\n "
							
							+ "1.4: No reverse engineering. Decompile or attempt to derive\n"
							+ "the source code of the Product otherwise.\n\n"
							
							+ "1.5: This agreement takes effect on April 20, 2020.\n";
					
					
					/**
					 * Declaring jt as Object of JTextArea to display all the String value.
					 * 
					 */
					JTextArea jt=new JTextArea(description,8,20);
					jt.setBackground(Color.decode("#035aa6"));
					jt.setForeground(Color.white);
					jt.setEditable(false);
					
					/**
					 * Declaring js as Object of JScrollPane and passing jt Object of JTextArea
					 * Adding js Object into the panel
					 */
					JScrollPane js=new JScrollPane(jt);
					js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
					js.setBounds(230, 40, 350, 350);
					panel.add(js);
					JFrame.setDefaultLookAndFeelDecorated(true);
					
					/**
					 * Creating media JPanel for the social medias
					 */
					JPanel media = new JPanel();
					media.setBackground(Color.decode("#035aa6"));
					//Setting border and title for media Panel.
					media.setBorder(new TitledBorder(null, "Follow Us", TitledBorder.CENTER, TitledBorder.TOP, null,Color.decode("#f6d743")));
					media.setBounds(100, 400, 340, 90);
					
					/**
					 * Image Icon for various social medias.
					 */
					ImageIcon fb=new ImageIcon("../Assignment_1/images/facebook.png");
					ImageIcon ig=new ImageIcon("../Assignment_1/images/instagram.png");
					ImageIcon gm=new ImageIcon("../Assignment_1/images/gmail.png");
					ImageIcon yt=new ImageIcon("../Assignment_1/images/youtube.png");
					ImageIcon b=new ImageIcon("../Assignment_1/images/back.gif");
					
					/**
					 * facebook JButton direct into the Facebook Media
					 * Passing object of Image into facebook button.
					 */
					JButton facebook = new JButton(fb);
					facebook.setBackground(Color.orange);
					facebook.setBounds(5, 5, 24, 24);
					facebook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					facebook.setToolTipText("www.bytepattern.com/Facebook");
					/**
					 * Adding actionListener with actionPerfomed method 
					 * Using try catch to the URL of facebook
					 */
					facebook.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							try {
								URL url=new URL("www.facebook.com");
							} catch (MalformedURLException e) {
								e.printStackTrace();
							}
						}
					});
					
					/**
					 * instagram JButton direct into the Instagram Media
					 * Passing object of Image into instagram button.
					 */
					JButton instagram = new JButton(ig);
					instagram.setBackground(Color.ORANGE);
					instagram.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					instagram.setBounds(5, 5, 24, 24);
					instagram.setToolTipText("www.bytepattern.com/Instagram");
					/**
					 * Adding actionListener with actionPerfomed method 
					 * Using try catch to the URL of instagram
					 */
					instagram.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							try {
								URL url_insta=new URL("www.instagram.com");
							} catch (MalformedURLException e) {
								e.printStackTrace();
								
							}
						}
					});
					
					/**
					 * gmail JButton direct into the Gmail Media
					 * Passing object of Image into gmail button.
					 */
					JButton gmail = new JButton(gm);
					gmail.setBackground(Color.ORANGE);
					gmail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					gmail.setBounds(5, 5, 24, 24);
					gmail.setToolTipText("www.bytepattern.com/Gmail");
					/**
					 * Adding actionListener with actionPerfomed method 
					 * Using try catch to the URL of gmail
					 */
					gmail.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							try {
								URL url_gmail=new URL("www.gmail.com");
							} catch (MalformedURLException e) {
								e.printStackTrace();
							}
						}
					});
					
					/**
					 * youtube JButton direct into the Youtube Media
					 * Passing object of Image into youtube button.
					 */
					JButton youtube = new JButton(yt);
					youtube.setBackground(Color.ORANGE);
					youtube.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					youtube.setBounds(5, 5, 24, 24);
					youtube.setToolTipText("www.bytepattern.com/YoutubeChannel");
					/**
					 * Adding actionListener with actionPerfomed method 
					 * Using try catch to the URL of youtube
					 */
					youtube.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							try {
								URL url_youtube=new URL("www.youtube.com");
							} catch (MalformedURLException e) {
								e.printStackTrace();
							}
						}
					});
					
					JLabel right=new JLabel("All Reserved Information");
					right.setForeground(Color.white);
					
					/**
					 * back JButton direct you to the MyGUIPanel after clicking into it.
					 * Passing image icon inside the back button
					 */
					JButton back=new JButton(b);
					back.setBounds(525, 2, 50, 35);
					back.setBackground(Color.red);
					back.setToolTipText("Click Here To Go Back");
					back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					/**
					 *
					 * Adding actionListener with actionPerfomed method 
					 * It disposes the window
					 */
					back.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {																			
							dispose();																									
								}
					});
					
					/**
					 * adding all social media Object to the media panel
					 */
					media.add(facebook);
					media.add(instagram);
					media.add(gmail);
					media.add(youtube);
					media.add(right);
					
					panel.add(back);
					panel.add(media);
					/**
					 * setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
					 */
					setLocationRelativeTo(null);
					setResizable(false);
					//frame size 
					setSize(600,550);																																	
					setVisible(true);
					//End of constructor.
			}									
	}

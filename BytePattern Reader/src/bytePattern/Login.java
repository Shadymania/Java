package bytePattern;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 * 
 * @author Nabin Atreya Sunar			
 * @version 1.0
 */

	
	public class Login  {
	
			/**
		    * A JButton as btnlogin to enter into this system.
		    */
		private JButton btnlogin;
		
		


		public Login(){
			
			/**
			 * Creating frame as an Object of JFrame
			 */
			JFrame frame=new JFrame("BytePattern Login Window");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			/**
			 * Creating panel_one as an Object of JPanel to add JLabel of login.
			 */
			JPanel panel_one=new JPanel();
			/**
			 * Setting Layout as null to use the properties of setBounds method.
			 */
			//Setting up the Color
			panel_one.setLayout(null);
			panel_one.setBounds(0, 0, 850, 60);
			panel_one.setBackground(Color.DARK_GRAY);
			
			//Creating login as an Object of JLabel
			JLabel login=new JLabel("<html><u>Login</u><html>");
			//Setting up the properties for the login 
			login.setFont(new Font("Dialog", Font.BOLD, 26));
			login.setForeground(Color.ORANGE);
			login.setBackground(Color.BLACK);
			login.setBounds(57, 10, 185, 30);
			panel_one.add(login);
			//Adding panel_one Object of JPanel to the frame.
			frame.getContentPane().add(panel_one);
			
			/** Creating panel_two as an Object of JPanel to add JLabel of username Object
			*   and JTextField of user_textfield Object.
			*/
			JPanel panel_two=new JPanel();
			panel_two.setLayout(null);
			panel_two.setBounds(0, 0, 850, 1000);
			
			/**
			 * Creating username as an Object of JLabel and setting up color, font and setBounds.
			 */
			JLabel username=new JLabel("User Name");
			username.setFont(new Font("Dialog", Font.BOLD, 25));
			username.setForeground(Color.white);
			username.setBounds(525, 325, 170, 36);
			/**
			 * Adding username into panel_two Object of JPanel.
			 */
			panel_two.add(username);
			
			// Creating user_textfield Object of JTextField
			// It allows the user to enter the text.
			JTextField user_textfield = new JTextField(8);
			user_textfield.setBounds(500, 365, 267, 39);
			user_textfield.setFont(new Font("Dialog", Font.BOLD, 20));
			user_textfield.setBackground(Color.decode("#29a19c"));
			user_textfield.setForeground(Color.yellow);
			user_textfield.setCaretColor(Color.WHITE);
			user_textfield.setToolTipText("Please enter valid user");
			
			/** Adding MouseListener events to the user_textfield.
			*   Notifies whenever it change the state of mouse.
			*/
			user_textfield.addMouseListener(new MouseAdapter(){	
				
				@Override
					public void mouseClicked(MouseEvent e){
						user_textfield.setText("");																							
								}
					});
			/**
			 * Adding builtin keyListener interface to the user_textfield
			 * Notify whenever user change the state of key. 
			 * It is notified against KeyEvent in the btnlogin button. 
			 */
			user_textfield.addKeyListener((KeyListener) new KeyAdapter() {																		
					public void keyPressed(KeyEvent key) {
						if(key.getKeyCode() == KeyEvent.VK_ENTER)
							btnlogin.doClick();
						}
					});
			panel_two.add(user_textfield);
			
			/**
			 * Creating panel_2 as an Object of JPanel to Color in the GUI
			 */
			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBackground(Color.MAGENTA);
			panel_2.setBounds(500, 400, 267, 10);
			panel_two.add(panel_2);
			
			
			/** Adding JLabel of password Object
			*   and JTextField of user_password Object in the panel_two Object of JPanel.
			*/
			JLabel password=new JLabel("Password");
			password.setFont(new Font("Dialog", Font.BOLD, 25));
			password.setForeground(Color.white);
			password.setBounds(525, 430, 170, 36);
			panel_two.add(password);
			
			/**
			 * JPasswordField make invisible to see the entered text.
			 */
			JPasswordField user_password = new JPasswordField(10);
			user_password.setBounds(500, 470, 267, 39);
			user_password.setToolTipText("Please enter valid password.");
			user_password.setCaretColor(Color.WHITE);
			user_password.setFont(new Font("Dialog", Font.BOLD, 20));
			user_password.setBackground(Color.decode("#29a19c"));
			user_password.setForeground(Color.yellow);
			panel_two.add(user_password);
			
			/**
			 * Adding built-in keyListener interface to the user_password
			 * Notify whenever user change the state of key. 
			 * It is notified against KeyEvent in the btnlogin button. 
			 */
			user_password.addKeyListener((KeyListener) new KeyAdapter() {
				public void keyPressed(KeyEvent key) {																					//adding keylistener to button with if condition
					if(key.getKeyCode() == KeyEvent.VK_ENTER)
						btnlogin.doClick();
						}
				});
			
			//Creating another feed Object of JPanel to give colorful in GUI.
			JPanel feed = new JPanel();
			feed.setLayout(null);
			feed.setBackground(Color.MAGENTA);
			feed.setBounds(500, 505, 267, 10);
			panel_two.add(feed);
			
			/**
			 * btnlogin Object of JButton allows to check if user name and password are correct
			 * enter into the main system to carry out the file scanning.
			 */
			JButton btnlogin=new JButton("Login");
			btnlogin.setToolTipText("Click Here To Login In");
			btnlogin.setMnemonic(KeyEvent.VK_L);
			btnlogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnlogin.setBounds(550, 550, 150, 50);
			btnlogin.setForeground(Color.decode("#f1fa3c"));
			btnlogin.setBackground(Color.decode("#29a19c"));
			btnlogin.setFont(new Font("Arial Black",Font.BOLD,20));
			btnlogin.addActionListener(new ActionListener(){																			
				public void actionPerformed(ActionEvent e) {
					//Creating image Object to pass into the JOptionPane for user name and password.
					ImageIcon sad=new ImageIcon("../Assignment_1/images/sad.png");
					ImageIcon wrong=new ImageIcon("../images/user_pass.png");
					
					/**
					 * Stores the value of JTextField into the String user variable.
					 * Stores the value of JPasswordField into the String pass variable.
					 */
					String user=user_textfield.getText();
					String pass=String.valueOf(user_password.getPassword());
					
					/**
					 * Checking for blank value of user and pass
					 */
							if(!user.equals("") && !pass.equals("")) {
								
								/**
								 * Checking the entered store value of user and pass
								 * Comparing them with defined user and pass.
								 */
									if(user.equals("admin")&&pass.equals("admin")) {
										/**
										 * Enter into the system if user name and password matches.
										 * Go the Driver Class
										 */
											ImageIcon unlocking=new ImageIcon("../Assignment_1/images/unlocking.png");
											JOptionPane.showMessageDialog(null, "Welcome to the System");
											frame.setVisible(false);
											new Driver();	
											}
									else {
										/**
										 * if user name and password doesn't match, show Message Dialog with message
										 */
											JOptionPane.showMessageDialog(null, "Opps...! Wrong User Name and Password","Wrong Input",JOptionPane.ERROR_MESSAGE,wrong);
											user_textfield.setText(null);
											user_password.setText(null);
											user_textfield.grabFocus();
											user_textfield.requestFocus();
										}
							}
							else {
									/**
									 * User name and Password are blank.
									 * Display this condition.
									 */
									JOptionPane.showMessageDialog(null,"Field cannot be blank\n Try Again...!","NO BLANK",JOptionPane.ERROR_MESSAGE,sad);
								}
				}
		});
			panel_two.add(btnlogin);
		
			
			JLabel background=new JLabel();
			background.setBounds(0, 60, 850, 1000);
			panel_two.add(background);
			ImageIcon img_background=new ImageIcon("images/nepal.jpeg");
			Image img1=img_background.getImage();
			Image img2=img1.getScaledInstance(background.getWidth(),background.getHeight(),Image.SCALE_SMOOTH);
			ImageIcon i=new ImageIcon(img2);
			background.setIcon(i);
			
			/**
			 * Setting background image in frame object of JFrame.
			 * 
			 */
			ImageIcon image=new ImageIcon("../Assignment_1/images/logo.png");
			frame.setIconImage(image.getImage());	
			frame.getContentPane().add(panel_two);
			//Setting size of frame (length * width).
			frame.setSize(800,800);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
		}
	
	
	}

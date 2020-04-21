package partwo;
/* 	Developer:
Nabin Atreya Sunar
C7202333
The British College
*/


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



public class Login  {
	JButton btnlogin;
	Login(){
		
		JFrame jf=new JFrame("My login window");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);
		ImageIcon img_logo=new ImageIcon("images/logo.jpg");
		jf.setIconImage(img_logo.getImage());
		
		JPanel panel_one=new JPanel();
		panel_one.setLayout(null);
		panel_one.setBounds(0, 0, 850, 60);
		panel_one.setBackground(Color.DARK_GRAY);
		
		JLabel login=new JLabel("<html><u>Login</u><html>");
		login.setFont(new Font("Dialog", Font.BOLD, 26));
		login.setForeground(Color.ORANGE);
		login.setBackground(Color.BLACK);
		login.setBounds(57, 10, 185, 30);
		panel_one.add(login);
		jf.getContentPane().add(panel_one);
		
		JPanel panel_two=new JPanel();
		panel_two.setLayout(null);
		panel_two.setBounds(0, 0, 850, 1000);
		
		JLabel username=new JLabel("User Name");
		username.setFont(new Font("Dialog", Font.BOLD, 25));
		username.setForeground(Color.white);
		username.setBounds(525, 325, 170, 36);
		
	
		panel_two.add(username);
		
		JTextField user_textfield = new JTextField(8);
		user_textfield.setBounds(500, 365, 267, 39);
		user_textfield.setFont(new Font("Dialog", Font.BOLD, 20));
		user_textfield.setBackground(Color.decode("#29a19c"));
		user_textfield.setForeground(Color.yellow);
		user_textfield.setCaretColor(Color.WHITE);
		
		user_textfield.setToolTipText("Please enter your valid user name");

		user_textfield.addMouseListener(new MouseAdapter(){																					//adding mouse listener to text field
			@Override
				public void mouseClicked(MouseEvent e){
					user_textfield.setText("");																								//clear up everything in text field
							}
				});
		user_textfield.addKeyListener((KeyListener) new KeyAdapter() {																		//adding keylistener to button with if condtion
				public void keyPressed(KeyEvent key) {
					if(key.getKeyCode() == KeyEvent.VK_ENTER)
						btnlogin.doClick();
					}
				});

		
		panel_two.add(user_textfield);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.MAGENTA);
		panel_2.setBounds(500, 400, 267, 10);
		panel_two.add(panel_2);
		
		
		
		JLabel password=new JLabel("Password");
		password.setFont(new Font("Dialog", Font.BOLD, 25));
		password.setForeground(Color.white);
		password.setBounds(525, 430, 170, 36);
		panel_two.add(password);
		
		JPasswordField user_password = new JPasswordField(10);
		user_password.setBounds(500, 470, 267, 39);
		user_password.setToolTipText("Please enter your valid password.");
		user_password.setCaretColor(Color.WHITE);
		user_password.setFont(new Font("Dialog", Font.BOLD, 20));
		user_password.setBackground(Color.decode("#29a19c"));
		user_password.setForeground(Color.yellow);
		panel_two.add(user_password);
		user_password.addKeyListener((KeyListener) new KeyAdapter() {
			public void keyPressed(KeyEvent key) {																					//adding keylistener to button with if condition
				if(key.getKeyCode() == KeyEvent.VK_ENTER)
					btnlogin.doClick();
					}
			});
		
		JPanel feed = new JPanel();
		feed.setLayout(null);
		feed.setBackground(Color.MAGENTA);
		feed.setBounds(500, 505, 267, 10);
		panel_two.add(feed);
		
		JButton btnlogin=new JButton("Login");
		btnlogin.setToolTipText("Click Here To Login In");
		btnlogin.setMnemonic(KeyEvent.VK_L);
		btnlogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		
		btnlogin.setBounds(550, 550, 150, 50);
		btnlogin.setForeground(Color.decode("#f1fa3c"));
		btnlogin.setBackground(Color.decode("#29a19c"));
	
		btnlogin.setFont(new Font("Arial Black",Font.BOLD,20));
		btnlogin.addActionListener(new ActionListener(){																					//Adding action listener to signin button
			public void actionPerformed(ActionEvent e) {
				ImageIcon sad=new ImageIcon("../C7202333/images/sad.png");
				ImageIcon wrong=new ImageIcon("../images/user_pass.png");
				String user=user_textfield.getText();
				String pass=String.valueOf(user_password.getPassword());
						if(!user.equals("") && !pass.equals("")) {																		//applying if else condition to perform
								if(user.equals("admin")&&pass.equals("admin")) {
										ImageIcon unlocking=new ImageIcon("../C7202333/images/unlocking.png");
										JOptionPane.showMessageDialog(null, "Welcome to the System");

										jf.setVisible(false);
										new Converter();	
										}
								else {
										JOptionPane.showMessageDialog(null, "Opps...! Wrong User Name and Password","Wrong Input",JOptionPane.ERROR_MESSAGE,wrong);
										user_textfield.setText(null);
										user_password.setText(null);
										user_textfield.grabFocus();
										user_textfield.requestFocus();
									}
						}
						else {
								
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
		
		ImageIcon image=new ImageIcon("../c7202333/convert.png");
		jf.setIconImage(image.getImage());			
		
		jf.getContentPane().add(panel_two);
		jf.setSize(850,1000);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
	}
	public static void main(String[] args) {
		
		new Login();
	}

}

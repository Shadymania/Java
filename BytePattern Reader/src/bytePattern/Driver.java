package bytePattern;
import java.time.ZoneId;
import java.util.TimeZone;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * 
 * @author Nabin Atreya Sunar			
 * @version 1.0
 */


		

public class Driver {
	
		
		/**
		 * -----------------------------------------------------------------
		 *  Constructor: Setting up the Driver Class.
		 *             	 Default Constructor.
		 *-----------------------------------------------------------------			  
		 */
	
	public Driver(){
		
		/**
		 * Creating frame as an Object of JFrame
		 * Setting image icon on the frame
		 */
        JFrame frame = new JFrame("Byte Pattern (File Scanner)");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		/**
		 * Closes specific window only
		 */
		frame.setLayout(null);
		ImageIcon image=new ImageIcon("../Assignment_1/logo.png");
		frame.setIconImage(image.getImage());	
		
		/**
		 * Creating panel Object of MyGUIPanel class to add String on it.
		 */
		MyGUIPanel panel = new MyGUIPanel();
		
		/**
		 * Adding String note into the JTextArea of MyGUIPanel class
		 */
		String note=" Note : ***** Please Load A Patten File From Menu Items First To Scan File *****."+"\n";
		panel.display.append(note+"\n");
		panel.setBounds(0, 0, 995, 750);
		panel.setLayout(null);
	    
		/**
		 * Adding addMenu method in frame from panel Object of MyGUIPanel class
		 */
		frame.setJMenuBar(panel.addMenu());
		frame.setSize(1000, 800);
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
		/**
		 * 		  This program is used to scan Byte Pattern via file.
		 * @param args arguments are stored in that array.
		 */
	public static void main(String[] args) {
		/**
		 * Calling Login class to run first.
		 */
		new Login();
		
	}


}

package bytePattern;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.text.AttributedString;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


/**
 * 
 * @author Nabin Atreya Sunar			
 * @version 1.0
 */


public class MyGUIPanel extends JPanel {
	
	/**
	 * Declaring menu items as private type.
	 * FileMenuItem			 Allows to load specific file.
	 * DirectoryMenuItem 	 Allows to loads the Directory/Folder.
	 * PatternMenuItem 		 Loads the pattern from the file.
	 * AboutMenuItem		 Details the user how program is run and other information.
	 * scrollPane			 Make scroll able view of a component when size is limited.
	 * display				 All the results are generated in this area.
	 * clear				 This JButton clears the text displayed on the JTextArea.
	 */
	
	private JMenuItem FileMenuItem;
	private JMenuItem DirectoryMenuItem;
	private JMenuItem PatternMenuItem;
	private JMenuItem ExitMenuItem;
	private JMenuItem AboutMenuItem;
	private JScrollPane scrollPane;
	public static JTextArea display;
	private JButton clear;
	
	/**
	 * bytePattern  Creating Variable of BytePattern Class.
	 * SelectFile	Used to select a file or directory.
	 * PatternFile	Chooses pattern file from the directory and comparing them into 
	 * 				ParseLine method of BytePattern Class.
	 * 
	 */
	public BytePattern bytePattern;
	public static File SelectFile;
	public static File PatternFile;
	
	
	
		
	/**
	 * JMenuBar		   Creates a new MenuBar.
	 * @return menuBar It returns  JMenuItems Components .
	 * 					
	 * 
	 */
	
	JMenuBar addMenu() {
		
		/**
		 * Creating various image icon for menu items.
		 */
		ImageIcon fileimg=new ImageIcon("../Assignment_1/images/file.png");						
		ImageIcon helpimg=new ImageIcon("../Assignment_1/images/help.png");
		ImageIcon openimg=new ImageIcon("../Assignment_1/images/open.png");
		ImageIcon newimg=new ImageIcon("../Assignment_1/images/new.png");
		ImageIcon patternimg=new ImageIcon("../Assignment_1/images/pattern.png");
		ImageIcon new_window_img=new ImageIcon("../Assignment_1/images/newwindow.png");
		ImageIcon exitimg=new ImageIcon("../Assignment_1/images/exit.png");
		ImageIcon aboutimg=new ImageIcon("../Assignment_1/images/aboutus.png");

		JMenuBar menuBar = new JMenuBar();		 
		/**
		 * Using default hand cursor for menuBar.
		 */
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));													

		/**
		 *  Creates a new menu with File text
		 *  Setting shortcut key or Mnemnonsic
		 *  Adding image icon on it
		 */
		JMenu menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F); 
		menu.setIcon(new ImageIcon("file.png"));
		menu.setIcon(fileimg);																						
		menu.setToolTipText("Click Here To Explore File");
		menu.setFont(new Font("arial black",Font.BOLD,18));
		menu.setForeground(Color.white);
		menu.setMnemonic(KeyEvent.VK_F);																						
		menuBar.add(menu);
		
			
		/**
		 *  Creates a new menu help with Help text
		 *  Setting shortcut key or Mnemnonsic
		 *  Adding image icon on it
		 */
		JMenu help=new JMenu("Help");																							
		//Creating Help Menu
		help.setToolTipText("Click Here To See About Us");
		help.setIcon(helpimg);
		help.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		help.setMnemonic(KeyEvent.VK_H);
		help.setFont(new Font("arial black",Font.BOLD,18));
		help.setForeground(Color.white);
		menuBar.add(help);
		
		
		FileMenuItem = new JMenuItem("Select A File");
		FileMenuItem.setToolTipText("Click Here To Open A File");
		FileMenuItem.setMnemonic(KeyEvent.VK_S);
		//FileMenuItem.setAccelerator(Keytroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		FileMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		FileMenuItem.setFont(new Font("arial black",Font.BOLD,12));
		FileMenuItem.setForeground(Color.black);
		FileMenuItem.setIcon(openimg);
		/**
		 * 	Adding ActionLisetener interface to the FileMenuItem
		 *  It has actionPerformed method that handles or select File
		 */
		FileMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/**
				 * Using Try-Catch for in-built exceptional handling
				 * Using try for file reading.
				 */
					try {
						/**
						 * File.separator system property return the correct file 
        				 * separator for each different platform
        				 * String filename allows to select the correct file
        				 * FileChooser pops up the dialog box to select a file
        				 * setCurrentDirectory gives the name of a selected file.
        				 * Setting selectionMode allowing only to set file.
        				 * The selected file is then read by the SelectFile variable.
        				 * 
						 */
						String filename = File.separator;
				        JFileChooser FileChooser = new JFileChooser(new File(filename));
				        FileChooser.setCurrentDirectory(new java.io.File("."));
				        FileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); 
				        int status=FileChooser.showOpenDialog(null);
				        SelectFile = FileChooser.getSelectedFile();
						JOptionPane.showMessageDialog(null, "Thank You ...! \nYou Have Selected A File.", "Scanning File ..............", JOptionPane.INFORMATION_MESSAGE);
								/**
								 * Calling the getPatterns() method through getter from BytePattern Class which
								 * returns pattern in the file.
								 * Ensuring that the patterns of a file is loaded first.
								 * Then comparing the selected file to check into the checkPattern() method
								 * Check the file if pattern is found.
								 * 
								 */
						        if(bytePattern.getPatterns().size() != 0)
							    	bytePattern.checkPattern(SelectFile);
						        
						        
						        /**
						         * When a file doesn't found its pattern type without loading pattern file,
						         *  pops up the showMessageDialog box.
						         */
							    else
									{	
										JOptionPane.showMessageDialog(null, "Opps...! Pattern Not Found \n"
												+ "Please, First Load A Pattern File ", "Scanning File ..............", JOptionPane.ERROR_MESSAGE);
									}
						}
				
					catch(Exception exceptionForFile) {}
				}
			});
		
		
	
		
		DirectoryMenuItem = new JMenuItem("Select A Directory/Folder");
		DirectoryMenuItem.setToolTipText("Click Here To Load Directory/Folder");
		DirectoryMenuItem.setMnemonic(KeyEvent.VK_D);
		DirectoryMenuItem.setFont(new Font("arial black",Font.BOLD,12));
		DirectoryMenuItem.setForeground(Color.black);
		DirectoryMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		DirectoryMenuItem.setIcon(newimg);
		DirectoryMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Using Try-Catch for in-built exceptional handling
				 * Using try for reading directory.
				 */
				try {
						/**
						 * File.separator system property return the correct files on it. 
	    				 * separator for each different platform
	    				 * String filename allows to select the correct files
	    				 * FileChooser pops up the dialog box to select a file
	    				 * setCurrentDirectory uses a specific path for the current directory.
	    				 * Setting selectionMode allowing only to set file.
	    				 * The selected directory is then read by the SelectFile variable.
	    				 * 
						 */
						String filename = File.separator;
				        JFileChooser fileChooser = new JFileChooser(new File(filename));
				        fileChooser.setCurrentDirectory(new java.io.File("."));
				        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
				        int status=fileChooser.showOpenDialog(null);
					    SelectFile = fileChooser.getSelectedFile(); 
						JOptionPane.showMessageDialog(null, "Thank You ...! \nYou Have Selected A Directory.", "Scanning Directory ..............", JOptionPane.INFORMATION_MESSAGE);
						
						/**
						 *  Get a list of all files and directories in the files variable
						 *  count variable list the number of files in the directory.
						 */
					    File[] files = SelectFile.listFiles();
					    int count=files.length;
					    display.append("Directory Name : "+(SelectFile.getName())+" ( "+count+ " files )\n\n");
				    
							/**
							 * Calling the getPatterns() method through getter from BytePattern Class which
							 * returns pattern in the files inside directory.
							 * Ensuring that the patterns of a file is loaded first and matches the pattern.
							 * Then comparing the selected file to check into the checkPattern() method
							 * Check the file if pattern is found.
							 * 
							 */
							if(bytePattern.getPatterns().size() != 0)
							{
									/**
									 *  Iterate over files and directories from files variable
									 *  Storing files variable to f variable and checking the patterns to the end
									 *  Through the checkPattern() Method.
									 */
									for(File f : files)
									{
										bytePattern.checkPattern(f);
									}
							}
							
							/**
					         * When a directory doesn't found its pattern type without loading pattern file, 
					         * pops up the showMessageDialog box.
					         */
							else{
									JOptionPane.showMessageDialog(null, "Opps...! Pattern Not Found\n"
											+ "Please, First Load A Pattern File ", "Scanning Directory ..............", JOptionPane.ERROR_MESSAGE);
								}
				}
					catch(Exception exceptionForDirectory) {}
			}
		});
		

		
		PatternMenuItem=new JMenuItem("Load A Pattern File");
		PatternMenuItem.setMnemonic(KeyEvent.VK_L);
		PatternMenuItem.setToolTipText("Click Here To Load A Pattern File");
		PatternMenuItem.setFont(new Font("arial black",Font.BOLD,12));
		PatternMenuItem.setForeground(Color.black);
		PatternMenuItem.setIcon(patternimg);
		PatternMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PatternMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/**
				 * Using Try-Catch for in-built exceptional handling
				 * Using try for reading directory.
				 */
				
				try {	
					
						/**
						 * File.separator system property return the correct pattern file.
	    				 * String filename allows to select the correct pattern file
	    				 * FileChooser pops up the dialog box to load a pattern file
	    				 * setCurrentDirectory gives the name of a selected pattern file.
	    				 * Setting selectionMode allowing only to select pattern file.
	    				 * The selected file is then read by the PatternFile variable and 
	    				 * returns the selected file.
						 */
						String filename = File.separator;
				        JFileChooser fileChooser = new JFileChooser(new File(filename));
				        fileChooser.setCurrentDirectory(new java.io.File("."));
				        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				        int status=fileChooser.showOpenDialog(null);
					    PatternFile = fileChooser.getSelectedFile();
					  
					    /**
					     * ParseLine() method accepts the PatternLine as parameter
					     * It reads or accpets the file from the directory or specific 
					     * file and ensure about the patterns and spaces in the file.
					     */
					    bytePattern.ParseLine(PatternFile);
					    
					    /**
					     * bytePattern Creating Variable of BytePattern Class.
					     * Calling getErrors() methods which returns the errors in the patterns
					     */
					    if(bytePattern.getErrors().length() > 0)
					    {
					    	JOptionPane.showMessageDialog(null, bytePattern.getErrors(), "Opps...! You Have Selected A Wrong Pattern File."
					    			, JOptionPane.WARNING_MESSAGE);
					    	JOptionPane.showMessageDialog(null,"Please Select A Valid Pattern File");
					    }
					    
					    /**
					     * Iterate over the files in the directory
					     * If pattern file found, check for the next inside for loop condition.
					     */
					    for(byte[] PatternLine : bytePattern.getPatterns())
						{
					    	
					    	/**
					    	 * PatternByte variable of byte type reads as the PatternLine
					    	 * Checks the stored value of PatternByte variable to the ByteToHexadecimal() method
					    	 * To ensure about the file reads hexadecimal format.
					    	 */
					    	
							for(byte PatternByte : PatternLine)
							{
								display.append(bytePattern.ByteToHexadecimal(PatternByte).toUpperCase());
							}
							display.append("\n");	
						}
				}
			catch(Exception exceptionForPatternFile) {}
			}
		});
		
		/**
		 *  Implementing divider lines for NewWindowMenuItem and ExitMenuItem
		 */
		JSeparator separator1=new JSeparator();
		JSeparator separator2=new JSeparator();
		
		/**
		 * Opens the New Window.
		 */
		JMenuItem NewWindowMenuItem=new JMenuItem("New Window");														
		NewWindowMenuItem.setToolTipText("Click Here To Open New Window");
		NewWindowMenuItem.setMnemonic(KeyEvent.VK_N);
		NewWindowMenuItem.setFont(new Font("arial black",Font.BOLD,12));
		NewWindowMenuItem.setForeground(Color.black);
		NewWindowMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		NewWindowMenuItem.setIcon(new_window_img);
		NewWindowMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent f) {
				new Driver();
			}
		});
		NewWindowMenuItem.add(separator1);
		menu.add(NewWindowMenuItem);
	
	

		/**
		 * Terminate the program
		 */
		JMenuItem ExitMenuItem=new JMenuItem("Exit");														
		ExitMenuItem.setToolTipText("Click Here To Exit This Window");
		ExitMenuItem.setMnemonic(KeyEvent.VK_E);
		ExitMenuItem.setFont(new Font("arial black",Font.BOLD,12));
		ExitMenuItem.setForeground(Color.black);
		ExitMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ExitMenuItem.setIcon(exitimg);
		ExitMenuItem.addActionListener(new ActionListener() {																		
			/**
			 * Performed Exit When clicked on Menu Items.
			 */
			public void actionPerformed(ActionEvent e) {
				    System.exit(0);
				}
			});
		ExitMenuItem.add(separator2);
		menu.add(ExitMenuItem);
		
		/**
		 * Creating menuitem and adding on help Menu.
		 */
		JMenuItem AboutMenuItem=new JMenuItem("About Us");																			
		AboutMenuItem.setToolTipText("See About Us");
		AboutMenuItem.setMnemonic(KeyEvent.VK_A);
		AboutMenuItem.setFont(new Font("arial black",Font.BOLD,12));
		AboutMenuItem.setForeground(Color.black);
		AboutMenuItem.setIcon(aboutimg);
		AboutMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AboutMenuItem.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					new AboutUs();
						}
				});
		
		/**
		 * Adds menu items to the menu.
		 */
		menu.add(FileMenuItem);
		menu.add(DirectoryMenuItem);
		menu.add(PatternMenuItem);
		menu.add(NewWindowMenuItem);
		menu.add(ExitMenuItem);
		help.add(AboutMenuItem);
		
		menu.setBackground(Color.blue);
		menuBar.setBackground(Color.decode("#035aa6"));
		return menuBar;
	}
	
	
	
	/**
	 * -----------------------------------------------------------------
	 *  Constructor: Setting up the MyGUIPanel Class Graphical User Interface (GUI).
	 *             	 Default Constructor.
	 *-----------------------------------------------------------------			  
	 */
	MyGUIPanel() {
		/**
		 * adding buttons, labels and text field to the MyGUIPanel
		 */
		
		bytePattern =new BytePattern();
		JLabel abc=new JLabel("<html><u>File Scanner</u></html>");
		abc.setBackground(Color.pink);
		abc.setFont(new Font("Algerian", Font.BOLD, 50));
		abc.setForeground(Color.yellow);
		abc.setBounds(360,10,460,80);
		add(abc);
		
		display = new JTextArea();
		display.setToolTipText("Scan File Will Be Output Here");
		display.setBackground(Color.WHITE);
		display.setForeground(Color.BLACK);	
		display.setEditable(false);
		display.setBounds(10, 50, 500, 300);
		add(display);
		
		/**
		 * Displaying JTextArea of display into the JScrollPane
		 */
		JScrollPane scrollPane = new JScrollPane(display, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBackground(Color.BLACK);
		scrollPane.setBounds(200,100,650,500);
		
		
		clear = new JButton("Clear");
		clear.setToolTipText("Click Here To Clear All");
		clear.setMnemonic(KeyEvent.VK_C);
		clear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clear.setForeground(Color.white);
		clear.setBackground(Color.decode("#ffa323"));
		clear.setFont(new Font("Tahoma", Font.BOLD, 18));
		clear.setBounds(400,615, 150, 35);
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			display.setText("");	
			}
		});
		
		add(clear);
		setBackground(Color.decode("#035aa6"));
		add(scrollPane);
	}
}

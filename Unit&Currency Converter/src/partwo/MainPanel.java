package partwo;
/* 	Developer:
Nabin Atreya Sunar
C7202333
The British College
*/

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
		
		public class MainPanel extends JPanel {
			// declaring a user_textfield to take values from the user
			private JTextField user_textfield; 
			/*
			* declaring JLablel lbl_result & counter to display the result and a count
			* of how many conversions have been done respectively
			*/
			private JLabel lbl_result;
			static JLabel counter;
			static String Path;
			// string path to store and use the path of the text file

			static String[] list = { "Inches To CentiMeter", "Miles To Nautical Miles", "Acres To Hectares", "Miles/Hour To Kilometers/Hour",
					"Yards To Meters", "Celcius To Fahrenheit","Degree To Radian"};
			//declaring array list
		
			private JComboBox<String> combo_box; 
			// declaring JComboBox to let the user choose one of several conversion
														
			static JCheckBox reverse; 
			// creating a checkbox to allow user to choose reverse conversion
			private JButton btn_convert;
			public static JButton btn_clear; 
			// btn_convert to carry out conversion and btn_clear to clear all values displayed
			
			static double result = 0; 
			// initializing a double result to store result after conversion
			static int count = 0; 
			// initializing an integer variable to keep count of number of conversion completed
									
		
			JMenuBar setupMenu() {
				//Creating image object
				ImageIcon fileimg=new ImageIcon("../c7202333/images/file.png");						
				ImageIcon editimg=new ImageIcon("../c7202333/images/edit.png");
				ImageIcon helpimg=new ImageIcon("../c7202333/images/help.png");
				ImageIcon newimg=new ImageIcon("../c7202333/images/new.png");
				ImageIcon openimg=new ImageIcon("../c7202333/images/open.png");
				ImageIcon closeimg=new ImageIcon("../c7202333/images/close.png");
				ImageIcon closeallimg=new ImageIcon("../c7202333/images/closeall.png");
				ImageIcon exitimg=new ImageIcon("../c7202333/images/exit.png");
				ImageIcon aboutimg=new ImageIcon("../c7202333/images/aboutus.png");
		
				JMenuBar menubar = new JMenuBar();
				menubar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));													
				//Using default cursor.
				
				JMenu menu=new JMenu("File");																							
				//Creating File Menu
				menu.setIcon(fileimg);																						
				menu.setToolTipText("Click Here To Explore File");
				menu.setFont(new Font("arial black",Font.BOLD,18));
				menu.setForeground(Color.white);
				menu.setMnemonic(KeyEvent.VK_F);																						
				//Setting Up Mnemnonic.
				menubar.add(menu);
			
				JMenu edit=new JMenu("Edit");																							
				//Creating Edit Menu
				edit.setToolTipText("Click Here To See Edit");
				edit.setMnemonic('D');
				edit.setFont(new Font("arial black",Font.BOLD,18));
				edit.setForeground(Color.white);
				edit.setIcon(editimg);
				menubar.add(edit);
			
				JMenu help=new JMenu("Help");																							
				//Creating Help Menu
				help.setToolTipText("Click Here To See About Us");
				help.setIcon(helpimg);
				help.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				help.setMnemonic(KeyEvent.VK_H);
				help.setFont(new Font("arial black",Font.BOLD,18));
				help.setForeground(Color.white);
				menubar.add(help);
		
				JMenuItem m1=new JMenuItem("New");																				
				//Creating menu item and adding on File Menu.
				m1.setToolTipText("Click Here To Open NEW Window");
				m1.setMnemonic(KeyEvent.VK_N);
				m1.setFont(new Font("arial black",Font.BOLD,12));
				m1.setForeground(Color.black);
				m1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				m1.setIcon(newimg);
				m1.addActionListener(new ActionListener() {																		
					//Adding ActionListener in menuitem.
						public void actionPerformed(ActionEvent e) {
								new Converter();																						
								//Calling object of a class	
								}
						});
				menu.add(m1);
				
				JMenuItem m2=new JMenuItem("Load File");
				m2.setToolTipText("Click Here To Load File");
				m2.setMnemonic(KeyEvent.VK_L);
				m2.setFont(new Font("arial black",Font.BOLD,12));
				m2.setForeground(Color.black);
				m2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				m2.setIcon(openimg);
				m2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// allowing user to select file after he chooses open file on menu
						JFileChooser opening_file = new JFileChooser();			//jfc=opening_file
						// filter to allow only text files
						FileNameExtensionFilter text = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
						opening_file.setFileFilter(text);
						opening_file.showOpenDialog(null);
						try {
							//if user uploads a file:
							// store the path of the file in Path string
							Path = opening_file.getSelectedFile().getAbsolutePath().toString();
							//refering to lineCount method to count number of lines in the file
							LineReader.lineCount();
							//refering to readFile method for validation and extracting values from the file
							CurrencyReader.readFile();	
							//Path.replaceAll("\\", "/");							
							//if user decides against uploading a file, set the String Path as null
						} catch (NullPointerException npe) {
							Path = null;
						}
					}
				});
				menu.add(m2);
				
				JMenuItem m3=new JMenuItem("Close");
				m3.setMnemonic(KeyEvent.VK_C);
				m3.setToolTipText("Click Here To Close");
				m3.setFont(new Font("arial black",Font.BOLD,12));
				m3.setForeground(Color.black);
				m3.setIcon(closeimg);
				m3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				m3.addActionListener(new ActionListener() {																		
					//For Closing when clicked on menu item: Close
						public void actionPerformed(ActionEvent e) {
								System.exit(0);
							}
						});
				menu.add(m3);
				
				JSeparator separator1=new JSeparator();
				
				JMenuItem m5=new JMenuItem("Exit");														
				m5.setToolTipText("Click Here To Exit This Window");
				m5.setMnemonic(KeyEvent.VK_E);
				m5.setFont(new Font("arial black",Font.BOLD,12));
				m5.setForeground(Color.black);
				m5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				m5.setIcon(exitimg);
				m5.addActionListener(new ActionListener() {																		
					//Performed Exit When clicked on Menu Items.
					public void actionPerformed(ActionEvent e) {
							System.exit(0);
						}
					});
				m5.add(separator1);
				menu.add(m5);
				
				JMenuItem copy=new JMenuItem("Copy");																				
				//Creating menuitem and adding on edit Menu.
				copy.setToolTipText("Copy From Here");
				copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
				copy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				edit.add(copy);
			
				JMenuItem paste=new JMenuItem("Paste");
				paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
				paste.setToolTipText("Paste From Here");
				edit.add(paste);
		
				JMenuItem about=new JMenuItem("About Us");																			
				//Creating menuitem and adding on help Menu.
				about.setToolTipText("See About Us");
				about.setMnemonic(KeyEvent.VK_A);
				about.setFont(new Font("arial black",Font.BOLD,12));
				about.setForeground(Color.black);
				about.setIcon(aboutimg);
				about.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				about.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							new About();
								}
						});
				help.add(about);
				
				menubar.setBackground(Color.decode("#6ba8a9"));
				return menubar;
			}
		
			MainPanel() {
				setLayout(null);
				//default constructor
				ActionListener listener = new ConvertListener();
				
				JLabel inputLabel = new JLabel("Please Select Your Choice");
				inputLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
				inputLabel.setForeground(Color.white);
				inputLabel.setBounds(50, 40, 300,35);
				
				Border boxing = BorderFactory.createLineBorder(Color.decode("#a8ff3e"), 3); 									
				//Creating Border 

				JPanel result_panel=new JPanel();																					
				//Creating another panel for result
				result_panel.setBackground(Color.decode("#216583"));
				result_panel.setBounds(950, 90, 350, 100);
				result_panel.setBorder(boxing);
				result_panel.setToolTipText("Your Result Will Be Shown Here");															
				//ToolTipText for JPanel
				
				
				combo_box = new JComboBox<String>(list);
				combo_box.addActionListener(listener);
				// convert values when option changed
				combo_box.setToolTipText("Please Select Your Choice Here");
				// description when hovered over
				combo_box.setEditable(false);	
				combo_box.setBounds(50, 90, 350, 40);

				combo_box.setFont(new Font("Tahoma", Font.BOLD, 17));
				combo_box.setBackground(Color.decode("#f45905"));
				combo_box.setForeground(Color.white);
				combo_box.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
				btn_convert = new JButton("Convert");
				btn_convert.addActionListener(listener);// convert values when pressed
				btn_convert.setToolTipText("Click Here To Convert");
				btn_convert.setMnemonic(KeyEvent.VK_C);
				// convertButton.setMnemonic(KeyEvent.VK_ENTER);
				btn_convert.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_convert.setForeground(SystemColor.text);
				btn_convert.setFont(new Font("Tahoma", Font.BOLD, 20));
				btn_convert.setBounds(500,150, 150, 39);
				btn_convert.setBackground(Color.decode("#91b029"));
		
				reverse = new JCheckBox("Reverse Conversion");
				reverse.addActionListener(listener); 
				// perfoms reverse conversion when checked
				reverse.setToolTipText("Check this option to reverseCheckBox the conversion.");
				reverse.setToolTipText("Please Tick To Reverse The Operation.");
				reverse.setBackground(Color.decode("#1b7fbd"));
				reverse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				reverse.setForeground(Color.white);
				reverse.setBounds(500, 200, 230, 30);
				reverse.setFont(new Font("arial black",Font.ITALIC,20));
				
				
				counter = new JLabel("Your Result");
				counter.setForeground(Color.decode("#f1fa3c"));
				counter.setFont(new Font("Tahoma", Font.BOLD, 25));
				counter.setBounds(1050, 140, 400, 27);
				
				
				lbl_result = new JLabel("");																						
				lbl_result.setForeground(Color.white);
				lbl_result.setFont(new Font("Tahoma", Font.BOLD, 25));
				lbl_result.setBounds(1050, 300, 250, 27);
				

				user_textfield = new JTextField("Please Enter The Value...?");
				user_textfield.setToolTipText("Please Put A Value To Convert ");
				user_textfield.addMouseListener(new MouseAdapter(){
		        @Override
		        	public void mouseClicked(MouseEvent e){																	
		        	//Adding mouseClick event.
		        		user_textfield.setText("");																			
		        		//When cursor is clicked on text, whole text get removed.
		        		user_textfield.setBackground(Color.white);
		        		user_textfield.setForeground(Color.black);
		        		}
					});
				user_textfield.addKeyListener(new KeyAdapter() {													
				@Override
					public void keyPressed(KeyEvent e) {																
					//Calling the convert button
						if (e.getKeyCode() == KeyEvent.VK_ENTER)
							btn_convert.doClick();
							}
					});
				user_textfield.setFont(new Font("Arial Black", Font.BOLD, 25));
				// adding action listener to the textField so that conversion can be carried out
				// even when return is pressed
				user_textfield.setColumns(15);	
				user_textfield.setBounds(500, 90,400, 40);
				user_textfield.setColumns(10);
				user_textfield.addActionListener(listener);
	
				
		
				btn_clear = new JButton("Clear");
				btn_clear.addActionListener(listener);// clear all field when pressed
				//adding all buttons, checkbox, labels and textfield to the MainPanel
				btn_clear.setToolTipText("Click Here To Reset All");
				btn_clear.setMnemonic(KeyEvent.VK_R);
				btn_clear.addActionListener(listener);
				
				btn_clear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btn_clear.setForeground(Color.white);
				btn_clear.setBackground(Color.decode("#ffa323"));
				btn_clear.setFont(new Font("Tahoma", Font.BOLD, 18));
				btn_clear.setBounds(500, 240, 150, 39);
				
				JScrollPane scrollPane = new JScrollPane(result_panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			     
				scrollPane.setBackground(Color.BLACK);
				
				scrollPane.setBounds(980,90,450,150);
				
				add(scrollPane);
			
				
				add(combo_box);
				add(inputLabel);
				add(user_textfield);
				add(btn_convert);
				result_panel.add(lbl_result);
				add(reverse);
				result_panel.add(counter);
				add(btn_clear);
				
				setPreferredSize(new Dimension(800, 80));
				setBackground(Color.LIGHT_GRAY);
		
			}
		
			public class ConvertListener implements ActionListener {		
				@Override
				public void actionPerformed(ActionEvent event) {	
					String text = user_textfield.getText().trim();
					/*
					 * run the calculation only if the user clicks convert or presses return on
					 * keyboard also checks for empty input
					 */
					boolean numericEntryCheck = true;
					// initializing a boolean to check whether the user input is a numeric														
					// value or not
					
					if (text.isEmpty() == false && (event.getSource() == btn_convert || event.getSource() == user_textfield)) {
						double value = 0; 
						// double value to store user-input for calculation		
						
						// to check if the input is a valid number
						try {
							value = Double.parseDouble(text);
						} catch (NumberFormatException nfe) { 
							// if exception is caught, a dialog box message error to inform																
							// the user
							JOptionPane.showMessageDialog(null, " Opps...! Sorry Invalid Entry ", "Entry Error ",
									JOptionPane.INFORMATION_MESSAGE);
							numericEntryCheck = false;
						}
						// the factor applied during the conversion
						double a = 0;		
						// the offset applied during the conversion.
						double b = 0;		
						// Setup the correct factor/offset values depending on required conversion
						
						switch (combo_box.getSelectedIndex()) {
						//inches into centimeter
						case 0: 
							a = 2.54;
							break;
							
						//miles to nauticalmiles
						case 1: 
							a=1.15078;
							break;
							
						//acres into hectares
						case 2:
							a=0.40468;
							break;
							
						//miles/hr to km/hr
						case 3: 						
							a=1.60934;
							break;
						
						// Yards to Meters
						case 4: 
							a=0.9144;
							break;
							
						// Celsius/Fahrenheit	
						case 5: 
							a = 1.8;
							b = 32;
							break;
							
						// degree to radians
						case 6: 
							a = 0.01745;
							break;
						}
		
						// using decimal formatter to display result in two decimal places
						DecimalFormat decimal_format = new DecimalFormat("0.00");
		
						// runs only if checkbox is selected and the userinput is a valid number
						if (reverse.isSelected() == false && numericEntryCheck == true) {
							result = a * value + b; 
							// formula to carry out straight conversion
							count++; 
							// increasing count when conversion is done
							counter.setText("Total Count: " + count+"\n");
							System.out.println("\n");

							// displaying the count of conversion done
							lbl_result.setText("\nYour Result\n");
							lbl_result.setText(decimal_format.format(result));
							// displaying the formatted string result
						} 
						else if (reverse.isSelected() == true && numericEntryCheck == true) {
							result = (value - b) / a; 
							// formula to carry out the reverse conversion
							count++; 
							// the count also increases when reverse conversion is done
							counter.setText("Total Count: " + count);
							System.out.println("\n");
							counter.setForeground(Color.decode("#f1fa3c"));
							counter.setFont(new Font("Tahoma", Font.BOLD, 25));
							lbl_result.setText(decimal_format.format(result));
						}
						
						// result = df.format(result);
						// in the case of empty text, user is shown dialog box with message about the
						// nature of error
					}
					else if (text.isEmpty() == true
							&& (event.getSource() == btn_convert || event.getSource() == user_textfield)) {
						JOptionPane.showMessageDialog(null,
								"The field is empty. Please make sure you've entered a number.", "Error",
								JOptionPane.WARNING_MESSAGE);
					}
					// remove all values from text input box, answer label and count label when
					// clear button is pressed
					if (event.getSource() == btn_clear) {
						count = 0;
						counter.setText("\nCounter: " + count+"\n");
						System.out.println("\n");
						lbl_result.setText("");
						user_textfield.setText("");
						CurrencyPanel.currency_result.setText("\nYour Currency Conversion Result\n");
						CurrencyPanel.currency_input.setText("");
					}
				}
			}
		
		}
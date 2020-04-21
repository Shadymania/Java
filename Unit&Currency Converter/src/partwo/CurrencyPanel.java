package partwo;
/* 	Developer:
Nabin Atreya Sunar
C7202333
The British College
*/

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;


public class CurrencyPanel extends JPanel {

	// combo-box that allows user to select required currency conversion
	public String[] currency_list = { "Euro (EUR)", "US Dollars (USD)", "Australian Dollars (AUD)",
			"Canadian Dollars (CAD)", "Icelandic  Króna (ISK)", "United Arab Emirates Dirham (AED)",
			"South African Rand (ZAR)", "Thai Baht (THB)" };

	public static JTextField currency_input;
	// declaring a text-field currInput to take value from the user
	public static JLabel currency_result, currency_pound; 
	// declaring a JLabel to display the result after currency conversion
	static JComboBox<String> currency_combo_box; 
	// combo-box that allows user to select required currency conversion
	public static JButton currency_btn; 
	// Button to allow user to convert currency
	double initialize_rate, user_input = 0; 
	// variables required for calculation. x is used for rate and y is used for
	// user-inputed value
	String symbol;
	// string symbol to store and display the currency symbol
	static boolean fileUploadCheck = false;
	// boolean fileUploadCheck to check whether a valid file has been or not
	static int validupload = 0; 
	// count of number of valid files uploaded by user

	CurrencyPanel() {
		setLayout(null);
		Border boxing = BorderFactory.createLineBorder(Color.decode("#a8ff3e"), 3); 									
		//Creating Border 

		JPanel result_panel=new JPanel();																						
		//Creating another panel for result		
		result_panel.setBackground(Color.decode("#216583"));
		result_panel.setBounds(950, 90, 350, 100);
		result_panel.setBorder(boxing);
		result_panel.setToolTipText("Your Result Will Be Shown Here");															
		//ToolTipText for JPanel
		
		//adding checkBox, buttons, labels and textfield to the panel
		JLabel inputLabel1 = new JLabel("Please Select Your Choice");
		inputLabel1.setFont(new Font("Tahoma", Font.BOLD, 20));
		inputLabel1.setForeground(Color.white);
		inputLabel1.setBounds(50, 20, 300,35);
		
		
		currency_pound = new JLabel("British Pound (GBP)");
		currency_pound.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		currency_pound.setForeground(SystemColor.text);
		currency_pound.setFont(new Font("Tahoma", Font.BOLD, 20));
		currency_pound.setBounds(50,60, 250, 39);
		currency_pound.setBackground(Color.decode("#91b029"));

		
		
		ActionListener abc = new ConvertListener();
		currency_combo_box = new JComboBox<String>(currency_list);
		currency_combo_box.addActionListener(abc);
		currency_combo_box.setToolTipText("Choose the currency you want to use for conversion.");
		currency_combo_box.setFont(new Font("Tahoma", Font.BOLD, 17));
		currency_combo_box.setBackground(Color.decode("#f45905"));
		currency_combo_box.setForeground(Color.white);
		currency_combo_box.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		currency_combo_box.setEditable(false);																				
		//Cannot be edited.
		currency_combo_box.setBounds(50,100, 350, 40);
	
	
		
		currency_result = new JLabel("Your Result");
		currency_result.setToolTipText("Result of Currency conversion.");
		currency_result.setForeground(Color.decode("#f1fa3c"));
		currency_result.setFont(new Font("Tahoma", Font.BOLD, 25));
		currency_result.setBounds(1050, 300, 250, 27);
		result_panel.add(currency_result);
		
		
		currency_input = new JTextField("Please Enter The Value...?");
		currency_input.addActionListener(abc);
		currency_input.addMouseListener(new MouseAdapter(){
            @Override
            	public void mouseClicked(MouseEvent e){																	
            	//Adding mouseClick event.
            		currency_input.setText("");																			
            		//When cursor is clicked on text, whole text get removed.
            		currency_input.setBackground(Color.white);
            		currency_input.setForeground(Color.black);
            		}
				});
			currency_input.addKeyListener(new KeyAdapter() {													
			@Override
				public void keyPressed(KeyEvent e) {																
				//Calling the convert button
					if (e.getKeyCode() == KeyEvent.VK_ENTER);
					//	currButton.doClick();
						}
				});
			currency_input.setFont(new Font("Arial Black", Font.BOLD, 25));
			currency_input.setBounds(500, 100,400, 40);
			currency_input.setColumns(10);
		currency_input.setToolTipText("Please Put A Value To Convert ");
		
		
		currency_btn = new JButton("Convert");
		currency_btn.addActionListener(abc);
		currency_btn .setToolTipText("Click Here To Convert");
		currency_btn.setMnemonic(KeyEvent.VK_V);
		currency_btn .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		currency_btn .setForeground(SystemColor.text);
		currency_btn .setFont(new Font("Tahoma", Font.BOLD, 20));
		currency_btn .setBounds(500,150, 150, 39);
		currency_btn .setBackground(Color.decode("#91b029"));
		

		JScrollPane scrollPane = new JScrollPane(result_panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	     
		scrollPane.setBackground(Color.BLACK);
		
		scrollPane.setBounds(980,90,450,150);
		
		add(scrollPane);
		
		
		add(currency_pound);
		add(currency_combo_box);
		add(inputLabel1);
		add(currency_input);
		add(currency_btn);


	}

	private class ConvertListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			String inputtext = currency_input.getText().trim();
			boolean numCheck = true;
			//check if user has uploaded a file
			//if user hasn't uploaded any valid file, setting default values for conversion 
			if (fileUploadCheck == false && validupload == 0) {
				if ((inputtext.isEmpty() == false) && (ae.getSource() == currency_btn || ae.getSource() == currency_input)) {

					switch (currency_combo_box.getSelectedIndex()) {
					case 0:	//Euro
						initialize_rate = 1.06;
						symbol = "€";
						break;
					case 1://American Dollar
						initialize_rate = 1.14;
						symbol = "$";
						break;
					case 2: //Australian Dollar
						initialize_rate = 1.52;
						symbol = "$";
						break;
					case 3: //Canadian Dollar
						initialize_rate = 1.77;
						symbol = "$";
						break;
					case 4: //Icelandic Króna
						initialize_rate = 130.62;
						symbol = "kr";
						break;
					case 5:// United Arab Emirates Dirham
						initialize_rate = 4.60;
						symbol = "د.إ";
						break;
					case 6: // South African Rand
						initialize_rate = 17.96;
						symbol = "R";
						break;
					case 7: //Thai Baht
						initialize_rate = 44.28;
						symbol = "฿";
						break;
					}
					try {
						//check if user-entry is numeric or not
						user_input = Double.parseDouble(inputtext);
					} catch (NumberFormatException ne) {
						//if user didn't input a numeric value throw an error
						JOptionPane.showMessageDialog(null, "Input Valid Number ", "Error",
								JOptionPane.INFORMATION_MESSAGE);
						numCheck = false;
					}
					//using decimal format to display result in 2decimal point
					DecimalFormat df = new DecimalFormat("0.00");
					//check if reverse checkbox is selected
					if (MainPanel.reverse.isSelected() == false && numCheck == true) {
						double z = initialize_rate * user_input;
						
						//display result with symbol of the currency
						currency_result.setText(symbol + df.format(z));
						MainPanel.count++;
						MainPanel.counter.setText("Count no. " + MainPanel.count);
					} else if (MainPanel.reverse.isSelected() == true && numCheck == true) {
						double z = user_input / initialize_rate;
						currency_result.setText("£  " + df.format(z));
						MainPanel.count++;
						MainPanel.counter.setText("Count no. " + MainPanel.count);
					}

				} else if (inputtext.isEmpty() == true
						&& (ae.getSource() == currency_btn || ae.getSource() == currency_input)) {
					//if no value is input, display an error message
					JOptionPane.showMessageDialog(null,
							"Opps... Sorry. The field is empty. Please enter valid values", "Error Message",
							JOptionPane.WARNING_MESSAGE);
				}
				//if user uploaded a valid file, use its values for conversion
			} else {
				if ((inputtext.isEmpty() == false) && (ae.getSource() == currency_btn || ae.getSource() == currency_input)) {
					//loop to compare all values with user selected index in combo box
					for (int i = 0; i < LineReader.numberOfLines; i++) {
						//if user selected a index with any error
						if (currency_combo_box.getSelectedIndex() == i && CurrencyReader.file_error[i] == null) {
							//
							initialize_rate = CurrencyReader.file_rate[i];
							symbol = CurrencyReader.file_symbol[i];
						}//if user selected an index with error for conversion, display subsequent error message
						else if (currency_combo_box.getSelectedIndex() == i && CurrencyReader.file_error[i] != null) {
							JOptionPane.showMessageDialog(null,
									"Opps..! Sorry not a valid currency.", " No Conversion Message",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}

					try {
						
						user_input = Double.parseDouble(inputtext);
					} 
					catch (NumberFormatException ne) {
						//display error message if user input a non-numeric value for conversion
						JOptionPane.showMessageDialog(null, "Opps... Sorry Invalid Entry ", "Error",
								JOptionPane.INFORMATION_MESSAGE);
						numCheck = false;
					}
					DecimalFormat df = new DecimalFormat("0.00");
					//if user input a valid number, and reverse checkbox is not selected
					//carry out the normal conversion
					if (MainPanel.reverse.isSelected() == false && numCheck == true) {
						double z = initialize_rate * user_input;
						currency_result.setText(symbol + df.format(z));
						//increasing value of count
						MainPanel.count++;
						MainPanel.counter.setText("Total Count:  " + MainPanel.count);
					} 
					else if (MainPanel.reverse.isSelected() == true && numCheck == true) {
						double z = user_input / initialize_rate;
						currency_result.setText("£ " + df.format(z));
						MainPanel.count++;
						MainPanel.counter.setText("Total Count:  " + MainPanel.count);
					}

				}
				else if (inputtext.isEmpty() == true
						&& (ae.getSource() == currency_btn || ae.getSource() == currency_input)) {
					JOptionPane.showMessageDialog(null,
							"Opps... Sorry .The field is empty. Please enter valid datatype i.e.numbers ", "Error Message",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		}

	}

}
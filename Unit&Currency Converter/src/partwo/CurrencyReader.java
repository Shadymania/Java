package partwo;
/* 	Developer:
Nabin Atreya Sunar
C7202333
The British College
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;
		
		public class CurrencyReader {
			// string line to read each line in the text file
			static String line;
			// array list line to store everything inside the text file
			static ArrayList<String> lines = new ArrayList<String>();
		
			// string array curr, symb and rate to store name of currency, its symbol and
			// its rate respectively
			static String[] file_currency;
			static String[] file_symbol;
			static Double[] file_rate;
			static String[] file_error; 
			// to store error in any line
			static String errorline = "";
			static int errors = 0; 
			// to count the number of errors
			static int myloop = 0; 
			// for looping purposes
		
			static void readFile() {
				try {
					// using buffered reader to read the user selected file
					BufferedReader myfile = new BufferedReader(new InputStreamReader(new FileInputStream(MainPanel.Path), "UTF8"));
		
					// BufferedReader myfile = new BufferedReader(frr);
		
					// check if there's a next line in the file
					while ((line = myfile.readLine()) != null) {
		
						lines.add(line); 
						// each line that the BufferedReader reads, it's stored in arraylist lines
						myloop = 0;
					}
					// setting the size of arrays to the number of lines in the file
					file_currency = new String[LineReader.numberOfLines];
					file_symbol = new String[LineReader.numberOfLines];
					file_rate = new Double[LineReader.numberOfLines];
					file_error = new String[LineReader.numberOfLines];
					// making use of enhanced for loop to visit each element of string array abc
					for (String def : lines) {
		
						Scanner keyboard = new Scanner(def);
						// making use of delimeter to separate diffrent values in a single line of data
						// from the file
						keyboard.useDelimiter(",");
						
						String store;
						while (keyboard.hasNext()) {
							// storing each values separated from the line in different arrays
		
							// multiple try catches to check if theres a error in a line
							try {
								store = keyboard.next().trim();
								
								file_currency[myloop] = store;
								store = keyboard.next().trim();
								try {
									file_rate[myloop] = Double.parseDouble(store);
								} catch (NumberFormatException nf) {
									file_error[myloop] = "error";
								}
								store = keyboard.next().trim();
								file_symbol[myloop] = store;
							} catch (NoSuchElementException nse) {

								// if any error is caught in a line, error is store in the index of that
								// particular line
								file_error[myloop] = "error";
		
							}
							myloop++;
						}
						keyboard.close();
						// clearing everything in arraylist line, once they've been stored in other
						// arrays
					}
		
					myfile.close();
					for (int i = 0; i < LineReader.numberOfLines; i++) {
						// check if the currency contains these specific currencies
						if ((file_currency[i].contains("EUR") || file_currency[i].contains("USD") || file_currency[i].contains("AUD")
								|| file_currency[i].contains("CAD") || file_currency[i].contains("ISK") || file_currency[i].contains("ZAR")
								|| file_currency[i].contains("AED") || file_currency[i].contains("THB")) && file_error[i] == null) {
							// if no, storing it in the lines
							lines.add(file_currency[i]);
						} else {
							if (file_error[i] == null) {
								file_error[i] = "error";
							}
		
						}
					}
					// if there are errors in file, count number of errors and store which lines the
					// errors are in
					for (int i = 0; i < LineReader.numberOfLines; i++) {
						if (file_error[i] != null) {
							if (errorline == "") {
								errorline = Integer.toString(i + 1);
								errors++;
							} else {
								errorline = errorline + ", " + Integer.toString(i + 1);
								errors++;
							}
						}
					}
					if (errors != 0 && errors != LineReader.numberOfLines) {
						// if there's atleast on valid currency, remove all previous combobox items
						CurrencyPanel.currency_combo_box.removeAllItems();
						for (int i = 0; i < LineReader.numberOfLines; i++) {
							if (file_error[i] == null) {
								//store the name of non-error currency
								CurrencyPanel.currency_combo_box.insertItemAt(file_currency[i], i);
								CurrencyPanel.currency_combo_box.setSelectedIndex(i);
							} else {
								//store error currency as error in combobox
								CurrencyPanel.currency_combo_box.insertItemAt("error", i);
							}
						}
		
						CurrencyPanel.fileUploadCheck = true;
						CurrencyPanel.validupload++;
						
						//display all the lines where there were errors
						JOptionPane.showMessageDialog(null,
								"There were " + errors + " errors in lines " + errorline + " in the file.", "",
								JOptionPane.INFORMATION_MESSAGE);
						errorline = "";
		
					} else if (errors == LineReader.numberOfLines) {
						//if all lines were error, display the message
						JOptionPane.showMessageDialog(null, "Errors in all the lines  of the file", "",
								JOptionPane.INFORMATION_MESSAGE);
						CurrencyPanel.fileUploadCheck = false;
					} else {
						CurrencyPanel.currency_combo_box.removeAllItems();
						for (int i = 0; i < LineReader.numberOfLines; i++) {
							if (file_error[i] == null) {
								CurrencyPanel.currency_combo_box.insertItemAt(file_currency[i], i);
								CurrencyPanel.currency_combo_box.setSelectedIndex(0);
							} else {
								CurrencyPanel.currency_combo_box.insertItemAt("error", i);
							}
						}
						CurrencyPanel.fileUploadCheck = true;
						CurrencyPanel.validupload++;
						JOptionPane.showMessageDialog(null, "Currency rates from the file is updated successfully", "",
								JOptionPane.INFORMATION_MESSAGE);
		
					}
		
				} catch (IOException ie) {
					// TODO Auto-generated catch block
					ie.printStackTrace();
				} catch (NullPointerException npe) {
		
				}
		
			}
		}
package bytePattern;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * 
 * @author Nabin Atreya Sunar		
 * @version 1.0
 */


		/**
		 * This class shows a single set of bytes that represent a pattern.
		 */
	public class BytePattern implements MyPattern{
		
		/**
		 * Declaring variable of private for encapsulation.
		 * 
		 * Declaring ArrayList and storing them into the smallest integer byte type
		 * errors checks the invalid length in the file. !=2 
		 * checkPos[] The next position to be checked within the pattern's byte array.
		 * offset checks the offset value in the file.
		 * PatternFound is set to be false at default.
		 */
		private ArrayList<byte[]> patterns=new ArrayList<byte[]>();
		private StringBuilder errors;
		public int[] checkPos;
		public int offset = 0;
		public boolean PatternFound = false;

		/**
		 *  ParseLine(File f) overriding the method with File parameter.
		 */
		@Override
		public void ParseLine(File f) {
			/**
			 * Calling the setErrors method and passing
			 * the StringBuilder object to check errors in the file.
			 * 
			 */
			setErrors(new StringBuilder());	
						
						/**
						 * line splits the text in the file.
						 * fileReader to read data from the file. It returns data in byte format.
						 * bufferedReader read the text from a character-based input stream which inherits fileReader.
						 * setPatterns method has an Object of ArrayList of byte data type via setter
						 * countLine counts the number of errors in line.
						 */
						try {
								String line;  
								FileReader fileReader = new FileReader(f);			
								BufferedReader bufferedReader = new BufferedReader(fileReader);		
								setPatterns(new ArrayList<byte[]>());
								int countLine = 0;					
								
								/**
								 *  read data line by line by readLine() method.
								 *  countLine get increment when errors are found in the line.
								 *  Using the first variation of java string split method
								 *   which splits the string into substring based on the space in the file
								 *   byteCount counts the number inside String Hexa
								 */
								while((line=bufferedReader.readLine())!=null)  	
								{  	
									countLine++;				
									String[] HexString = line.split(" ");	
									int byteCount = 0;
									
									/**
									 * The substring of the HexString is now referred in String Hexa
									 */
									for(String Hexa : HexString)
									{	
										/**
										 * Checking the value of the String Hexa length equals to 2
										 */
										if(Hexa.length() == 2)	
										{	
											/**
											 * Ensuring the file of String Hexa into Hexadecimal format
											 */
											
											try {	
												HexadecimalToByte(Hexa);	
												byteCount++;		
												}
											catch(Exception e){}
										}
									}
									
									/**
									 *  Initializing the byte array in MyPatternLine
									 * 	Declaring default boolean ValidPatternFound variable. 
									 */
									
									byte[] MyPatternLine = new byte[byteCount];
									int k = 0;
									boolean ValidPatternFound = false;
									
									/**
									 * The substring of the HexString is now again referred in String Hexa
									 * for validation
									 * 
									 */
									for(String Hexa : HexString)			
									{
										ValidPatternFound = false;
										
										/**
										 * Count line error occurs if the length of String Hexa doesn't equal.
										 */
										
										if(Hexa.length() != 2)			
										{
											/**
											 * For usual images or error file which acts a load pattern file.
											 */
											getErrors().append("Error In Line "+countLine+"\n");
											break;
										}
										
										else
										{	
											/**
											 * Successful valid pattern found then
											 * MyPatternLine[k] array stores the value of String
											 *  Hexa from method HexadecimalToByte();
											 * 
											 */
											try {
												MyPatternLine[k] = HexadecimalToByte(Hexa);
												k++;
												ValidPatternFound = true;
												}
											catch(Exception e){
											getErrors().append("Error In Line "+countLine+"\n");	
												}
										}
									}
									
									
									/**
									 *
									 * Returns the patterns from getPatterns() method
									 * Stores them into byte array in MyPatternLine .
									 */
									if(ValidPatternFound)
										getPatterns().add(MyPatternLine);	
									}  //end of while loop
							fileReader.close(); 
						}
						catch(Exception e){}	
			}
		
		
		/**
		 * Checks if the given value matches the next byte to be checked within the pattern.
		 * Each time this method is called it progresses to the next byte within the pattern,
		 * until the value does not match
		 * or the end of the pattern is reached (in which case a match has been found).
		 */
		
		@Override
		public void checkNext(byte value) {
			int PatternNumber = 0;
			
			/**
			 * The patterns value is now referenced to the mybytepattern as byte.
			 */
			for(byte[] mybytepattern : getPatterns())
			{		
					/**
					 * The value now compared to the mybytepattern of array to
					 *  check the next position in byte array.
					 */
					if(value == mybytepattern[checkPos[PatternNumber]])
					{
						checkPos[PatternNumber]++;
						
						/**
						 * Checking mybytepattern length to the next position within the file
						 */
						if(checkPos[PatternNumber] == mybytepattern.length)
						{	
							/**
							 * When pattern found append to the display JTextArea of MyGUIPanel
							 * Using HexaString method() of mybtyepattern as byte data type in array
							 * offset offset value in the file when pattern is found.
							 * 
							 */
							checkPos[PatternNumber]=0;
							MyGUIPanel.display.append("Pattern found: "+ByteArraytoHexadecimalString(mybytepattern)+", "
									+ " at offset: "+(offset-mybytepattern.length)
									+" (0x"+ByteToHexadecimal((byte)(offset-mybytepattern.length)).toUpperCase()+") "
											+ "within the file.\n");
							PatternFound = true;
						}
					}
					else if(value == mybytepattern[0])
					{
						checkPos[PatternNumber] = 1;
					}
					else
					{
						checkPos[PatternNumber] = 0;
					}
				
				PatternNumber++;
			}//end of for loop
			
		}
		
		/**
		 *  checkPattern(File file) overriding the method with File parameter
		 *  that checks the pattern in the file.
		 */
		@Override
		public void checkPattern(File file) {
			
			/**
			 * Check if the specified file is File or not.
			 */
			if(file.isFile())
			{	
				/**
				 * offset is set to 1 to read each byte of the file.
				 * checkPos checks the next position from the getPatterns() method in integer array.
				 */
				offset = 1;
				checkPos = new int[getPatterns().size()];
					for(int i=0; i<getPatterns().size();i++)
					{	
						/**
						 * if the given byte does not match the next byte in the 
						 * pattern then the match has failed, so reset checkPos.
						 */
						checkPos[i] = 0;
					}
					
				try {
						/**
						 * InputStream read one byte at a time from a file.
						 * BufferedInputStream  reads a larger block at a time into an internal buffer.
						 * FileInputStream To read the contents of a file as a stream of bytes.
						 * int next  the most recently read byte from the file.
						 */
						PatternFound = false;
						InputStream myIS;
						myIS = new BufferedInputStream(new FileInputStream(file));
					
						MyGUIPanel.display.append("Filename: "+file.getName()+"\n");
				        int next;
		
				        /**
				         *  Read each byte of the file (until the end of the file has been reached), 
				         *  looking for any of the patterns
				         */
				        while ((next = myIS.read()) != -1) 
				        { 	
				        	
				        	/**
				        	 *  Convert the value read into an 8 bit byte
				        	 */
				        	byte nextByte = (byte)next; 
				        	
				        	/**
				        	 *  compare value of 'nextByte' with the next byte within the pattern to be detected
				        	 */
				        	checkNext(nextByte);
				        	offset++;
				        }
				        
				        /**
				         * Pattern Not Found display append this message.
				         */
				        if(!PatternFound)
				        	MyGUIPanel.display.append("No Patterns Found \n");
		
						MyGUIPanel.display.append("\n");
				        myIS.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
				}
				catch(IOException e) {}
	
			}//end of if condition
			
		}
		
	
		/**
		 * Converted String into integers at first
		 * @param HexString Encodes the String into sequence of bytes using the specified String
		 * @return byte Shifted most significant digit by 4 bits and
		 * 		   Concatenate the two four bit-segments to get the byte equivalent
		 * 		   the binary representation has zeros at four least significant bits
		 */
	
		public byte HexadecimalToByte(String HexString) {
		    int firstDigit = toDigit(HexString.charAt(0));
		    int secondDigit = toDigit(HexString.charAt(1));
		    return (byte) ((firstDigit << 4) + secondDigit);
		}
		 
		/**
		 * 
		 * @param HexaChar Accepts in the form of Character only for
		 * 		  Character.digit() method for conversion.
		 * @return digit If the character value passed to this method 
		 * 			is not a valid digit, it returns the -1.
		 */
		private int toDigit(char HexaChar) {
		    int digit = Character.digit(HexaChar, 16);
		    if(digit == -1) {
		    	
		    	/**
		    	 * Validating the return value and throwing an exception
		    	 *  if an invalid value was passed.
		    	 */
		        throw new IllegalArgumentException(
		          "Opps...Error Invalid Hexadecimal Character: "+ HexaChar);
		    }
		    return digit;
		}
		
		
		
		/**
		 * 		  StringBuffer and StringBuilder classes are used for creating mutable string.
		 * @param byteArray loop through the array and generate
		 *        hexadecimal pair for each byte
		 * @return hexStringBuffer mutable string all in UpperCase 
		 * 
		 * 
		 */
		public String ByteArraytoHexadecimalString(byte[] byteArray) {
		    StringBuffer hexStringBuffer = new StringBuffer();
		    for (int i = 0; i < byteArray.length; i++) {
		        hexStringBuffer.append(ByteToHexadecimal(byteArray[i]));	
		    }
		    return hexStringBuffer.toString().toUpperCase();
		}
		
		
		/**
		 * 
		 * @param num accepts as the byte data types. Convert each 4-bit segment to hex separately
		 * 		  and concatenate them.
		 * 		 Created a char array of length 2 to store the output.
		 *		 Order bits by right shifting 4 bits
		 * 		
		 * @return new String() String object from the char array. And then,
		 * 		   returned this object as converted hexadecimal array.
		 */
		public String ByteToHexadecimal(byte num) {
		    char[] hexDigits = new char[2];
		    hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
		    /**
		     *  convert the remaining 4 bits to hexadecimal
		     */
		    hexDigits[1] = Character.forDigit((num & 0xF), 16);
		    return new String(hexDigits);
		}
	
		
		/**
		 * 
		 * @return patterns Object of byte array.
		 */
		public ArrayList<byte[]> getPatterns() {
			return patterns;
		}
		
		/**
		 * 
		 * @param patterns Allows to display the valid patterns file from the directory.
		 */
		public void setPatterns(ArrayList<byte[]> patterns) {
			this.patterns = patterns;
		}
		
		/**
		 * 
		 * @return errors in the pattern file having the errors and checking line by line.
		 */
		public StringBuilder getErrors() {
			return errors;
		}
		
		/**
		 * 
		 * @param errors for creating mutuable string.
		 */
		public void setErrors(StringBuilder errors) {
			this.errors = errors;
		}
		
	}

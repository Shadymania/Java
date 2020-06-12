package bytePattern;

import java.io.File;
/**
 * 
 * @author Nabin Atreya Sunar			
 * @version 1.0
 */




		/**
		 *Creating interface class to achieve abstraction.
		 *Three different methods on it.
		 */
		public interface MyPattern {
			
			/**
			 * 
			 * @param f It reads or accepts the file from the directory or specific file
			 * 			and ensure about the patterns and spaces in the file
			 */
			public void ParseLine(File f);
			
			
			/**
			 * 
			 * @param value the value to be checked against the next byte in the pattern (as determined by checkPos).
			 * 		  Checks if the given value matches the next byte to be checked within the pattern.
			 *        Each time this method is called it progresses to the next byte within the pattern, 
			 *        until the value does not match or the end of the pattern is reached.
     		 *        	
			 */
			public void checkNext(byte value);
			
			
			/**
			 * 
			 * @param file The file is read each byte of the file until last and looks out for any of the patterns in the file.
        	 *	      If the given files does not match the next byte in the pattern then it gives the pattern not found message
        	 *        If the given files does match the next byte in the pattern it shows the pattern is found wit specific files.      
			 */
			public void checkPattern(File file);
			
		}

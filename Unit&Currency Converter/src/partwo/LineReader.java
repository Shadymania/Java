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

public class LineReader {
static String line;
static int numberOfLines;
	
	static void lineCount() {
		 try {
				BufferedReader myfile = new BufferedReader(new InputStreamReader(new FileInputStream(MainPanel.Path), "UTF8"));
				//using buffered reader to read file
				numberOfLines = 0;
				CurrencyReader.lines.clear();
				while ((line = myfile.readLine()) != null) {
					numberOfLines++;
					//for everyline there is in the file, increase the value of the integer
				}
	 }
		 catch (IOException ioe) {	 
	 }
	}
}
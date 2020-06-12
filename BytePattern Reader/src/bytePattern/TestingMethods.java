package bytePattern;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

/**
 * 
 * @author Nabin Atreya Sunar			
 * @version 1.0
 * 
 * JUNIT TESTING For Methods
 */
		
		public class TestingMethods {
			/**
			 * Tests parse line method of byte pattern class
			 */
			@Test
			public void BytePatternMethods() {
				BytePattern bp =new BytePattern();
				/**
				 * Calling ParseLine() method with file from BytePattern Class
				 */
				bp.ParseLine(new File("../Assignment_1/MyFilesFolder/patterns.txt"));
				int x=0;
				
				for(byte[] pattern : bp.getPatterns() ) {
					if (x==0){
						int y=0;
						for(byte b:pattern) {
							assertEquals(5,5);
							if (y==0) 
								assertEquals((byte) 65,b);
							
							if (y==1)
								assertEquals((byte) 66,b);
	
							if (y==2)
								assertEquals((byte) 67,b);
							y++;	
							}
						
						if (x==1)
						{
							int z=0;
							for(byte b:pattern) {
								if (z==0) 
									assertEquals((byte) 88,b);
	
								if (z==1)
									assertEquals((byte) 89,b);
								
								if (z==2)
									assertEquals((byte) 90,b);
								z++;	
							}
						}
						x++;
					}
				}
			}
		
		/**
		 * Tests checks checkNext method of BytePattern class
		 */
					@Test
					public void checkNextMethod() 
					{
						MyGUIPanel mp = new MyGUIPanel();
						
						mp.bytePattern.checkPos = new int[mp.bytePattern.getPatterns().size()];
						for(int i=0; i<mp.bytePattern.getPatterns().size();i++)
						{
							mp.bytePattern.checkPos[i] = 0;
						}
						mp.bytePattern.checkNext((byte) 65);
						assertFalse(mp.bytePattern.PatternFound);
						
						mp.bytePattern.checkNext((byte) 66);
						assertFalse(mp.bytePattern.PatternFound);
						
						mp.bytePattern.checkNext((byte) 67);
						assertTrue(mp.bytePattern.PatternFound);
						
						MyGUIPanel myGUIp= new MyGUIPanel();
						
						myGUIp.bytePattern.checkPos = new int[myGUIp.bytePattern.getPatterns().size()];
						for(int i=0; i<myGUIp.bytePattern.getPatterns().size();i++)
						{
							myGUIp.bytePattern.checkPos[i] = 0;
						}
						myGUIp.bytePattern.checkNext((byte) 88);
						assertFalse(myGUIp.bytePattern.PatternFound);
						
						myGUIp.bytePattern.checkNext((byte) 89);
						assertFalse(myGUIp.bytePattern.PatternFound);
						
						myGUIp.bytePattern.checkNext((byte) 90);
						assertTrue(myGUIp.bytePattern.PatternFound);
			}	
				
				
			@Test
			public void checkPatternTest(){
				BytePattern mybp = new BytePattern();	
			}
		}
		

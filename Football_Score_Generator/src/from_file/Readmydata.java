package nabin_atreya_sunar;

								// Package name
import java.io.File;
import java.io.FileNotFoundException;			// Importing and using the java.util.Scanner library to read data of various type.
import java.util.Scanner;

	public class Readmydata {				// Class name Football_results_generator
		
		public static void main(String[] args) {	// Main method to run a program.
			 // declaring static variable and initializing value as zero.
			String line;
			int errors=0;
			String split[]=new String [4];				// allocates for delimiter using split array in file
			String[] home_team_name=new String[30] ; 	// allocates for home_team_name memory up to 30 String.
			String[] home_team_score=new String[30] ;
			String[] away_team_name=new String[30] ;
			String[] away_team_score=new String[30] ;
			int[] home_score= new int[30];				//an array to store parseInt Value on it
			int[] away_score= new int[30];
			int i=0;
			String search_result;
	
			Scanner keyboard=new Scanner(System.in);	// Creating scanner object.
			System.out.println("FILE NAME: \t𝘃𝗮𝗹𝗶𝗱.𝘁𝘅𝘁\n"+"\t \t𝗶𝗻𝘃𝗮𝗹𝗶𝗱.𝘁𝘅𝘁\n" +"𝙋𝙇𝙀𝘼𝙎𝙀，　𝙀𝙉𝙏𝙀𝙍　𝙏𝙃𝙀　𝙁𝙄𝙇𝙀　𝙉𝘼𝙈𝙀　？"); 	// Ask the user to input file.
			line=keyboard.nextLine();
			File myfile = new File (line);				// Creating file object and passing user input file.

			
				try {									//using try-catch method
					Scanner fileReader = new Scanner (myfile); 		// Scanner object to read a file.
					System.out.println("\n▁ ▂ ▄ ▅ ▆ ▇ █ ▌|〘 𝗥𝗘𝗔𝗗𝗜𝗡𝗚 𝗙𝗢𝗢𝗧𝗕𝗔𝗟𝗟 𝗠𝗔𝗧𝗖𝗛 𝗗𝗔𝗧𝗔 𝗙𝗜𝗟𝗘 〙| █ ▇ ▆ ▅ ▄ ▂ ▁\n");
							while(fileReader.hasNext()){		//using while loop and hasNext() method.
							line = fileReader. nextLine();	//Read a line of data from text file
							System.out.println(line);}		// team names and scores are separated by a semicolon respectively.
							fileReader.close();
					}
				catch (FileNotFoundException e){		//Exception case.
							System.out.print("");      
											}
	
				
				try {	
					Scanner fileReader = new Scanner(myfile);
					System.out.println("\n\t\t   ⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽"+"\n\t ⚽⚽⚽⚽⚽ 🅿🆁🅴🅼🅸🅴🆁 🅻🅴🅰🅶🆄🅴  🆁🅴🆂🆄🅻🆃🆂  🅶🅴🅽🅴🆁🅰🆃🅾🆁 ⚽⚽⚽⚽⚽"+"\n\t \t   ⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽"+
							"⚽⚽⚽⚽⚽⚽⚽⚽⚽⚽"+"⚽⚽⚽⚽⚽⚽\n");			// FOR CONSOLE UI PROGRAM DESIGN
					System.out.println("HOME TEAM NAME" +"\t    HOME TEAM SCORE"+"\t   AWAY TEAM NAME"+  "\tAWAY TEAM SCORE"+ "\n= = = = = = = = " +"    " +"= = = = = = = = " +"     "+" = = = = = = = =\t"  +"= = = = = = = = ");
							while(fileReader.hasNext()){
								line = fileReader.nextLine(); 		// Line below separates the content of line of data read by semicolon & store them in the array
								split = line.split(":");
										if(split.length==4)
										{								//Exception handling for wrong data type.
											home_team_name[i]= split[0];	
											home_team_score[i]=split[2];
											away_team_name[i]= split[1];
											away_team_score[i]= split[3];
					
												try {							//passing string value into integer value with no addition spaces.
														home_score[i] = Integer.parseInt(home_team_score[i].trim());
														away_score[i] = Integer.parseInt(away_team_score[i].trim());
													}
												catch(NumberFormatException e) {
														System.out.print("");
																			}
					
											if(home_team_name[i].trim().isEmpty() && away_team_name[i].trim().isEmpty()) {							//checking if home team name and away team missing.
												System.out.println("𝑺𝑶𝑹𝑹𝒀 ! 𝑵𝑶 𝑴𝑨𝑻𝑪𝑯 𝑫𝑨𝑻𝑨 𝑺𝑯𝑶𝑾𝑵: 𝑴𝑰𝑺𝑺𝑰𝑵𝑮 𝑯𝑶𝑴𝑬 𝑻𝑬𝑨𝑴 𝑨𝑵𝑫 𝑨𝑾𝑨𝒀 𝑻𝑬𝑨𝑴 𝑵𝑨𝑴𝑬 !!!");
												errors++;																							//acts as a count as its get increment.
																														}
											else if(home_team_name[i].trim().isEmpty()) {															//checking if home team name is missing.
												System.out.println("𝙎𝙊𝙍𝙍𝙔 ! 𝙉𝙊 𝙈𝘼𝙏𝘾𝙃 𝘿𝘼𝙏𝘼 𝙎𝙃𝙊𝙒𝙉 • 𝙈𝙄𝙎𝙎𝙄𝙉𝙂 𝙃𝙊𝙈𝙀 𝙏𝙀𝘼𝙈 𝙉𝘼𝙈𝙀 •\t");
												errors++;
																						}
											else if(home_team_score[i].trim().equals("A")) {														//checking if home team score has String value
												System.out.println("𝑺𝑶𝑹𝑹𝒀 ! 𝑵𝑶 𝑫𝑨𝑻𝑨 𝑺𝑯𝑶𝑾𝑵 : 𝑰𝑵𝑽𝑨𝑳𝑰𝑫 𝑯𝑶𝑴𝑬 𝑺𝑪𝑶𝑹𝑬  𝑰𝑵𝑻𝑬𝑮𝑬𝑹 !!!  ");
												errors++;
																							}
											else if(away_team_score[i].trim().equals("x")) {														//checking if away team score has String value	
													System.out.println("𝑺𝑶𝑹𝑹𝒀 ! 𝑵𝑶 𝑫𝑨𝑻𝑨 𝑺𝑯𝑶𝑾𝑵 : 𝑰𝑵𝑽𝑨𝑳𝑰𝑫  𝑨𝑾𝑨𝒀 𝑺𝑪𝑶𝑹𝑬 𝑰𝑵𝑻𝑬𝑮𝑬𝑹 !!!");
													errors++;
																							}
											else if(away_team_name[i].trim().isEmpty()) {															//checking if away team name is missing.
													System.out.println("𝙎𝙊𝙍𝙍𝙔 ! 𝙉𝙊 𝙈𝘼𝙏𝘾𝙃 𝘿𝘼𝙏𝘼 𝙎𝙃𝙊𝙒𝙉  • 𝙈𝙄𝙎𝙎𝙄𝙉𝙂 𝘼𝙒𝘼𝙔 𝙏𝙀𝘼𝙈  𝙉𝘼𝙈𝙀 •");
													errors++;
																						}
											else if(home_team_score[i].trim().isEmpty()) {														//checking if home team score is missing or empty.
													System.out.println("𝑺𝑶𝑹𝑹𝒀 ! 𝑵𝑶 𝑫𝑨𝑻𝑨 𝑺𝑯𝑶𝑾𝑵 : 𝑴𝑰𝑺𝑺𝑰𝑵𝑮 𝑯𝑶𝑴𝑬 𝑺𝑪𝑶𝑹𝑬");
													errors++;	
																						}
											else {																								//else condition and passing value in respective order as shown and displaying in console.
													System.out.println(String.format("%-27s", home_team_name[i])+String.format("%-15s", home_score[i])+
													String.format("%-27s", away_team_name[i])+String.format("%-10s", away_score[i]));
													i++;																						//increment as it run.
												}
										}
				
										else {																								//Using condition for missing delimiter
											System.out.println("𝑺𝑶𝑹𝑹𝒀 ! 𝑵𝑶 𝑴𝑨𝑻𝑪𝑯 𝑫𝑨𝑻𝑨 𝑺𝑯𝑶𝑾𝑵 - 𝑴𝑰𝑺𝑺𝑰𝑵𝑮  𝑶𝑹  𝑾𝑹𝑶𝑵𝑮 𝑰𝑫𝑬𝑳𝑰𝑴𝑰𝑻𝑬𝑹 ✍︎");
											errors++;
											}
							}	

				System.out.println("\n\t\t\t\tⓉⓄⓉⒶⓁ ⓃⓊⓂⒷⒺⓇⓈ ⓄⒻ ⒺⓇⓇⓄⓇⓈ :"+errors);
				fileReader.close();																										//Closing file.
				System.out.println("\n\n\t \t 🄴🄽🅃🄴🅁 🅈🄾🅄🅁 🄵🄰🅅🄾🅁🄸🅃🄴 🅃🄴🄰🄼 🄽🄰🄼🄴  \n" + 
				"\t\t      🅃🄾 🅂🄴🄴 🄰🄻🄻 🄼🄰🅃🄲🄷 🄳🄴🅃🄰🄸🄻🅂 \n");
				System.out.print("♥ 𝗘𝗡𝗧𝗘𝗥 𝗬𝗢𝗨𝗥 𝗧𝗘𝗔𝗠 𝗡𝗔𝗠𝗘 ♥"+"\n"+"➡️ ");
				search_result = keyboard.nextLine();																				//Take string from the keyboard object.
				System.out.println("\n\n \t 【﻿＊＊＊＊＊ "+"𝔸𝕃𝕃 𝕍𝔸𝕃𝕀𝔻 𝕄𝔸𝕋ℂℍ ℝ𝔼𝕊𝕌𝕃𝕋𝕊: "+search_result +" ＊＊＊＊＊】\n");
				System.out.println("HOME TEAM NAME" +"\t    HOME TEAM SCORE"+"\t   AWAY TEAM NAME"+ "\tAWAY TEAM SCORE"+ "\n= = = = = = = = " +"    " +"= = = = = = = = " +"     "+" = = = = = = = =\t"  +"= = = = = = = = ");

				for(int counter=0; counter<i; counter++)																			//Using local variable as counter to count
					{
						if(search_result.equalsIgnoreCase(home_team_name[counter].trim())){										//using if condition and ignores small and capital character.
									System.out.println(String.format("%-25s", home_team_name[counter])+String.format("%-18s", home_score[counter])+ 
									String.format("%-27s", away_team_name[counter])+String.format("%-8s", away_score[counter])); // Displaying on console
																					}	
						else if(search_result.equalsIgnoreCase(away_team_name[counter].trim())){								//Run this condition if above condition is not met.
									System.out.println(String.format("%-25s", home_team_name[counter])+String.format("%-18s", home_score[counter])+
									String.format("%-27s", away_team_name[counter])+String.format("%-8s", away_score[counter]));
																						}
					}
				
				System.out.println("\n\t\t\t♨😝  𝑻𝑯𝑨𝑵𝑲 𝒀𝑶𝑼 𝑭𝑶𝑹 𝑼𝑺𝑰𝑵𝑮 𝑻𝑯𝑰𝑺 𝑷𝑹𝑶𝑮𝑹𝑨𝑴 !\n" + 										//Displaying message in console.
				"\t\t\t   𝑯𝑨𝑽𝑬 𝑨 𝑾𝑶𝑵𝑫𝑬𝑹𝑭𝑼𝑳 𝑫𝑨𝒀/𝑾𝑬𝑬𝑲𝑬𝑵𝑫 𝑨𝑯𝑬𝑨𝑫 .\n" + 
				"\t\t\t   𝑪𝑯𝑬𝑬𝑹𝑺 ...! 🍷🍷  ♬😝 ");		
				}
	
				catch (FileNotFoundException e)																		//Through exception  if appropriate file is not found.
				{
						System.out.println("𝗢𝗣𝗣𝗣𝗦 ...! 𝗬𝗢𝗨 𝗘𝗡𝗧𝗘𝗥𝗘𝗗 𝗧𝗛𝗘 𝗜𝗡𝗩𝗔𝗟𝗜𝗗 𝗙𝗜𝗟𝗘 𝗡𝗔𝗠𝗘 😞😞"); 				//Displaying message in console.
				}
	}
}									//End of program


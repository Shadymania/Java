   /**
   * 
   */
   package nabin_atreya_sunar; // Package name

   import java.util.Scanner;  // Importing and using the java.util.Scanner library to read data of various type. 

   /**
   * @author nabin
   *
   */
   public class Football_results_generator {          // Class name Football_results_generator
	

	  public static void main(String[] args) {        // Main method to run a program.
		  
		  // declaring static variable and initializing value as zero.
		  int match=0;                              
		  int home_total_score=0;
		  int away_total_score=0;
		  int draws=0;
		  int home_highest_score=0;
		  int away_highest_score=0;                     
		  
		  
	
		  String inputforexit[]=new String[10];      // allocates memory for Continue or EXIT.
     	  String []home_team_name=new String[10];    // allocates for home_team_name memory up to 10 String.
		  String []away_team_name=new String[10];    // allocates for away_team_name memory up to 10 String.
		  
		  Integer[]home_team_score=new Integer[10];  // allocates for home_team_score memory up to 10 Integer.
		  Integer[]away_team_score=new Integer[10];  // allocates for away_team_score memory up to 10 Integer.
		
		  
		  
		  Scanner input=new Scanner(System.in);     // Creating scanner object and passing home_team_name and away_team_name of string in it.
		  Scanner scoring=new Scanner(System.in);	// Creating scanner object and passing home_team_score and away_team_score of Integer in it.
		  Scanner inputone=new Scanner(System.in);  // Creating scanner object and passing for Continue and Exit String in it.
	 
		
	    	do{                                                         // Statment inside loop
	    		for(int counter=0;counter<10;counter++) {              // Initializing local variable as counter for counting and increment.
                   
					System.out.println("\nENTER THE HOME TEAM NAME");    // Ask the user to input home_team_name
					home_team_name[counter]=input.nextLine();         // Take the user input and store in the declare variable with respective array index.

					System.out.println("ENTER THE AWAY TEAM NAME");   // Ask the user to input away_team_name
					away_team_name[counter]=" "+ input.nextLine();    // Take the user input and store in the declare variable with respective array index.

		            System.out.println("ENTER THE HOME SCORE OF "+(home_team_name[counter]));   // Ask the users to input home_team_score
					home_team_score[counter]=scoring.nextInt();                                 // Take the user input and store in the declare variable with respective array index.
					
					System.out.println("ENTER THE AWAY SCORE OF "+(away_team_name[counter]));   // Ask the users to input away_team_score
					away_team_score[counter]=scoring.nextInt();                                 // Take the user input and store in the declare variable with respective array index.
					
					System.out.print("PLEASE,  ENTER ANY KEY / [Y] TO CONTINUE ... " +"\n OR ,\t ENTER [EXIT] / [X] TO STOP THIS PROGRAM : ");     // Displaying message and ask user to input. 
					inputforexit[counter]=inputone.nextLine();                                                                    // Take the user input as a String for Continue or Exit process.
					
					match++;                                                                   // match play increase by 1.
					home_total_score= home_total_score + home_team_score[counter];            // home_total_score counter.
					away_total_score= away_total_score + away_team_score[counter];           //  away_total_score counter.
						
							if(home_team_score[counter]==away_team_score[counter]){         // draws increase by 1.
								draws=draws+1;
								}
					int a=counter;                                                        // Comparing the value of integer a and counter. 
					int b= a;                                                            // Comparing the value of integer a and b.
	           
				
							if(a==0) {                                                 // Initializing the local variable in a if statement for home_highest_score ( condition one).
								home_highest_score= home_team_score[a];                // Store the home_highest_score for first input.
								}
							
							else if(home_team_score[a]>home_team_score[a-1]) {        // Checking and comparing condition one if not met. Then met (condition two).
								home_highest_score=home_team_score[a];               // Store after checking condition.
								}
							
							else if(home_team_score[a]<home_team_score[a-1]) {      // Checking and comparing condition one and two if not met. Then met (condition three).
								home_highest_score=home_team_score[a-1];             // Store after checking condition.
								}
					
					
							if(b==0) {                                           // Again initializing the another local variable in a if statement for away_highest_score ( condition one).
								away_highest_score= away_team_score[b];         // Store the away_highest_score for first input.
								}
							
							else if(away_team_score[a]>away_team_score[b-1]) {       // Checking and comparing condition one if not met. Then met (condition two).
							away_highest_score=away_team_score[b];                   // Store after checking condition.
								}
							
							else if(away_team_score[a]<away_team_score[b-1]) {      // Checking and comparing condition one and two if not met. Then met (condition three).
								away_highest_score=away_team_score[b-1];              // Store after checking condition.
									}
					
							if(inputforexit[counter].equals("YES") || inputforexit[counter].equals("yes") || inputforexit[counter].equals("Y") || inputforexit[counter].equals("y") ) 
							    {                                                                // Check the user input in Continue process at the given condition one. 
								System.out.println("\n"+"Enter the match details" +"\n");          //  If true, Displays continue to enter data.
	
								}
				
							else if(inputforexit[counter].equals("EXIT") || inputforexit[counter].equals("exit") || inputforexit[counter].equals("X") || inputforexit[counter].equals("x"))
							    {                                                            // Check the user input in Exit process at the given condition two.
								break;                                                      // If true, out from (for loop) and terminate program.
							    }
							
							else{
								System.out.println("\n"+ "Enter the next match details ");  // Displays if condition one and two are not met.
								
							     }
	    			}
	    		   		
	
	    		System.out.println("\n"+"\n *** Football Results Generator ***");             // Display output of this line on console.      
	    		for(int counter=0;counter<match;counter++) {							     //  For loop to display the  match results.
				System.out.println("\n"+" "+ home_team_name[counter] +" ["+home_team_score[counter]+"]"+"\t"+"|   " +away_team_name[counter] +" ["+away_team_score[counter]+"]");
	    		}
	    		                                                                                  
	    		System.out.println("\n"+"\n"+" Totals" +"\n" + " _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _  _ _");          // Displaying overall statistics for the games.
	    		System.out.println("\n"+" Total number of matches played: "+match +"\n"+" Total home score: "+home_total_score + "\n"+" Total away score :"
	    		+away_total_score +"\n"+" Total number of draws : "+draws +"\n" + " Highest home score : "+home_highest_score +"\n"+" Highest away score : "+away_highest_score +"\n");

		       }
		      while(false);               // Loop statements (finite loop).      	  
	        }                             // End of main method class.
	     }                                // End of class.  

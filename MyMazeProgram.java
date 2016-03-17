// See Commenting Guide (Learn@UW)

// put file header here
///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Title:            MyMazeProgram
//Files:            (list of source files)
//Semester:         Comp Sci 302 Fall 2015
//
//Author:           Daniel Ng
//Email:            dng4@wisc.edu
//CS Login:         dng4
//Lecturer's Name:  Deb Deppeler
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.util.Random;

// put class header here
public class MyMazeProgram {

	// put method header here
	public static void main(String[] args) {

		// Scanner connected to keyboard for reading user input
		Scanner scnr = new Scanner(System.in);

		// Random number generated seeded according to Config file
		Random rng = new Random(10);

		// DISPLAY WELCOME MESSAGE AND HELP
		System.out.println( "Welcome to MyMazeProgram!" );

		//WHILE LOOPING NEEDED
		boolean condition = true;
		while(condition) {

			//Display Main menu
			System.out.println ( "\n1. Temperature Converter\n" 
					+"2. Simple Robot Maze\n" 
					+"3. Random Robot Maze with Obstacle\n"
					+"4. Exit");
			System.out.println( "Enter Choice:");

			//Using Scanner for Main Menu
			// READ (SCAN) user input as a String
			String strChoice = scnr.nextLine() ;


			//Temp Conv;
			if (strChoice.equals( "1" )){

				System.out.println( "Enter Fahrenheit temperature: " );

				// Declare variables and describe their use
				if (scnr.hasNextDouble()) {
					//input
					double fahrenheit = scnr.nextDouble();
					// output
					double celsius = (5.0/9) * (fahrenheit - 32) ; 

					// Temp Converter Code 
					System.out.println( fahrenheit + "F" + "=" + celsius
							+ "C") ;		
				}


				//putting invalid input
				// Display bad type message to user
				else if (scnr.hasNextLine()) {
					System.out.println( "Can't convert " + scnr.nextLine() 
					+ " to " + "C" );
				}		
			}


			//Simple Robot Maze
			else if (strChoice.equals( "2" )){		        	
				// Instruction
				System.out.println( "Help Robot (R) get to Exit (E)" );

				// Declare variables and describe their use
				int posX=0; //position of Robot x
				int posY=0; //position of Robot y
				int Count = 0; //counts move

				//Looping unit R gets to E
				while (! (posX==4 && posY==4) ) {	
					//Robot Maze Code
					for (int i = 0;  i < 5;  i++) {
						for (int j = 0;  j < 5;  j++){
							if( j == posX  &&  i == posY){
								System.out.print( "R "); 
							}
							else if( j == 4  &&  i == 4 ){
								System.out.print( "E" );
							}
							else {
								System.out.print( "O ");
							}
						}
						System.out.println();
					}

					//Instruction for Robot move
					// DISPLAY COMMAND PROMPT	
					System.out.println("1. up\n2. down\n3. left\n4. right\n"
							+ "Move?");


					// READ (SCAN) user input as a String
					String strPutput = scnr.nextLine();

					// IF the user intput is the correct type:
					if ( strPutput.equals( "1" ) ){
						Count++; 
						if ( !( posY == 0 ) ){ 
							posY--;
						}
					}
					else if ( strPutput.equals( "2" ) ){
						Count++;
						if ( ! ( posY == 4 ) ){
							posY++;
						}
					}
					else if ( strPutput.equals( "3" ) ){
						Count++;
						if ( ! ( posX == 0 ) ){
							posX--;
						}
					}
					else if ( strPutput.equals( "4" ) ){
						Count++;
						if ( ! ( posX == 4 ) ){
							posX++;
						}
					}
					// IGNORE UNRECOGNIZED command
					// but count moves
					else {
						Count++;
					}
					// EXIT command
					if ( posX == 4 && posY == 4 ){
						System.out.println( "Congratulations! Robot is free!\n"
								+ "It took " + Count + " moves\n" );

					}
				}			
			}



			else if ( strChoice.equals( "3" ) ){

				//Looping unit R gets to E
				boolean check = false;

				String strScnr = null ;

				//Loop
				while( check == false ){

					//Make User to input size of Maze 
					System.out.println( "How big is the maze?" + "(3-10)" );

					//Scanner by user to move Robot
					strScnr = scnr.nextLine();

					if ( strScnr.equals( "3" ) ){
						check = true;
					}
					else if( strScnr.equals( "4" ) ){
						check = true;
					}
					else if( strScnr.equals( "5" ) ){
						check = true;
					}
					else if( strScnr.equals( "6" ) ){
						check = true;
					}
					else if( strScnr.equals( "7" ) ){
						check = true;
					}
					else if( strScnr.equals( "8" ) ){
						check = true;
					}
					else if( strScnr.equals( "9" ) ){
						check = true;
					}
					else if( strScnr.equals( "10" ) ){
						check = true;
					}
					// Display bad type message to user
					else {
						System.out.println( "Must be between 3 and 10,"
								+ " inclusive." );
					}
				}
				System.out.println( "Help Robot (R) get to Exit (E)" );

				// Declare variables and describe their use
				//counting moves
				int count = 0; 
				// int simply
				int ranOut = (Integer.parseInt(strScnr));

				// obstacle X coordinate
				int oX = rng.nextInt(Integer.parseInt(strScnr));
				// obstacle Y coordinate
				int oY = rng.nextInt(Integer.parseInt(strScnr));
				// robot X coordinate
				int rX = rng.nextInt(Integer.parseInt(strScnr));
				// robot Y coordinate
				int rY = 0;
				// exit X coordinate
				int eX = rng.nextInt(Integer.parseInt(strScnr));
				// exit Y coordinate
				int eY= (ranOut-1);


				//Robot Maze Code

				while ( !( rX == eX && rY == eY ) ){

					for ( int i=0 ; i < ranOut ; i++ ){

						for ( int j = 0 ; j <ranOut ; j++ ){

							if ( j == rX && i == rY ){

								System.out.print( "R " );
							}

							else if ( j == eX && i == eY ){
								System.out.print( "E " );
							}

							else if ( j == oX && i == oY ){
								System.out.print( "X " );
							}

							else {
								System.out.print( "O " );
							}
						}

						System.out.println();
					}

					//Instruction for Robot move
					// DISPLAY COMMAND PROMPT	
					System.out.println( "1. up\n2. down\n3. left\n4. right\n"
							+ "Move?" );


					// READ (SCAN) user input as a String
					String strPutput = scnr.nextLine();

					// IF the user input is the correct type:
					if ( strPutput.equals( "1" ) ){
						count++;

						if ( ! ( rY == 0 ) ){

							if ( ( rY - 1 ) == oY && rX == oX ){
							}

							else {
								rY--;	
							}

						}
					}

					else if ( strPutput.equals( "2" ) ){
						count++;

						if ( rY < ( ranOut - 1 ) ){

							if ( ( rY + 1 ) == oY && rX == oX ){
							}

							else {
								rY++;
								
							}

						}

					}

					else if ( strPutput.equals( "3" ) ){
						count ++;

						if ( !( rX == 0 ) ){

							if ( ( rX - 1 ) == oX && rY == oY ){
							}

							else {
								rX--;
							}

						}

					}

					else if ( strPutput.equals( "4" ) ){
						count ++;

						if ( rX < ( ranOut - 1 ) ){

							if ( ( rX + 1 ) == oX && rY == oY ){
							}

							else {
								rX++;
							}
						}
					}

					// IGNORE UNRECOGNIZED command but count moves
					else {
						count++;
					}

				}

				// EXIT command
				//	Exit when R=E
				if ( rX == eX && rY == eY ){

					System.out.println("Congratulations! Robot is free!\n"
							+ "It took " + count + " moves\n");
				}
			}

			// EXIT command
			else if (strChoice.equals( "4" ) ){ 

				System.out.println( "Live Long And Prosper!" );
				// Break Loop
				condition = false;
				// Close the scanner to avoid potential resource leak
				scnr.close();
			}

			// typing in other strings not the numbers, then looping to
			// + main me
			else {
				System.out.println("Sorry, I don't understand that");
			}

		}

	}//end of main method

}//   end of MyMazeProgram class






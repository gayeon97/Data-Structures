package project1;

import java.util.*;

import project1.Color;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class is the actual program that tests Color and ColorList classes.   
 * 
 * @author Gayeon Park
 */
public class ColorConverter {

	public static void main(String[] args) throws FileNotFoundException {
		if (args.length < 1){
			System.err.println("Usage Error: the program expects file name as an argument.");
			System.exit(0);
		}

		File cssColorList = new File(args[0]);
		//Check if file exists
		if (!cssColorList.exists()){
			System.err.printf("ERROR: the file %s. doesn't exist.\n", args[0]);
		}
		//Check if file can be read	
		if (!cssColorList.canRead()) {
			System.err.printf("ERROR: cannot read file %s.\n\n", args[0]);
			System.exit(1);
		}
		//open and read the data file using the Scanner object
		Scanner inColors = new Scanner(cssColorList);

		//create the ColorList of Color objects
		ColorList listOfColors = new ColorList();
		while ( inColors.hasNext() ) {
			//the input file contains the data one per line
			//and the name of the color and its hexvalue are separated by "," and
			//arbitrary number of white space characters 

			//read the next line from file
			String line = inColors.nextLine();
			//split the line at ","
			String [] names  = line.split(",");
			//trim the extra white space around the names of
			//the color name and its hexvalue
			names[0] = names[0].trim();
			names[1] = names[1].trim();
			//create a new Color class using the above two values 
			//and add it to ColorList listofColors
			listOfColors.add(new Color(names[1],names[0]));
		}

		//close the input file
		inColors.close();

		//Ask the user to enter a hexadecimal color value.
		System.out.print("Enter the color in HEX format (#RRGGBB) or 'quit' to stop: ");
		Scanner input = new Scanner(System.in);
		String userInput = input.next();
		//The program runs in a loop asking for user info and prints
		//the hexadecimal value, corresponding RGB value, and the color name (if such exists) 
		//until the user quits.
		while (!userInput.equalsIgnoreCase("quit")){
			try{
				if (listOfColors.getColorByHexValue(userInput) == null){
					System.out.println((new Color(userInput)).toString() +'\n');
				} else	System.out.println(listOfColors.getColorByHexValue(userInput).toString() + '\n'); 
			} catch (IllegalArgumentException e){
				System.out.println(e.getMessage() + '\n' 
						+ "Please try again or enter \"quit\" to exit." + '\n');
			}

			//Prompts the user for another input
			System.out.print("Enter the color in HEX format (#RRGGBB) or 'quit' to stop: ");
			userInput = input.next();
		}

	}
}
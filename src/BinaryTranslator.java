//This program takes user input from a file or the console and translates it to decimal or binary
//Author: Grace Hunter
//Date: 9/28/17

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BinaryTranslator {
	
	public BinaryTranslator() {
		
		//create scanner to read input from the console
		Scanner consoleReader = new Scanner(System.in);
		
		//ask for input source (file or console)
		System.out.println("If you would like to translate file, type \"file\". If you would like to use the console, type \"console\".");
		String fileType = consoleReader.nextLine();
		String input = "";
		
		//if user wants to use a file...
		if (fileType.equals("file")) {
			try {
			System.out.println("What is the name of your file?");
			String fileName = consoleReader.nextLine();
			Scanner fileReader = new Scanner(new File(fileName));
			input = fileReader.nextLine();
			fileReader.close();
			} 
			
			//if the file does not exist...
			catch (IOException exception) {
				System.out.println("This file could not be found.");
				consoleReader.close();
				System.exit(1);
			}
		}
		
		//if user wants to use the console...
		else {
			System.out.println("Enter a number:");
			input = consoleReader.nextLine();
		}
		
		//ask whether user would like to translate to decimal or to binary
		System.out.println("If you would like to translate to binary, type \"binary\". \nIf you would like to translate to decimal, type \"decimal\".");
		String translateTo = consoleReader.nextLine();
		
		//if user wants to translate to binary...
		if (translateTo.equals("binary")) {
			
			//create String to store answer
			String answer = "";
			
			int number = Integer.parseInt(input); //make the String input into an integer
			
			while (number >= 1) {
				
				int isDivisible = number % 2;
				
				//if it is not divisible by two add a one onto the end of the answer
				if (isDivisible == 1) {
					answer = answer + "1";
				}
				
				//if it is divisible by two add a 0 onto the end of the answer
				else {
					answer = answer + "0";
				}
				
				number = number / 2;
			}
			
			//reverse answer so that place values are in correct order
			String reverseAnswer = "";
			for (int x = answer.length() - 1; x >= 0; x--) {
				reverseAnswer = reverseAnswer + answer.charAt(x); //for each character at the end of input, add it to the end of reverseInput
			}
			
			//return answer
			System.out.println(input + " translated to binary is " + reverseAnswer);
		}
		
		//translate to decimal
		else {
			
			//create integer to store answer
			int newNumber = 0;
			
			//reverse input so that place values are in order from lowest to highest instead of highest to lowest
			String reverseInput = "";
			for (int x = input.length() - 1; x >= 0; x--) {
				reverseInput = reverseInput + input.charAt(x); //for each character at the end of input, add it to the end of reverseInput
			}
			
			//translate to decimal one place at a time
			for (int place = reverseInput.length() - 1; place >= 0; place--) {
				
				//if the number at the place is a one, add the appropriate power of two to the answer
				if (reverseInput.charAt(place) == '1'){
					newNumber = newNumber + (int)(Math.pow(2, place));
				}
			}
			
			//return answer
			System.out.println(input + " translated to decimal is " + newNumber);
		}	
	}

	public static void main(String[] args) {
		new BinaryTranslator();
	}
}

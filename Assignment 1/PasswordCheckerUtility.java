/**
Name: Benz Jeither Tamayo
Professor: Farnaz eivazi
Summary: When the application begins, the user will be presented with a screen that states the above instructions for creating a password, two text entry boxes for typing in a password, and three buttons.  
If the user wants to check a single password, they will type in the password in both boxes and select the “Check Password” button.
If the user wants to read in and check a list of passwords, they will select the “Check Passwords in File” button, be presented with a file explorer, and select the file to read from.  Those passwords that failed the check will be displayed, with their error message.
Due date: September 14, 2021

*/

import java.util.ArrayList;
import java.util.regex.Pattern;


import java.util.regex.Matcher;



public class PasswordCheckerUtility{

	public PasswordCheckerUtility() {
		
	}
	
    // Compare equality of two passwords

	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		
		// if the passwords typed don't match, it should throw an UnmatchedException
		if(!password.equals(passwordConfirm) ) {
			throw new UnmatchedException();
		}
		
			
	}
	
	
	// Compare equality of two passwords
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		
		// if the passwords typed matches, then it should return true
		boolean flag;
		if(password.equals(passwordConfirm) ) {
			flag = true;        // set flag to  true if the password matches
		}
		else {
			flag = false;       // set flag to false if the password didnt match
		}
			
		return flag;            // return boolean value
	}
	
	// this method return the list of invalid passwords
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		
		
		ArrayList<String> passwordList = new ArrayList<String>();   // make an arrayList object

		for(String x : passwords) {
			try {
				isValidPassword(x);
			} catch(Exception e) {
				passwordList.add(x + " -> " + e.getMessage());   // display the given invalidPasswords and display their error message
			}

		}
		return passwordList;

	}
	
	/* This method checks if the typed in password is between six and nine characters long
	 * which considers to be a valid length of password*/
	public static boolean hasBetweenSixandNineChars (String password) throws LengthException {
		boolean flag = false;   // initialize flag
		
		if(password.length() >= 6 && password.length() <= 9) // if the given password is between 6 and nine characters,
		{
			flag = true;          // set flag to true
		}
		else {
			throw new LengthException();       // if not, throw the LengthException
		}
		
		
		return flag;
	}
	
	/* This hasDigit method checks the typed in password if it contains a digit, if it 
	 not, then it should throw the NoDigitException
	**/
	public static boolean hasDigit (String password) throws NoDigitException {

		int number = 0;     // iniialize int variable number
		for(int i = 0; i < password.length();i++ ) {
			
			if(Character.isDigit(password.charAt(i))) // check all of the character one by one and increment the variable number if there is a digit detected
			{
				number++;       //increment number
			}
		}
		
		if(number > 0)  // if the variable number is more than zero then the password means contain a digit
		{
			return true;          // return true
		}
		else 
		{
				throw new NoDigitException(); //otherwsise, throw NoDigitException
		}
		

	}
	
	/* This hasLowerAlpha method checks the typed in password if it contains a lower case letter, if it 
	 not, then it should throw the NoLowerAlphaException
	**/
	
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
	
		
		int numOfLowerAlpha = 0;
		for(int i = 0; i < password.length();i++ ) {
			if(Character.isLowerCase(password.charAt(i))) // check all of the character one by one and increment the variable 
			                                                    	//numOfLowerAlpha if there is a lower case letter detected
			{
				numOfLowerAlpha++;  // increment numOfLowerAlpha
			}

		}
		
		if(numOfLowerAlpha > 0) //if numOfLowerAlphais more than zero, it means that password contains Lower case letter
		{
			return true; // return true
		}
		else {
			throw new NoLowerAlphaException();// else, throw NoLowerAlphaException
		}
		
	
	}
	
	/* This hasUpperAlpha method checks the typed in password if it contains a upper case letter, if it 
	 not, then it should throw the NoUpperAlphaException
	**/
	
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {

		
		int numOfUpperAlpha = 0;
		for(int i = 0; i < password.length();i++ ) {
			if(Character.isUpperCase(password.charAt(i)))  // check all of the character one by one and increment the variable 
            	                                             //numOfUpperAlpha if there is a upper case letter detected
			{
				numOfUpperAlpha++;
			}

		}	
		if(numOfUpperAlpha > 0) //if numOfLowerAlphais more than zero, it means that password contains upper case letter
		{
			return true;
		}
		else {
			throw new NoUpperAlphaException(); // throw NoUpperAlphaException ifthe password dont have any upper case letter
		}
	}
	
	/* This hasSameCharInSequence method checks the typed in password if it contains three or more of the same character in the password, if it 
	 not, then it should throw the InvalidSequenceException
	**/
	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException, IndexOutOfBoundsException {
		
		boolean flag = true;
		
		for(int i = 0; i < password.length();i++ ) 
		{
			if((password.charAt(i) == (password.charAt(i+1) )) && (password.charAt(i) == password.charAt(i+2))) // if the password has three or 
				                                                                           //more in a sequence, then throw the InValidSequenceException
			{
				throw new InvalidSequenceException();

			}
		}
		
		return flag;
	}
	
	
	/* This hasSpecialChar method checks the typed in password if it contains a special character in the password, if it 
	 not, then it should throw the NoSpecialCharException
	**/
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		
			boolean flag = false;
	
			
		    Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		    Matcher matcher = pattern.matcher(password);
		    
		    if(!matcher.matches()) {
		    	flag =true;
		    }
		    else {
		    	throw new NoSpecialCharacterException();
		    }

		    return flag;

	}
	
	
	/* This isValidLength method checks the typed in password if it is long enough to be accepted as a password, if it 
	 not, then it should throw the NoLengthException
	**/
	public static boolean isValidLength(String password) throws LengthException {
		
		boolean flag = false;
		
		if(password.length() >= 6) {
			flag = true;
		}
		else {
			throw new LengthException();
		}
		
		return flag;
	}
	
	

	/* This isValidPassword method checks the typed in password if all the requirements for a valid password is met
	**/
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, 
	NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException, WeakPasswordException
	{
		
			if(hasBetweenSixandNineChars(password) && hasDigit(password) && hasLowerAlpha(password)&& hasSpecialChar(password) && hasUpperAlpha(password)
					&& hasSameCharInSequence(password)) {
				return true;
			}
			else if(!hasBetweenSixandNineChars(password)){
				throw new LengthException();
			}
			else if(!hasDigit(password)) {
				throw new NoDigitException();
			}
			else if(!hasLowerAlpha(password)) {
				throw new NoLowerAlphaException();
				
			}
			else if(!hasSpecialChar(password)) {
				throw new NoSpecialCharacterException();
			}
			else if(!hasUpperAlpha(password)) {
				throw new NoUpperAlphaException();
			}
			else if(hasSameCharInSequence(password)) {
				throw new InvalidSequenceException();
			}
			else{
				return false;
			}

	}
	
	/* This method checks if the password is Weak or Strong. It is consider a strong password if its greater than 10 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException, LengthException {
		
	boolean flag = true;
	
	try {
		if (password.length() >=10)
			flag = false;
		else 
			throw new WeakPasswordException();
	} catch (WeakPasswordException e) {
		e.printStackTrace();
	}
    
    return flag;

		
	}
}

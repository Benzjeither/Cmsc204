import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {

	private static MorseCodeTree tree = new MorseCodeTree();
	public MorseCodeConverter() {};
	
	
	/**
	 * 
	 * @return returns a string with all the data in the tree in LNR order with an space in between them. Uses the toArrayList method in MorseCodeTree It should return the data in this order:
"h s v i f u e l r a p w j b d x n c k y t z g q m o" Note the extra space between j and b - that is 
because there is an empty string that is the root, and in the LNR traversal, the root would come between 
the right most child of the left tree (j) and the left most child of the right tree (b). This is used for testing purposes 
to make sure the MorseCodeTree has been built properly
	 */
	public static String printTree() {
		    String str= "";
	        ArrayList<String> treeList = new ArrayList<>();
	        treeList = tree.toArrayList();
	       
	        for (String character : treeList) {
	            str += character + " ";
	        }
	        return str;
	}
	
	/**
	 * @method Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
			Example:
					code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
					string returned = "Hello World"
	 * @param code
	 * @return
	 */
	public static String convertToEnglish(String code) {

		String[] word = code.split(" / ");
		String[] alphabets;
		String output = "";

		for(String i: word) {
			alphabets = i.split(" ");
			for(String x: alphabets) {
				output =  output +tree.fetch(x);
			}

			output = output + " ";
			
		}
		return output.trim();
		
		
	}
	
	/**
	 * @method Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
			Example:
					a file that contains ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
					string returned = "Hello World"
	 * @param ccodeFile
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		try {
			Scanner input = new Scanner(codeFile);
			StringBuilder sb = new StringBuilder();
			
			do {
				sb.append(input.nextLine());
			}while (input.hasNextLine());

			input.close();
			
			return convertToEnglish(sb.toString());
		} catch (Exception e) {
			
			throw new FileNotFoundException();
		}
	}
	
}

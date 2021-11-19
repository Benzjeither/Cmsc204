

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

    private TreeNode<String> root;

    /**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 * 
	 */
    public MorseCodeTree() {
        buildTree();
    }
    /**
     * Returns a reference to the root
		Specified by:
		getRoot in interface LinkedConverterTreeInterface<java.lang.String>
	@return  reference to root
     */
    
    public TreeNode<String> getRoot() {

        return root;
    }
    
    /**
  	 * sets the root of the Tree
  	 * @param newNode a TreeNode<T> that will be the new root
  	 */
      @Override
      public void setRoot(TreeNode<String> newNode) {
          root = new TreeNode<>(newNode);
      }
    
      /**
  	 * Adds result to the correct position in the tree based on the code
  	 * This method will call the recursive method addNode
  	 * 
  	 * @param code the code for the new node to be added
  	 * @return the linkedConverterTree with the new node added
  	 */
      
    @Override
    public MorseCodeTree insert(String code, String letter) {
        addNode(root, code, letter);
        return this;
    }
    
    /**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
    @Override
    public void addNode(TreeNode<String> root, String code, String letter) {
    	
    	char alphabet = code.charAt(0);
    	
        if (code.length() != 1){
        	
            if (alphabet == '.') {
            	
                addNode(root.leftNode, code.substring(1), letter);
                
            } else if (alphabet == '-') {
            	
                addNode(root.rightNode, code.substring(1), letter);
            }
        }
        else{
            if (code.equals("-")) {
            	root.rightNode = new TreeNode<>(letter);
               
                
            } else if (code.equals(".")) {
         	
            	 root.leftNode = new TreeNode<>(letter);
            }
        }  
    }
    
    
    /**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 * 
	 */
    @Override
    public void buildTree() {
        root = new TreeNode<>("");

        //building the first level of the tree
        insert("." , "e");
        insert("-" , "t");
    
        //building the second level of the tree
        insert(".." , "i");
        insert(".-" , "a");
        insert("-." , "n");
        insert("--" , "m");
   
        
        //building the third level of the tree
        insert("..." , "s");
        insert("..-" , "u");
        insert(".-." , "r");
        insert(".--" , "w");
        insert("-.." , "d");
        insert("-.-" , "k");
        insert("--." , "g");
        insert("---" , "o");
      
        //building the fourth level of the tree
        insert("...." , "h");
        insert("...-" , "v");
        insert("..-." , "f");
        insert(".-.." , "l");
        insert(".--." , "p");
        insert(".---" , "j");
        insert("-..." , "b");
        insert("-..-" , "x");
        insert("-.-." , "c");
        insert("-.--" , "y");
        insert("--.." , "z");
        insert("--.-" , "q");
        
    }
    
    /**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
    @Override
    public String fetch(String code) {
        return fetchNode(root, code);
    }
    

	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
    @Override
    public String fetchNode(TreeNode<String> root, String code) {
        String letter = "";
        char alphabet = code.charAt(0);
        
        if (code.length() != 1) {
        	 if (!code.isEmpty()) {
                 if (alphabet == '.') {
                	 
                     letter = fetchNode(root.leftNode, code.substring(1));
                 } else if (!code.isEmpty()) {
                	 if(alphabet == '-') {
                		 
                     letter = fetchNode(root.rightNode, code.substring(1));
                	 }
                 }
             }

        } else {
            if (code.equals(".")) {
                letter = root.leftNode.data;
            } else if (code.equals("-")) {
                letter = root.rightNode.data;
            }
        }
        return letter;
    }
    
	
	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
    
  
    
    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if (root != null) {
            LNRoutputTraversal(root.leftNode, list);
            list.add(root.data);
            LNRoutputTraversal(root.rightNode, list);
        }
    }
    
  
    /**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> treeList = new ArrayList<>();
        LNRoutputTraversal(root, treeList);
        return treeList;
    }
    
    /**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
    @Override
    public MorseCodeTree update() {
        throw new UnsupportedOperationException();
    }
    
    /**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
    @Override
    public MorseCodeTree delete(String data) {
        throw new UnsupportedOperationException();
    }
}


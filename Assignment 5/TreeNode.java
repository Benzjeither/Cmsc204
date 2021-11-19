
public class TreeNode <T>{

	TreeNode<T> leftNode;
	TreeNode<T> rightNode;
	T data;
	
	/** 
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
       Parameters:
       dataNode - the data to be stored in the TreeNode
	  */
	public TreeNode(T dataNode) {
		
		leftNode = null;
		rightNode = null; 
		data = dataNode;
	}
	
	/** 
	 * used for making deep copies
Parameters:
node - node to make copy of
	 * @param node
	 */
	public TreeNode(TreeNode<T> node) {
		leftNode = node.leftNode;
		rightNode = node.rightNode; 
		data = node.getData();
	}
	
	/** 
	 * Return the data within this TreeNode
Returns:
the data within the TreeNode
	 * @return
	 */
	public T getData() {
		return data;
	}
	
}

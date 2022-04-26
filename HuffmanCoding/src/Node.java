/*
 * Node class - this will acts as the class for the non leaf nodes of the huffmanTree
 * I'm also implementing the comparable interface to provide a mechanism to compare to node objects
 */
public class Node implements Comparable<Node> {

    private final int frequency;
    private Node leftNode;
    private Node rightNode;

    //Constructor with 2 Node parameters
    public Node(Node leftNode, Node rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.frequency = leftNode.getFrequency() + rightNode.getFrequency();
    }
    
    //Constructor with only frequency as a parameter
    public Node(int frequency) {
    	this.frequency = frequency;
    }

    //getter function of the frequency
    private int getFrequency() {
		return this.frequency;
	}
    
    //getter function of the left node
    public Node getLeftNode() {
		return leftNode;
	}

    //getter function of the right node
	public Node getRightNode() {
		return rightNode;
	}

	/*
	 * This will compare to node objects that are,
	 * the object which is calling this method and Object passed as a parameter to this function
	 * 
	 * Conditions are,
	 * if the return value is zero or negative consider the object calling the function as the smaller object
	 * if the return value is positive consider the object passed as a parameter as the smaller object
	 */
	@Override
    public int compareTo(Node node) {
        return this.frequency - node.getFrequency();
    }

	

}
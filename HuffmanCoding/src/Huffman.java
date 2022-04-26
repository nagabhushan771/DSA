
import java.util.*;

/*
 * Huffman class consists of the methods to encode and decode the given text
 * methods which can the users can use are,
 * String encode(String text);
 * 		this will return the encoded text using huffman coding to the binary string.
 * String decode(String encodedText);
 * 		this will return the Actual string by converting the encode text to actual text using the huffman codes 
 * void printCodes();
 * 		this will print all the unique characters of the string with their corresponding huffman code values
 */
public class Huffman {

    private Node root; //Stores the root reference of the Huffman coding tree I'm creating
    private Map<Character, Integer> charFrequencies;//this map stores the frequencies of the character in the string
    private final Map<Character, String> huffmanCodes;//this map stores the huffman codes of each characters of the string


    //constructor
    public Huffman() {
        huffmanCodes = new HashMap<>();//the Object of the huffmanCodes map got created
    }

    /*
     * this method will create the map of the distinct characters of the given text and their frequencies
     * Input : String which need to be encoded
     * Output : return type is void but the map will get created inside this object 
     * 			containing the distinct characters of the given text and their frequencies
     */
    private void fillCharFrequenciesMap(String text) {
        charFrequencies = new HashMap<>();//hashMap to store the distinct characters and their frequencies
        int length = text.length();
        //loop to create the map
        for (int i = 0; i<length; i++) { 
        	char character = text.charAt(i);
        	charFrequencies.put(character, charFrequencies.getOrDefault(character, 0)+1);
        }
    }

    /*
     * this method will return the encoded form of the given text
     * Input : String (which need to be encoded)
     * Output : Encoded binary string
     * 			It also creates the Huffman coding tree and fills the huffmanCodes map with the characters and their huffman codes
     */
    public String encode(String text) {
    	fillCharFrequenciesMap(text);//creates the frequency map
    	
    	/*
    	 * I'm using the minimum heap to get the characters with 2 minimum frequencies in the heap
    	 * In huffman code tree only leaf nodes will have the characters
    	 * First I'm going to add all the leaf nodes of the huffman code tree to the heap
    	 * Then I will pick top 2 elements when the size of the heap is greater than 1 and make them the left and right node of the new non leaf node
    	 * the new non leaf node that i will be creating will have the frequency of sum of frequencies of left and right node and I will add that node back to the heap
    	 */
        Queue<Node> queue = new PriorityQueue<>();
        for(char c : charFrequencies.keySet())
        	queue.add(new Leaf(c, charFrequencies.get(c)));
        
        while (queue.size() > 1) 
            queue.add(new Node(queue.poll(), queue.poll()));
        
        //when there is only one node left in the heap I will poll that node and make it as the root of the huffman code tree
        root = queue.poll();
        generateHuffmanCodes(root, "");//calling this method for creating the map of the huffman codes for the given text using the huffman tree
        return getEncodedText(text);//calling this method to get the encoded text of the given text using the huffman codes map
    }

    /*
     * this recursive method will generate the map of the unique character in the text and their huffman codes using the huffman tree
     * Input : Root node of the huffman code tree and the code of the path of tree at any given time
     * Output : Return type is void but internally I will populate the huffmanCodes map with the unique characters and their huffmanCodes
     */
    private void generateHuffmanCodes(Node node, String code) {
    	/*
    	 * Base case: if I reach the leaf node I'll add the character in the leaf node
    	 * and the code which contains the path to that leaf node to the huffmanCodes map  
    	 */
        if (node.getLeftNode() == null && node.getRightNode() == null) {
            huffmanCodes.put(((Leaf) node).getCharacter(), code);
            return;
        }
        /*
         * If I'm not at the base case I will choose two paths left and right of the node
         * if I choose the left node I will concatenate the code with zero denoting left path
         * if I choose the right node I will concatenate the code with one denoting the right path
         */
        generateHuffmanCodes(node.getLeftNode(), code.concat("0"));
        generateHuffmanCodes(node.getRightNode(), code.concat("1"));
    }

    /*
     * This method will take the text as the input and gives the encoded text as the output using the huffmanCodes map
     * Input : String that need to be encoded
     * OutPut : Encoded String using the huffman code in the huffmanCodes map
     */
    private String getEncodedText(String text) {
        StringBuilder sb = new StringBuilder();
        int length = text.length();
        /*
         * for each character in the string I will append the stringBulder with the corresponding huffman code
         */
        for (int i = 0; i<length; i++) {
        	char character = text.charAt(i);
            sb.append(huffmanCodes.get(character));
        }
        return sb.toString();
    }


    /*
     * This method will decode the BinaryString given into the actual text
     * Input : Binary String (Encoded string)
     * Output : Decode actual string
     */
    public String decode(String encodedText) {
        StringBuilder sb = new StringBuilder();
        Node current = root;
        int length = encodedText.length();
        /*
         * I will traverse through the string character by character
         * and also I will traverse through the huffman code tree according to the each character in the string
         * I mean if the current character of the string is 0 I will go to the left subtree of the current node if it is not leaf node
         * and if the current character is String is 1 I will go to the right subtree of the current node if it is not leaf node
         * 
         * Once I reach the leaf node I will append the character in that node to stringBuilder and set the current to root so that
         * I can search for the next character of the actual string 
         */
        for (int i = 0; i<length; i++) {
        	char character = encodedText.charAt(i);
            current = character == '0' ? current.getLeftNode() : current.getRightNode();
            if (current.getLeftNode() == null && current.getRightNode() == null) {
                sb.append(((Leaf)current).getCharacter());
                current = root;
            }
        }
        return sb.toString();
    }


    /*
     * This will print the character and their huffman codes in the console
     * Input : N/A
     * Output : Return type is void but it will print the contents of the huffmanCodes map in the console
     */
    public void printCodes() {
    	for(char c : huffmanCodes.keySet())
    		System.out.println(c +" : " + huffmanCodes.get(c));
    }

}